import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;

public class MagicTypingGlass {
    private static String fullText = "";
    private static int index = 0;

    public static void main(String[] args) {
        JFrame frame = new JFrame("✨ Magic Typing Glass");
        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Input field
        JTextField inputField = new JTextField();
        inputField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        inputField.setHorizontalAlignment(JTextField.CENTER);
        inputField.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        inputField.setToolTipText("Type anything magical ✨");
        frame.add(inputField, BorderLayout.NORTH);

        // Display label
        JLabel displayLabel = new JLabel("", JLabel.CENTER);
        displayLabel.setFont(new Font("Monospaced", Font.BOLD, 26));
        displayLabel.setForeground(new Color(255, 255, 255));
        displayLabel.setOpaque(true);
        displayLabel.setBackground(new Color(30, 30, 30));
        frame.add(displayLabel, BorderLayout.CENTER);

        // Fancy background panel
        JPanel bgPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                setBackground(new Color(20, 20, 20));
                Graphics2D g2d = (Graphics2D) g;
                g2d.setPaint(new GradientPaint(0, 0, new Color(0, 255, 200), getWidth(), getHeight(), new Color(0, 100, 200)));
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        bgPanel.setLayout(new BorderLayout());
        bgPanel.add(inputField, BorderLayout.NORTH);
        bgPanel.add(displayLabel, BorderLayout.CENTER);

        frame.setContentPane(bgPanel);

        // On Enter key, start animated typing
        inputField.addActionListener(e -> {
            fullText = inputField.getText();
            index = 0;
            displayLabel.setText("");
            startTypingAnimation(displayLabel);
        });

        frame.setVisible(true);
    }

    // Animate the text one character at a time
    private static void startTypingAnimation(JLabel label) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                if (index < fullText.length()) {
                    label.setText(label.getText() + fullText.charAt(index));
                    index++;
                } else {
                    timer.cancel();
                }
            }
        }, 100, 80); // Delay before start, speed per character
    }
}
