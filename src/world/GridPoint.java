package world;

public class GridPoint {
	private int x, y;
	/**
	 * Constructor method.
	 * @param x x coordinate
	 * @param y y coordinate
	 */
	public GridPoint(int x, int y) {
		this.x=x; this.y=y;
	}
	/**
	 * x coordinate getter
	 * @return x coordinate
	 */
	public int getX() {
		return x;
	}
	/**
	 * y coordinate getter
	 * @return y coordinate
	 */
	public int getY() {
		return y;
	}
}
