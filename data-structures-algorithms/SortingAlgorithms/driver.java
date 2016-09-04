import java.util.*;


public class driver<T>
{
	public static <T extends Comparable<? super T>> void SelectionSort(T[] arr, int size)
        {
                int min;

                for(int i=0; i<size; i++)
                {
                        min = i;
                        for(int j=i+1; j<size; j++)
                        {
                                if(arr[j].compareTo(arr[min])<0)
                                {
                                        min = j;
                                }
                        }
                        if(min!=i)
                        {
                                swapReferences(arr, i, min);
                        }
                }
        }

	public static <T extends Comparable<? super T>> void InsertionSort(T[] arr, int size)
        {
                int j;

                for(int i=1; i<size; i++)
                {
                        T temp = arr[i];
                        for(j=i; j>0 && temp.compareTo(arr[j-1])<0; j--)
                        {
                                arr[j] = arr[j-1];
                        }
                        arr[j] = temp;
                }
        }

	private static final int CUTOFF = 10;

        private static <T extends Comparable<? super T>> void QuickSort(T[] arr, int left, int right)
        {
                if(left + CUTOFF <= right)
                {
                        T pivot = median(arr, left, right);

                        int i = left;
                        int j = right-1;
                        for(;;)
                        {
                                while(arr[++i].compareTo(pivot)<0)
                                {
                                }
                                while(arr[--j].compareTo(pivot)>0)
                                {
                                }
                                if(i<j)
                                {
                                        swapReferences(arr, i, j);
                                }
                                else
                                {
                                        break;
                                }
                        }

                        swapReferences(arr, i, right-1);

                        QuickSort(arr, left, i-1);
                        QuickSort(arr, i+1, right);
                }
		else
		{
			InsertionSort(arr, arr.length);
		}
        }

        public static <T extends Comparable<? super T>> void QuickSort(T[] arr, int size)
        {
                QuickSort(arr, 0, size-1);
        }

        private static <T extends Comparable<? super T>> void MergeSort(T[] arr, T[] temparr, int left, int right)
        {
                if(left<right)
                {
                        int center = (left+right)/2;
                        MergeSort(arr, temparr, left, center);
                        MergeSort(arr, temparr, center+1, right);
                        merge(arr, temparr, left, center+1, right);
                }

        }

        public static <T extends Comparable<? super T>> void MergeSort(T[] arr, int size)
        {
                T[] temparr = (T[]) new Comparable[size];
                MergeSort(arr, temparr, 0, size-1);
        }

        public static <T extends Comparable<? super T>> void HeapSort(T[] arr, int size)
        {
                for(int i=size/2-1; i>=0; i--)
                {
                        percDown(arr, i, size);
                }
                for(int i=size-1; i>0; i--)
                {
                        swapReferences(arr, 0, i);
                        percDown(arr, 0, i);
                }
        }

	public static <T extends Comparable<? super T>> void ShellSort(T[] arr, int size)
        {
                for(int i=size/2; i>0; i/=2)
                {
                        for(int j=i; j<size; j++)
                        {
                                T temp = arr[j];
                                int k;
                                for(k=j; k>=i && temp.compareTo(arr[k-i])<0; k-=i)
                                {
                                        arr[k] = arr[k-i];
                                }
                                arr[k] = temp;
                        }
                }
        }

        private static <T extends Comparable<? super T>> void percDown(T[] arr, int i, int n)
        {
                int child;
                T temp;

                for(temp=arr[i]; leftChild(i)<n; i=child)
                {
                        child = leftChild(i);
                        if(child!=(n-1) && arr[child].compareTo(arr[child+1])<0)
                        {
                                child++;
                        }
                        if(temp.compareTo(arr[child])<0)
                        {
                                arr[i] = arr[child];
                        }
                        else
                        {
                                break;
                        }
                }
                arr[i] = temp;
        }

        private static int leftChild(int i)
        {
                return 2*i+1;
        }

	private static <T extends Comparable<? super T>> void merge(T[] arr, T[] temparr, int leftPos, int rightPos, int rightEnd)
        {
                int leftEnd = rightPos-1;
                int tempPos = leftPos;
                int num = rightEnd-leftPos+1;

                while(leftPos<=leftEnd && rightPos<=rightEnd)
                {
                        if(arr[leftPos].compareTo(arr[rightPos])<=0)
                        {
                                temparr[tempPos++] = arr[leftPos++];
                        }
                        else
                        {
                                temparr[tempPos++] = arr[rightPos++];
                        }
                }
                while(leftPos<=leftEnd)
                {
                        temparr[tempPos++] = arr[leftPos++];
                }
                while(rightPos<=rightEnd)
                {
                        temparr[tempPos++] = arr[rightPos++];
                }

                for(int i=0; i<num; i++, rightEnd--)
                {
                        arr[rightEnd] = temparr[rightEnd];
                }
        }

        private static <T extends Comparable<? super T>> T median(T[] arr, int left, int right)
        {
                int center = (left+right)/2;

                if(arr[center].compareTo(arr[left])<0)
                {
                        swapReferences(arr, left, center);
                }
                if(arr[right].compareTo(arr[left])<0)
                {
                        swapReferences(arr, left, right);
                }
                if(arr[right].compareTo(arr[center])<0)
                {
                        swapReferences(arr, center, right);
                }

                swapReferences(arr, center, right-1);
                return arr[right-1];
	}

	public static <T extends Comparable<? super T>> void BubbleSort(T[] arr, int size)
        {
                for(int i=1; i<size; i++)
                {
                        for(int j=0; j<size-1; j++)
                        {
                                if(arr[j].compareTo(arr[j+1])>0)
                                {
                                        swapReferences(arr, j, j+1);
                                }
                        }
                }
        }	
	
	public static final <T> void swapReferences(T[] arr, int index1, int index2)
        {
                T temp = arr[index1];
                arr[index1] = arr[index2];
                arr[index2] = temp;
        }



	public static void main(String[] args)
	{
		Integer[] nums = new Integer[10];
		Integer[] nums2 = new Integer[10];
		Integer[] nums3 = new Integer[10];
		Integer[] nums4 = new Integer[10];
		Integer[] nums5 = new Integer[10];
		Integer[] nums6 = new Integer[10];
		Integer[] nums7 = new Integer[10];
		for(int i=0; i<nums.length; i++)
		{
			nums[i] = (int)(Math.random()*nums.length);
		}
		for(int j=0; j<nums.length; j++)
		{
			nums2[j]=nums3[j]=nums4[j]=nums5[j]=nums6[j]=nums7[j]=nums[j];
		}
		System.out.println("Nums: ");
		for(int j=0; j<nums.length; j++)
		{
			System.out.println(j + ": " + nums[j]);
		}

		System.out.println();
		System.out.println("SelectionSorting...");
		SelectionSort(nums, nums.length);
		System.out.println();

		System.out.println("Nums: ");
                for(int j=0; j<nums.length; j++)
                {
                        System.out.println(j + ": " + nums[j]);
                }

		System.out.println();
                System.out.println("BubbleSorting...");
                BubbleSort(nums2, nums2.length);
                System.out.println();

                System.out.println("Nums: ");
                for(int j=0; j<nums2.length; j++)
                {
                        System.out.println(j + ": " + nums2[j]);
                }
		
				
		System.out.println();
                System.out.println("InsertionSorting...");
                InsertionSort(nums3, nums3.length);
                System.out.println();

                System.out.println("Nums: ");
                for(int j=0; j<nums4.length; j++)
                {
                        System.out.println(j + ": " + nums3[j]);
                }

		System.out.println();
                System.out.println("QuickSorting...");
                QuickSort(nums4, nums4.length);
                System.out.println();

                System.out.println("Nums: ");
                for(int j=0; j<nums4.length; j++)
                {
                        System.out.println(j + ": " + nums4[j]);
                }

		System.out.println();
                System.out.println("MergeSorting...");
                MergeSort(nums5, nums5.length);
                System.out.println();

                System.out.println("Nums: ");
                for(int j=0; j<nums5.length; j++)
                {
                        System.out.println(j + ": " + nums5[j]);
                }

		System.out.println();
                System.out.println("HeapSorting...");
                HeapSort(nums6, nums6.length);
                System.out.println();

                System.out.println("Nums: ");
                for(int j=0; j<nums6.length; j++)
                {
                        System.out.println(j + ": " + nums6[j]);
                }

		System.out.println();
                System.out.println("ShellSorting...");
                ShellSort(nums7, nums7.length);
                System.out.println();

                System.out.println("Nums: ");
                for(int j=0; j<nums7.length; j++)
                {
                        System.out.println(j + ": " + nums7[j]);
                }
	}
}


































