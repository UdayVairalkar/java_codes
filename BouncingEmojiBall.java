import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class BouncingEmojiBall extends JPanel {
    private int x = 50, y = 50; // Position
    private int dx = 4, dy = 4; // Movement speed
    private final int radius = 50;
    private final String emoji = "😎";

    public BouncingEmojiBall() {
        setBackground(Color.black);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                x += dx;
                y += dy;

                if (x < 0 || x > getWidth() - radius) dx *= -1;
                if (y < 0 || y > getHeight() - radius) dy *= -1;

                repaint();
            }
        }, 0, 20); // 50 FPS
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Smooth animation
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // Draw bouncing emoji
        g2.setFont(new Font("Segoe UI Emoji", Font.PLAIN, radius));
        g2.drawString(emoji, x, y + radius);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bouncing Emoji Ball 🎾");
        BouncingEmojiBall animation = new BouncingEmojiBall();

        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(animation);
        frame.setVisible(true);
    }
}
