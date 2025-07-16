public class Cashin {
    public static void deposit(String email, double amount) throws Exception {
        User user = GcashDatabase.getUser(email);
        if (user != null) {
            user.setBalance(user.getBalance() + amount);
        } else {
            throw new Exception("User not found");
        }
    }
}