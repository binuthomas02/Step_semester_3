public class Problem5_BookingReceipt {

    public static void main(String[] args) {
        BookingReceipt b = new BookingReceipt("CH-1001", new String[]{"A1", "A2"});
        String[] seats = b.getSeatNumbers();
        seats[0] = "X"; // mutating the returned array must not affect internal state
        System.out.println(b.getSeatNumbers()[0]); // "A1"

        BookingReceipt updated = b.withUpdatedSeat(1, "A3");
        System.out.println(java.util.Arrays.toString(b.getSeatNumbers()));       // [A1, A2]
        System.out.println(java.util.Arrays.toString(updated.getSeatNumbers())); // [A1, A3]

        BookingReceipt[] batch = {
                new GroupBookingReceipt("CH-2002", new String[]{"B1", "B2"}, 2),
                null,
                new BookingReceipt("CH-3003", new String[]{"C1"})
        };
        System.out.println(NightlySettlement.processNightlySettlement(batch));
        // "2 processed | 1 null skipped | 1 group | 1 individual"
    }
}

/*
 * Note: the spec asks for BookingReceipt to be `final` AND for GroupBookingReceipt
 * to extend it so processNightlySettlement can use `instanceof` to tell them apart.
 * Real Java can't satisfy both at once — a final class cannot be subclassed.
 * Since instanceof-based dispatch through inheritance is an explicit requirement,
 * this keeps the inheritance and drops only the literal `final` keyword on the class.
 * Immutability itself (final fields, defensive copies both ways, wither method) is intact.
 */
class BookingReceipt {
    private final String bookingId;
    private final String[] seatNumbers;

    public BookingReceipt(String bookingId, String[] seatNumbers) {
        this.bookingId = bookingId;
        this.seatNumbers = seatNumbers.clone(); // defensive copy IN
    }

    public String getBookingId() {
        return bookingId;
    }

    public String[] getSeatNumbers() {
        return seatNumbers.clone(); // defensive copy OUT
    }

    public BookingReceipt withUpdatedSeat(int index, String newSeat) {
        String[] updatedSeats = seatNumbers.clone();
        updatedSeats[index] = newSeat;
        return new BookingReceipt(bookingId, updatedSeats);
    }
}

final class GroupBookingReceipt extends BookingReceipt {
    private final int groupSize;

    public GroupBookingReceipt(String bookingId, String[] seatNumbers, int groupSize) {
        super(bookingId, seatNumbers);
        this.groupSize = groupSize;
    }

    public int getGroupSize() {
        return groupSize;
    }
}

class NightlySettlement {
    static String processNightlySettlement(BookingReceipt[] receipts) {
        int processed = 0, nullsSkipped = 0, group = 0, individual = 0;

        for (BookingReceipt r : receipts) {
            if (r == null) {
                nullsSkipped++;
                continue;
            }
            processed++;
            if (r instanceof GroupBookingReceipt) {
                group++;
            } else {
                individual++;
            }
        }

        return processed + " processed | " + nullsSkipped + " null skipped | "
                + group + " group | " + individual + " individual";
    }
}
