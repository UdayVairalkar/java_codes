import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class HackerPortal extends JPanel implements ActionListener {
    private final Timer timer = new Timer(50, this);
    private final int width = 800;
    private final int height = 600;
    private final int fontSize = 20;
    private final int columns = width / fontSize;
    private final char[] charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@$%#".toCharArray();
    private final int[] drops = new int[columns];
    private final Random rand = new Random();

    public HackerPortal() {
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.BLACK);
        for (int i = 0; i < columns; i++) drops[i] = rand.nextInt(height / fontSize);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Fade background slightly for trailing effect
        g2d.setColor(new Color(0, 0, 0, 100));
        g2d.fillRect(0, 0, width, height);

        g2d.setFont(new Font("Consolas", Font.BOLD, fontSize));

        for (int i = 0; i < drops.length; i++) {
            char ch = charset[rand.nextInt(charset.length)];
            g2d.setColor(Color.GREEN);
            g2d.drawString(Character.toString(ch), i * fontSize, drops[i] * fontSize);

            if (drops[i] * fontSize > height && rand.nextDouble() > 0.975) {
                drops[i] = 0;
            }

            drops[i]++;
        }

        // Glitching console message
        if (rand.nextDouble() > 0.98) {
            g2d.setFont(new Font("Monospaced", Font.PLAIN, 18));
            g2d.setColor(Color.GREEN);
            g2d.drawString(">> Decrypting...", 20, height - 40);
        }
        if (rand.nextDouble() > 0.985) {
            g2d.setColor(Color.RED);
            g2d.drawString("!! Intrusion Detected !!", 20, height - 20);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("💻 Hacker Portal - Code Rain Mode");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new HackerPortal());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
