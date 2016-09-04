import java.util.*;

public class AQueue<T>
{
	private T[] arr;
	private int front;
	private int end;
	private int count;

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

	public AQueue(int size)
	{
		arr = (T[]) new Object[size];
		front = 0;
		end = -1;
	 	count = 0;	
	}

	public boolean isEmpty()
	{
		if (count == 0)
			return true;
		else
			return false;
	}
	
	public void enqueue(T element)
	{
		if (count == arr.length)
		{
			T[] temp = (T[]) new Object[arr.length*2];
			int tempCount = 0;
			if (front > end)
			{
				for (int i = front; i < arr.length; i++)
				{
					temp[tempCount] = arr[i];
					tempCount++;
				}
				front = 0;				

				for (int j = 0; j <= end; j++)
				{
					temp[tempCount] = arr[j];
					tempCount++;
				}
				end = count-1;
			}
			else
			{
				for (int i = front; i <= end; i++)
				{
					temp[i] = arr[i];
				}
			}
			arr = temp;
		}
		end++;
		if (end == arr.length)
		{
			end = 0;
		}
		arr[end] = element;
		count++; 
	}

	public T dequeue()
	{
		T temp = null;
		if (isEmpty())
		{
			throw new MyException("Queue is empty");
		}

		front++;
		count--;
		if (front == arr.length)
		{
			front = 0;
			temp = arr[arr.length-1];
			arr[arr.length-1] = null;
			return temp;
		}
		temp = arr[front-1];
		arr[front-1] = null;
		return temp;
	}
	
	public void printArray()
	{
		for (int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
