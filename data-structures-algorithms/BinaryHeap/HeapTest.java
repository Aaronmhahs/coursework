/**
 * HeapTest is for testing the operations of BinHeap.
 * 
 * 
 * @author      Aaron Hahs (Ahahs@calpoly.edu)
 * @author      Landon Woollard (Woollard@calpoly.edu)
 * @version     10/22/2015
 * @version		Project 2
 */

import java.util.*;

/**
 * A driver to test a Binary Heaps holding String values.
 */
public class HeapTest
{
	
	/**
     * Work with a BinHeap object to test its functionality.
     * You can test the operations of the heap for as long you you would like.
	 * Upon quitting, the contents of the heap will be printed to the screen in ascending order. 
	 *
     * @return null
	 */
	public static void main(String[] args)
	{
		BinHeap<String> theHeap;
		Scanner keyScan = new Scanner(System.in);
		System.out.println("How many elements should this heap be able to hold?");
		if(keyScan.hasNextInt())
		{
			theHeap = new BinHeap<String>(keyScan.nextInt());
		}
		else
		{
			System.out.println("Invalid input.");
			System.out.println("Creating a heap of size = 100.");
			theHeap = new BinHeap<String>();
		}
		keyScan.nextLine();
		System.out.println("Choose one of the following operations: \n- add an element (enter the letter a) \n- delete the smallest element (enter the letter d) \n- is the heap empty (enter the letter e) \n- size of the collection (enter the letter s) \n- print the collection (enter the letter p) \n- Quit (enter the letter q)");
		
		boolean done = false;
		while(!done)
		{
			String choice = keyScan.nextLine();
			
			switch(choice)
			{
				case "a":
					System.out.println("Enter a value to be added to the heap:");
					String read = keyScan.nextLine();
					theHeap.insert(read);
					System.out.println("\"" + read + "\"" + " inserted");
					break;
				case "d":
				try
				{
					String removed = (String)theHeap.deleteMin();
					System.out.println("\"" + removed + "\"" + " deleted");
					break;
				}
				catch(BinHeap.MyException e)
				{
					System.out.println("Invalid operation on an empty heap");
					break;
				}
				case "e":
					if(theHeap.isEmpty())
					{
						System.out.println("heap is empty");
					}
					else
					{
							System.out.println("heap is not empty");
					}
					break;
				case "s":
					System.out.println("The size is " + theHeap.size());
					break;
				case "p":
					System.out.println(theHeap.toString());
					break;
				case "q":
					done = true;
					System.out.println("quitting");
					while(theHeap.size() >0)
					{
						System.out.print(theHeap.deleteMin() + " ");
					}
					break;
				default:
					System.out.println("Invalid menu choice.");
					break;
			}
		}
		
		while(!theHeap.isEmpty())
		{
			System.out.print(theHeap.deleteMin() + " ");
		}
		System.out.println();
	}
}
