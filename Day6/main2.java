package Day6;

//MyThread demonstrates a custom thread that counts to 3
class MyThread extends Thread {
 private final String name;

 public MyThread(String name) {
     this.name = name;
 }

 // Override run() to provide the thread’s work
 @Override
 public void run() {
     for (int i = 1; i <= 3; i++) {
         System.out.println(name + " - Count: " + i);
         try {
             Thread.sleep(500);          // Pause 500 ms
         } catch (InterruptedException e) {
             System.out.println(name + " was interrupted.");
             Thread.currentThread().interrupt(); // restore flag
         }
     }
     System.out.println(name + " has finished.");
 }
}

//Main2 launches two threads and uses join() for sequencing
public class main2 {
 public static void main(String[] args) {
     MyThread thread1 = new MyThread("Thread 1");
     MyThread thread2 = new MyThread("Thread 2");

     thread1.start();        // start first

     try {
         thread1.join();     // wait until thread1 is done
     } catch (InterruptedException e) {
         System.out.println("Main thread interrupted while waiting for thread1.");
         Thread.currentThread().interrupt();
     }

     thread2.start();        // start second

     try {
         thread2.join();     // wait until thread2 is done
     } catch (InterruptedException e) {
         System.out.println("Main thread interrupted while waiting for thread2.");
         Thread.currentThread().interrupt();
     }

     System.out.println("Main thread finished.");
 }
}
