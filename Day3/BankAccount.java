package Day3;

public class BankAccount {
    private String accountHolderName;
    private String accountNumber;
    private double balance;

    
    public BankAccount(String name, String number, double initialBalance) {
        this.accountHolderName = name;
        this.accountNumber = number;
        this.balance = initialBalance;
    }

    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: ₹" + amount);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    
    public double getBalance() {
        return balance;
    }

    
    public void displayAccountDetails() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: ₹" + balance);
    }

    
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Sowmeha", "1234567890", 1000.0);

        account.displayAccountDetails();
        account.deposit(500.0);
        account.withdraw(200.0);
        account.withdraw(2000.0);  
        account.displayAccountDetails();
    }
}

