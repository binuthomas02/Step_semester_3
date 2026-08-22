import java.util.*;

public class Reference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Reference Number: ");
        String ref = sc.nextLine().trim();

        if (ref.length() != 14) {
            System.out.println("Invalid: wrong length");
            return;
        }

        ref = ref.substring(0, 3).toUpperCase() + ref.substring(3);

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(ref.charAt(i))) {
                System.out.println("Invalid: bank code must be 3 letters");
                return;
            }
        }

        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(ref.charAt(i))) {
                System.out.println("Invalid: body must contain digits");
                return;
            }
        }

        String date = ref.substring(3, 5) + "/" +
                      ref.substring(5, 7) + "/" +
                      ref.substring(7, 9);

        String seq = ref.substring(9);

        System.out.println("[" + ref.substring(0, 3) + "] DATE: " + date + " | SEQ: " + seq);
    }
}