import java.util.Scanner;

public class UserManager {
    private final String USERNAME = "admin";
    private final String PASSWORD = "1234";

    public boolean login(Scanner scanner) {
        System.out.print("Username: ");
        String user = scanner.nextLine();
        System.out.print("Password: ");
        String pass = scanner.nextLine();

        return user.equals(USERNAME) && pass.equals(PASSWORD);
    }
}
