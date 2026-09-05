public class Problem3_CineScreen {

    public static void main(String[] args) {
        CineScreen c = new CineScreen(2);
        c.bookSeat();
        c.bookSeat();
        c.bookSeat(); // rejected, only 2 seats existed
        System.out.println(c.getSeatsAvailable()); // 0

        c.cancelBooking();
        c.cancelBooking();
        c.cancelBooking(); // rejected, already back to full
        System.out.println(c.getSeatsAvailable()); // 2

        try {
            new CineScreen(0);
        } catch (IllegalArgumentException e) {
            System.out.println("construction rejected: " + e.getMessage());
        }
    }
}

class CineScreen {
    private int seatsTotal;
    private int seatsAvailable;

    public CineScreen(int seatsTotal) {
        if (seatsTotal <= 0) {
            throw new IllegalArgumentException("seatsTotal must be positive");
        }
        this.seatsTotal = seatsTotal;
        this.seatsAvailable = seatsTotal;
    }

    public void bookSeat() {
        if (seatsAvailable > 0) {
            seatsAvailable--;
        }
        // else: silently reject, no seats left
    }

    public void cancelBooking() {
        if (seatsAvailable < seatsTotal) {
            seatsAvailable++;
        }
        // else: silently reject, nothing genuine to undo
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }
}
