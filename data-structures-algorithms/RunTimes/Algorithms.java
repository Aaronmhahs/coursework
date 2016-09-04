public class Algorithms
{
	public static void linearAlgorithm(long n)
	{
		for(long i = 1; i <= n; i++)
		{
			int x = 1;
		}
	}
	
	public static void quadraticAlgorithm(long n)
	{
		for(long i = 1; i <= n; i++)
		{
			for(long j = 1; j <= n; j++)
			{
				int x = 1;
			}
		}
	}

	public static void logarithmicAlgorithm(long n)
        {
		for(long i = n; i >= 1; i/=2)
		{
			int x = 1;	
		}
        }

	public static void nlognAlgorithm(long n)
        {
		for(long i = 1; i <= n; i++)
		{
			for(long j = n; j >= 1; j/=2)
			{
				int x = 1;
			}
		}
        }
}
