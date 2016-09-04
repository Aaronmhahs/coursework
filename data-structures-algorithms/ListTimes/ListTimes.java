public class ListTimes
{
	public static void main(String[] args)
	{
		MyArrayList_Lab4 list = new MyArrayList_Lab4();
		list.ensureCapacity(1000);		
		for(int i=0; i<990; i++)
		{
			list.add(1);
		}

		System.out.println("Testing add method");
		long startTime = System.nanoTime();
		list.add(3);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("Add method runtime: " + duration + " nanoseconds");
		
		System.out.println("Testing add(with index) method");
                startTime = System.nanoTime();
                list.add(999,9);
                endTime = System.nanoTime();
                duration = (endTime - startTime);
                System.out.println("Add(with index) method runtime: " + duration + " nanoseconds");

		System.out.println("Testing get method");
                startTime = System.nanoTime();
                list.get(0);
                endTime = System.nanoTime();
                duration = (endTime - startTime);
                System.out.println("Get method runtime: " + duration + " nanoseconds");
		
		System.out.println("Testing set method");
                startTime = System.nanoTime();
                list.set(0,2);
                endTime = System.nanoTime();
                duration = (endTime - startTime);
                System.out.println("Set method runtime: " + duration + " nanoseconds");

		System.out.println("Testing remove method");
                startTime = System.nanoTime();
                list.remove(0);
                endTime = System.nanoTime();
                duration = (endTime - startTime);
                System.out.println("Remove method runtime: " + duration + " nanoseconds");		
	}
}
