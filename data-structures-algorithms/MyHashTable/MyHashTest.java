import java.util.*;

public class MyHashTest
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter size of table: ");
		int size = scan.nextInt();
		scan.nextLine();
		MyHashTable<Integer> table = new MyHashTable<Integer>(size);

		System.out.println("Choose one of the following operations:");
	 	System.out.println("- Insert (enter the letter a)");
		System.out.println("- Find (enter the letter f)");
		System.out.println("- Delete (enter the letter d)");
		System.out.println("- Is empty? (enter the letter e)");
		System.out.println("- Print (enter the letter p)");
		System.out.println("- Output the collection (enter the letter o)");
		System.out.println("- Make empty (enter the letter k)");
		System.out.println("- Size (enter the letter s)");
		System.out.println("- Quit (enter the letter q)");

		boolean done = false;
		while (!done)
		{
			System.out.println("Enter a menu choice: ");
 			int number = 0;		      
	
		 	String idChar = scan.nextLine();	
			switch (idChar)
			{
				case "a":
					System.out.println("Enter a number: ");
					number = scan.nextInt();
					scan.nextLine();
					table.insert(number);
					System.out.println(number + " added.");
					break;
				case "f":
					System.out.println("Enter a number: ");
                                        number = scan.nextInt();
                                        scan.nextLine();
                                        System.out.println(number + " found? " + table.find(number));
					break;
				case "d":
					System.out.println("Enter a number: ");
                                        number = scan.nextInt();
                                        scan.nextLine();
                                        table.delete(number);
                                        System.out.println(number + " deleted.");
					break;
				case "e":
					System.out.println("Table empty? " + table.isEmpty());
                                        break;
				case "p":
					table.print();
					break;
				case "k":
					table.makeEmpty();
					System.out.println("Table is now empty.");
					break;
				case "s":
					System.out.println("The number of elements is: " + table.size());
                                        break;
				case "o":
					Iterator<Integer> intIter = table.iterator();
					while(intIter.hasNext())
					{
					        Integer print = intIter.next();
					        if(print != null)
					        {
					                System.out.print(print + " ");
					        }
					}
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

