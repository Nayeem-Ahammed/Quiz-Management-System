
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
            Design.printDesign (Design.PURPLE, Main.tab, "Error loading quizzes: " , e.getMessage(), Design.RESET);
        }
    }


    // Create a new quiz
    public void createQuiz (Quiz quiz) {
            quizzes.add(quiz);
        try {
            database.saveQuiz(quiz);
            Design.printDesign (Design.GREEN, Main.tab, "Quiz saved successfully!\n\n", Design.RESET);
        } catch (Exception e) {
            Design.printDesign (Design.PURPLE, Main.tab, "Error saving quiz: " , e.getMessage(), Design.RESET);
        }
    }

    // Take a quiz
    public int takeQuiz (String quizId, Scanner input) {
        // if want to add time limit , add a timer here
            
        // find the quiz by id using java Streams
        Quiz quiz = quizzes.stream()
                .filter (q -> q.getQuizId().equals(quizId))
                .findFirst()
                .orElse(null);

        if (quiz == null) {
            Design.printDesign (Design.RED, Main.tab, "Quiz not found!", Design.RESET);
            return -1;
        }

        Design.printDesign(Design.CYAN, Main.tab, "Taking quiz: ", quiz.getTitle(), Design.RESET);
        int score = 0;
        ArrayList<Question> questions = quiz.getQuestions();

        int n = 1;
        for (Question question : quiz.getQuestions()) {
            Design.printDesign(Main.tab, Design.RED, "Q", Integer.toString(n++) , " : ", Design.GREEN, question.getQuestionText(), Design.RESET);

            ArrayList<String> options = question.getOptions();
            for(int i = 0; i < options.size(); i++) {
                Design.printDesign (Main.tab, Design.YELLOW, "  ", Integer.toString(i + 1), ". ", Design.CYAN, options.get(i), Design.RESET);
            }

            Design.printDesign (Main.tab, Design.YELLOW, "Enter your answer (1-" + options.size() + "): ", Design.RESET);
            int answer = input.nextInt();
            
            if(answer < 1 || answer > options.size()) {
                // invalid answer
            }

            if(question.getCorrectAnswerIndex() == answer - 1) score++;
        }
        return score;
    }


    // get all quizzes
    public ArrayList <Quiz> getQuizzes() {
        return quizzes;
    }
    
}