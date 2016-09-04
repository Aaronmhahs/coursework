import java.util.*;

public class HashTableSC<T>
{
	LinkedList<T>[] arr;
	
	public HashTableSC(int size)
	{
		arr = (LinkedList<T>[]) new LinkedList[size];
		
		for (int i = 0; i < size; i++)
		{
			arr[i] = new LinkedList<T>();
		}	
	}

	private int hash(T item)
	{
		return Math.abs(item.hashCode())%arr.length;
	}

	public void insert(T item)
	{
		int hash = hash(item);
		arr[hash].addFirst(item);
	}

	public void delete(T item)
	{
		int hash = hash(item);
		arr[hash].remove(item);
	}
	
	public boolean find(T item)
	{
		int hash = hash(item);
		return arr[hash].contains(item);
	}

	public boolean isEmpty()
	{
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i].size() > 0)
			{
				return false;
			}
		}
		return true;
	}

	public void print()
	{
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(i + ": ");
			for(int j = 0; j < arr[i].size(); j++)
			{
				System.out.print(arr[i].get(j) + " ");
			}
			System.out.println();
		}
	}	
}
