public class CheckBalance {
    public static double getBalance(String email) throws Exception {
        User user = GcashDatabase.getUser(email);
        if (user != null) {
            return user.getBalance();
        }
        throw new Exception("User not found");
    }
}