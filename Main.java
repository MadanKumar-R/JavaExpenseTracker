import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserManager userManager = new UserManager();

        System.out.println("Welcome to Secure Expense Tracker");
        if (!userManager.login(scanner)) {
            System.out.println("Login failed. Exiting...");
            return;
        }

        ExpenseManager manager = new ExpenseManager();
        int choice;

        do {
            System.out.println("\n--- Expense Tracker Menu ---");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Total Spent");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    manager.addExpense(scanner);
                    break;
                case 2:
                    manager.viewExpenses();
                    break;
                case 3:
                    manager.calculateTotal();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
