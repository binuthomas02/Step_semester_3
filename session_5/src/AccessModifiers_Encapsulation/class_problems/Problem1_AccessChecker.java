public class Problem1_AccessChecker {

    public static void main(String[] args) {
        System.out.println(classifyAccess("private", "SAME_CLASS"));
        System.out.println(classifyAccess("protected", "DIFFERENT_PACKAGE"));
        System.out.println(summarizeBatch(new String[][]{
                {"default", "SAME_PACKAGE"},
                {"default", "DIFFERENT_PACKAGE"},
                {"public", "DIFFERENT_PACKAGE"}
        }));
    }

    static String classifyAccess(String fieldModifier, String accessorContext) {
        boolean allowed;

        if (fieldModifier.equals("private")) {
            allowed = accessorContext.equals("SAME_CLASS");
        } else if (fieldModifier.equals("default")) {
            allowed = accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE");
        } else if (fieldModifier.equals("protected")) {
            allowed = accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE");
        } else if (fieldModifier.equals("public")) {
            allowed = true;
        } else {
            allowed = false;
        }

        return allowed ? "ALLOWED" : "DENIED";
    }

    static String summarizeBatch(String[][] attempts) {
        int allowed = 0, denied = 0;
        for (String[] a : attempts) {
            if (classifyAccess(a[0], a[1]).equals("ALLOWED")) {
                allowed++;
            } else {
                denied++;
            }
        }
        return "Allowed: " + allowed + " | Denied: " + denied;
    }
}

/**
 * MovieTicket — field access levels chosen per real-world need:
 *  - seatNumber: private   (only this exact ticket instance should touch it)
 *  - screenId:   default   (package-level booking utilities need it)
 *  - ticketPrice: protected (Problem 2 requires a subclass in another package to read it)
 *  - movieTitle: public    (shown everywhere, safe to expose fully)
 */
class MovieTicket {
    private int seatNumber;
    int screenId;
    protected double ticketPrice;
    public String movieTitle;
}
