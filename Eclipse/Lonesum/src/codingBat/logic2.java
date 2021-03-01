package codingBat;

public class logic2 {
	public static void main(String[] args) {
		
	}
	
	public static int loneSum(int a, int b, int c) {
		int sum = 0;
		
		if(a != b && a != c)
			sum += a;
		if(b != a && b != c)
			sum += b;
		if(c != a && c != b)
			sum += c;

		return sum;
	}
}
