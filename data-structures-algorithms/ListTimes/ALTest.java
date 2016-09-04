import java.util.*;
import java.lang.*;

public class ALTest
{
	public static void main(String[] args)
	{
		MyArrayList_Lab4 list = new MyArrayList_Lab4();
		Scanner scan = new Scanner(System.in);
	        	
		System.out.println("Enter minimum value");
		int min = scan.nextInt();
		System.out.println("Enter maximum value");
		int max = scan.nextInt();
		
		for(int i = 0; i < 10; i++)
		{
			int n = (min + (int)(Math.random()*(max-min)+1));
			if(n%2==0)
			{
				n--;
			}
			list.add(n);
		}		

		System.out.println("Current list: " + list);
		System.out.println("Current size: " + list.size());

		boolean done = false;
		while(!done)
		{
			System.out.print("Remove first and last element? (y/n): ");
			String answer = scan.next();
			if(answer.equals("y"))
			{
				System.out.println("Removing first and last elements");
				list.remove(list.size()-1);
				list.remove(0);
				System.out.println("New list: " + list);
				System.out.println("New size: " + list.size());
				if(list.isEmpty())
				{
					done = true;
				}
			}
			else
			{
				done = true;
			}

		}		
	}
}
