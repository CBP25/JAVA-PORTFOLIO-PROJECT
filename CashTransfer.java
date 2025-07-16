public class CashTransfer {
    public static void transfer(String fromEmail, String toEmail, double amount) throws Exception {
        User sender = GcashDatabase.getUser(fromEmail);
        User receiver = GcashDatabase.getUser(toEmail);

        if (sender == null || receiver == null) {
            throw new Exception("Sender or receiver not found");
        }
        if (sender.getBalance() < amount) {
            throw new Exception("Insufficient balance");
        }
        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);
    }
}