package resursion;

public class FibonacciDemo {

	public static void main(String[] args) {
		for (int i=1; i < 50; i++) {
			System.out.printf("%02d %d %n", i, fibonacci(i));
		}

	}
	
	/**
	 * Calculates the n-th fibonacci number.
	 * @param n
	 * @return
	 */
	
	public static long fibonacci(int n) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		return fibonacci(n-1) + fibonacci(n-2);
	}

}
