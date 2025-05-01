import java.util.Scanner;

public class Main {

public static String[] java = {
"                          @                                                            ",
"                         @@                                                            ",
"                        @@@                                                            ",
"                        @@@                                                            ",
"                       @@@                                                             ",
"                    @@@@@                                                              ",
"                  @@@@@    @@@@                                                        ",
"                @@@@@   @@@@                                                           ",
"              @@@@@  @@@@@                                                             ",
"             @@@@@  @@@@                                                               ",
"             @@@   @@@@                        @@@                                     ",
"             @@@    @@@@                       @@@@                                    ",
"              @@@    @@@@@                     @@@@                                    ",
"                @@   @@@@@                     @@@@ @@@@@@@@@@ @@@@     @@@@ @@@@@@@@@ ",
"                 @@    @@@                     @@@@ @@@   @@@@@ @@@@    @@@  @@    @@@@",
"           @@         @@@       @@@@@@         @@@@        @@@@  @@@@  @@@@        @@@@",
"     @@@@@                 @@@@     @@@        @@@@  @@@@@@@@@@  @@@@ @@@@    @@@@@@@@@",
"     @@@@@@@@@@@@@@@@@@@@@@@        @@@        @@@@ @@@@   @@@@   @@@@@@@@  @@@@   @@@@",
"                                   @@@@        @@@@ @@@    @@@@   @@@@@@@   @@@@   @@@@",
"         @@@@        @@@@@@@     @@@@          @@@@ @@@@@@@@@@@    @@@@@    @@@@@@@@@@@",
"          @@@@@@@@@@@@@@@@@    @@             @@@@     @@                       @      ",
"                                             @@@@                                      ",
"          @@@@@@@@@@@@@@@@@                 @@@@                                       ",
"            @@@@@@@@@@@@@@                                                             ",
 "@@@@@                             @@                                                  ",
"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  @@                                                ",
"    @@@@@@@@@@@@@@@@@@@@@@@@@     @@@@                                                 ",
"        @@@@@@@@@@@@@@@@@@@@@@@@@@                                                     "
                                                                                 	
};
    public static String tab = "\t\t\t\t\t\t\t\t\t\t\t";
    public static void main(String[] args) {
        

        while (true) { 
            Design.clearScreen();
            Design.printDesign("\n\n\n", tab, Design.BOLD, Design.CYAN, "Welcome to the Quiz Management System\n\n", Design.RESET);
            Design.printDesign(Design.BOLD, Design.RED, tab, "\t1. ", Design.GREEN, "Registration\n", Design.RESET);
            Design.printDesign(Design.BOLD, Design.RED, tab, "\t2. ", Design.GREEN, "Login\n", Design.RESET);
            Design.printDesign(Design.BOLD, Design.RED, tab, "\t3. ", Design.GREEN, "Exit\n", Design.RESET);
            Design.printDesign(tab, Design.ITALIC, Design.YELLOW, "Please select an option: ", Design.RESET);

            Scanner input = new Scanner(System.in);
            String choice = input.nextLine();

            switch (choice) {
                case "1":
                    reginstration();
                    break;
                case "2":
                    login();
                    break;
                case "3":
                    // Design.clearScreen();
                    Design.printDesign(Design.BOLD, Design.RED, tab, "Exiting the program...\n", Design.RESET);
                    Design.sleep(1f);
                    System.exit(0);
                default:
                    Design.printDesign(Design.ITALIC, Design.STRIKETHROUGH, "Invalid choice. ", Design.RESET, Design.ITALIC, Design.PURPLE, "Please try again.\n");
                    Design.sleep(1.3f);
            }
        }   
    }

    // Registration
    public static void reginstration() {
        // Design.clearScreen();
        // Design.printDesign("\n\n\n", tab, Design.BOLD, Design.CYAN, "Registration\n\n", Design.RESET);
        // Design.printDesign(tab, Design.ITALIC, Design.YELLOW, "Please enter your name: ", Design.RESET);
        // Scanner input = new Scanner(System.in);
        // String name = input.nextLine();
        // Design.printDesign(tab, Design.ITALIC, Design.YELLOW, "Please enter your email: ", Design.RESET);
        // String email = input.nextLine();
        // // Add registration logic here
        // Design.printDesign(tab, Design.BOLD, Design.GREEN, "Registration successful!\n", Design.RESET);
        // Design.sleep(2);
    }

    // Login
    public static void login() {
        // Design.clearScreen();
        // Design.printDesign("\n\n\n", tab, Design.BOLD, Design.CYAN, "Login\n\n", Design.RESET);
        // Design.printDesign(tab, Design.ITALIC, Design.YELLOW, "Please enter your email: ", Design.RESET);
        // Scanner input = new Scanner(System.in);
        // String email = input.nextLine();
        // Design.printDesign(tab, Design.ITALIC, Design.YELLOW, "Please enter your password: ", Design.RESET);
        // String password = input.nextLine();
        // // Add login logic here
        // Design.printDesign(tab, Design.BOLD, Design.GREEN, "Login successful!\n", Design.RESET);
        // Design.sleep(2);
    }
}