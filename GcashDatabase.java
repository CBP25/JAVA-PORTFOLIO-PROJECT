import java.util.ArrayList;

public class GcashDatabase {
    private static ArrayList<User> users = new ArrayList<>();

    static {
        users.add(new User("test@gmail.com", "1234", 5000));
        users.add(new User("john@gmail.com", "abcd", 2000));
    }

    public static User getUser(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }
}
