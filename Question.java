
import java.util.ArrayList;

public class Question {
    private String questionText;
    private ArrayList<String> options;
    private int correctAnswerIndex;

    // Constructor for setting up a question 
    public Question (String questionText, ArrayList<String> options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    // Getters for question text, options, and correct answer index
    public String getQuestionText() {
        return questionText;
    }
    public ArrayList<String> getOptions() {
        return options;
    }
    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }
}
