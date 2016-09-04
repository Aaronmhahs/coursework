import java.util.*;
public class GCDcalculator
{
        public static int GCD(int x, int y)
        {
                if(x==y)
                {
                        return x;
                }
                else if(x>y)
                {
                        return GCD(x-y, y);
                }
                else return GCD(x, y-x);
        }
        
        public static void main(String[] args)
        {       
                Scanner scan = new Scanner(System.in);
                
                while(true)
                {
                        System.out.println("enter 2 numbers");
                        int num1 = scan.nextInt();
                        scan.nextLine();
                        int num2 = scan.nextInt();
                        scan.nextLine();
                        System.out.println("GCD is: " + GCD(num1,num2));
                        
                        System.out.println("y to continue | n to quit");
                        
                        String check = scan.next();
                        if(check.equals("n"))
                        {
                                return;
                        }
                }
        }
}
