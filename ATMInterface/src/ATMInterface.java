import java.util.Scanner;

class BankAccount {
    private double balance;

    // Constructor to initialize the account with an initial balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to deposit an amount into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw an amount from the account
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew: $" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance for this transaction.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    // Method to check the current balance of the account
    public double checkBalance() {
        return balance;
    }
}

class ATM {
    private BankAccount account;

    // Constructor to initialize the ATM with a bank account
    public ATM(BankAccount account) {
        this.account = account;
    }

    // Method to display the ATM menu and process user input
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Please choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit(scanner);
                    break;
                case 3:
                    withdraw(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 4);
    }

    // Method to check the balance
    private void checkBalance() {
        System.out.println("Current balance: $" + account.checkBalance());
    }

    // Method to deposit an amount into the account
    private void deposit(Scanner scanner) {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    // Method to withdraw an amount from the account
    private void withdraw(Scanner scanner) {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.00);

        // Initialize the ATM with the user's bank account
        ATM atm = new ATM(userAccount);

        // Display the ATM menu
        atm.displayMenu();
    }
}
