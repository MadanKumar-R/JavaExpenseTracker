public class Expense {
    private String title;
    private double amount;
    private String date;

    public Expense(String title, double amount, String date) {
        this.title = title;
        this.amount = amount;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public String toFileFormat() {
        return title + "," + amount + "," + date;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Amount: ₹" + amount + ", Date: " + date;
    }
}
