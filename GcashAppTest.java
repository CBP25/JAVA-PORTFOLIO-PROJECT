// File: GcashAppTest.java
import java.util.Scanner;
import java.util.ArrayList;

public class GcashAppTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("test@gmail.com", "1234", 5000));
        users.add(new User("john@gmail.com", "abcd", 2000));
        users.add(new User("maria@gmail.com", "pass123", 3000));

        User currentUser = null;

        try {
            // Login
            System.out.println("===== GCASH LOGIN =====");
            System.out.print("Enter email: ");
            String email = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            for (User u : users) {
                if (u.getEmail().equalsIgnoreCase(email) && u.getPassword().equals(password)) {
                    currentUser = u;
                    break;
                }
            }

            if (currentUser == null) {
                System.out.println("Invalid email or password. Exiting...");
                return;
            } else {
                System.out.println("Login successful! Welcome " + currentUser.getEmail());
            }

            int choice = -1;
            ArrayList<String> transactions = new ArrayList<>();

            while (choice != 6) {
                System.out.println("\n===== GCASH MENU =====");
                System.out.println("1. Check Balance");
                System.out.println("2. Cash In");
                System.out.println("3. Cash Transfer");
                System.out.println("4. View Transactions");
                System.out.println("5. Change Account");
System.out.println("6. Exit");
                System.out.print("Choose an option: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Your current balance is: PHP " + currentUser.getBalance());
                        break;
                    case 2:
                        System.out.print("Enter amount to cash in: PHP ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine();
                        currentUser.setBalance(currentUser.getBalance() + amount);
                        transactions.add("Cash in: PHP " + amount);
                        System.out.println("Cash in successful.");
                        break;
                    case 3:
                        System.out.print("Enter recipient's email: ");
                        String recipientEmail = scanner.nextLine();
                        User recipient = null;
                        for (User u : users) {
                            if (u.getEmail().equalsIgnoreCase(recipientEmail)) {
                                recipient = u;
                                break;
                            }
                        }
                        if (recipient == null) {
                            System.out.println("Recipient not found.");
                            break;
                        }
                        System.out.print("Enter amount to transfer: PHP ");
                        double transfer = scanner.nextDouble();
                        scanner.nextLine();
                        if (currentUser.getBalance() >= transfer) {
                            currentUser.setBalance(currentUser.getBalance() - transfer);
                            recipient.setBalance(recipient.getBalance() + transfer);
                            transactions.add("Transferred PHP " + transfer + " to " + recipientEmail);
                            transactions.add("Received PHP " + transfer + " from " + currentUser.getEmail());
                            System.out.println("Transfer successful.");
                        } else {
                            System.out.println("Insufficient balance.");
                        }
                        break;
                    case 4:
                        System.out.println("\n=== Transaction History ===");
                        if (transactions.isEmpty()) {
                            System.out.println("No transactions yet.");
                        } else {
                            for (String t : transactions) {
                                System.out.println(t);
                            }
                        }
                        break;
                    case 5:
    System.out.println("=== Change Account ===");
    System.out.print("Enter email: ");
    String newEmail = scanner.nextLine();
    System.out.print("Enter password: ");
    String newPassword = scanner.nextLine();
    boolean found = false;
    for (User u : users) {
        if (u.getEmail().equalsIgnoreCase(newEmail) && u.getPassword().equals(newPassword)) {
            currentUser = u;
            transactions.clear();
            System.out.println("Switched to account: " + newEmail);
            found = true;
            break;
        }
    }
    if (!found) {
        System.out.println("Invalid email or password.");
    }
    break;

case 6:
    System.out.println("Thank you for using Gcash. Goodbye!");
    break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
