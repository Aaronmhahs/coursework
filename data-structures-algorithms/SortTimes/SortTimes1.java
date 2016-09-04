public class SortTimes1
{
	public static void main(String[] args)
	{
		Integer[] arr = new Integer[80000];

		Integer[] arr2 = arr;
		Integer[] arr3 = arr;
		Integer[] arr4 = arr;
		Integer[] arr5 = arr;

		System.out.println("TEST1: presorted list");

		int i = 0;
		for(int n = 5000; n<=80000; n*=2)
		{
			for(int j=0; j<n; j++)
			{
				arr[j] = j;
			}
			for(int l=0; l<arr.length; l++)
			{
				arr2[l] = arr3[l] = arr4[l] = arr5[l] = arr[l];
			}
			long SSS = System.nanoTime()/1000000;
			Sorts.selectionSort(arr,n);
			long SSE = System.nanoTime()/1000000;
			
			long BSS = System.nanoTime()/1000000;
			Sorts.bubbleSort(arr2,n);
			long BSE = System.nanoTime()/1000000;

			long ISS = System.nanoTime()/1000000;
			Sorts.insertionSort(arr3,n);
			long ISE = System.nanoTime()/1000000;

			long MSS = System.nanoTime()/1000000;
			Sorts.mergeSort(arr4,n);
			long MSE = System.nanoTime()/1000000;

			long QSS = System.nanoTime()/1000000;
			Sorts.quickSort(arr5,n);
			long QSE = System.nanoTime()/1000000;

			System.out.println("N=" + n + ": T_ss=" + (SSE - SSS) + ", T_bs=" + (BSE - BSS) + ", T_is=" + (ISE - ISS)+ ", T_ms=" + (MSE - MSS)+ ", T_qs=" + (QSE - QSS));
		}
		System.out.println("END TEST1");
	}
}
