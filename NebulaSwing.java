import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class NebulaSwing extends JPanel implements ActionListener, MouseMotionListener {

    class Particle {
        float x, y, vx, vy, size;
        Color color;

        Particle() {
            x = rand(WIDTH);
            y = rand(HEIGHT);
            vx = rand(-1, 1);
            vy = rand(-1, 1);
            size = rand(1, 4);
            color = new Color(rand(100, 255), rand(100, 255), rand(100, 255), 150);
        }

        void move() {
            x += vx;
            y += vy;
            if (x < 0 || x > WIDTH) vx *= -1;
            if (y < 0 || y > HEIGHT) vy *= -1;
        }

        void draw(Graphics2D g) {
            g.setColor(color);
            g.fillOval((int) x, (int) y, (int) size, (int) size);
        }
    }

    final int WIDTH = 800, HEIGHT = 600;
    final int PARTICLE_COUNT = 300;
    java.util.List<Particle> particles = new ArrayList<>();
   javax.swing.Timer timer;

    int mouseX = WIDTH / 2, mouseY = HEIGHT / 2;

    public NebulaSwing() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        addMouseMotionListener(this);

        for (int i = 0; i < PARTICLE_COUNT; i++) {
            particles.add(new Particle());
        }

       timer = new javax.swing.Timer(16, this);

        timer.start();
    }

    @Override
    protected void paintComponent(Graphics gOld) {
        super.paintComponent(gOld);
        Graphics2D g = (Graphics2D) gOld;

        // Background fading trail
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.1f));
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setComposite(AlphaComposite.SrcOver);

        for (Particle p : particles) {
            double dx = p.x - mouseX;
            double dy = p.y - mouseY;
            double dist = Math.sqrt(dx * dx + dy * dy);
            if (dist < 100) {
                p.vx += dx / dist * 0.05;
                p.vy += dy / dist * 0.05;
            }
            p.move();
            p.draw(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    float rand(float min, float max) {
        return min + (float) Math.random() * (max - min);
    }

    float rand(float max) {
        return (float) (Math.random() * max);
    }

    int rand(int min, int max) {
        return min + (int) (Math.random() * (max - min + 1));
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    public void mouseDragged(MouseEvent e) {}
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Nebula Galaxy - Java Swing Animation 🚀");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(false);
        frame.setResizable(false);
        frame.setContentPane(new NebulaSwing());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
