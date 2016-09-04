import java.util.*;

public class ListWork
{
        public static void main(String[] args)
        {
                 Scanner scanner = new Scanner(System.in);
                 Integer[] ints = new Integer[10];
                 int count = 0;
                 Integer i = 0;
                 System.out.println("Input 10 Integer values:");
                while(count < 10)
                {
                        
                        try
                        {
                                i = scanner.nextInt();
                                ints[count] = i;
                                count++;
                        }
                        catch(InputMismatchException e)
                        {
                                scanner.next();
                        }             
                        
                }
                scanner.nextLine();
                boolean go = false;
                String cont = new String();
                while (!go)
                {
                        System.out.println("Search for an element? (yes/no)");
                        cont = scanner.next();
                        if (cont.equals("yes"))
                        {
                                System.out.println("Input target integer");
                                try     
                                {
                                        i = scanner.nextInt();
                                        System.out.println(search(ints, i));
                                        
                                        
                                }
                                catch(InputMismatchException e)
                                {
                                        System.out.println("Error: Must be int type");
                                        scanner.next();
                                }
                        }
                        
                        else if (cont.equals("no"))
                        {
                                go = true;
                        }
                }         
                        print(ints);
         }       
                
                
        public static <T> boolean search(T[] arr, T targ)
        {
                for(T elem : arr)
                {
                        if(elem.equals(targ))
                        {
                                return true;
                        }
                }
                return false;
        }       
        public static <T> void print(T[] arr)
        {
                for(T elem : arr)
                {
                        System.out.println(elem);
                }
        }
}
