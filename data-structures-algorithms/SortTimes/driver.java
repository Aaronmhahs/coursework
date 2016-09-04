public class driver
{
	public static void main(String[] args)
	{
		Integer[] arr = new Integer[80000];
		for(int i=0; i<arr.length; i++)
		{
			arr[i] = (int)(Math.random()*100);
		}
		
		for(int j=0; j<arr.length; j++)
		{
			System.out.print(arr[j] + " ");
		}
		
		Integer[] arr2 = arr;
		Integer[] arr3 = arr;
		Integer[] arr4 = arr;
		Integer[] arr5 = arr;

		//Sorts.selectionSort(arr,arr.length);
		long BSS = System.nanoTime()/1000000;
		Sorts.bubbleSort(arr2,arr.length);
		long BSE = System.nanoTime()/1000000;
		/*Sorts.insertionSort(arr3,arr.length);
		Sorts.mergeSort(arr4,arr.length);
		Sorts.quickSort(arr5,arr.length);
		System.out.println();

		System.out.println("selectionSort: ");
		for(int j=0; j<arr.length; j++)
		{
			System.out.print(arr[j] + " ");
		}
		*/System.out.println();

		System.out.println("bubbleSort: ");  
		for(int j=0; j<arr2.length; j++)
		{
			System.out.print(arr[j] + " ");
		}
		System.out.println();
		System.out.println("Time for BubbleSort: " + (BSE-BSS));/*

		System.out.println("insertionSort: ");  
		for(int j=0; j<arr3.length; j++)
		{
			System.out.print(arr[j] + " ");
		}       
		System.out.println();

		System.out.println("mergeSort: ");  
		for(int j=0; j<arr4.length; j++)
		{
			System.out.print(arr[j] + " ");
		}       
		System.out.println();

		System.out.println("quickSort: ");  
		for(int j=0; j<arr5.length; j++)
		{
			System.out.print(arr[j] + " ");
		}       
		System.out.println();*/	
	}
}
