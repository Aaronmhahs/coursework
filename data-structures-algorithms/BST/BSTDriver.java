import java.util.*;

public class BSTDriver
{
	public static void main(String[] args)
        {
                Scanner keyScan = new Scanner(System.in);
		BST<Integer> tree = new BST<Integer>();

                System.out.println("Choose one of the following operations by entering the provided letter:");
		System.out.println("i- insert an element");
		System.out.println("d- delete an element");
		System.out.println("f- find an element");
		System.out.println("h- check height of tree");
		System.out.println("e- check if the tree is empty");
		System.out.println("p- print the tree");
		System.out.println("q- quit the program");

                boolean done = false;
                while(!done)
                {
			System.out.println("Enter a menu choice: ");
                        String choice = keyScan.nextLine();

                        switch(choice)
                        {
                                case "i":
					System.out.println("Enter number to add: ");
					int addElement = keyScan.nextInt();
					keyScan.nextLine();
					tree.insert(addElement);
					System.out.println(addElement + " added.");
                                        break;
                                case "d":
				        System.out.println("Enter number to delete: ");
                                        int delElement = keyScan.nextInt();
					keyScan.nextLine();
                                        tree.delete(delElement);
                                        System.out.println(delElement + " deleted.");	
                                        break;
				case "f":
					System.out.println("Enter number to find: ");
                                        int findElement = keyScan.nextInt();
					keyScan.nextLine();
                                        System.out.println(findElement + " found: " + tree.find(findElement));
                                        break;
				case "h":
					System.out.println("Height of tree: " + tree.height());
					break;
                                case "e":
					System.out.println("tree is empty: " + tree.isEmpty());
                                        break;
                                case "p":
					tree.printTree();
                                        break;
                                case "q":
                                        done = true;
	                                System.out.println("quitting");
                                        break;
                                default:
                                        System.out.println("Invalid menu choice.");
                                        break;
			}
		}	
        }
}
