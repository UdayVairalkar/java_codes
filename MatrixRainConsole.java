import java.util.Random;

public class MatrixRainConsole {

    static final int WIDTH = 80;
    static final int HEIGHT = 30;
    static final char[] CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@#$%&".toCharArray();
    static final Random rand = new Random();
    static final int[] yPositions = new int[WIDTH];

    public static void main(String[] args) throws InterruptedException {
        // Clear screen
        System.out.print("\033[2J");

        while (true) {
            StringBuilder frame = new StringBuilder();

            for (int y = 0; y < HEIGHT; y++) {
                for (int x = 0; x < WIDTH; x++) {
                    if (y == yPositions[x]) {
                        char ch = CHARS[rand.nextInt(CHARS.length)];
                        frame.append("\033[32m").append(ch); // Green color
                    } else {
                        frame.append(" ");
                    }
                }
                frame.append("\n");
            }

            System.out.print("\033[H"); // Move cursor to top-left
            System.out.print(frame);

            // update y positions
            for (int i = 0; i < WIDTH; i++) {
                if (rand.nextInt(100) > 97) {
                    yPositions[i] = 0;
                } else {
                    yPositions[i] = (yPositions[i] + 1) % HEIGHT;
                }
            }

            Thread.sleep(50);
        }
    }
}
