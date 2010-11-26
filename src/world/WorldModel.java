package world;

import java.util.LinkedList;
import java.util.Locale;
import java.util.Observable;
import java.util.Queue;
import java.util.Random;



public class WorldModel extends Observable {
  public enum WorldEvents {
    CONFIG_CHANGED, STEP_FORWARD;
  }
  public enum GameState {
    STOP, PLAY, PAUSE, GAME_OVER;
  }
  public enum Direction {
	UP, DOWN, LEFT, RIGHT;
  }
  private int  	score=0;
  private int	cntEaten=0;
  private int 	speed=10;
  private int 	gridWidth=100;
  private int	gridHeight=100;
  private int    [][] gameGrid;
  private GameState   state;
  private Locale locale;
  private LinkedList<GridPoint> snake=new LinkedList<GridPoint>();
  private Direction nextDirection = Direction.LEFT;
  private GridPoint insect = new GridPoint(0, 0);
  private Random r = new Random();
  
  public WorldModel(){
    setLocale(Locale.getDefault());
    state = GameState.STOP;
    snake.addFirst(new GridPoint(gridWidth/2, gridHeight/2));
    snake.addFirst(new GridPoint(gridWidth/2-1, gridHeight/2));
    snake.addFirst(new GridPoint(gridWidth/2-2, gridHeight/2));
    snake.addFirst(new GridPoint(gridWidth/2-2, gridHeight/2-1));
    snake.addFirst(new GridPoint(gridWidth/2-2, gridHeight/2-2));
  }
  /**
   * @param width grid width
   * @param height grid height
   */
  public void setGridDimensions(int width, int height) {
    gridWidth=width; gridHeight=height;
  }
  /**
   * @param speed the speed to set
   */
  public void setSpeed(int speed) {
    this.speed = speed;
    setChanged();
    notifyObservers(WorldEvents.CONFIG_CHANGED);
  }
  /**
   * @return the speed
   */
  public int getSpeed() {
    return speed;
  }
  /**
   * @param score the score to set
   */
  public void setScore(int score) {
    this.score = score;
    setChanged();
    notifyObservers(WorldEvents.CONFIG_CHANGED);
  }
  /**
   * @return the score
   */
  public int getScore() {
    return score;
  }
  /**
   * sets the number of eaten insects
   * @param cntEaten number of eaten insects
   */
  public void setCntEaten(int cntEaten) {
	  setChanged();
	  notifyObservers(WorldEvents.CONFIG_CHANGED);
	  this.cntEaten = cntEaten;	  
  }
  /**
   * gets the number of eaten insects
   */
  public int getCntEaten() {
	  return cntEaten;	  
  }
  /**
   * @param locale the locale to set
   */
  public void setLocale(Locale locale) {
	this.locale = locale;
    setChanged();
    notifyObservers(WorldEvents.CONFIG_CHANGED);
  }
  /**
   * @return the locale
   */
  public Locale getLocale() {
    return locale;
  }
  /**
   * @param state the state to set
   */
  public void setState(GameState state) {
	this.state = state;
    setChanged();
    notifyObservers(WorldEvents.CONFIG_CHANGED);
  }
  /**
   * @return the state
   */
  public GameState getState() {
    return state;
  }
  /**
   * sets the next direction to d
   * @param d next direction
   */
  public void setNextDirection(Direction d) {
	  // check if next direction is opposite to the current one
	  if ((nextDirection==Direction.DOWN && d==Direction.UP) ||
			  (nextDirection==Direction.UP && d==Direction.DOWN))
		  return;
	  if ((nextDirection==Direction.LEFT && d==Direction.RIGHT) ||
			  (nextDirection==Direction.RIGHT && d==Direction.LEFT))
		  return;
	  // change next direction
	  nextDirection = d;
  }
  /**
   * @return the insect
   */
  public GridPoint getInsect(){
	  return insect;
  }
  /**
   * @return the Queue representing the snake
   */
  public Queue<GridPoint> getSnake(){
	  return snake;
  }
  /**
   * creates a new insect in a random place.
   */
  private void replaceInsect(){
	  GridPoint ni; // the new insect
	  do {
		  ni=new GridPoint(r.nextInt(gridWidth), r.nextInt(gridHeight));
	  }while(isSnakeOnPoint(ni));
	  insect = ni;
  }
  /**
   * checks if the snake is placed on the given point
   * @param p point to check
   * @return true if snake is on p
   */
  private boolean isSnakeOnPoint(GridPoint p) {
	  for(GridPoint sp : snake) {
		if(sp.getX()==p.getX() && sp.getY()==p.getY()) {
			return true;
		}
	  }
	  return false;
  }
  /**
   * move snake to its next position.
   */
  public void stepForward() {
	GridPoint crt = snake.getFirst();
	GridPoint next;
	
	switch(nextDirection) {
		case UP:
			next = new GridPoint(crt.getX(), crt.getY()-1);
			break;
		case DOWN:
			next = new GridPoint(crt.getX(), crt.getY()+1);
			break;
		case LEFT:
			next = new GridPoint(crt.getX()-1, crt.getY());
			break;
		case RIGHT:
			next = new GridPoint(crt.getX()+1, crt.getY());
			break;
		default:
			next = new GridPoint(crt.getX(), crt.getY());
	}
	
	if(		next.getX()<0 || next.getX()>=gridWidth ||	// check if snake goes out of bounds
			next.getY()<0 || next.getY()>=gridHeight) {
		setState(GameState.GAME_OVER);
		return;
	}
	
	if(isSnakeOnPoint(next)) {	// snake eats its own tail
		setState(GameState.GAME_OVER);
		return;
	}
	
	snake.addFirst(next);
	
	// Insect has been eaten, snake grows longer
	if(next.getX()==insect.getX() && next.getY()==insect.getY()) {
		insect = new GridPoint((new Random()).nextInt(gridWidth), (new Random()).nextInt(gridHeight));
		replaceInsect();
	}
	else {
		snake.removeLast();
	}
	
    setChanged();
    notifyObservers(WorldEvents.STEP_FORWARD);
  }
}
