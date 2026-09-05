public class Problem4_MovieBookingProfile {

    public static void main(String[] args) {
        MovieBookingProfile p = new MovieBookingProfile("Rahul Dev");
        System.out.println(p.getName()); // "Rahul Dev"

        p.setConfirmed(true);
        System.out.println(p.isConfirmed()); // true

        p.setOtp("4471"); // no getter exists anywhere to read this back
    }
}

class MovieBookingProfile {
    private String name;
    private boolean confirmed;
    private String otp;

    public MovieBookingProfile() {
    }

    public MovieBookingProfile(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
    // Deliberately no getOtp() / isOtp() anywhere — otp is permanently write-only.
}
