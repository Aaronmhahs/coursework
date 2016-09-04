import java.util.*;
import java.io.*;

public class AQueueDriver
{
	public static void main(String [] args) throws IOException
	{
		Scanner scanner = new Scanner(System.in);
		AQueue<Integer> queue = new AQueue<Integer>(5);

		System.out.println("Choose one of the following operations:");
	 	System.out.println("- enqueue/add (enter the letter a)");
		System.out.println("- dequeue/delete (enter the letter d)");
		System.out.println("- print (enter the letter p)");
		System.out.println("- check if the queue is empty (enter the letter e)");
		System.out.println("- quit (enter the letter q)");

		boolean done = false;
		while (!done)
		{
			System.out.println("Enter a menu choice: ");
			
		 	String idChar = scanner.nextLine();	
			switch (idChar)
			{
				case "a":
					System.out.println("Add Integers: ");
                                        if (!scanner.hasNextInt())
					{
						System.out.println("Invalid input");
						scanner.nextLine();
						break;
					}
					Integer in = scanner.nextInt();
 					scanner.nextLine();
					queue.enqueue(in);
					System.out.println(in + " enqueued");
					break;
				case "d":
					try
					{
						Integer out = queue.dequeue();
                                		System.out.println(out + " dequeued");
						break;
					}
					catch(AQueue.MyException e)
					{
						System.out.println("Invalid operation: queue is empty");
						break;
					}
				case "p":
				        	queue.printArray();
				        	break;
				case "e":
					if(queue.isEmpty())
					{
						System.out.println("empty");
						break;
					}
					System.out.println("not empty");
					break;
				case "q":
					while(!queue.isEmpty())
					{
						System.out.print(queue.dequeue() + " ");
					}
					done = true;
					break;
				default:
					System.out.println("Invalid choice");
					break;
					
			}
			System.out.println();
		}	
	}	
}
