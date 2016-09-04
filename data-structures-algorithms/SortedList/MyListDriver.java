import java.util.*;

public class MyListDriver
{
	public static void main(String[] args)
	{
		MySortedList list = new MySortedList();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Choose one of the following operations:");
	 	System.out.println("- add (enter the letter a)");
		System.out.println("- delete (enter the letter d)");
		System.out.println("- Max (enter the letter x)");
		System.out.println("- Min (enter the letter m)");
		System.out.println("- print (enter the letter p)");
		System.out.println("- check if the List is empty (enter the letter e)");
		System.out.println("- quit (enter the letter q)");

		boolean done = false;
		while (!done)
		{
			System.out.println("Enter a menu choice: ");
			
		 	String idChar = scanner.nextLine();	
			switch (idChar)
			{
				case "a":
					System.out.println("Enter an int to add");
					int value = scanner.nextInt();
					scanner.nextLine();
					list.add(value);
					System.out.println(value + " was added");
					break;
				case "d":
					System.out.println("Enter an int to delete");
					int delValue = scanner.nextInt();
					scanner.nextLine();
					list.delete(delValue);
					System.out.println(delValue + " was deleted");
					break;
				case "x":
					try
					{
						System.out.println("Max value is " + list.max());
						break;
					}
					catch (NullPointerException e)
					{
						System.out.println("List is empty");
						break;
					}	
				case "m":
					try
                                        {
                                                System.out.println("Min value is " + list.min());
                                                break;
                                        }
                                        catch (NullPointerException e)
                                        {
                                                System.out.println("List is empty");    
                                                break;
                                        }
				case "p":
					list.print();
					break;
				case "e":
					System.out.println("List is empty? " + list.isEmpty());
                                        break;
                                case "q":
					done = true;
                                        break;
				default:
					System.out.println("Invalid choice");
					break;
			}
			System.out.println();
		}
	}
}
