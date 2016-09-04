import java.util.*;

public class AVLTest
{
	public static void main(String[] args)
	{
		BasicAVL basic = new BasicAVL();
		System.out.println("Enter a menu choice: ");
		System.out.println("a - add/insert");
		System.out.println("p - print");
		System.out.println("q - quit");
		Scanner scan = new Scanner(System.in);
		
		boolean done = false;
		while(!done)
		{
			String c = scan.next();
			switch(c)
			{
				case "a":
					System.out.println("Enter a number: ");
					int num = scan.nextInt();
					basic.insert(num);
					System.out.println(num + " was added!");
					break;
				case "p":
					basic.print();
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
