/**
 * This is the driver to test our implementation of a stack. You will be asked to 
 * give input to the keyboard, and output will be given through the console.
 * 
 * @author      Aaron Hahs (Ahahs@calpoly.edu)
 * @author      Landon Woollard (Woollard@calpoly.edu)
 * @version     10/8/2015
 * @version		Project 1
 */

import java.util.*;

/**
 * A driver to work with a stack containing String objects.
 */
public class StackTest
{
	
	/**
	* Test the functionality of a Stack. This stack contains String objects. User will be prompted to push, pop or peek Strings,
	* check if the stack is empty, or quit. information will be displayed through the console.
	*
	* @return null
	*/
	public static void main(String[] args)
	{
		MyStack <String> stack = new MyStack <String> ();
		Scanner keyScan = new Scanner(System.in);
		System.out.println("Choose one of the following operations: \n-Push/add (enter the letter a) \n-Pop/delete (enter the letter d) \n-Peek (enter the letter p) \n-Check if the list is empty (enter the letter e) \n-Quit (enter the letter q)");
		boolean again = true;
		while(again)
		{
			System.out.print("Enter a menu choice: ");
			String switchString = keyScan.nextLine();
			switch (switchString)
			{
				case "a":
					System.out.print("Enter a string: ");
					String in = keyScan.nextLine();
					stack.push(in);
					System.out.println("\"" + in + "\"" + " pushed in");
					break;
				case "d":
					try
					{
						String out = stack.pop();
						System.out.println("\"" + out + "\"" + " popped out");
						break;
					}
					catch(EmptyStackException e)
					{
						System.out.println("Invalid operation on an empty stack");
						break;
					}
				case "p":
					try
					{
						System.out.println("\"" + stack.peek() + "\"" + " on the top");
						break;
					}
					catch(EmptyStackException e)
					{
						System.out.println("Invalid operation on an empty stack");
						break;
					}
				case "e":
					if(stack.isEmpty())
					{
						System.out.println("empty.");
						break;
					}
					else 
					{
						System.out.println("not empty");
						break;
					}
				case "q":
					System.out.println("quitting");
					again = false;
					break;
				default:
					System.out.println("Invalid choice");
					break;	
			}
		}
		System.out.println("Goodbye.");
	}
}
