import java.util.ArrayList;
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
        // Design.pause();
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
        // Design.getSize();
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
                AdminPanel(quizManager, input);
            } else {
                StudentPanel(quizManager, input);
            }
        }
        else {
            Design.printDesign(tab, Design.RED, "Login failed. Invalid username or password.\n", Design.RESET);
            Design.sleep(.5f);
        }
    }


// ###################################################################################################


    // Admin panel
    /*
     * 1. Create Quiz
     * 2. View Quizzes
     * 3. Logout
     */
    private static void AdminPanel(QuizManager quizManager, Scanner input) {
        
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
                    Design.clearScreen();
                    Design.printDesign(tab, Design.CYAN, "Creating quiz...\n", Design.RESET);
                    Design.sleep(.5f);
                    // Design.clearScreen();
                    createQuiz(quizManager , input);
                    break;
                case 2:
                    // View quizzes
                    Design.clearScreen();
                    Design.printDesign(tab, Design.CYAN, "Viewing quizzes...\n", Design.RESET);
                    Design.sleep(.5f);

                    viewQuizzes(quizManager, input);
                    Design.pause();
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
    // create quiz
    private static void createQuiz (QuizManager quizManager, Scanner input) {
        Design.clearScreen();
        Design.printDesign("\n\n\n", tab, Design.BOLD, Design.CYAN, "\tCreate Quiz Page\n\n", Design.RESET);
        Design.printDesign(tab, Design.CYAN, "Enter Quiz ID: ", Design.RESET);
        String quizId = input.nextLine();
        Design.printDesign(tab, Design.CYAN, "Enter Quiz Title: ", Design.RESET);
        String title = input.nextLine();

        ArrayList <Question> questions = new ArrayList<>();
        while (true) { 
            Design.clearScreen();
            Design.printDesign(Design.CYAN, tab, "Add a question (or type 'done' to finish): ", Design.RESET);
            String questionText = input.nextLine();
            if(questionText.equalsIgnoreCase("done")) break;

            ArrayList <String> options = new ArrayList<>();
            for(int i = 1; i <= 4; i++) {
                Design.printDesign(tab, Design.CYAN, "Option " + i + ": ", Design.RESET);
                options.add (input.nextLine());
            }

            Design.printDesign(tab, Design.CYAN, "Correct option (1-4): ", Design.RESET);
            int answer = input.nextInt();
            input.nextLine();

            questions.add(new Question (questionText, options, answer));
        }

        quizManager.createQuiz(new Quiz (quizId, title, questions));
        Design.printDesign(tab, Design.CYAN, "Quiz created successfully!\n", Design.RESET);
        Design.sleep(.5f);
        
    }
    // view quizzes
    private static void viewQuizzes (QuizManager quizManager, Scanner input) {
        Design.clearScreen();
        Design.printDesign(tab, Design.CYAN, "View Quizzes\n", Design.RESET);
        ArrayList <Quiz> quizzes = quizManager.getQuizzes();

        if(quizzes.isEmpty()) {
            Design.printDesign(tab, Design.RED, "No quizzes available.\n", Design.RESET);
            Design.sleep(.5f);
            return;
        }

        Design.printDesign(tab, Design.CYAN, "Available Quizzes:\n", Design.RESET);
        for (Quiz quiz : quizzes) {
            Design.printDesign(tab, "-> ", Design.BLUE, quiz.getQuizId(), ": ", Design.GREEN, quiz.getTitle(), "\n", Design.RESET);
        }
    }



    // Student panel
    /*
     * 1. View Quizzes
     * 2. Take Quiz
     * 3. Logout
     */
    private static  void StudentPanel(QuizManager quizManager, Scanner input) {
        while (true) {
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
                    Design.clearScreen();
                    Design.printDesign(tab, Design.CYAN, "Viewing quizzes...\n", Design.RESET);
                    Design.sleep(.5f);

                    viewQuizzes(quizManager, input);
                    Design.pause();
                    break;
                case 2:
                    // take quiz
                    Design.clearScreen();
                    Design.printDesign(tab, Design.CYAN, "Taking quiz...\n", Design.RESET);
                    Design.sleep(.5f);
                    Design.printDesign(tab, Design.CYAN, "Enter Quiz ID: ", Design.RESET);
                    String quizId = input.nextLine();
                    quizManager.takeQuiz(quizId, input);
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
}

