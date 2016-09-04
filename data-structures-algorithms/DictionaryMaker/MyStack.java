/**
 * This is an implementation of the first-in-last-out abstract data type 
 * known as a stack. A stack can be used to store large amounts of data,
 * though you can only access the item on top. This is a generic implementation
 * and can hold any data type.
 * 
 * @author      Aaron Hahs (Ahahs@calpoly.edu)
 * @author      Landon Woollard (Woollard@calpoly.edu)
 * @version     10/8/2015
 * @version		Project 1
 */
 
import java.util.*;

/**
 * A generic implementation of a stack. With this stack, you specifiy the type of data you will be storing. 
 * You are then able to push (add), or pop(remove) data to and from the stack. You can also peek at the 
 * first item, to see it without removing it. Lastly, you can check if the stack is empty.
 */
public class MyStack <T>
{
	/**
	* A node is the basic building block of this stack. Each node points to its respective element, and 
	* to the node that comes after it.
	*/
	private class Node
	{
 		public T element;
		public Node next;
	}
	
	private Node firstNode;
	
	/**
	* Constructs an empty stack.  The first node of the stack is given a null value.
	*/
	public MyStack()
	{
		firstNode = null;
	}
	
	/**
	* Add elements one-by-one to the top of the stack. 
	*
	* @param elem elem is of the generic type T, and needs to be synonymous with the data type your stack
	* was initialized to hold.
	*
	* @return push will always return null.
	*/
	public void push(T elem)
	{
		Node add = new Node();
		add.element = elem;
		add.next = firstNode;
		firstNode = add;
	}
	
	/**
	* Remove whatever value is on the top of the stack.
	*
	*
	* @return pop will return the value of the element (of the type held in the stack) on top of the stack.
	*
	* @throws EmptyStackException if there is an attempt to pop the top value off of a stack with nothing  
	* inside.
	*/
	public T pop()
	{
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		else
		{
			T temp = firstNode.element;
			firstNode = firstNode.next;
			return temp;
		}
	}
	
	/**
	* View (but don't remove) whatever value is on the top of the stack.
	*
	*
	* @return peek will return the value of the element (of the type held in the stack) on top of the stack.
	*
	* @throws EmptyStackException if there is an attempt to pop the top value off of a stack with nothing  
	* inside.
	*/
	public T peek()
	{
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		else
		{
			return firstNode.element;
		}
	}
	
	/**
	* Determine if there is data held in this stack, or if it is empty.
	*
	* @return true if there is nothing stored in the stack
	* @return false if there are objects in the stack
	*/
	public boolean isEmpty()
	{
		if(firstNode == null)
		{
			return true;
		}
		else return false;
	}
	
}
