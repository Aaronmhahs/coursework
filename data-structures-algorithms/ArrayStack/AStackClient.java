import java.util.*;
import java.io.*;

public class AStackClient 
{
        public static void main(String[] args) throws IOException
        {
                Scanner words = new Scanner(System.in);
                System.out.println("Enter file name.");
                String fileName = words.next();
                FileReader reader = new FileReader(fileName);
                Scanner file = new Scanner(reader);
                AStack<Integer> ints = new AStack<Integer>(5);
                AStack<Float> floats = new AStack<Float>(5);
                AStack<String> strings = new AStack<String>(5);
                while(file.hasNext())
                {
                        if(file.hasNextInt())
                        {
                                ints.push(file.nextInt());
                        }
                        else if(file.hasNextFloat())
                        {
                                floats.push(file.nextFloat());
                        }
                        else
                        {
                                strings.push(file.next());
                        }
                }
                
                System.out.println();
                System.out.print("Strings: ");
                while(!strings.isEmpty())
                {
                        System.out.print(strings.pop() + " ");
                }
                
                System.out.println();
                System.out.print("Floats: ");
                while(!floats.isEmpty())
                {
                        System.out.print(floats.pop() + " ");
                }
                
                System.out.println();
                System.out.print("Integers: ");
                while(!ints.isEmpty())
                {
                        System.out.print(ints.pop() + " ");
                }
                System.out.println();
        }
}
