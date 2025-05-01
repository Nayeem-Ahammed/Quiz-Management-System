/*      User Manager
 * ___________________________ 
 * 1. saveUser(User user)
 * 2. loadUsers()
 * 3. saveQuiz(Quiz quiz)
 * 4. loadQuizzes()
 */


import java.io.*;
import java.util.ArrayList;

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
    // load all quezzes from file

}