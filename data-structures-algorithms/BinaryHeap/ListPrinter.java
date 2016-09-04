/**
 * ListPrinter outputs a sorted list of student records, entering data from a file. Sorting is by student id.
 * 
 * 
 * @author      Aaron Hahs (Ahahs@calpoly.edu)
 * @author      Landon Woollard (Woollard@calpoly.edu)
 * @version     10/22/2015
 * @version		Project 2
 */

import java.util.*;
import java.io.*;

/**
 * A driver to test a Binary Heaps holding Student values.
 */
public class ListPrinter
{
	
	/**
     * Work with a BinHeap object to test the compareTo and toString functions of Student.
     * Information to fill the heap will be read from a .txt file.
	 * Upon finishing, the students from the heap will be printed in order. 
	 *
     * @return null
	 *
	 * @throws IOException if an incorrect filename is entered.
	 */
	public static void main(String[] args) throws IOException
	{
		Scanner scan = new Scanner(System.in);
		BinHeap<Student> studentHeap = new BinHeap<Student>();
		
		System.out.println("Name of file?");
		String fileName = scan.nextLine();
		FileReader file = new FileReader(fileName);
		Scanner fileScan = new Scanner(file);
		while(fileScan.hasNext())
		{
			boolean idIn = false;
			boolean nameIn = false;
			boolean moreThan2 = false;
			Scanner lineScan = new Scanner(fileScan.nextLine());
			long idRead = 0;
			String nameRead = "";
			if(lineScan.hasNextLong())
			{
				idRead = lineScan.nextLong();
				if(idRead >0)
				{
					idIn = true;
				}
			}
			if(lineScan.hasNext())
			{
				nameRead = lineScan.next();
				nameIn = true;
			}
			if(lineScan.hasNext())
			{
				moreThan2 = true;
			}
			
			if(idIn && nameIn && !moreThan2)
			{
				Student newStudent = new Student(idRead, nameRead);
				studentHeap.insert(newStudent);
			}
		}
		int counter = 1;
		System.out.println("Student List:");
		while(!studentHeap.isEmpty())
		{
			System.out.println(counter + ". " + studentHeap.deleteMin().toString());
			counter++;
		}
	}
}