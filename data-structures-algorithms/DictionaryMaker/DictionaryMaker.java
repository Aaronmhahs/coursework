import java.util.*;
import java.io.*;

public class DictionaryMaker
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
			
		System.out.println("Enter input file name: ");
		File fileIn = new File(scan.nextLine());
		BST<String> stringList = new BST<String>();

		try
		{
			Scanner fileScanner = new Scanner(fileIn); 		
			while(fileScanner.hasNextLine())
                	{
                        	String word = fileScanner.next();
                        	if(!stringList.find(word))
                        	{
                                	stringList.insert(word);
                        	}
                        	fileScanner.nextLine();
                	}	
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found");
		}

		System.out.println("Enter output file name: ");
		
		try
		{
			PrintWriter pw = new PrintWriter(scan.nextLine());
			Iterator<String> in = stringList.iteratorIn();
                	while(in.hasNext())
                	{
                        	pw.println(in.next());
                	}
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found");
		}
	}
}
