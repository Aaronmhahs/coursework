public class RunTimes
{
	public static void main(String[] args)
	{
		long startTime = 0;
		long endTime = 0;

		System.out.println("Logarithmic algorithm's running times: ");
		for(long n = 10000; n < 100000000; n*=2)
		{
			startTime = System.nanoTime()/1000000;
			Algorithms.logarithmicAlgorithm(n);
			endTime = System.nanoTime()/1000000;
			System.out.println("T(" + n + ") = " + (endTime - startTime));
		}

		System.out.println("Linear algorithm's running times: ");
		for(long n = 10000; n < 100000000; n*=2)
                {
                        startTime = System.nanoTime()/1000000;
                        Algorithms.linearAlgorithm(n);
                        endTime = System.nanoTime()/1000000;
                        System.out.println("T(" + n + ") = " + (endTime - startTime));
                } 

		System.out.println("NlogN algorithm's running times: ");
		for(long n = 10000; n < 100000000; n*=2)
                {
                        startTime = System.nanoTime()/1000000;
                        Algorithms.nlognAlgorithm(n);
                        endTime = System.nanoTime()/1000000;
                        System.out.println("T(" + n + ") = " + (endTime - startTime));
                }

		System.out.println("Quadratic algorithm's running times: ");
		for(long n = 10000; n < 800000; n*=2)
                {
                        startTime = System.nanoTime()/1000000;
                        Algorithms.quadraticAlgorithm(n);
                        endTime = System.nanoTime()/1000000;
                        System.out.println("T(" + n + ") = " + (endTime - startTime));
                }
	}
}
