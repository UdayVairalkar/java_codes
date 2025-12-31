import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class HyperWarp extends JPanel {
    class Star {
        double x, y, z;

        public Star() {
            reset();
        }

        public void reset() {
            x = rand.nextDouble() * 2 - 1;
            y = rand.nextDouble() * 2 - 1;
            z = rand.nextDouble();
        }

        public void update() {
            z -= 0.01;
            if (z <= 0) reset();
        }

        public int getScreenX(int w) {
            return (int) ((x / z) * w / 2 + w / 2);
        }

        public int getScreenY(int h) {
            return (int) ((y / z) * h / 2 + h / 2);
        }

        public int getSize() {
            return (int) ((1 - z) * 5);
        }
    }

    private final Star[] stars = new Star[500];
    private final Random rand = new Random();

    public HyperWarp() {
        setBackground(Color.black);
        for (int i = 0; i < stars.length; i++) stars[i] = new Star();

        Timer timer = new Timer(16, e -> {
            for (Star star : stars) star.update();
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w = getWidth(), h = getHeight();
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2.setColor(Color.white);

        for (Star s : stars) {
            int size = s.getSize();
            int x = s.getScreenX(w);
            int y = s.getScreenY(h);
            if (x >= 0 && x < w && y >= 0 && y < h) {
                g2.fillOval(x, y, size, size);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("🚀 HyperWarp Simulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(new HyperWarp());
        frame.setVisible(true);
    }
}
