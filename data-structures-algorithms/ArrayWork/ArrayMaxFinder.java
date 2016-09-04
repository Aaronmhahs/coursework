import java.util.*;
public class ArrayMaxFinder
{
        public static int arrayMax(int[] arr, int first)
        {
                
                if(first == 0)
                {
                        return arr[0];
                }
                
                return Math.max(arrayMax(arr, first-1), arr[first]);
        }
        
        public static void main(String[] args)
        {
                int[] nums = new int[10];
                Scanner scan = new Scanner(System.in);
                System.out.println("enter 10 numbers: ");
                for(int i = 0; i<10; i++)
                {
                        nums[i] = scan.nextInt();
                        scan.nextLine();
                }        
                
                System.out.println("Max is: " +arrayMax(nums, nums.length-1));
        }
}
