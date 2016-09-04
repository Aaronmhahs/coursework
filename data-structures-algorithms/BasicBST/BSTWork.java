import java.util.*;

public class BSTWork
{
	public static void main(String [] args)
	{
		BasicBST tree = new BasicBST();
                Scanner scan = new Scanner(System.in);

		System.out.println("Choose one of the following operations:");
	 	System.out.println("- Insert (enter the letter a)");
		System.out.println("- Odds (enter the letter o)");
		System.out.println("- Height (enter the letter h)");
		System.out.println("- Leaves (enter the letter l)");
		System.out.println("- One Child Nodes (enter the letter c)");
		System.out.println("- quit (enter the letter q)");

		boolean done = false;
		while (!done)
		{
			System.out.println("Enter a menu choice: ");
			
		 	String idChar = scan.nextLine();	
			switch (idChar)
			{
				case "a":
					System.out.println("Enter a number");
					int value = scan.nextInt();
					tree.insert(value);
					System.out.println(value + " added");
					scan.nextLine();
					break;
				case "o":
					System.out.println(tree.countOdds());
					break;
				case "h":
					System.out.println("height is: " + tree.height());
					break;
				case "l":
					System.out.println("Leaves: " + tree.countLeaves());
                                        break;
				case "c":
					System.out.println("One Child Parents: " + tree.countOneChildParents());
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
