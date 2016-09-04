
import java.util.*;

public class HashTest 
{
	public static void main(String[] args) 
	{
        	Scanner in = new Scanner (System.in);
        	Scanner iterate;
        	HashTableP3<Integer> hashTable;

        	System.out.print("Enter the size of the array: ");
        	iterate = new Scanner(in.nextLine());
        	if (iterate.hasNextInt()) 
		{
            		hashTable = new HashTableP3<Integer>(iterate.nextInt());
        	} 
		else 
		{
            		hashTable = new HashTableP3<Integer>(in.nextInt());	
        	}
        
        	System.out.print("Enter size of buckets: ");
        	iterate = new Scanner(in.nextLine());
        	if (iterate.hasNextInt()) 
		{
            		hashTable.setBuckSize(iterate.nextInt());
        	} 
		else 
		{
            		hashTable.setBuckSize(in.nextInt());	
        	}

	        System.out.print("Enter the hashing type to use (1 or 2): ");
        	String input2 = in.nextLine();
        	if (input2.length() > 0) 
		{
            		input2 = input2.substring(0,1);
        	}
        	hashTable.setHash(Integer.parseInt(input2));

	        boolean repeat = true;
        	while (repeat == true) 
		{
            		System.out.println("Choose an operation: ");
            		System.out.println("a: Add/insert");
            		System.out.println("f: Find");
            		System.out.println("d: Delete");
            		System.out.println("e: Is empty");
            		System.out.println("p: Print");
            		System.out.println("q: Quit");

            		String input = in.nextLine();
            		if (input.length() > 0) 
			{
                		input = input.substring(0,1);
            		}
            		switch(input) 
			{
                		case "a":	
                    			System.out.println("Enter a number to add: ");
                    			iterate = new Scanner(in.nextLine());
                    			while (iterate.hasNext()) 
					{
                        			if (iterate.hasNextInt()) 
						{
                            				int addNum = Integer.parseInt(iterate.next());
                            				hashTable.insert(addNum);
                            				System.out.println(addNum +  " inserted.");
                        			} 
						else 
						{
                            				iterate.next();
                        			}
                    			}
                    			break;
                		case "f":	
                    			System.out.println("Enter the number to search for: ");
                    			iterate = new Scanner(in.nextLine());
                    			if (iterate.hasNextInt()) 
					{
                        			if (hashTable.find(iterate.nextInt())) 
						{
                            				System.out.println("found");
                        			} 
						else 
						{
                            				System.out.println("not found");
                        			}
					}		
                     			else 
					{
                        			System.out.println("Not an option. Try Again.");
                    			}
                    			break;
                		case "d":	
                    			System.out.println("Enter the number you want to delete: ");
                    			iterate = new Scanner(in.nextLine());
                    			if (iterate.hasNextInt()) 
					{
                        			int deleteNum = Integer.parseInt(iterate.next());
                        			hashTable.delete(deleteNum);
                        			System.out.println(deleteNum +  " deleted.");
                    			} 
					else 
					{
                        			System.out.println("Not an option. Try Again.");
                    			}
                    			break;
                		case "e":   
                    			if (hashTable.isEmpty()) 
					{
                        			System.out.println("empty");
                    			} 
					else 
					{
                        			System.out.println("not empty");
                    			}
                    			break;
                		case "p":	
                    			hashTable.print();
                    			break;
                		case "q":
                    			System.out.println("There were " + hashTable.collisions/2 + " collisions.");
                    			repeat = false;
                    			break;											
                		default:	
                    			System.out.println("Not an option. Try Again.");
                    			break;
			}
		}
	}     
}
