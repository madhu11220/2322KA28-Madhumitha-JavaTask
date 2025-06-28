package Day6;


//Step 1: Create a class that extends Thread
class NumberPrinter extends Thread {
 // Step 2: Override the run() method
 @Override
 public void run() {
     // Step 3: Print numbers from 1 to 10
     for (int i = 1; i <= 10; i++) {
         System.out.println(i);
         try {
             // Sleep for 500 milliseconds to slow down output
             Thread.sleep(500);
         } catch (InterruptedException e) {
             System.out.println("Thread was interrupted.");
             Thread.currentThread().interrupt(); // Restore interrupt status
         }
     }
 }
}

