/*
 * Author: Aaron Hahs
 * Class: CPE103-05
 * Project: 3
 * Date: 5-16-16
 */

import java.util.*;

public class HashTableP3<T>
{
	LinkedList<T>[] arr;
	
	ArrayList<T> overflow;
	
	T[] linear;
	T[] quadratic;
	T[] bucket;
	
	int choice;
	int buckSize;
	int collisions = 0;

	/*
	 * Initializes all arrays to empty lists, as well as inititalizing the hash choice and size of bucket
	 */
	public HashTableP3(int size)
	{
		arr = (LinkedList<T>[]) new LinkedList[size];
		
		for (int i = 0; i < size; i++)
		{
			arr[i] = new LinkedList<T>();
		}

		linear = (T[]) new Object[size]; 
		quadratic = (T[]) new Object[size];
		bucket = (T[]) new Object[size];
		overflow = new ArrayList<T>();
		choice = 1;
		buckSize = 1;
		
	}
	
	/*
	 * Two hash functions used for indexing through hash table
	 */
	private int hash_func1(String s)
	{
		if(s.length() >= 3)
		{
			return(s.charAt(0) + s.charAt(1)*27 + s.charAt(2)*729)%arr.length;
		}
		else
		{
			int sum = 0;
			for(int i=0; i<s.length(); i++)
			{
				sum = sum + (int)(s.charAt(i)*Math.pow(27, i));
			}
			return sum%arr.length;
		}
	}

	private int hash_func2(String s)
	{
		int sum = 0;
		for(int i=0; i<s.length(); i++)
		{
			sum = sum + (int)(s.charAt(i)*Math.pow(37, i));
		}
		return sum%arr.length;
	}
	
	/*
	 * Method to handle collision via linear probing
	 */
	private void linProbe(T item)
	{
		if(full(linear)==false)
		{
			int index = hash(item);
			boolean done = false;
			for(int i=index; i<linear.length; i++)
			{
				if(linear[i]==null)
				{
					linear[i] = item;
					done = true;
					break;
				}
			}
			if(done==false)
			{
				for(int i=0; i<index; i++)
				{
					if(linear[i]==null)
					{
						linear[i] = item;
						done = true;
						break;
					}
				}
			}
		}
	}

	/*
	 * Method to handle collision via quadratic probing
	 */
	private void quadProbe(T item)
	{
		if(full(quadratic)==false)
		{
			int index = hash(item);
			boolean done = false;
			int i = 0;

			while(done==false)
			{
				int pos = index;
				if((index + i*i) < quadratic.length)
				{
					pos = pos + i*i;
				}
				else
				{
					pos = ((i*i - (quadratic.length - index))%quadratic.length)%quadratic.length;
				}
				if(quadratic[pos]==null)
				{
					quadratic[pos] = item;
					done = true;
				}
				else
				{
					i++;
				}
			}
		}
	}

	/*
	 * Method (and helper functions) to handle collision via buckets 
	 */
	private void buckCollision(T item)
	{
		int pos = hash(item);
		int start = (pos/buckSize)*buckSize;
		int end = start + buckSize;
		if(end > bucket.length)
		{
			end = bucket.length;
		}
		if(bucket.length%3 != 0)
		{
			if((start + buckSize > bucket.length)&&(start - buckSize >= 0))
			{
				start = start - buckSize;
			}
			if(start + 2*buckSize > bucket.length)
			{
				end = bucket.length;
			}
		}
		boolean full = true;
		for(int i=start; i<end; i++)
		{
			if(bucket[i]==null)
			{
				full = false;
				bucket[i] = item;
				break;
			}
		}
		if(full)
		{
			overflow.add(item);
		}
	}

	public void setBuckSize(int size)
	{
		buckSize = size;
	}

	/*
	 * Set the hash function to use
	 */
	public void setHash(int input)
	{
		if(input==1)
		{
			choice = 1;
		}
		else if(input==2)
		{
			choice = 2;
		}
	}

	/*
	 * Applies hashing to the input item
	 */
	private int hash(T item)
	{
		if(item instanceof String)
		{
			if(choice==1)
			{
				return hash_func1((String)item);
			}
			else
			{
				return hash_func2((String)item);
			}
		}
		else if(item instanceof Integer)
		{
			String val = String.valueOf(item);
			if(choice==1)
			{
				return hash_func1(val);
			}
			else
			{
				return hash_func2(val);
			}
		}
		return -1;
	}
	
	/*
	 * Returns whether the array is full
	 */
	private boolean full(T[] input)
	{
		for(int i=0; i<input.length; i++)
		{
			if(input[i]==null)
			{
				return false;
			}
		}
		return true;
	}
	
	/*
	 * Insert item into each array
	 */
	public void insert(T item)
	{
		int index = hash(item);
		if(arr[index] == null)
		{
			arr[index].addFirst(item);
			linear[index] = item;
			quadratic[index] = item;
			bucket[index] = item;
		}
		else
		{
			arr[index].addFirst(item);
			linProbe(item);
			quadProbe(item);
			buckCollision(item);
			collisions++;
		}
	}

	/*
	 * Delete item from each array
	 */
	public void delete(T item)
	{
		int index = hash(item);
		arr[index].remove(item);
		for(int i=0; i<arr.length; i++)
		{
			if(arr[i] != null)
			{
				for(int j=0; j<arr[i].size(); j++)
				{
					if(arr[i].get(j).equals(item))
					{
						arr[i].remove(j);
					}
				}
			}
		}
		for(int i=0; i<linear.length; i++)
		{
			if(linear[i] != null)
			{
				if(linear[i].equals(item))
				{
					linear[i] = null;
				}
			}
		}
		for(int i=0; i<quadratic.length; i++)
		{
			if(quadratic[i] != null)
			{
				if(quadratic[i].equals(item))
				{
					quadratic[i] = null;
				}
			}
		}
		for(int i=0; i<bucket.length; i++)
		{
			if(bucket[i] != null)
			{
				if(bucket[i].equals(item))
				{
					bucket[i] = null;
				}
			}
		}
		for(int i=0; i<overflow.size(); i++)
		{
			if(overflow.get(i).equals(item))
			{
				overflow.remove(i);
			}
		}
	}

	/*
	 * Find item in each array
	 */
	public boolean find(T item)
	{
		int index = hash(item);
		int search = arr[index].indexOf(item);
		if(search == -1)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	/*
	 * Check to see if the arrays are empty
	 */
	public boolean isEmpty()
	{
		for(int i=0; i<arr.length; i++)
		{
			if(arr[i].isEmpty()==false)
			{
				return false;
			}
		}
		for(int i=0; i<linear.length; i++)
		{
			if(linear[i] != null)
			{
				return false;
			}
		}
		for(int i=0; i<quadratic.length; i++)
		{
			if(quadratic[i] != null)
			{
				return false;
			}
		}
		for(int i=0; i<bucket.length; i++)
		{
			if(bucket[i] != null)
			{
				return false;
			}
		}
		return true;
	}

	/*
	 * Print the contents of each array
	 */
	public void print()
	{
		System.out.println("Chaining");
		for(int i=0; i<arr.length; i++)
		{
			System.out.print(i + ": ");
			String present = arr[i].toString().substring(1, arr[i].toString().length()-1);
			System.out.println(present);
		}
		System.out.println("Linear Probing");
		for(int i=0; i<linear.length; i++)
		{
			if(linear[i] != null)
			{
				System.out.println(i + ": " + linear[i]);
			}
			else
			{
				System.out.println(i + ": ");
			}
		}
		System.out.println("Quadratic Probing");
		for(int i=0; i<quadratic.length; i++)
		{
			if(quadratic[i] != null)
			{
				System.out.println(i + ": " + quadratic[i]);
			}
			else
			{
				System.out.println(i + ": ");
			}
		}
		System.out.println("Bucket");
		for(int i=0; i<bucket.length; i++)
		{
			if(bucket[i] != null)
			{
				System.out.println(i + ": " + bucket[i]);
			}
			else
			{
				System.out.println(i + ": ");
			}
		}
	}
}
