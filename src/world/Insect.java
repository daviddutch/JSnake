package world;

public class Insect extends GridPoint {
	private int score;
	/**
	 * constructor
	 */
	public Insect(int x, int y, int score) {
		super(x, y);
		this.score = score;
	}
	/**
	 * @return the score of this insect
	 */
	public int getScore() { return score; }
}
