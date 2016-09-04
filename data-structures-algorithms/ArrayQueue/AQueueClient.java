import java.util.*;
import java.io.*;

public class AQueueClient 
{
        public static void main(String[] args) throws IOException
        {
		AQueue<Float> arr = new AQueue<Float>(5);
		Scanner scanner = new Scanner(System.in);
				
		System.out.println("Enter floats");
		while (scanner.hasNext())
		{
			if (scanner.hasNextFloat())
			{
				arr.enqueue(scanner.nextFloat());
			}
		
			else
			{
				scanner.next();
			}		
		}
		
		while (!arr.isEmpty())
		{
			System.out.print(arr.dequeue() + " ");
		}
        }
}
