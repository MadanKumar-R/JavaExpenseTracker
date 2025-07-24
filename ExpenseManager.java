import java.io.*;
import java.util.*;

public class ExpenseManager {
    private final String FILE_NAME = "expenses.txt";

    public void addExpense(Scanner scanner) {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter date (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        Expense expense = new Expense(title, amount, date);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(expense.toFileFormat());
            writer.newLine();
            System.out.println("Expense added.");
        } catch (IOException e) {
            System.out.println("Failed to write expense.");
        }
    }

    public void viewExpenses() {
        System.out.println("\n--- All Expenses ---");
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Expense expense = new Expense(parts[0], Double.parseDouble(parts[1]), parts[2]);
                System.out.println(expense);
            }
        } catch (IOException e) {
            System.out.println("Failed to read expenses.");
        }
    }

    public void calculateTotal() {
        double total = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                total += Double.parseDouble(parts[1]);
            }
        } catch (IOException e) {
            System.out.println("Failed to calculate total.");
        }
        System.out.println("Total spent: ₹" + total);
    }
}
