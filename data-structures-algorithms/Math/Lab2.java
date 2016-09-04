//Student: Aaron Hahs
//Class: CPE103-04
//Date: 4-11-16

public class Lab2
{
	public static void main(String[] args)
	{
		System.out.println("Factorial of 6: " + factorial(6));
		System.out.println("Factorial of 8: " + factorial(8));
		System.out.println("Factorial of 12: " + factorial(12));

		System.out.println("Recursive Factorial of 6: " + recFactorial(6));
		System.out.println("Recursive Factorial of 8: " + recFactorial(8));
		System.out.println("Recursive Factorial of 12: " + recFactorial(12));		
	
		System.out.println("Fibonacci of 6: " + fibonacci(6));
                System.out.println("Fibonacci of 8: " + fibonacci(8));
                System.out.println("Fibonacci of 12: " + fibonacci(12));

		System.out.println("recFibonacci of 6: " + recFibonacci(6));
                System.out.println("recFibonacci of 8: " + recFibonacci(8));
                System.out.println("recFibonacci of 12: " + recFibonacci(12));
	}

	public static int factorial(int n)
	{
		int val = n;
		int sum = 1;
		while(val>0)
		{
			sum = sum*val;
			val--;
		}
		return sum;
	}
	
	public static int fibonacci(int n)
	{
		if(n==0)
		{
			return 0;
		}
		else if(n==1)
		{
			return 1;
		}
		else
		{
			int last =  
			int secondLast = 
		}
	}

	public static int recFactorial(int n)
	{
		int val = n;
		if(val<1)
		{
			return 1;
		}
		else
		{
			return val * recFactorial(val-1);
		}
	}

	public static int recFibonacci(int n)
	{
		if(n==0)
		{
			return 0;		
		}		
		else if(n==1)
		{
			return 1;
		}
		else
		{
			return recFibonacci(n-1) + recFibonacci(n-2);
		}		
	}
}	
