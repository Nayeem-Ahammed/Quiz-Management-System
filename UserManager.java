
import java.util.ArrayList;



public class UserManager {
    private FileDatabase database;
    private User currentUser;

    public UserManager() {
        this.database = new FileDatabase();
    }
    

    // Register a new user
    public boolean register (User user) {
        try {
            database.saveUser(user);
            
        } catch (Exception e) {
            System.out.println("Error saving user: " + e.getMessage());
            return false;
        }
        return true;
    }

    // Login a user
    public User login (String username, String password) {
        try {
            ArrayList <User> users = database.loadUsers();

            for(User user : users) {
                if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    currentUser = user;
                    return currentUser;
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading users: " + e.getMessage());
        }
        return null;
    }

    // Get the current user
    public User getCurrentUser() { return currentUser; }
}
