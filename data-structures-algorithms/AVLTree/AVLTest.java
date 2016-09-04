import java.util.*;

public class AVLTest
{
	public static void main(String[] args)
	{
		AVLTree tree = new AVLTree();
		System.out.println("Enter a menu choice: ");
		System.out.println("i - insert");
		System.out.println("s - search");
		System.out.println("d - delete");
		System.out.println("p - print");
		System.out.println("h - height of nodes");
		System.out.println("e - check empty");
		System.out.println("c - clear tree");
		System.out.println("q - quit");
		Scanner scan = new Scanner(System.in);
		
		boolean done = false;
		while(!done)
		{
			String c = scan.next();
			switch(c)
			{
				case "i":
					System.out.println("Enter a number: ");
					int num = scan.nextInt();
					tree.insert(num);
					System.out.println(num + " was added!");
					break;
				case "s":
					System.out.println("Enter a number: ");
					int num2 = scan.nextInt();
					System.out.println("Value in tree? " + tree.search(num2));
					break;
				case "d":
					System.out.println("Enter a number: ");
					int num3 = scan.nextInt();
					tree.delete(num3);
					System.out.println(num3 + " was deleted!");
					break;
				case "p":
					System.out.println("Printing tree.");
					tree.print_tree();
					break;
				case "h":
					System.out.println("Height of tree is: " + tree.height());
					break;
				case "e":
					System.out.println("Tree empty? " + tree.isEmpty());
					break;
				case "c":
					System.out.println("Tree cleared.");
					tree.makeEmpty();
					break;
				case "q":
					System.out.println("Quitting...");
					done = true;
					break;
				default:
					System.out.println("Invalid input");
					break;
			}
		}
	}
}
