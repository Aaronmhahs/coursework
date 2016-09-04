import java.util.*;

public class runtimes
{
	public static void main(String[] args)
	{
		BST<Integer> tree = new BST<Integer>();
		
		long startI = System.nanoTime();
		tree.insert(1);
		long endI = System.nanoTime();
		System.out.println("insert: " + (endI - startI));

		long startF = System.nanoTime();
                tree.find(1);
                long endF = System.nanoTime();
                System.out.println("find: " + (endF - startF));

		long startH = System.nanoTime();
                tree.height();
                long endH = System.nanoTime();
                System.out.println("height: " + (endH - startH));

		long startD = System.nanoTime();
                tree.delete(1);
                long endD = System.nanoTime();
                System.out.println("delete: " + (endD - startD));
	}
}
