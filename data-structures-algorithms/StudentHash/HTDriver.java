import java.io.*;
import java.util.*;

public class HTDriver
{
        public static void main( String[] args)
        {
                Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter input file name: ");
		String fileName;
		FileReader fileIn;
		Scanner fileScan;		
		try
		{
			fileName = scan.nextLine();
			fileIn = new FileReader(fileName);
			fileScan = new Scanner(fileIn);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found.");
			return;
		}

		int numOfThings = 0;
		HashTable hash = new HashTable(0);
		try
		{
			numOfThings = fileScan.nextInt();
                        fileScan.nextLine();
                        hash = new HashTable(numOfThings);
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Invalid first line.");
		}

		if(fileScan.hasNext())
		{
		        for(int i = 0; i<numOfThings; i++)
		        {
		                boolean idIn = false;
			        boolean nameIn = false;
			        boolean moreThan2 = false;

			        Scanner lineScan = new Scanner(fileScan.nextLine());

			        long idRead = 0;
			        String nameRead = "";

			        if(lineScan.hasNextLong())
			        {
			        	idRead = lineScan.nextLong();
			        	if(idRead >0)
			        	{
			        		idIn = true;
			        	}
			        }
			        if(lineScan.hasNext())
			        {
			        	nameRead = lineScan.next();
			        	nameIn = true;
			        }
			        if(lineScan.hasNext())
			        {
			        	moreThan2 = true;
			     	}
			        if(idIn && nameIn && !moreThan2)
			        {
			        	Student newStudent = new Student(idRead, nameRead);
				        hash.insert(newStudent);
			        }
		        }
		}
		
		System.out.println("Choose one of the following operations: \n- add an element (enter the letter a) \n- delete the element (enter the letter d) \n- find and retrieve element (enter the letter f) \n- get the number of elements in the collection (enter the letter n) \n- check if the collection is empty (enter the letter e) \n- Make the hast table empty (enter the letter k) \n- Print the contents of the hash table (enter the letter p) \n- Output the elements of the collection (enter the letter o) \n- Quit (enter the letter q)");
		
		boolean done = false;

		while(!done)

		{
			String choice = scan.nextLine();
			
			switch(choice)
			{
				case "a":
					System.out.println("Enter an id number and a name to add:");
					
					try
					{
						long id = scan.nextLong();
						String name = null;
						name = scan.next();
						if(name.equals(null) || id < 0 || scan.hasNext())
						{
							System.out.println("Invalid student entry.");
							break;
						}
						scan.nextLine();
						Student addthis = new Student(id, name);
						hash.insert(addthis);
						
						System.out.println( addthis  + " inserted");
						break;
					}
					catch(InputMismatchException e)
					{
						System.out.println("Invalid student entry.");
						break;
					}					

				case "d":
					try
					{
						System.out.println("Enter an id number:");
						long idd = scan.nextLong();
						scan.nextLine();
                                        	Student dummy = new Student(idd, "");
                                        	hash.delete(dummy);

						System.out.println("Student with id: " + idd  + " deleted");

						break;
					}
					catch(IllegalArgumentException e)
					{
						System.out.println("Invalid input.");
						break;
					}

				case "f":
				        try
				        {

					        System.out.println("Enter an id number to find:");

					        long idf = scan.nextLong();
					        scan.nextLine();
					        Student search = new Student(idf,"");
					        if(hash.find(search) == null)
					        {
					                System.out.println("Not found.");
					        }
					        else
					        {
					                System.out.println(hash.find(search));
					        }

					        break;
				        }
				        catch (IllegalArgumentException e)
				        {
				                System.out.println("Invalid input.");
				                break;
				        }

				case "n":

					Iterator iter = hash.iterator();
					int count = 0;
					while(iter.hasNext())
					{
					       count++;
					       iter.next();
					}

					System.out.println("there are " + count + " elements in this table.");

					break;

				case "e":

					System.out.println(hash.isEmpty());

					break;
				case "k":

					hash.makeEmpty();
					System.out.println("Hash table now empty, fool!");

					break;
				case "p":

					hash.printTable();

					break;

				case "o":

					Iterator siter = hash.iterator();
					System.out.println("Students: ");
					while(siter.hasNext())
					{
					        System.out.println(siter.next());
					}

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
