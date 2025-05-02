
import java.util.ArrayList;

public class Quiz {
    private String quizId, title;
    private ArrayList<Question> questions;

    // Constructor for setting up a quiz
    public Quiz (String quizId, String title, ArrayList<Question> questions) {
        this.quizId = quizId;
        this.title = title;
        this.questions = questions;
    }

    // Getters for quiz ID, title, and questions
    public String getQuizId() {
        return quizId;
    }
    public String getTitle() {
        return title;
    }
    public ArrayList<Question> getQuestions() {
        return questions;
    }
    
}
