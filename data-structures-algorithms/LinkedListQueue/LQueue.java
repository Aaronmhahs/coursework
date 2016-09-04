import java.util.*;

public class LQueue<T>
{
	private class Node
	{
 		public T element;
		public Node next;
	}

	public static class MyException extends RuntimeException
	{
		public MyException()
		{
			super();
		}

		public MyException(String message)
		{
			super(message);
		}
	}

	private Node front;
	private Node end;

	public LQueue()
	{
		front = null;
		end = null;
	}

	public void enqueue(T element)
	{
		if (front == null)
		{
			Node first = new Node();
			first.element = element;
			front = first;
			end = first;
		}
		else if(front != null && front == end)
		{
			Node add = new Node();
			add.element = element;
			front.next = add;
			end = add;
		}

		else
		{
			Node add = new Node();
			add.element = element;
			end.next = add;
			end = add;
		}
	}

	public T dequeue()
	{
		if (isEmpty())
		{
			throw new MyException("Queue is empty");
		}

		else
		{
			T temp = front.element;
			front = front.next;
			return temp;
		}
	}

	public boolean isEmpty()
	{
		if (front == null)
		{
			return true;
		}
		return false;		
	}
}

