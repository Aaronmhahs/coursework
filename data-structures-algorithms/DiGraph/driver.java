import java.util.*;

public class driver
{
        public static void main(String [] args)
	{
		Scanner scanner = new Scanner(System.in);
		LQueue<Integer> queue = new LQueue<Integer>();
		
		System.out.println("Enter a number of vertices. ");
		int vert = scanner.nextInt();
		scanner.nextLine();
		
		DiGraphAM g = new DiGraphAM(vert);

		System.out.println("Choose one of the following operations:");
	 	System.out.println("- add edge (enter the letter a)");
		System.out.println("- delete edge (enter the letter d)");
		System.out.println("- edge count (enter the letter e)");
		System.out.println("- vertex count (enter the letter v)");
		System.out.println("- print (enter the letter p)");
		System.out.println("- topological sort (enter the letter t)");
		System.out.println("quit (enter the letter q)");

		boolean done = false;
		while (!done)
		{
			System.out.println("Enter a menu choice: ");
			
		 	String idChar = scanner.nextLine();	
			switch (idChar)
			{
				case "a":
					System.out.println("Enter Two Integers on one line: ");
                                        int v1 = scanner.nextInt();
                                        int v2 = scanner.nextInt();
                                        scanner.nextLine();
                                        
                                        g.addEdge(v1,v2);
                                        
                                        System.out.println("edge of " + v1 + " and " + v2 + " added.");
					break;
				case "d":
				        System.out.println("Enter Two Integers on one line: ");
                                        int v3 = scanner.nextInt();
                                        int v4 = scanner.nextInt();
                                        scanner.nextLine();
                                        
                                        g.deleteEdge(v3,v4);
                                        
                                        System.out.println("edge of " + v3 + " and " + v4 + " deleted.");
					break;
				case "e":
					System.out.println("There are " + g.edgeCount() + " edges");
					break;
				case "v":
					System.out.println("There are " + g.vertexCount() + " vertices");
					break;
				case "p":
					g.print();
					break;
				case "t":
					try
					{
						int[] print = g.topSort();
						for(int i = 0; i< print.length; i++)
						{
					        	System.out.print( print[i] + " ");
						}
						System.out.println();
					}
					catch(RuntimeException e)
					{
						System.out.println("Graph is cyclic");
					}
					break;
				case "q":
					
					done = true;
					break;
				default:
					System.out.println("Invalid choice");
					break;	
			}
		}	
	}	
}
