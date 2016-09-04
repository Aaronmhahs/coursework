public class TreeWork <T extends Comparable<? super T>>
{
        public static <T extends Comparable<? super T>> boolean isHeap(T[] arr, int n)
        {
                for(int i = 0; i < n; i++)
                {
                        if(2*i + 1 < n)
                        {
                                if(arr[i].compareTo(arr[(2*i) +1]) > 0)
                                {
                                        return false;
                                }
                        }
                        if(2*i + 2 < n)
                        {
                                if(arr[i].compareTo(arr[(2*i) +2]) > 0)
                                {
                                        return false;
                                }
                        }
                        
                }
                return true;
                
        }
        public static <T> void printTree(T[] arr, int n)
        {
                int maxLevels = (int)(Math.log(n)/Math.log(2)) + 1;
                int level = 0;
                int printCount = 0;
                while(level != maxLevels-1)
                {
                        for(int i = 0; i<Math.pow(2, level); i++)
                        {
                                System.out.print(arr[printCount] + " " );
                                printCount++;
                        }
                        System.out.println();
                        level++;
                }
                
                for(; printCount < n; printCount++)
                {
                        System.out.print(arr[printCount] + " ");
                }
                 System.out.println();
        }
       
}
