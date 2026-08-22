import java.util.*;
class MaskedPhone {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Phone Number: ");
        String phoneNo = sc.nextLine();
        
        if(phoneNo.length() != 10)
        {
            System.out.println("Invalid Phone Number");
            return ;
        }
        for(int i = 0; i < phoneNo.length(); i++)
        {
            if(!Character.isDigit(phoneNo.charAt(i)))
            {
                System.out.println("Invalid Phone Number");
                return ;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("XXXXXX");
        sb.append(phoneNo.substring(6));
        sb.insert(6,"");
        System.out.println(sb.toString());
        
    }
}