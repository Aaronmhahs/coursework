/**
 * BinHeap is for creating generic Binary Heaps that hold Comparable data types.
 * 
 * 
 * @author      Aaron Hahs (Ahahs@calpoly.edu)
 * @author      Landon Woollard (Woollard@calpoly.edu)
 * @version     10/22/2015
 * @version		Project 2
 */

import java.util.*;

/**
 * The BinHeap class works with any comparable data types (ie Data types that implement the comparable interface).
 * It can add values to their correct location, delete the minimum value(root) and maintain a proper structure.
 * BinHeap can also check if it is empty, report its size, and print all of the values it holds.
 */
public class BinHeap<T extends Comparable<? super T>>
{
	
	/**
	 * The MyException class is a simple exception.
	 * It can have a message if you wish.
	 */
	public static class MyException extends RuntimeException
	{
		/**
		 * Constructor calls super(), invoking the constructor of RunTimeExeption.
		 */
		public MyException()
		{
			super();
		}
		
		/**
		 * Constructor calls super(String message), invoking the constructor of RunTimeExeption.
		 *
		 * @param message message is of the String type, and should contain a helpful message.
		 */
		public MyException(String message)
		{
			super(message);
		}
	}
	
	private T[] array;
	private int size;
	
	/**
	 * Constructs a BinHeap object starting with a maximum size of 100.
	 */
	public BinHeap()
	{
		array = (T[]) new Comparable[100];
		size = 0;
	}
	
	/**
	 * Constructs a BinHeap object with your choice of starting maximum size.
	 *
	 * @param sizeInput sizeInput is a primitive int value, and will be the initial size of the heap.
	 */
	public BinHeap(int sizeInput)
	{
		array = (T[]) new Comparable[sizeInput];
		size = 0;
	}	
	
	/**
	 * Adds an object to its proper place in the heap.
	 * If the heap is full, it will double the size prior to inserting the new element.
	 *
	 * @param value the object to be added to the heap. 
	 *
	 * @return insert will always return null.
	 */
	public void insert(T value)
	{
		if(size == array.length)
		{
			T[] temp = (T[]) new Comparable[size*2];
			for(int i = 0; i<array.length; i++)
			{
				temp[i] = array[i];
			}
			array = temp;			
		}
		int hole = 0;
		if (size != 0)
		{
			hole = size;
		}
		int parent = ((hole-1)/2);
		while (hole != 0 && (array[parent].compareTo(value) > 0))
		{
			array[hole] = array[parent];
			hole = parent;
			parent = ((hole-1)/2);
		}
		array[hole] = value;
		size++;
	}
	
	/**
	 * Deletes the element at the root of the heap, and properly fills its place with the lowest successor. 
	 *
	 * @return The value that was at the root of the heap.
	 *
	 * @throws MyException if there is an attempt to delete the minimum value of an empty heap.  
	 */
	public T deleteMin()
	{
		if(!isEmpty())
		{
			T temp = array[0];
			T item = array[size-1];
			size--;
			int hole = 0;
			int newHole = newHole(hole, item);
			while(newHole > -1)
			{
				array[hole] = array[newHole];
				hole = newHole;
				newHole = newHole(hole, item);
			}
			array[hole] = item;
			return temp;
		}
		else
		{
			throw new MyException();
		}
	}
	
	private int newHole(int hole, T item)
	{
		int returnIndex = -1;
		int leftChild = (2*hole)+1;
		int rightChild = (2*hole)+2;
		if (leftChild < size)
		{
			if(rightChild >= size)
			{
				if(array[leftChild].compareTo(item) < 0)
				{
					returnIndex = leftChild;
				}
			}
			else
			{
				int smaller = 0;
				if(array[leftChild].compareTo(array[rightChild]) < 0)
				{
					smaller = leftChild;
				}
				else
				{
					smaller = rightChild;
				}
				returnIndex = smaller;
			}      
		}
		return returnIndex;
	}
	
	/**
	 * Determine if there is data held in this heap, or if it is empty.
	 *
	 * @return true if there is nothing stored in the heap
	 * @return false if there are objects in the heap
	 */
	public boolean isEmpty()
	{
		if(size == 0)
		{
			return true;
		}
		else return false;
	}
	
	/**
	 * See how many elements are currently in the heap.
	 *
	 * @return the integer value of the number of elements in the heap.
	 */
	public int size()
	{
		return size;
	}
	
	/**
	 * A list of the elements in the heap in level-order (or ordered by index).
	 *
	 * @return A String of all elements in the heap.
	 */
	public String toString()
	{
		String contents = new String();
		for(int i = 0; i<size; i++)
		{
			contents += array[i];
			contents += " ";
		}
		return contents;
	}
	
	
}
