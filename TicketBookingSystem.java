import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketBookingSystem {
    private static final int TOTAL_SEATS = 10;
    private static final Lock lock = new ReentrantLock();
    private static int availableSeats = TOTAL_SEATS;

    public static void main(String[] args) {
        Thread vipThread = new Thread(new BookingRunnable("VIP"), "VIP");
        Thread regularThread = new Thread(new BookingRunnable("Regular"), "Regular");

        vipThread.setPriority(Thread.MAX_PRIORITY);
        regularThread.setPriority(Thread.NORM_PRIORITY);

        vipThread.start();
        regularThread.start();
    }

    static class BookingRunnable implements Runnable {
        private String type;

        public BookingRunnable(String type) {
            this.type = type;
        }

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    if (availableSeats > 0) {
                        System.out.println(type + " thread booked a seat. Available seats: " + --availableSeats);
                    } else {
                        break;
                    }
                } finally {
                    lock.unlock();
                }

                try {
                    Thread.sleep(500); // Simulate booking time
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
