package Day6;

/**
 * A simple bank account that supports thread-safe withdrawals.
 */
public class Account {
    private int balance;

    public Account(int openingBalance) {
        this.balance = openingBalance;
    }

    /**
     * Withdraws the requested amount if sufficient funds exist.
     * The method is synchronized to avoid race conditions.
     *
     * @return true on success, false if insufficient balance
     */
    public synchronized boolean withdraw(String threadName, int amount) {
        System.out.printf("[%s]  Attempting to withdraw ₹%d …%n", threadName, amount);

        try {
            // Simulate processing / network delay
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        if (amount <= balance) {
            balance -= amount;
            System.out.printf("[%s]  ✅ Withdrawal successful. Remaining balance: ₹%d%n",
                              threadName, balance);
            return true;
        } else {
            System.out.printf("[%s]  ❌ Withdrawal failed (insufficient funds). Balance: ₹%d%n",
                              threadName, balance);
            return false;
        }
    }

    public int getBalance() {
        return balance;
    }
}
