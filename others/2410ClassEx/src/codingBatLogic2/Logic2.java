package codingBatLogic2;

/**
 * Class contains the algorithms necessary loop through each number.
 * @author Heberto Rodriguez, Logic2
 *
 */

public class Logic2 {
	public static int loneSum(int a, int b, int c) {
		int count = 0;
    	if (a != b && a != c)
		    count += a;		    
    	if (b != a && b != c)
		    count += b;		    
    	if (c != a && c != b)
		    count += c;

		return count;
	}
}
