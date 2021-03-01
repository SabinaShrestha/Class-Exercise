package resursion;

public class Factorial {

	public static void main(String[] args) {
		int number = 5;
		

	}
	
	/*
	 * Calculate the factorial of n in an iterative way
	 */
	public static long iterativeFactorial(int n) {
		if (n < 0)
			throw new IllegalArgumentException("Negative factorial can't be calculated.");
		
		int factorial = 1;
		for (int i = 1; i <= n; i++) {
			factorial *= i;
		}
		return factorial;
	}
	
	/*
	 * Calculate the factorial of n using recursion
	 * @param n
	 * @return
	 */
	public static long recursiveFactorial(int n) {
		if (n < 0)
			throw new IllegalArgumentException("Negative factorial can't be calculated.");
		
		if (n == 0)
			return 1;
		
		//n is positive
		return n * recursiveFactorial(n-1);
	}

}
