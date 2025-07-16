public class User {
    private String email;
    private String password;
    private double balance;

    public User(String email, String password, double balance) {
        this.email = email;
        this.password = password;
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
