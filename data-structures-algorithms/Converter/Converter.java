/**
 * This is a class for converting infix notation expressions to postfix notation expressions.
 * It can also solve expressions.
 * 
 * @author      Aaron Hahs (Ahahs@calpoly.edu)
 * @author      Landon Woollard (Woollard@calpoly.edu)
 * @version     10/8/2015
 * @version		Project 1
 */

import java.util.*;

/**
 * The converter class works with infix and postfix notation mathematical expressions.
 * It can convert infix expressions to postfix. It can also evaluate postfix expressions.
 */
public class Converter
{
	/**
	* Convert an infix notation expression to postfix notation. 
	*
	* @param expression A String containing an infix expression.
	* Preconditions: Must contain a valid infix expression. All
	* terms (operands and operations) must be separated by at 
	* least one space. Can only contain the following operators: + - * / ( ) 
	*
	* @return a String object containing the postfix expression. All
    * terms (operands and operations) will be separated by at least one space.
	*/
	public static String infixToPostfix(String expression)
	{
		MyStack<String> operators = new MyStack<String>();
		Scanner scan = new Scanner(expression);
		String result = new String();
		String nextPiece = new String();
		
		while(scan.hasNext())
		{
			nextPiece = scan.next();
			
			if(nextPiece.equals("("))
			{
				operators.push(nextPiece);
				
			}
			else if(nextPiece.equals(")"))
			{
				while(!(operators.isEmpty() || operators.peek().equals("(")))
				{
					result = result + " " + operators.pop();
				}
				operators.pop(); // remove the "(" from the stack but don't add it to the output
				
			}
			else if(nextPiece.equals("*") || nextPiece.equals("/")) // the next item is a high priority operator
			{
				while(!(operators.isEmpty() || operators.peek().equals("+") || operators.peek().equals("-") || operators.peek().equals("("))) //until there is something of lower priority. "(" is an exception
				{
					result = result + " " + operators.pop();
				}
				operators.push(nextPiece);
			}
			else if(nextPiece.equals("+") || nextPiece.equals("-")) // the next item is a low priority operator
			{
				while(!(operators.isEmpty() || operators.peek().equals("(")))
				{
					result = result + " " + operators.pop();
				}
				operators.push(nextPiece);
			}
			else // the next thing is an operand
			{
				
				result = result + " " + nextPiece;
			}
			
		}
		while(!operators.isEmpty())
		{
			result = result + " " + operators.pop();
		}
		return result;
	}
	
	/**
	* Evaluate a postfix notation expression. 
	*
	* @param expression A String containing an postfix expression.
	* Preconditions: Must contain a valid postfix expression. All
	* terms (operands and operations) must be separated by at 
	* least one space. Can only contain integers and doubles as operands. 
	* Can only contain the following operators: + - * / ( )
	*
	* @return a double containing the evaluation of the postfix expression.
	*/
	public static double postfixValue(String expression)
	{
	        Scanner scan = new Scanner(expression);
	        double temp1 = 0;
	        double temp2 = 0;
	        String nextPiece;
	        MyStack<Double> dubStack = new MyStack<Double>();
	        while(scan.hasNext())
	        {
	                 nextPiece = scan.next();
	                 if(!(nextPiece.equals("+") || nextPiece.equals("-") || nextPiece.equals("*") || nextPiece.equals("/")))
	                 {
	                        dubStack.push(Double.parseDouble(nextPiece));
	                 }
	                 else
	                 {
	                        temp1 = dubStack.pop();
	                        temp2 = dubStack.pop();
	                        if(nextPiece.equals("+"))
	                        {
	                                dubStack.push(temp1 + temp2);
	                        }
	                        else if(nextPiece.equals("-"))
	                        {
	                                dubStack.push(temp2 - temp1);
	                        }
	                        else if(nextPiece.equals("*"))
	                        {
	                                dubStack.push(temp1 * temp2);
	                        }
	                        else if(nextPiece.equals("/"))
	                        {
	                                dubStack.push(temp2 / temp1);
	                        }
	                 }
	                        
	        }
	        return dubStack.pop();                
	}
}
