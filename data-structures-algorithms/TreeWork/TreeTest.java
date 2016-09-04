import java.util.*;
public class TreeTest
{
        public static void main (String[] args)
        {
                Integer[] tree = new Integer[20];
                int values = 0;
                Scanner scan = new Scanner(System.in);
                System.out.println("Enter Integers: ");
                while(values < 20 && scan.hasNext())
                {
                        tree[values] = scan.nextInt();
                        values++;
                }
                if(values == 0)
                {
                        System.out.println("Tree is empty.");
                }
                else
                {
                        
                        if(TreeWork.isHeap(tree, values))
                        {
                                System.out.println("This is a heap.");
                        }
                        else
                        {
                                System.out.println("This is not a heap.");
                        }
                        System.out.println();
                        TreeWork.printTree(tree, values);
                }
        }
}
