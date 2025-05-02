/*      User Manager
 * ___________________________ 
 * 1. saveUser(User user)
 * 2. loadUsers()
 * 3. saveQuiz(Quiz quiz)
 * 4. loadQuizzes()
 */


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileDatabase {
    private static final String USERS_FILE = "users.txt";
    private static final String QUIZZESS_FILE = "quizzes.txt";

    // check if username already exists
    public boolean userExists(String username) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(username)) {
                    return true;
                }
            }
        }
        return false;
    }
    // check if password is correct

    // save user data to file
    public void saveUser(User user) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USERS_FILE, true))) {
            writer.write(user.getUsername() + "," + user.getPassword() + "," + user.getRole());
            writer.newLine();
        }
    }
    // Load all users from file
    public ArrayList <User> loadUsers() throws IOException {
        ArrayList <User> users = new ArrayList<>();
        File file = new File(USERS_FILE);

        if(!file.exists()) return users;

        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    users.add(new User(parts[0], parts[1], parts[2]));
                }
            }
        }
        return users; 
    }

    // save quiz data to file
    public void saveQuiz (Quiz quiz) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter (QUIZZESS_FILE, true))) {
            // format : quizId|title|question1_text;option1,option2,option3,option4;correctInex|question2_text;opt....
            StringBuilder sb = new StringBuilder();
            sb.append(quiz.getQuizId()). append("|"). append(quiz.getTitle()). append("|");

            for(Question question : quiz.getQuestions()) {
                sb.append(question.getQuestionText()).append(";");
                sb.append(String.join(",", question.getOptions())).append(";");
                sb.append(question.getCorrectAnswerIndex()).append("|");
            }

            writer.write(sb.toString());
            writer.newLine();
        }
            
    }


    // load all quezzes from file
    public ArrayList<Quiz> loadQuizzes() throws IOException {
        ArrayList<Quiz> quizzes = new ArrayList<>();
        File file = new File (QUIZZESS_FILE);

        if(!file.exists()) return quizzes;

        try (BufferedReader reader = new BufferedReader(new FileReader (QUIZZESS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|"); // Split by '|'
                // format : quizId|title|question1_text;option1,option2,option3,option4;correctInex|question2_text;opt....
                if (parts.length > 2) { // at least quizId, title, and one question
                    
                    String quizId = parts[0], title = parts[1];
                    ArrayList <Question> questions = new ArrayList<>();
                    
                    for(int i = 2; i < parts.length; i++) {  
                        String[] questionParts = parts[i].split(";"); 
                        if (questionParts.length == 3) { 
                            String questionText = questionParts[0]; 
                            ArrayList <String> options = new ArrayList<> (List.of(questionParts[1].split(","))); // 
                            int correctAnswerIndex = Integer.parseInt(questionParts[2]);

                            questions.add (new Question(questionText, options, correctAnswerIndex));
                        }
                    }

                    quizzes.add (new Quiz(quizId, title, questions));
                }
            }
        }
        return quizzes;
    }

}