/**
 * This is the driver to test our implementation of the Converter class. You will be asked to 
 * give input to the keyboard, and output will be given through the console.
 * 
 * @author      Aaron Hahs (Ahahs@calpoly.edu)
 * @author      Landon Woollard (Woollard@calpoly.edu)
 * @version     10/8/2015
 * @version		Project 1
 */

import java.util.*;

/**
 * A driver to work with the static methods of Converter.
 */
public class ConTest
{
	
	/**
	* Test the functionality of the Converter. This Converter works with infix and postfix expressions.
    * User will be prompted to convert an infix expression, evaluate a postfix expression,
	* evaluate an infix (arithmetic) expression, or quit. Information will be displayed through the console.
	*
	* @return null
	*/
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Choose one of the following operations: \n-Infix to postfix conversion (enter the letter i) \n-Postfix expression evaluation (enter the letter p) \n-Arithmetic expression evaluation (enter the letter a) \n-Quit the program (enter the letter q)");
		boolean again = true;
		while(again)
		{
			System.out.print("Enter a menu choice: ");
			String switchString = scan.nextLine();
			switch (switchString)
			{
				case "i":
				        System.out.println("Enter an infix expression");
						System.out.println("the postfix expression is: " + Converter.infixToPostfix(scan.nextLine()));
					break;
				case "p":
				        System.out.println("Enter a postfix expression");
					System.out.println("the value of the postFix expression is: " + Converter.postfixValue(scan.nextLine()));
					break;
				case "a":
				        System.out.println("Enter an arithmetic expression");
					System.out.println("the value of the arithmetic expression is: " + Converter.postfixValue(Converter.infixToPostfix(scan.nextLine())));
					break;
				case "q":
					System.out.println("Quitting.");
					again = false;
					break;
				default:
					System.out.println("Invalid choice");
					break;	
			}
		}
		System.out.println("Farewell!");
	}
}
