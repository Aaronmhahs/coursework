public class Sorts
{
	public static <T extends Comparable<? super T>> void selectionSort(T[] arr, int size)
	{
		//Sorts the list of size elements contained in arr using the selection sort algorithm.
		for(int i = 0; i < size-1; i++)
		{
			int minIndex = i;
			for(int j = i+1; j < size; j++)
			{
				if(arr[j].compareTo(arr[minIndex]) < 0)
				{
					minIndex = j;
				}
			}
			T temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
	}
		
	public static <T extends Comparable<? super T>> void bubbleSort(T[] arr, int size)
	{
		//Sorts the list of size elements contained in arr using the bubble sort algorithm.
		boolean done = false;
		while(!done)
		{
			done = true;
			for(int i = 0; i < size-1; i++)
			{
				if(arr[i].compareTo(arr[i+1]) > 0)
				{
					T temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					done = false;
				}
			}
		}
	}	
	public static <T extends Comparable<? super T>> void insertionSort(T[] arr, int size)
	{
		//Sorts the list of size elements contained in arr using the insertion sort algorithm
		
		for(int i = 1; i< size; i++)
		{
			T temp = arr[i];
			int j = i;
			while(j > 0)
			{
				arr[j] = arr[j-1];
				j--;
			}
			arr[j] = temp;
		}
	}

	
	
	//O(NlogN) Algorithms Below-----------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------------------
	public static <T extends Comparable<? super T>> void mergeSort(T[] arr, int size)
	{
		mergeSort(arr, 0, size-1);//Sorts the list of size elements contained in arr using the merge sort algorithm.
	}
	private static <T extends Comparable<? super T>> void mergeSort(T[] list, int first, int last)
	{
		if(first < last)
		{
			int middle = (first + last)/2;
			mergeSort(list, first, middle);
			mergeSort(list, middle+1, last);
			mergeSortedHalves(list, first, middle, last);
		}
	}
	private static <T extends Comparable<? super T>> void mergeSortedHalves(T[] arr, int left, int middle, int right)
	{
		T[] temp = (T[])new Comparable[right-left+1];
		int index1 = left;
		int index2 = middle+1;
		int index = 0;
		
		while(index1 <= middle && index2 < right)//elements in both halves
		{
			if(arr[index1].compareTo(arr[index2]) < 0)//arr[index1] < arr[index2])
			{
				temp[index] = arr[index1];
				index1++;
			}
			else
			{
				temp[index] = arr[index2];
				index2++;
			}
			index++;
		}
		
		if(index1 <= middle)
		{
			for(; index1 <= middle; index1++)
			{
				temp[index++] = arr[index1];
			}
		}
		else
		{
			for(; index2 < right; index2++)
			{
				temp[index++] = arr[index2];
			}
		}
		
		index = left;
		for(int i = 0; i < temp.length-1; i++)
		{
			arr[index++] = temp[i];
		}
	}
	public static <T extends Comparable<? super T>> void quickSort(T[] arr, int size)
	{
		//Sorts the list of size elements contained in arr using the quick sort algorithm with
		//median-of-three pivot and rearrangement of the three elements (as done in class).
		quickSort(arr, 0, size-1);
	}
	private static <T extends Comparable<? super T>> void quickSort(T[] list, int first, int last)
	{
		if(first < last)
		{
			setPivotToEnd(list, first, last);
			int pivotIndex = splitList(list, first, last);
			quickSort(list, first, pivotIndex-1);
			quickSort(list, pivotIndex+1, last);
		}
	}
	private static <T extends Comparable<? super T>> void setPivotToEnd(T[] arr, int left, int right)
	{
		int center = (left + right)/2;
		
		if(arr[center].compareTo(arr[left]) < 0)//arr[center] < arr[left])
		{
			T temp = arr[center];
			arr[center] = arr[left];
			arr[left] = temp;
		}
		if(arr[right].compareTo(arr[left]) < 0)//arr[right] < arr[left])
		{
			T temp = arr[right];
			arr[right] = arr[left];
			arr[left] = temp;
		}
		if(arr[center].compareTo(arr[right]) < 0)//arr[center] < arr[right])
		{
			T temp = arr[center];
			arr[center] = arr[right];
			arr[right] = temp;
		}
	}
	private static <T extends Comparable<? super T>> int splitList(T[] arr, int left, int right)
	{
		int indexL = left;
		int indexR = right-1;
		T pivot = arr[right];
		T temp = null;
		while(indexR > indexL)
		{
			while(arr[indexL].compareTo(pivot) < 0)//item at indexL is less than pivot
			{
				indexL++;
			}
			while(indexR > indexL && arr[indexR].compareTo(pivot) > 0)//item at indexR is greater than pivot
			{
				indexR--;
			}
			if(indexR > indexL)
			{
				temp = arr[indexL];
				arr[indexL++] = arr[indexR];
				arr[indexR--] = temp;
			}
		}
		temp = arr[indexL];
		arr[indexL] = arr[right];
		arr[right] = temp;
		return indexL;
	}
}
