package Day6;

import java.util.Random;

/** Shared ticket counter */
class TicketCounter {
    private int seatsAvailable;

    public TicketCounter(int seats) {
        this.seatsAvailable = seats;
    }

    /**
     * Attempts to book the requested number of seats.
     * Uses a synchronized block on the TicketCounter instance to avoid race conditions.
     */
    public boolean book(String userName, int seatsRequested) {
        synchronized (this) {
            System.out.printf("%s is attempting to book %d seat(s)…%n", userName, seatsRequested);

            // Simulate payment/processing delay while still holding the lock
            try {
                Thread.sleep(500);  // 0.5-second processing time
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            if (seatsRequested <= seatsAvailable) {
                seatsAvailable -= seatsRequested;
                System.out.printf("✅ %s successfully booked %d seat(s). Seats left: %d%n",
                        userName, seatsRequested, seatsAvailable);
                return true;
            } else {
                System.out.printf("❌ %s FAILED to book %d seat(s). Only %d left.%n",
                        userName, seatsRequested, seatsAvailable);
                return false;
            }
        }
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }
}

/** Runnable representing a user trying to book tickets */
class User implements Runnable {
    private final TicketCounter counter;
    private final int seatsToBook;
    private final Random random = new Random();

    public User(TicketCounter counter, int seatsToBook) {
        this.counter = counter;
        this.seatsToBook = seatsToBook;
    }

    @Override
    public void run() {
        // Random delay before attempting to book (simulates users arriving at different times)
        try {
            Thread.sleep(random.nextInt(800));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        counter.book(Thread.currentThread().getName(), seatsToBook);
    }
}

public class TicketBookingSimulation {
    public static void main(String[] args) {
        int initialSeats = 6;
        TicketCounter counter = new TicketCounter(initialSeats);

        // Create users who each want 2 seats
        Thread alice  = new Thread(new User(counter, 2), "Alice");
        Thread bob    = new Thread(new User(counter, 2), "Bob");
        Thread carol  = new Thread(new User(counter, 2), "Carol");
        Thread dave   = new Thread(new User(counter, 2), "Dave"); // will likely fail

        alice.start();
        bob.start();
        carol.start();
        dave.start();

        // Wait for all users to finish, using join()
        try {
            alice.join();
            bob.join();
            carol.join();
            dave.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.printf("%nBooking session complete. Final seats remaining: %d%n",
                counter.getSeatsAvailable());
    }
}

