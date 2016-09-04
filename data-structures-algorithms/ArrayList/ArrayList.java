// Student: Aaron Hahs
// Class: CPE103-04
// Date: 4/5/16

import java.util.*;

public class ArrayList
{
	public static void main(String[] args)
	{
		Integer[] ints = new Integer[6];
		Scanner scan = new Scanner(System.in);
		System.out.println("Input values, including at least 6 integers.");
		int count = 0;
		Integer n = 0;
		while(count < 6)
		{
			try
			{
				int i = scan.nextInt();
				ints[count] = i;
				count++;
			}
			catch(InputMismatchException e)
			{
				scan.next();
			}	
		}
		
		boolean go = false;
		while(!go)
		{
			System.out.println("Input target value");
			try
			{
				n = scan.nextInt();
				if(Search(ints,n))
				{
					System.out.println(n + " found in the list.");
				}
				else
				{
					System.out.println(n + " not found in the list.");
				}
			}
			catch (InputMismatchException e)
			{
				System.out.println("Value must be an Integer");
				scan.next();
			}
			go = true;
		}
		Print(ints);
		

		// CHARACTERS
		Character[] chars = new Character[6];
                Scanner scanner = new Scanner(System.in);
                System.out.println("Input values, including at least 6 characters.");
                int counter = 0;
                char m = 'n';
                while(counter < 6)
                {
                        try
                        {
				char c = scan.next().charAt(0);
				if(Character.isLetter(c))
				{
                                	chars[counter] = c;
                                	counter++;
				}
                        }
                        catch(InputMismatchException e)
                        {
                                scan.next();
                        }
                }

                boolean gogo = false;
                while(!gogo)
                {
                        System.out.println("Input target value");
                        try
                        {
                                m = scan.next().charAt(0);
				if(Character.isLetter(m))
				{
					if(Search(chars,m))
                                	{
                                        	System.out.println(m + " found in the list.");
                                	}
                                	else
                                	{
                                        	System.out.println(m + " not found in the list.");
                                	}
				}
				else
				{
					System.out.println("Value must be a Character");
				}
				break;
                        }
                        catch (InputMismatchException e)
                        {
                                System.out.println("Must be a char");
                                scan.next();
                        }
                        gogo = true;
                }	
		Print(chars);
	}

	public static <T> boolean Search(T[] arr, T target)
	{
		for(int i=0; i<arr.length;i++)
		{
			if(target == arr[i])
			{
				return true;
			}
		}
		return false;		
	}

	public static <T> void Print(T[] arr)
	{
		for(int i=0; i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
	} 
}
