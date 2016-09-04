import java.util.*;
import java.io.*;

public class AStackDriver
{
	public static void main(String [] args) throws IOException
	{
		Scanner scanner = new Scanner(System.in);
		AStack<Integer> stack = new AStack<Integer>(5);

		System.out.println("Choose one of the following operations:");
	 	System.out.println("- push/add (enter the letter a)");
		System.out.println("- pop/delete (enter the letter d)");
		System.out.println("- peek (enter the letter p)");
		System.out.println("- check if the list is empty (enter the letter e)");
		System.out.println("- quit (enter the letter q)");

		boolean done = false;
		while (!done)
		{
			System.out.println("Enter a menu choice: ");
			
		 	String idChar = scanner.nextLine();	
			switch (idChar)
			{
				case "a":
					System.out.println("Add Integer: ");
                                        if (!scanner.hasNextInt())
					{
						System.out.println("Invalid input");
						scanner.nextLine();
						break;
					}
					Integer in = scanner.nextInt();
 					scanner.nextLine();
					stack.push(in);
					System.out.println(in + " pushed");
					break;
				case "d":
					try
					{
						Integer out = stack.pop();
                                		System.out.println(out + " popped");
						break;
					}
					catch(AStack.MyException e)
					{
						System.out.println("Invalid operation: stack is empty");
						break;
					}
				case "p":
				        try
				        {
				        System.out.println(stack.peek()+ " is the value on top");
				        break;
				        }
				        catch(AStack.MyException e)
				        {
				                System.out.println("Invalid operation: stack is empty");
						break;
				        }			
				case "e":
					if(stack.isEmpty())
					{
						System.out.println("empty");
						break;
					}
					System.out.println("not empty");
					break;
				case "q":
					while(!stack.isEmpty())
					{
						System.out.print(stack.pop() + " ");
					}
					done = true;
					break;
				default:
					System.out.println("Invalid choice");
					break;
					
					System.out.println();	
			}
		}	
	}	
}
