import java.util.ArrayList;

public class Transactions {
    private static ArrayList<String> history = new ArrayList<>();

    public static void log(String message) {
        history.add(message);
    }

    public static ArrayList<String> getHistory() {
        return history;
    }
}