/**
 * Student is a comparable object with a last name and and id number.
 * 
 * 
 * @author      Aaron Hahs (Ahahs@calpoly.edu)
 * @author      Landon Woollard (Woollard@calpoly.edu)
 * @version     10/22/2015
 * @version		Project 2
 */

 /**
  * The Student class is a comparable data type, made to be used in a Binary Heap.
  * It has a compareTo, and a toString method.
  */
public class Student implements Comparable<Student>
{
	private long ID;
	private String name;
	
	/**
	 * Constructor creates a student object with a name and id number
	 *
	 * @param IDin IDin is a primitive long, and is the id number of the student.
	 * @param nameIn nameIn is a String type object that contains the last name of the student.
	 */
	public Student(long IDin, String nameIn)
	{
		ID = IDin;
		name = nameIn;
	}
	
	/**
	 * Compares two Student objects by their id number.
	 *
	 * @param other The student to be compared to.
	 *
	 * @return -1 is the id value of this is less than the id value of other.
	 * @return 1 is the id value of this is greater than the id value of other.
	 * @return 0 is the id value of this is equal to the id value of other.
	 */
	public int compareTo(Student other)
	{
		if(this.ID < ((Student)other).ID)
		{
			return -1;
		}
		else if(this.ID > ((Student)other).ID)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	
	/**
	 * The details of a student are placed into an organized string.
	 *
	 * @return A String to view the id and name of a student.
	 */
	public String toString()
	{
		String result = "{ id: " + ID + ", name: " + name + " }";
		return result;
	}
}