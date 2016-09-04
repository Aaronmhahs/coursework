/*
 * Aaron Hahs
 * CPE103-05
 * Project4
 */

import java.util.*;

/*
 * Class containing methods for seven different sorting algorithms: SelectionSort, BubbleSort, InsertionSort, QuickSort, MergeSort, HeapSort, and ShellSort.
 */
public class sorts<T>
{
	static Integer[] sel1 = new Integer[1000];
	static Integer[] sel2 = new Integer[20000];
	static Integer[] sel3 = new Integer[80000];
	static Integer[] sel4 = new Integer[100000];
	static Integer[] sel5 = new Integer[500000];
	


	/*
	 * Sorts the array of size elements with the selection sort algorithm
	 */
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
	
	/*
	 * Sorts the array of size elements with the bubble sort algorithm
	 */
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

	/*
	 * Sorts the array of size elements with the insertion sort algorithm
	 */
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

	/*
	 * Sorts the array of size elements with the quick sort algorithm
	 */
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

	/*
	 * Sorts the array of size elements with the merge sort algorithm
	 */
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

	/*
	 * Sorts the array of size elements with the heap sort algorithm
	 */
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

	/*
	 * Sorts the array of size elements with the shell sort algorithm
	 */
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

	//Helper methods for above sorting algorithms. ================================================================================

	/*
	 * Internal method for HeapSort that is used to build the heap and delete the max value
	 */
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

 	/*
	 * Internal method used for HeapSort to return the index of the left child
	 */
	private static int leftChild(int i)
	{
		return 2*i+1;
	}

	/*
	 * Internal method for all sorting algorithms to swap reference values in the given array
	 */
	public static final <T> void swapReferences(T[] arr, int index1, int index2)
	{
		T temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}

	/*
	 * Internal method that merges two sorted halves of a subarray
	 */
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

	/*
	 * Internal method used for QuickSort to return the median of the left, center, and right
	 */
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

	// Run time analysis methods for each sorting algorithm =======================================================================

	public static void TimeSortedArray()
	{
		// N = 1000
		
		Integer[] bub1 = new Integer[1000];
		Integer[] ins1 = new Integer[1000];
		Integer[] qui1 = new Integer[1000];
		Integer[] mer1 = new Integer[1000];
		Integer[] hea1 = new Integer[1000];
		Integer[] she1 = new Integer[1000];
	

		for(int n=0; n<sel1.length; n++)
		{
			sel1[n] = n;
		}
		for(int i=0; i<sel1.length; i++)
		{
			bub1[i] = ins1[i] = qui1[i] = mer1[i] = hea1[i] = she1[i] = sel1[i];
		}
		
		long SSS1 = System.nanoTime()/1000000;
		sorts.SelectionSort(sel1, sel1.length);
		long SSE1 = System.nanoTime()/1000000;	
		
		long BSS1 = System.nanoTime()/1000000;
                sorts.BubbleSort(bub1, sel1.length);
                long BSE1 = System.nanoTime()/1000000;

		long ISS1 = System.nanoTime()/1000000;
                sorts.InsertionSort(ins1, sel1.length);
                long ISE1 = System.nanoTime()/1000000;

		long QSS1 = System.nanoTime()/1000000;
                sorts.QuickSort(qui1, sel1.length);
                long QSE1 = System.nanoTime()/1000000;

		long MSS1 = System.nanoTime()/1000000;
                sorts.MergeSort(mer1, sel1.length);
                long MSE1 = System.nanoTime()/1000000;

		long HSS1 = System.nanoTime()/1000000;
                sorts.HeapSort(hea1, sel1.length);
                long HSE1 = System.nanoTime()/1000000;

		long ESS1 = System.nanoTime()/1000000;
                sorts.ShellSort(she1, sel1.length);
                long ESE1 = System.nanoTime()/1000000;
		
		System.out.println();
		System.out.println("Sorted List:");
		System.out.println();
		System.out.println("N: " + sel1.length);
		System.out.println("Selection: " + (SSE1-SSS1) + "ms");
		System.out.println("Bubble: " + (BSE1-BSS1) + "ms");
		System.out.println("Insertion: " + (ISE1-ISS1) + "ms");
		System.out.println("Quick: " + (QSE1-QSS1) + "ms");
		System.out.println("Merge: " + (MSE1-MSS1) + "ms");
		System.out.println("Heap: " + (HSE1-HSS1) + "ms");
		System.out.println("Shell: " + (ESE1-ESS1) + "ms");
		System.out.println();

		// N = 20000

		Integer[] bub2 = new Integer[20000];
                Integer[] ins2 = new Integer[20000];
                Integer[] qui2 = new Integer[20000];
                Integer[] mer2 = new Integer[20000];
                Integer[] hea2 = new Integer[20000];
                Integer[] she2 = new Integer[20000];


                for(int n=0; n<sel2.length; n++)
                {
                        sel2[n] = n;
                }
                for(int i=0; i<sel2.length; i++)
                {
                        bub2[i] = ins2[i] = qui2[i] = mer2[i] = hea2[i] = she2[i] = sel2[i];
                }

                long SSS2 = System.nanoTime()/1000000;
                sorts.SelectionSort(sel2, sel2.length);
                long SSE2 = System.nanoTime()/1000000;

                long BSS2 = System.nanoTime()/1000000;
                sorts.BubbleSort(bub2, sel2.length);
                long BSE2 = System.nanoTime()/1000000;

                long ISS2 = System.nanoTime()/1000000;
                sorts.InsertionSort(ins2, sel2.length);
                long ISE2 = System.nanoTime()/1000000;

                long QSS2 = System.nanoTime()/1000000;
                sorts.QuickSort(qui2, sel2.length);
                long QSE2 = System.nanoTime()/1000000;

                long MSS2 = System.nanoTime()/1000000;
                sorts.MergeSort(mer2, sel2.length);
                long MSE2 = System.nanoTime()/1000000;

                long HSS2 = System.nanoTime()/1000000;
                sorts.HeapSort(hea2, sel2.length);
                long HSE2 = System.nanoTime()/1000000;

                long ESS2 = System.nanoTime()/1000000;
                sorts.ShellSort(she2, sel2.length);
                long ESE2 = System.nanoTime()/1000000;

                System.out.println("N: " + sel2.length);
                System.out.println("Selection: " + (SSE2-SSS2) + "ms");
                System.out.println("Bubble: " + (BSE2-BSS2) + "ms");
                System.out.println("Insertion: " + (ISE2-ISS2) + "ms");
                System.out.println("Quick: " + (QSE2-QSS2) + "ms");
                System.out.println("Merge: " + (MSE2-MSS2) + "ms");
                System.out.println("Heap: " + (HSE2-HSS2) + "ms");
                System.out.println("Shell: " + (ESE2-ESS2) + "ms");
		System.out.println();

		// N = 80000
		
		Integer[] bub3 = new Integer[80000];
                Integer[] ins3 = new Integer[80000];
                Integer[] qui3 = new Integer[80000];
                Integer[] mer3 = new Integer[80000];
                Integer[] hea3 = new Integer[80000];
                Integer[] she3 = new Integer[80000];


                for(int n=0; n<sel3.length; n++)
                {
                        sel3[n] = n;
                }
                for(int i=0; i<sel3.length; i++)
                {
                        bub3[i] = ins3[i] = qui3[i] = mer3[i] = hea3[i] = she3[i] = sel3[i];
                }

                long SSS3 = System.nanoTime()/1000000;
                sorts.SelectionSort(sel3, sel3.length);
                long SSE3 = System.nanoTime()/1000000;

                long BSS3 = System.nanoTime()/1000000;
                sorts.BubbleSort(bub3, sel3.length);
                long BSE3 = System.nanoTime()/1000000;

                long ISS3 = System.nanoTime()/1000000;
                sorts.InsertionSort(ins3, sel3.length);
                long ISE3 = System.nanoTime()/1000000;

                long QSS3 = System.nanoTime()/1000000;
                sorts.QuickSort(qui3, sel3.length);
                long QSE3 = System.nanoTime()/1000000;

                long MSS3 = System.nanoTime()/1000000;
                sorts.MergeSort(mer3, sel3.length);
                long MSE3 = System.nanoTime()/1000000;

                long HSS3 = System.nanoTime()/1000000;
                sorts.HeapSort(hea3, sel3.length);
                long HSE3 = System.nanoTime()/1000000;

                long ESS3 = System.nanoTime()/1000000;
                sorts.ShellSort(she3, sel3.length);
                long ESE3 = System.nanoTime()/1000000;

                System.out.println("N: " + sel3.length);
                System.out.println("Selection: " + (SSE3-SSS3) + "ms");
                System.out.println("Bubble: " + (BSE3-BSS3) + "ms");
                System.out.println("Insertion: " + (ISE3-ISS3) + "ms");
                System.out.println("Quick: " + (QSE3-QSS3) + "ms");
                System.out.println("Merge: " + (MSE3-MSS3) + "ms");
                System.out.println("Heap: " + (HSE3-HSS3) + "ms");
                System.out.println("Shell: " + (ESE3-ESS3) + "ms");
                System.out.println();		
	
		// N = 100000
		
		Integer[] bub4 = new Integer[100000];
                Integer[] ins4 = new Integer[100000];
                Integer[] qui4 = new Integer[100000];
                Integer[] mer4 = new Integer[100000];
                Integer[] hea4 = new Integer[100000];
                Integer[] she4 = new Integer[100000];


                for(int n=0; n<sel4.length; n++)
                {
                        sel4[n] = n;
                }
                for(int i=0; i<sel4.length; i++)
                {
                        bub4[i] = ins4[i] = qui4[i] = mer4[i] = hea4[i] = she4[i] = sel4[i];
                }

                long SSS4 = System.nanoTime()/1000000;
                sorts.SelectionSort(sel4, sel4.length);
                long SSE4 = System.nanoTime()/1000000;

                long BSS4 = System.nanoTime()/1000000;
                sorts.BubbleSort(bub4, sel4.length);
                long BSE4 = System.nanoTime()/1000000;

                long ISS4 = System.nanoTime()/1000000;
                sorts.InsertionSort(ins4, sel4.length);
                long ISE4 = System.nanoTime()/1000000;

                long QSS4 = System.nanoTime()/1000000;
                sorts.QuickSort(qui4, sel4.length);
                long QSE4 = System.nanoTime()/1000000;

                long MSS4 = System.nanoTime()/1000000;
                sorts.MergeSort(mer4, sel4.length);
                long MSE4 = System.nanoTime()/1000000;

                long HSS4 = System.nanoTime()/1000000;
                sorts.HeapSort(hea4, sel4.length);
                long HSE4 = System.nanoTime()/1000000;

                long ESS4 = System.nanoTime()/1000000;
                sorts.ShellSort(she4, sel4.length);
                long ESE4 = System.nanoTime()/1000000;

                System.out.println("N: " + sel4.length);
                System.out.println("Selection: " + (SSE4-SSS4) + "ms");
                System.out.println("Bubble: " + (BSE4-BSS4) + "ms");
                System.out.println("Insertion: " + (ISE4-ISS4) + "ms");
                System.out.println("Quick: " + (QSE4-QSS4) + "ms");
                System.out.println("Merge: " + (MSE4-MSS4) + "ms");
                System.out.println("Heap: " + (HSE4-HSS4) + "ms");
                System.out.println("Shell: " + (ESE4-ESS4) + "ms");
                System.out.println();		

		// N = 500000	

		Integer[] bub5 = new Integer[500000];
                Integer[] ins5 = new Integer[500000];
                Integer[] qui5 = new Integer[500000];
                Integer[] mer5 = new Integer[500000];
                Integer[] hea5 = new Integer[500000];
                Integer[] she5 = new Integer[500000];


                for(int n=0; n<sel5.length; n++)
                {
                        sel5[n] = n;
                }
                for(int i=0; i<sel5.length; i++)
                {
                        bub5[i] = ins5[i] = qui5[i] = mer5[i] = hea5[i] = she5[i] = sel5[i];
                }

                long SSS5 = System.nanoTime()/1000000;
                sorts.SelectionSort(sel5, sel5.length);
                long SSE5 = System.nanoTime()/1000000;

                long BSS5 = System.nanoTime()/1000000;
                sorts.BubbleSort(bub5, sel5.length);
                long BSE5 = System.nanoTime()/1000000;

                long ISS5 = System.nanoTime()/1000000;
                sorts.InsertionSort(ins5, sel5.length);
                long ISE5 = System.nanoTime()/1000000;

                long QSS5 = System.nanoTime()/1000000;
                sorts.QuickSort(qui5, sel5.length);
                long QSE5 = System.nanoTime()/1000000;

                long MSS5 = System.nanoTime()/1000000;
                sorts.MergeSort(mer5, sel5.length);
                long MSE5 = System.nanoTime()/1000000;

                long HSS5 = System.nanoTime()/1000000;
                sorts.HeapSort(hea5, sel5.length);
                long HSE5 = System.nanoTime()/1000000;

                long ESS5 = System.nanoTime()/1000000;
                sorts.ShellSort(she5, sel5.length);
                long ESE5 = System.nanoTime()/1000000;

                System.out.println("N: " + sel5.length);
                System.out.println("Selection: " + (SSE5-SSS5) + "ms");
                System.out.println("Bubble: " + (BSE5-BSS5) + "ms");
                System.out.println("Insertion: " + (ISE5-ISS5) + "ms");
                System.out.println("Quick: " + (QSE5-QSS5) + "ms");
                System.out.println("Merge: " + (MSE5-MSS5) + "ms");
                System.out.println("Heap: " + (HSE5-HSS5) + "ms");
                System.out.println("Shell: " + (ESE5-ESS5) + "ms");
                System.out.println();	
	}

	public static void TimeNotSortedArray()
	{
		// N = 1000

                Integer[] bub1 = new Integer[1000];
                Integer[] ins1 = new Integer[1000];
                Integer[] qui1 = new Integer[1000];
                Integer[] mer1 = new Integer[1000];
                Integer[] hea1 = new Integer[1000];
                Integer[] she1 = new Integer[1000];


                for(int n=0; n<sel1.length; n++)
                {
                        sel1[n] = (int)(Math.random()*n);
                }
                for(int i=0; i<sel1.length; i++)
                {
                        bub1[i] = ins1[i] = qui1[i] = mer1[i] = hea1[i] = she1[i] = sel1[i];
                }

                long SSS1 = System.nanoTime()/1000000;
                sorts.SelectionSort(sel1, sel1.length);
                long SSE1 = System.nanoTime()/1000000;

                long BSS1 = System.nanoTime()/1000000;
                sorts.BubbleSort(bub1, sel1.length);
                long BSE1 = System.nanoTime()/1000000;

                long ISS1 = System.nanoTime()/1000000;
                sorts.InsertionSort(ins1, sel1.length);
                long ISE1 = System.nanoTime()/1000000;

                long QSS1 = System.nanoTime()/1000000;
                sorts.QuickSort(qui1, sel1.length);
                long QSE1 = System.nanoTime()/1000000;

                long MSS1 = System.nanoTime()/1000000;
                sorts.MergeSort(mer1, sel1.length);
                long MSE1 = System.nanoTime()/1000000;

                long HSS1 = System.nanoTime()/1000000;
                sorts.HeapSort(hea1, sel1.length);
                long HSE1 = System.nanoTime()/1000000;

                long ESS1 = System.nanoTime()/1000000;
                sorts.ShellSort(she1, sel1.length);
                long ESE1 = System.nanoTime()/1000000;

                System.out.println();
                System.out.println("Unsorted List:");
                System.out.println();
                System.out.println("N: " + sel1.length);
                System.out.println("Selection: " + (SSE1-SSS1) + "ms");
                System.out.println("Bubble: " + (BSE1-BSS1) + "ms");
                System.out.println("Insertion: " + (ISE1-ISS1) + "ms");
                System.out.println("Quick: " + (QSE1-QSS1) + "ms");
                System.out.println("Merge: " + (MSE1-MSS1) + "ms");
                System.out.println("Heap: " + (HSE1-HSS1) + "ms");
                System.out.println("Shell: " + (ESE1-ESS1) + "ms");
                System.out.println();

		// N = 20000

                Integer[] bub2 = new Integer[20000];
                Integer[] ins2 = new Integer[20000];
                Integer[] qui2 = new Integer[20000];
                Integer[] mer2 = new Integer[20000];
                Integer[] hea2 = new Integer[20000];
                Integer[] she2 = new Integer[20000];


                for(int n=0; n<sel2.length; n++)
                {
                        sel2[n] = (int)(Math.random()*n);
                }
                for(int i=0; i<sel2.length; i++)
                {
                        bub2[i] = ins2[i] = qui2[i] = mer2[i] = hea2[i] = she2[i] = sel2[i];
                }

                long SSS2 = System.nanoTime()/1000000;
                sorts.SelectionSort(sel2, sel2.length);
                long SSE2 = System.nanoTime()/1000000;

                long BSS2 = System.nanoTime()/1000000;
                sorts.BubbleSort(bub2, sel2.length);
                long BSE2 = System.nanoTime()/1000000;

                long ISS2 = System.nanoTime()/1000000;
                sorts.InsertionSort(ins2, sel2.length);
                long ISE2 = System.nanoTime()/1000000;

                long QSS2 = System.nanoTime()/1000000;
                sorts.QuickSort(qui2, sel2.length);
                long QSE2 = System.nanoTime()/1000000;

                long MSS2 = System.nanoTime()/1000000;
                sorts.MergeSort(mer2, sel2.length);
                long MSE2 = System.nanoTime()/1000000;

                long HSS2 = System.nanoTime()/1000000;
                sorts.HeapSort(hea2, sel2.length);
                long HSE2 = System.nanoTime()/1000000;

                long ESS2 = System.nanoTime()/1000000;
                sorts.ShellSort(she2, sel2.length);
                long ESE2 = System.nanoTime()/1000000;

                System.out.println("N: " + sel2.length);
                System.out.println("Selection: " + (SSE2-SSS2) + "ms");
                System.out.println("Bubble: " + (BSE2-BSS2) + "ms");
                System.out.println("Insertion: " + (ISE2-ISS2) + "ms");
                System.out.println("Quick: " + (QSE2-QSS2) + "ms");
                System.out.println("Merge: " + (MSE2-MSS2) + "ms");
                System.out.println("Heap: " + (HSE2-HSS2) + "ms");
                System.out.println("Shell: " + (ESE2-ESS2) + "ms");
                System.out.println();

		// N = 80000

                Integer[] bub3 = new Integer[80000];
                Integer[] ins3 = new Integer[80000];
                Integer[] qui3 = new Integer[80000];
                Integer[] mer3 = new Integer[80000];
                Integer[] hea3 = new Integer[80000];
                Integer[] she3 = new Integer[80000];


                for(int n=0; n<sel3.length; n++)
                {
                        sel3[n] = (int)(Math.random()*n);
                }
                for(int i=0; i<sel3.length; i++)
                {
                        bub3[i] = ins3[i] = qui3[i] = mer3[i] = hea3[i] = she3[i] = sel3[i];
                }

                long SSS3 = System.nanoTime()/1000000;
                sorts.SelectionSort(sel3, sel3.length);
                long SSE3 = System.nanoTime()/1000000;

                long BSS3 = System.nanoTime()/1000000;
                sorts.BubbleSort(bub3, sel3.length);
                long BSE3 = System.nanoTime()/1000000;

                long ISS3 = System.nanoTime()/1000000;
                sorts.InsertionSort(ins3, sel3.length);
                long ISE3 = System.nanoTime()/1000000;

                long QSS3 = System.nanoTime()/1000000;
                sorts.QuickSort(qui3, sel3.length);
                long QSE3 = System.nanoTime()/1000000;

                long MSS3 = System.nanoTime()/1000000;
                sorts.MergeSort(mer3, sel3.length);
                long MSE3 = System.nanoTime()/1000000;

                long HSS3 = System.nanoTime()/1000000;
                sorts.HeapSort(hea3, sel3.length);
                long HSE3 = System.nanoTime()/1000000;

                long ESS3 = System.nanoTime()/1000000;
                sorts.ShellSort(she3, sel3.length);
                long ESE3 = System.nanoTime()/1000000;

                System.out.println("N: " + sel3.length);
                System.out.println("Selection: " + (SSE3-SSS3) + "ms");
                System.out.println("Bubble: " + (BSE3-BSS3) + "ms");
                System.out.println("Insertion: " + (ISE3-ISS3) + "ms");
                System.out.println("Quick: " + (QSE3-QSS3) + "ms");
                System.out.println("Merge: " + (MSE3-MSS3) + "ms");
                System.out.println("Heap: " + (HSE3-HSS3) + "ms");
                System.out.println("Shell: " + (ESE3-ESS3) + "ms");
                System.out.println();
		
		// N = 100000

                Integer[] bub4 = new Integer[100000];
                Integer[] ins4 = new Integer[100000];
                Integer[] qui4 = new Integer[100000];
                Integer[] mer4 = new Integer[100000];
                Integer[] hea4 = new Integer[100000];
                Integer[] she4 = new Integer[100000];


                for(int n=0; n<sel4.length; n++)
                {
                        sel4[n] = (int)(Math.random()*n);
                }
                for(int i=0; i<sel4.length; i++)
                {
                        bub4[i] = ins4[i] = qui4[i] = mer4[i] = hea4[i] = she4[i] = sel4[i];
                }

                long SSS4 = System.nanoTime()/1000000;
                sorts.SelectionSort(sel4, sel4.length);
                long SSE4 = System.nanoTime()/1000000;

                long BSS4 = System.nanoTime()/1000000;
                sorts.BubbleSort(bub4, sel4.length);
                long BSE4 = System.nanoTime()/1000000;

                long ISS4 = System.nanoTime()/1000000;
                sorts.InsertionSort(ins4, sel4.length);
                long ISE4 = System.nanoTime()/1000000;

                long QSS4 = System.nanoTime()/1000000;
                sorts.QuickSort(qui4, sel4.length);
                long QSE4 = System.nanoTime()/1000000;

                long MSS4 = System.nanoTime()/1000000;
                sorts.MergeSort(mer4, sel4.length);
                long MSE4 = System.nanoTime()/1000000;

                long HSS4 = System.nanoTime()/1000000;
                sorts.HeapSort(hea4, sel4.length);
                long HSE4 = System.nanoTime()/1000000;

                long ESS4 = System.nanoTime()/1000000;
                sorts.ShellSort(she4, sel4.length);
                long ESE4 = System.nanoTime()/1000000;

                System.out.println("N: " + sel4.length);
                System.out.println("Selection: " + (SSE4-SSS4) + "ms");
                System.out.println("Bubble: " + (BSE4-BSS4) + "ms");
                System.out.println("Insertion: " + (ISE4-ISS4) + "ms");
                System.out.println("Quick: " + (QSE4-QSS4) + "ms");
                System.out.println("Merge: " + (MSE4-MSS4) + "ms");
                System.out.println("Heap: " + (HSE4-HSS4) + "ms");
                System.out.println("Shell: " + (ESE4-ESS4) + "ms");
                System.out.println();
		
		// N = 500000

                Integer[] bub5 = new Integer[500000];
                Integer[] ins5 = new Integer[500000];
                Integer[] qui5 = new Integer[500000];
                Integer[] mer5 = new Integer[500000];
                Integer[] hea5 = new Integer[500000];
                Integer[] she5 = new Integer[500000];


                for(int n=0; n<sel5.length; n++)
                {
                        sel5[n] = (int)(Math.random()*n);
                }
                for(int i=0; i<sel5.length; i++)
                {
                        bub5[i] = ins5[i] = qui5[i] = mer5[i] = hea5[i] = she5[i] = sel5[i];
                }

                long SSS5 = System.nanoTime()/1000000;
                sorts.SelectionSort(sel5, sel5.length);
                long SSE5 = System.nanoTime()/1000000;

                long BSS5 = System.nanoTime()/1000000;
                sorts.BubbleSort(bub5, sel5.length);
                long BSE5 = System.nanoTime()/1000000;

                long ISS5 = System.nanoTime()/1000000;
                sorts.InsertionSort(ins5, sel5.length);
                long ISE5 = System.nanoTime()/1000000;

                long QSS5 = System.nanoTime()/1000000;
                sorts.QuickSort(qui5, sel5.length);
                long QSE5 = System.nanoTime()/1000000;

                long MSS5 = System.nanoTime()/1000000;
                sorts.MergeSort(mer5, sel5.length);
                long MSE5 = System.nanoTime()/1000000;

                long HSS5 = System.nanoTime()/1000000;
                sorts.HeapSort(hea5, sel5.length);
                long HSE5 = System.nanoTime()/1000000;

                long ESS5 = System.nanoTime()/1000000;
                sorts.ShellSort(she5, sel5.length);
                long ESE5 = System.nanoTime()/1000000;

                System.out.println("N: " + sel5.length);
                System.out.println("Selection: " + (SSE5-SSS5) + "ms");
                System.out.println("Bubble: " + (BSE5-BSS5) + "ms");
                System.out.println("Insertion: " + (ISE5-ISS5) + "ms");
                System.out.println("Quick: " + (QSE5-QSS5) + "ms");
                System.out.println("Merge: " + (MSE5-MSS5) + "ms");
                System.out.println("Heap: " + (HSE5-HSS5) + "ms");
                System.out.println("Shell: " + (ESE5-ESS5) + "ms");
                System.out.println();
	}
	

	// Main method

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter choice: Sorted(s) or Unsorted(u)?: ");
		char choice = scan.next().charAt(0);
		scan.nextLine();
		if(choice == 's')
		{
			TimeSortedArray();
		}
		else if(choice == 'u')
		{
			TimeNotSortedArray();
		}
		else
		{
			System.out.println("Invalid choice. Quitting...");
		}

	}
}





















































