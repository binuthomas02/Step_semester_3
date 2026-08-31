import java.util.*;
class VowConcounter {
    public static void main(String[] args) {
     Scanner sc = new Scanner (System.in);
     System.out.print("Enter a word: ");
     String word = sc.nextLine().toLowerCase();
     int vowels = 0;
     int consonants = 0;
     for(int i = 0; i < word.length(); i++)
     {
         char ch = word.charAt(i);
         
         if( ch >= 'a' && ch <= 'z') 
         {
             if( ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
             {
                   vowels++;
                   
             }
             else 
             {
                 consonants++;
                 
             }
         }
     }
      System.out.println("vowels: " + vowels);
      System.out.println("Consonants: " + consonants);
    }
}