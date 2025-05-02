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
        Scanner input = new Scanner(System.in);
        UserManager userManager = new UserManager();
        QuizManager quizManager = new QuizManager();

        // ArrayList <User> users = FileDatabase.loadUsers();

        while (true) { 
            Design.clearScreen();
            Design.printDesign("\n\n\n", tab, Design.BOLD, Design.CYAN, "Welcome to the Quiz Management System\n\n", Design.RESET);
            Design.printDesign(Design.BOLD, Design.RED, tab, "\t1. ", Design.GREEN, "Registration\n", Design.RESET);
            Design.printDesign(Design.BOLD, Design.RED, tab, "\t2. ", Design.GREEN, "Login\n", Design.RESET);
            Design.printDesign(Design.BOLD, Design.RED, tab, "\t3. ", Design.GREEN, "Exit\n", Design.RESET);
            Design.printDesign(tab, Design.ITALIC, Design.YELLOW, "Please select an option: ", Design.RESET);

            String choice = input.nextLine();
            int option = Integer.parseInt(choice);

            switch (option) {
                case 1:
                    reginstration(userManager, input);
                    break;
                case 2:
                    login(userManager, quizManager, input);
                    break;
                case 3:
                    // Design.clearScreen();
                    Design.printDesign(Design.UNDERLINE, Design.BLUE, tab, "Exiting the program...\n\n", Design.RESET);
                    Design.sleep(1f);
                    System.exit(0);
                default:
                    Design.printDesign(Design.ITALIC, Design.STRIKETHROUGH, tab, "Invalid choice. ", Design.RESET, Design.ITALIC, Design.PURPLE, "Please try again.\n");
                    Design.sleep(.4f);
            }
        }   
    }

    // Registration
    private  static void reginstration(UserManager userManager, Scanner input) {
        Design.clearScreen();
        Design.printDesign("\n\n\n", tab, Design.BOLD, Design.CYAN, "\tRegistration Page\n\n", Design.RESET);
        Design.printDesign(tab, Design.ITALIC, Design.WHITE, "Enter username: ", Design.RESET);
        String name = input.nextLine();
        Design.printDesign(tab, Design.ITALIC, Design.WHITE, "Enter password: ", Design.RESET);
        String password = input.nextLine();
        Design.printDesign(tab, Design.ITALIC, Design.WHITE, "Enter role (admin/student): ", Design.RESET);
        String role = input.nextLine();

        // check if the user already exists
        // check & save the data
        if(userManager.register(new User(name, password, role))) {
            Design.printDesign(tab, Design.CYAN, "Registration successful!\n", Design.RESET);
        }else {
            Design.printDesign(tab, Design.RED, "Registration failed. User already exists.\n", Design.RESET);
            Design.sleep(.5f);
        }

        Design.sleep(.5f);
    }

    // Login
    private static void login(UserManager userManager, QuizManager quizManager, Scanner input) {
        Design.clearScreen();
        Design.printDesign("\n\n\n", tab, Design.BOLD, Design.CYAN, "\tLogin Page\n\n", Design.RESET);
        Design.printDesign(tab, Design.ITALIC, Design.WHITE, "Enter username: ", Design.RESET);
        String name = input.nextLine();
        Design.printDesign(tab, Design.ITALIC, Design.WHITE, "Enter password: ", Design.RESET);
        String password = input.nextLine();

        // check the data
        if(userManager.login(name, password) != null) {
            Design.printDesign(tab, Design.CYAN, "Login successful!\n", Design.RESET);
            Design.sleep(.5f);
            // Design.clearScreen();


            // check the role
            if(userManager.getCurrentUser().getRole().equals("admin")) {
                AdminPanel(input);
            } else {
                StudentPanel(input);
            }
        }
        else {
            Design.printDesign(tab, Design.RED, "Login failed. Invalid username or password.\n", Design.RESET);
            Design.sleep(.5f);
        }
    }
// ###################################################################################################


    // Admin panel

    private static void AdminPanel(Scanner input) {
        
        while (true) { 
            Design.clearScreen();
            Design.printDesign("\n\n\n", tab, Design.BOLD, Design.CYAN, "\tAdmin Panel\n\n", Design.RESET);
            Design.printDesign(tab, Design.BOLD, Design.RED, "\t1. ", Design.GREEN, "Create Quiz\n", Design.RESET);
            Design.printDesign(tab, Design.BOLD, Design.RED, "\t2. ", Design.GREEN, "View Quizzes\n", Design.RESET);
            Design.printDesign(tab, Design.BOLD, Design.RED, "\t3. ", Design.GREEN, "Logout\n", Design.RESET);
            Design.printDesign(tab, Design.ITALIC, Design.YELLOW, "Please select an option: ", Design.RESET);
            
            String choice = input.nextLine();
            int option = Integer.parseInt(choice);
            
            switch (option) {
                case 1:
                    // Create quiz
                    break;
                case 2:
                    // View quizzes
                    break;
                case 3:
                    // Logout
                    Design.printDesign(tab, Design.CYAN, "Logging out...\n", Design.RESET);
                    Design.sleep(.5f);
                    return;
                default:
                    Design.printDesign(tab, Design.ITALIC, Design.RED, "Invalid choice. ", Design.PURPLE, "Please try again.\n", Design.RESET);
                    Design.sleep(.4f);
            }
        }
    }

    // Student panel
    /*
     * 1. View Quizzes
     * 2. Take Quiz
     * 3. Logout
     */
    private static  void StudentPanel(Scanner input) {

        Design.clearScreen();
            Design.printDesign("\n\n\n", tab, Design.BOLD, Design.CYAN, "\tStudent Panel\n\n", Design.RESET);
            Design.printDesign(tab, Design.BOLD, Design.RED, "\t1. ", Design.GREEN, "View Quizzes\n", Design.RESET);
            Design.printDesign(tab, Design.BOLD, Design.RED, "\t2. ", Design.GREEN, "Take Quiz\n", Design.RESET);
            Design.printDesign(tab, Design.BOLD, Design.RED, "\t3. ", Design.GREEN, "Logout\n", Design.RESET);
            Design.printDesign(tab, Design.ITALIC, Design.YELLOW, "Please select an option: ", Design.RESET);
            
            String choice = input.nextLine();
            int option = Integer.parseInt(choice);
            
            switch (option) {
                case 1:
                    // view quizzes
                    break;
                case 2:
                    // take quiz
                    break;
                case 3:
                    // Logout
                    Design.printDesign(tab, Design.CYAN, "Logging out...\n", Design.RESET);
                    Design.sleep(.5f);
                    return;
                default:
                    Design.printDesign(tab, Design.ITALIC, Design.RED, "Invalid choice. ", Design.PURPLE, "Please try again.\n", Design.RESET);
                    Design.sleep(.4f);
            }
    }
}