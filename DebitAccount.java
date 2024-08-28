// Class to represent a bank account
class Account {
    private double balance;

    // Constructor to initialize the account balance
    public Account(double initialBalance) {
        if (initialBalance > 0.0) {
            this.balance = initialBalance;
        }
    }

    // Method to credit (add) an amount to the account
    public void credit(double amount) {
        balance += amount;
    }

    // Method to debit (withdraw) an amount from the account
    public void debit(double amount) {
        if (amount > balance) {
            System.out.println("Debit amount exceeded account balance.");
        } else {
            balance -= amount;
        }
    }

    // Method to get the current balance
    public double getBalance() {
        return balance;
    }
}

// Class to test the Account class and its debit method
public class DebitAccount {
    public static void main(String[] args) {
        Account myAccount = new Account(100.00); // Create Account with initial balance

        System.out.println("Initial balance: $" + myAccount.getBalance());

        myAccount.credit(50.00); // Add money to the account
        System.out.println("Balance after credit: $" + myAccount.getBalance());

        myAccount.debit(30.00); // Attempt to withdraw money
        System.out.println("Balance after debit: $" + myAccount.getBalance());

        myAccount.debit(150.00); // Attempt to withdraw more than the balance
        System.out.println("Balance after attempted over-debit: $" + myAccount.getBalance());
    }
}
