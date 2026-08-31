import java.util.*;
class Filename {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Filename: ");
        String filename = sc.nextLine();
        int dotIndex = filename.lastIndexOf(".");
        if (dotIndex > 0 && dotIndex < filename.length() - 1) {
            String extension = filename.substring(dotIndex + 1);
            System.out.println("Accepted");
        } else {
            System.out.println("Rejected — invalid file type        ");
        }
        
        sc.close();
    }
}