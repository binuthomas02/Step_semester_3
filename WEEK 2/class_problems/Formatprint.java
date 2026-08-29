import java.util.*;
class Formatprint{
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter a line: ");
       String line = sc.nextLine();
       String [] word = line.split(",");
       if( word.length != 3)
       {
           System.out.println("Invalid Record");
       }
       else
       {
           System.out.println("Name: " + word[0] +"|" + "Regno.: " + word[1] + "|" + "Dept: " + word[2] );
           
           
       }
    }
}