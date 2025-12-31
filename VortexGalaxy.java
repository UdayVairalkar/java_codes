import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class VortexGalaxy extends JPanel implements ActionListener, MouseMotionListener {
    class Particle {
        double x, y, angle, radius, speed;
        Color color;

        Particle() {
            reset();
        }

        void reset() {
            radius = rand.nextDouble() * 300;
            angle = rand.nextDouble() * 2 * Math.PI;
            speed = 0.002 + rand.nextDouble() * 0.01;
            updatePosition();
            color = Color.getHSBColor(rand.nextFloat(), 1f, 1f);
        }

        void updatePosition() {
            x = centerX + radius * Math.cos(angle);
            y = centerY + radius * Math.sin(angle);
        }

        void update() {
            angle += speed;
            radius -= 0.05;
            if (radius <= 1) reset();

            // Mouse gravity
            double dx = mouseX - x;
            double dy = mouseY - y;
            double dist = Math.sqrt(dx * dx + dy * dy);
            if (dist < 100) {
                radius -= 1.5;
            }

            updatePosition();
        }
    }

    final int centerX = 400, centerY = 300;
    int mouseX = centerX, mouseY = centerY;
    final Particle[] particles = new Particle[1000];
    final Timer timer = new Timer(16, this);
    final Random rand = new Random();

    public VortexGalaxy() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.black);
        addMouseMotionListener(this);
        for (int i = 0; i < particles.length; i++) particles[i] = new Particle();
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (Particle p : particles) {
            g2.setColor(p.color);
            g2.fillOval((int)p.x, (int)p.y, 3, 3);
        }

        // Optional: draw gravity point
        g2.setColor(new Color(255, 255, 255, 40));
        g2.fillOval(mouseX - 15, mouseY - 15, 30, 30);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Particle p : particles) p.update();
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseMoved(e);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("🌌 Galaxy Vortex - Drag Mouse to Pull Stars");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new VortexGalaxy());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
