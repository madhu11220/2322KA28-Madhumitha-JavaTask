package Day6;

// A task that simply prints a message
class MessageTask implements Runnable {
    private final String message;

    MessageTask(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        // Print the message along with the current thread’s name
        System.out.println(Thread.currentThread().getName() + ": " + message);
    }
}

public class Main3 {
    public static void main(String[] args) {
        // Create three Runnable tasks, each with its own message
        Runnable task1 = new MessageTask("Hello from Task 1!");
        Runnable task2 = new MessageTask("Greetings from Task 2!");
        Runnable task3 = new MessageTask("Hi there from Task 3!");

        // Wrap each Runnable in a Thread (optional: give each thread a name)
        Thread thread1 = new Thread(task1, "Thread-A");
        Thread thread2 = new Thread(task2, "Thread-B");
        Thread thread3 = new Thread(task3, "Thread-C");

        // Start all three threads
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
