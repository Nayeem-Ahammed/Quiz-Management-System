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
    
    // public static String tab = " ".repeat(Design.width()/3 + Design.width()/10);
    // public static String down = "\n".repeat(Design.height()/4);
    public static String tab() {
        return (" ".repeat(Design.width()/3 + Design.width()/10));
    }
    public static String down() {
        return ("\n".repeat(Design.height()/4));
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        UserManager userManager = new UserManager();
        QuizManager quizManager = new QuizManager();

        // ArrayList <User> users = FileDatabase.loadUsers();
        // Design.pause();
        while (true) { 
            Design.clearScreen();
            Design.printDesign(Design.BOLD, Design.CYAN, down(), tab(), Design.UNDERLINE, "Welcome to the Quiz Management System\n\n", Design.RESET);
            Design.printDesign(Design.BOLD, Design.RED, tab(), "\t1. ", Design.GREEN, "Registration\n", Design.RESET);
            Design.printDesign(Design.BOLD, Design.RED, tab(), "\t2. ", Design.GREEN, "Login\n", Design.RESET);
            Design.printDesign(Design.BOLD, Design.RED, tab(), "\t3. ", Design.GREEN, "Exit\n", Design.RESET);
            Design.printDesign(Design.ITALIC, Design.YELLOW, tab(), "Please select an option: ", Design.RESET);

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
                    Design.printDesign(Design.BOLD, Design.PURPLE, tab(), "Exiting the program...\n\n", Design.RESET);
                    Design.sleep(.5f);
                    Design.clearScreen();
                    System.exit(0);
                default:
                    Design.printDesign(Design.ITALIC, Design.PURPLE, tab(), "Invalid choice. Please try again..!  ", Design.RESET);
                    Design.sleep(.5f);
            }
        }   
    }

    // Registration
    private  static void reginstration(UserManager userManager, Scanner input) {
        Design.clearScreen();
        Design.printDesign(Design.BOLD, Design.CYAN, down(), tab(), Design.UNDERLINE, "Registration Page\n\n", Design.RESET);
        Design.printDesign(Design.BOLD, Design.RED, tab(), "🔘 ", Design.ITALIC, Design.GREEN,"Enter username: ", Design.RESET);
        String name = input.nextLine();
        Design.printDesign(Design.BOLD, Design.RED, tab(), "🔘 ", Design.ITALIC, Design.GREEN, "Enter password: ", Design.RESET);
        String password = input.nextLine();
        Design.printDesign(Design.BOLD, Design.ITALIC, tab(), Design.GREEN, "Enter role (admin/student): ", Design.RESET);
        String role = input.nextLine();

        // check if the user already exists
        // check & save the data
        if(userManager.register(new User(name, password, role))) {
            Design.printDesign(Design.ITALIC, Design.PURPLE, tab(), "Registration successful!  ", Design.RESET);
        }else {
            Design.printDesign(Design.ITALIC, Design.PURPLE, tab(), "User already exists. Try again..!  ", Design.RESET);
        }
        Design.sleep(.5f);
    }

    // Login
    private static void login(UserManager userManager, QuizManager quizManager, Scanner input) {
        Design.clearScreen();
        // Design.getSize();
        Design.printDesign(Design.BOLD, Design.CYAN, down(), tab(), Design.UNDERLINE, "   Login Page   \n\n", Design.RESET);
        Design.printDesign(Design.BOLD, Design.ITALIC, tab(), "🔘 ", Design.GREEN,"Enter username: ", Design.RESET);
        String name = input.nextLine();
        Design.printDesign(Design.BOLD, Design.ITALIC, tab(), "🔘 ", Design.GREEN, "Enter password: ", Design.RESET);
        String password = input.nextLine();

        // check the data
        if(userManager.login(name, password) != null) {
            Design.printDesign(Design.BOLD, Design.ITALIC, Design.PURPLE, tab(), "Login successful! ", Design.RESET);
            Design.sleep(.5f);

            // check the role
            if(userManager.getCurrentUser().getRole().equals("admin")) {
                AdminPanel(quizManager, input);
            } else {
                StudentPanel(quizManager, userManager.getCurrentUser().getUsername(), input);
            }
        }
        else {
            Design.printDesign(tab(), Design.PURPLE, "Login failed. Invalid username or password.. ", Design.RESET);
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
            Design.printDesign(Design.BOLD, Design.CYAN, down(), tab(), Design.UNDERLINE, "  Admin Panel  \n\n", Design.RESET);
            Design.printDesign(Design.BOLD, Design.RED, tab(), " 1. ", Design.GREEN, "Create Quiz\n", Design.RESET);
            Design.printDesign(Design.BOLD, Design.RED, tab(), " 2. ", Design.GREEN, "View Quizzes\n", Design.RESET);
            Design.printDesign(Design.BOLD, Design.RED, tab(), " 3. ", Design.GREEN, "Logout\n", Design.RESET);
            Design.printDesign(Design.ITALIC, Design.YELLOW, tab(), "Please select an option: ", Design.RESET);
            
            String choice = input.nextLine();
            int option = Integer.parseInt(choice);
            
            switch (option) {
                case 1:
                    // Create quiz
                    Design.clearScreen();
                    Design.printDesign(Design.BOLD, Design.CYAN, down(), tab(), "Create Quiz\n", Design.RESET);
                    Design.sleep(.5f);

                    createQuiz(quizManager , input);
                    break;
                case 2:
                    // View quizzes
                    Design.clearScreen();
                    Design.printDesign(Design.BOLD, Design.CYAN, down(), tab(), "Available Quizzes...", Design.RESET);
                    Design.sleep(.5f);

                    viewQuizzes(quizManager, input);
                    Design.pause(input);
                    break;
                case 3:
                    // Logout
                    Design.printDesign(Design.BOLD, Design.PURPLE, tab(), "Exiting the program...\n\n", Design.RESET);
                    Design.sleep(.5f);
                    return;
                default:
                    Design.printDesign(Design.ITALIC, Design.PURPLE, tab(), "Invalid choice. Please try again..!  ", Design.RESET);
                    Design.sleep(.5f);
            }
        }
    }
    // create quiz
    private static void createQuiz (QuizManager quizManager, Scanner input) {
        Design.clearScreen();
        Design.printDesign(Design.BOLD, Design.CYAN, down(), tab(), Design.UNDERLINE, " Create Quiz Page \n\n", Design.RESET);
        Design.printDesign(Design.BOLD, Design.GREEN, tab(),  "🔘 Enter Quiz ID: ", Design.RESET);
        String quizId = input.nextLine();
        // check if the quiz id already exists
        if(quizManager.getQuizzes().stream().anyMatch(id -> id.getQuizId().equals(quizId))) {
            Design.printDesign(Design.ITALIC, Design.PURPLE, tab(), "Quiz ID already exists. Try again..! ", Design.RESET);
            Design.sleep(.5f);
            return;
        } else if (quizId.isEmpty()) {
            Design.printDesign(Design.ITALIC, Design.PURPLE, tab(), "Quiz ID cannot be empty. Try again..! ", Design.RESET);
            Design.sleep(.5f);
            return;
        }
        Design.printDesign(Design.BOLD, Design.GREEN, tab(), "🔘 Enter Quiz Title: ", Design.RESET);
        String title = input.nextLine();

        ArrayList <Question> questions = new ArrayList<>();
        int q = 1;
        while (true) { 
            Design.clearScreen();
            Design.printDesign(Design.BOLD, Design.CYAN, down(), tab(), Design.UNDERLINE, " Create Quiz Page \n\n", Design.RESET);
            Design.printDesign(Design.BOLD, Design.GREEN, " ".repeat(Design.width()/4), "Quiz ID: " + quizId + " ".repeat(Design.width()/4), "Quiz Title: " + title + "\n\n", Design.RESET);

            Design.printDesign(Design.YELLOW, " ".repeat(Design.width()/4), "Add a question", Design.ITALIC, " (or type 'done' to finish): \n", Design.RESET);
            Design.printDesign(Design.RED, Design.BOLD, " ".repeat(Design.width()/4), "Q" + q++ + ": ", Design.RESET);
            String questionText = input.nextLine();
            if(questionText.equalsIgnoreCase("done")) break;

            ArrayList <String> options = new ArrayList<>();
            for(int i = 1; i <= 4; i++) {
                Design.printDesign(Design.BOLD, Design.GREEN, " ".repeat(Design.width()/4), " Option " + i + ": ", Design.RESET);
                options.add (input.nextLine());
            }

            Design.printDesign(Design.BOLD, Design.GREEN, " ".repeat(Design.width()/4), " Correct option (1-4): ", Design.RESET);
            int answer = input.nextInt();
            input.nextLine();

            questions.add(new Question (questionText, options, answer));
        }

        quizManager.createQuiz(new Quiz (quizId, title, questions));
        Design.printDesign(Design.ITALIC, Design.PURPLE, tab(), "Quiz created successfully!  ", Design.RESET);
        Design.sleep(.5f);
        
    }
    // view quizzes
    private static void viewQuizzes (QuizManager quizManager, Scanner input) {
        Design.clearScreen();
        Design.printDesign(Design.BOLD, Design.CYAN, down(), tab(), Design.UNDERLINE, "  View Quizzes  \n\n", Design.RESET);
        ArrayList <Quiz> quizzes = quizManager.getQuizzes();

        if(quizzes.isEmpty()) {
            Design.printDesign(Design.ITALIC, Design.PURPLE, tab(), "No quizzes available..!! ", Design.RESET);
            Design.sleep(.5f);
            return;
        }

        Design.printDesign(Design.BOLD, Design.WHITE, Design.ITALIC, tab(), "Available Quizzes:\n\n", Design.RESET);
        Design.printDesign(Design.PURPLE, tab(), " Quiz ID  -   Quiz Title\n", Design.RESET);
        for (Quiz quiz : quizzes) {
            Design.printDesign(Design.BOLD, Design.RED, tab(), "-> ", Design.BLUE, quiz.getQuizId(), ": ", Design.GREEN, quiz.getTitle(), "\n", Design.RESET);
        }
        Design.printDesign("\n");
    }



    // Student panel
    /*
     * 1. View Quizzes
     * 2. Take Quiz
     * 3. Logout
     */
    private static  void StudentPanel(QuizManager quizManager, String username, Scanner input) {
        while (true) {
            Design.clearScreen();
            Design.printDesign(Design.BOLD, Design.CYAN, down(), tab(), Design.UNDERLINE, "Student Panel\n\n", Design.RESET);
            Design.printDesign(Design.BOLD, Design.RED, tab(), " 1. ", Design.GREEN, "View Quizzes\n", Design.RESET);
            Design.printDesign(Design.BOLD, Design.RED, tab(), " 2. ", Design.GREEN, "Take Quiz\n", Design.RESET);
            Design.printDesign(Design.BOLD, Design.RED, tab(), " 3. ", Design.GREEN, "Logout\n", Design.RESET);
            Design.printDesign(Design.ITALIC, Design.YELLOW, tab(), "Please select an option: ", Design.RESET);
            
            String choice = input.nextLine();
            int option = Integer.parseInt(choice);
            
            switch (option) {
                case 1:
                    // View quizzes
                    Design.clearScreen();
                    Design.printDesign(Design.ITALIC, Design.CYAN, down(), tab(), "Available Quizzes... ", Design.RESET);
                    Design.sleep(.5f);

                    viewQuizzes(quizManager, input);
                    Design.pause(input);
                    break;
                case 2:
                    // take quiz
                    Design.clearScreen();
                    Design.printDesign(Design.BOLD, Design.CYAN, down(), tab(), Design.UNDERLINE, "  Take Quiz  \n\n", Design.RESET);
                    Design.sleep(.5f);
                    Design.printDesign(Design.BOLD, Design.GREEN, tab(), "🔘 ", "Enter Quiz ID: ", Design.RESET);
                    String quizId = input.nextLine();
                    int score = quizManager.takeQuiz(quizId, input);

                    Design.clearScreen();
                    input.nextLine();
                    Design.printDesign(Design.BOLD, Design.CYAN, down(), tab(), Design.UNDERLINE, "  Quiz Result  \n\n", Design.RESET);
                    if (score != -1) {
                        Design.printDesign(Design.BOLD, Design.GREEN, tab(), "Congratulation ", username, "! Your score is: "+ score, Design.RESET, "\n");
                        Design.pause(input);
                    } else {
                        Design.printDesign(Design.ITALIC, Design.PURPLE, tab(), "Quiz not found..!! ", Design.RESET);
                        Design.sleep(.5f);
                    }
                    break;
                case 3:
                    // Logout
                    Design.printDesign(Design.ITALIC, Design.PURPLE, tab(), "Logging out...\n", Design.RESET);
                    Design.sleep(.5f);
                    return;
                default:
                    Design.printDesign(Design.ITALIC, Design.PURPLE, tab(), "Invalid choice. Please try again..!  ", Design.RESET);
                    Design.sleep(.5f);
            }
        }
        
    }
}

