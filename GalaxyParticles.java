import java.awt.*;
import java.util.*;
import java.util.List;
import javax.swing.*;

public class GalaxyParticles extends JPanel {
    static class Particle {
        int x, y;
        int dx, dy;
        int size;
        Color color;

        public Particle(int x, int y, int dx, int dy, int size, Color color) {
            this.x = x;
            this.y = y;
            this.dx = dx;
            this.dy = dy;
            this.size = size;
            this.color = color;
        }

        public void move(int width, int height) {
            x += dx;
            y += dy;

            if (x < 0 || x > width - size) dx *= -1;
            if (y < 0 || y > height - size) dy *= -1;
        }
    }

    private final List<Particle> particles = new ArrayList<>();
    private final Random rand = new Random();

    public GalaxyParticles(int numParticles) {
        setBackground(Color.black);

        // Create particles
        for (int i = 0; i < numParticles; i++) {
            int size = rand.nextInt(8) + 3;
            int x = rand.nextInt(800);
            int y = rand.nextInt(600);
            int dx = rand.nextInt(5) + 1;
            int dy = rand.nextInt(5) + 1;
            Color color = new Color(
                rand.nextInt(155) + 100,
                rand.nextInt(155) + 100,
                rand.nextInt(155) + 100
            );
            particles.add(new Particle(x, y, dx, dy, size, color));
        }

        // Animation timer (60 FPS)
       javax.swing.Timer timer = new javax.swing.Timer(1000 / 60, e -> {

            for (Particle p : particles) {
                p.move(getWidth(), getHeight());
            }
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Particle p : particles) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(p.color);
            g2.fillOval(p.x, p.y, p.size, p.size);
            g2.dispose();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("✨ Galaxy Particle Animation");
        GalaxyParticles panel = new GalaxyParticles(100); // You can increase particles if PC is fast

        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center screen
        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}
