package queue;

/**
 * Point of the Cartesian Coordinate system.
 * 
 * @author Sabina Shrestha
 *
 */
public class Point {
	private int x;
	private int y;
	
	/**
	 * Initializes x and y.
	 * 
	 * @param x
	 * @param y
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}
