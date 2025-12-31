import javax.swing.JFrame;
import javax.swing.JLabel;

public class MySwingApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing Demo");
        JLabel label = new JLabel("Hello Swing!", JLabel.CENTER);

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(label);
        frame.setVisible(true);
    }
}
