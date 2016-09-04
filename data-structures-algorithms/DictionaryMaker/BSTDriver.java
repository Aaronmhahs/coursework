import java.util.*;

public class BSTDriver
{
	public static void main(String[] args)
        {
                Scanner keyScan = new Scanner(System.in);
		BST<Integer> tree = new BST<Integer>();

                System.out.println("Choose one of the following operations by entering the provided letter:");
		System.out.println("a- add the element");
		System.out.println("d- delete the element");
		System.out.println("f- find the element");
		System.out.println("e- check if the tree is empty");
		System.out.println("k- make the tree empty");
		System.out.println("n- get the number of nodes (the size) of the tree");
		System.out.println("m- find the minimal element");
		System.out.println("x- find the maximal element");
                System.out.println("p- print the tree in preorder using iterator");
                System.out.println("i- print the tree inorder using iterator");
                System.out.println("l- print the tree in levelorder using iterator");
                System.out.println("t- print the tree using printTree");
                System.out.println("o- output the tree using toString");
		System.out.println("q- quit the program");

                boolean done = false;
                while(!done)
                {
			System.out.println("Enter a menu choice: ");
                        String choice = keyScan.nextLine();

                        switch(choice)
                        {
                                case "a":
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
                                case "e":
					System.out.println("tree is empty: " + tree.isEmpty());
                                        break;
                                case "k":
					tree.makeEmpty();
					System.out.println("tree is now empty");
                                        break;
                                case "n":
					System.out.println("size is: " + tree.size());
                                        break;
                                case "m":
					try
					{
						System.out.println("minimum is: " + tree.findMinimum());
						break;
					}
					catch(BST.MyException e)
					{
						System.out.println("tree is empty");
						break;
					}
                                case "x":
					try
					{
						System.out.println("maximum is: " + tree.findMaximum());
						break;
					}
                                        catch(BST.MyException e)
                                        {
                                                System.out.println("tree is empty");
						break;
                                        } 
				case "p":
					Iterator<Integer> pre = tree.iteratorPre();
					while(pre.hasNext())
					{
						System.out.print(pre.next() + " ");
					}
                                        break;
                                case "i":
					Iterator<Integer> in = tree.iteratorIn();
                                        while(in.hasNext())
                                        {
                                                System.out.print(in.next() + " ");
                                        }
                                        break;
                                case "l":
					Iterator<Integer> lvl = tree.iteratorLevel();
                                        while(lvl.hasNext())
                                        {
                                                System.out.print(lvl.next() + " ");
                                        }
                                        break;
                                case "t":
					tree.printTree();
                                        break;
                                case "o":
					System.out.println(tree.toString());
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
