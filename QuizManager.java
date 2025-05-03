
import java.util.ArrayList;
import java.util.Scanner;

/*
 * 1. Create a quiz
 * 2. Take a quiz
 * 3. Calculate score
 * 4. view all quizzes
 */
public class QuizManager {
    private FileDatabase database;
    private ArrayList<Quiz> quizzes;

    public QuizManager() {
        this.database = new FileDatabase();
        try {
            this.quizzes = database.loadQuizzes();

        } catch (Exception e) {
            Design.printDesign (Design.PURPLE, Main.tab(), "Error loading quizzes: " , e.getMessage(), Design.RESET);
        }
    }


    // Create a new quiz
    public void createQuiz (Quiz quiz) {
            quizzes.add(quiz);
        try {
            database.saveQuiz(quiz);
            Design.printDesign (Design.GREEN, Main.tab(), "Quiz saved successfully!\n\n", Design.RESET);
        } catch (Exception e) {
            Design.printDesign (Design.PURPLE, Main.tab(), "Error saving quiz: " , e.getMessage(), Design.RESET);
        }
    }

    // Take a quiz
    public int takeQuiz (String quizId, Scanner input) {
        Design.clearScreen();
        // if want to add time limit , add a timer here
            
        // find the quiz by id using java Streams
        Quiz quiz = quizzes.stream()
                .filter (q -> q.getQuizId().equals(quizId))
                .findFirst()
                .orElse(null);

        if (quiz == null) {
            Design.printDesign (Design.ITALIC, Design.PURPLE, Main.down(), Main.tab(), "Quiz not found!", Design.RESET);
            return -1;
        }

        Design.printDesign("\n", Main.tab(), Design.UNDERLINE, Design.BOLD, Design.CYAN, "Taking quiz: ", quiz.getTitle(), Design.RESET, "\n\n");
        int score = 0;
        ArrayList<Question> questions = quiz.getQuestions();

        int n = 1;
        for (Question question : questions) {
            Design.printDesign(" ".repeat(Design.width()/4), Design.BOLD, Design.RED, "Q", Integer.toString(n++) , " : ", Design.GREEN, question.getQuestionText(), Design.RESET, "\n");

            ArrayList<String> options = question.getOptions();
            for(int i = 0; i < options.size(); i++) {
                Design.printDesign (" ".repeat(Design.width()/4), Design.BLUE, Design.BOLD, "  ", Integer.toString(i + 1), ". ", Design.WHITE, options.get(i), Design.RESET + "\n");
            }

            Design.printDesign (" ".repeat(Design.width()/4), Design.YELLOW, "Enter your answer (1-" + options.size() + "): ", Design.RESET);
            int answer = input.nextInt();
            
            if(answer < 1 || answer > options.size()) {
                // invalid answer
            }

            if(question.getCorrectAnswerIndex() == answer) score++;
            // System.out.println("\n\n");
        }
        return score;
    }


    // get all quizzes
    public ArrayList <Quiz> getQuizzes() {
        return quizzes;
    }
    
}