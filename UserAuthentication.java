public class UserAuthentication {
    public static boolean login(String email, String password) throws Exception {
        User user = GcashDatabase.getUser(email);
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        throw new Exception("Invalid email or password");
    }
}