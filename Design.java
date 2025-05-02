
import java.io.IOException;



public class Design {
    /********  ANSI color codes   ********/
    // text color

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";  
    // text style
    public static final String BOLD = "\u001B[1m";
    public static final String ITALIC = "\u001B[3m";
    public static final String UNDERLINE = "\u001B[4m";
    public static final String STRIKETHROUGH = "\u001B[9m";
    // public static final String BOLD_OFF = "\u001B[22m";
    // public static final String ITALIC_OFF = "\u001B[23m";
    // public static final String UNDERLINE_OFF = "\u001B[24m";
    // public static final String STRIKETHROUGH_OFF = "\u001B[29m";

    // Cross-platform clear screen
    public static void clearScreen() {
        try {
            String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Error clearing screen: " + e.getMessage());
        }
    }

    // Wait for user to press Enter
    public static void pause() {
        System.out.print("Press Enter to continue...");
        try {
            System.in.read();
            while (System.in.available() > 0) {
                System.in.read(); // Clear the input buffer
            }
        } catch (IOException e) {
            System.out.println("Error waiting for Enter: " + e.getMessage());
        }
    }
    

    // Sleep for a given seconds
    public static void sleep(float  seconds) {
        try {
            Thread.sleep((long)(seconds * 1000L));
        } catch (InterruptedException e) {
            System.out.println("Error sleeping: " + e.getMessage());
        }
    }

    // Print custom text
    public static void printDesign(String... elements) {
        for(String element : elements) {
            
            String text = "";
            switch (element) {
                case "RED":
                    text += Design.RED;
                    break;
                case "GREEN":
                    text += Design.GREEN;
                    break;
                case "YELLOW":
                    text += Design.YELLOW;
                    break;
                case "BLUE":
                    text += Design.BLUE;
                    break;
                case "PURPLE":
                    text += Design.PURPLE;
                    break;
                case "CYAN":
                    text += Design.CYAN;
                    break;
                case "WHITE":
                    text += Design.WHITE;
                    break;
                case "BOLD":
                    text += Design.BOLD;
                    break;
                case "ITALIC":
                    text += Design.ITALIC;
                    break;
                case "UNDERLINE":
                    text += Design.UNDERLINE;
                    break;
                case "STRIKETHROUGH":
                    text += Design.STRIKETHROUGH;
                    break;
                case "RESET":
                    text += Design.RESET;
                    break;
                default:
                    text += element;
                    break;
            }
            // text += Design.RESET;
            System.out.print(text);
        }
    } 
    
}
