package Day6;

//Demonstrates thread coordination with sleep() and join()
class Worker extends Thread {
 private final int workTimeMillis;

 Worker(String name, int workTimeMillis) {
     super(name);                // set thread name
     this.workTimeMillis = workTimeMillis;
 }

 @Override
 public void run() {
     try {
         System.out.println(getName() + " starting work");
         Thread.sleep(workTimeMillis);          // simulate work
         System.out.println(getName() + " finished work");
     } catch (InterruptedException e) {
         System.out.println(getName() + " was interrupted");
         Thread.currentThread().interrupt();    // restore flag
     }
 }
}

public class CoordinatedThreads {
 public static void main(String[] args) {
     Worker w1 = new Worker("Worker-1", 2000);   // 2-second job
     Worker w2 = new Worker("Worker-2", 3000);   // 3-second job

     w1.start();         // start first worker

     try {
         /* ---------- join() #1 ----------
          * Main waits until w1 is done before starting w2.
          */
         w1.join();
     } catch (InterruptedException e) {
         System.out.println("Main thread interrupted while waiting for w1");
         Thread.currentThread().interrupt();
     }

     w2.start();         // start second worker

     try {
         /* ---------- join() #2 ----------
          * Main waits until w2 is done before exiting.
          */
         w2.join();
     } catch (InterruptedException e) {
         System.out.println("Main thread interrupted while waiting for w2");
         Thread.currentThread().interrupt();
     }

     System.out.println("Both workers completed. Main thread exiting.");
 }
}
