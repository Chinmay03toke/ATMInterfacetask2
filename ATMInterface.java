import java.util.Scanner;

public class ATMInterface {
    private static double balance = 1000.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM Interface!");

        while (true) {
            printMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayBalance();
                    break;
                case 2:
                    depositAmount(scanner);
                    break;
                case 3:
                    withdrawAmount(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Have a great day!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nSelect an option:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    private static void displayBalance() {
        System.out.println("Your account balance: $" + balance);
    }

    private static void depositAmount(Scanner scanner) {
        System.out.print("Enter the amount to deposit: $");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount. Please try again.");
        } else {
            balance += amount;
            System.out.println("Deposit successful. New balance: $" + balance);
        }
    }

    private static void withdrawAmount(Scanner scanner) {
        System.out.print("Enter the amount to withdraw: $");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount. Please try again.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance. You can't withdraw more than your account balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
        }
    }
}
