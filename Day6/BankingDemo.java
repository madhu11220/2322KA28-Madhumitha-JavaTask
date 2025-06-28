package Day6;

/**
 * Spawns multiple user threads that try to withdraw from the same account.
 */
public class BankingDemo {
    public static void main(String[] args) {
        final Account account = new Account(5000); // opening balance ₹5,000

        // Each user (thread) will attempt to withdraw ₹2,000
        Runnable userTask = () -> account.withdraw(Thread.currentThread().getName(), 2000);

        // Create four users; only the first two should succeed
        Thread user1 = new Thread(userTask, "User-1");
        Thread user2 = new Thread(userTask, "User-2");
        Thread user3 = new Thread(userTask, "User-3");
        Thread user4 = new Thread(userTask, "User-4");

        user1.start();
        user2.start();
        user3.start();
        user4.start();

        // Wait for all threads to complete so Main exits cleanly
        try {
            user1.join();
            user2.join();
            user3.join();
            user4.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.printf("%n[Main]  Final balance in account: ₹%d%n", account.getBalance());
    }
}
