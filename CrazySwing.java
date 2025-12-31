import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class CrazySwing {
    public static void main(String[] args) {
        Random rand = new Random();

        while (true) {
            // Create a new window (frame)
            JFrame frame = new JFrame("😵 Surprise!");

            // Create a colorful random label
            JLabel label = new JLabel(randomText(rand), JLabel.CENTER);
            label.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
            label.setForeground(randomColor(rand));
            frame.add(label);

            // Set random position and size
            int width = rand.nextInt(200) + 200;
            int height = rand.nextInt(100) + 100;
            int x = rand.nextInt(1200);
            int y = rand.nextInt(700);
            frame.setBounds(x, y, width, height);

            // Frame settings
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setAlwaysOnTop(true);
            frame.setVisible(true);

            // Pause for 500 ms
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Generate random funny text
    private static String randomText(Random rand) {
        String[] texts = {
            "You clicked me!", "I'm alive!", "Hehe 😂", "Stop this madness!",
            "Boop!", "I'm everywhere!", "Catch me if you can!", "Hiiiii 👻",
            "Swing Swing Baby!", "Why are you running?"
        };
        return texts[rand.nextInt(texts.length)];
    }

    // Generate random color
    private static Color randomColor(Random rand) {
        return new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    }
}
