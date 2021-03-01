package resursion;

public class EuklideanAlgorithm {
	public static void main(String[] args) {
		int x = 18;
		int y = 21;
		System.out.printf("gcd(%d,%d) = %d %n", x, y, gcd(x,y));
	}
	
	private static int gcd(int a, int b) {
		if (b == 0)
			return a;
		else 
			return gcd(b, a % b);
	}
	
}
