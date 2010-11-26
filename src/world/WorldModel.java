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
  private int    score=0;
  private int	 cntEaten=0;
  private int    speed=4;
  public static final int GRID_WIDTH=100;
  public static final int GRID_HEIGHT=100;
  private int    [][] gameGrid;
  private GameState   state;
  private Locale locale;
  private LinkedList<GridPoint> snake=new LinkedList<GridPoint>();
  private Direction nextDirection = Direction.LEFT;
  private GridPoint insect = new GridPoint(0, 0);
  
  public WorldModel(){
    setLocale(Locale.getDefault());
    state = GameState.STOP;
    snake.addFirst(new GridPoint(GRID_WIDTH/2, GRID_HEIGHT/2));
    snake.addFirst(new GridPoint(GRID_WIDTH/2-1, GRID_HEIGHT/2));
    snake.addFirst(new GridPoint(GRID_WIDTH/2-2, GRID_HEIGHT/2));
    snake.addFirst(new GridPoint(GRID_WIDTH/2-2, GRID_HEIGHT/2-1));
    snake.addFirst(new GridPoint(GRID_WIDTH/2-2, GRID_HEIGHT/2-2));
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
   * set the number of eaten insects
   * @param cntEaten number of eaten insects
   */
  public void setCntEaten(int cntEaten) {
	  setChanged();
	  notifyObservers(WorldEvents.CONFIG_CHANGED);
	  this.cntEaten = cntEaten;	  
  }
  /**
   * get the number of eaten insects
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
   * Move snake to its next position.
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
	
	//TODO: if next position is not valid return error value
	if(		next.getX()<0 || next.getX()>=GRID_WIDTH ||	// snake's head out of bounds
			next.getY()<0 || next.getY()>=GRID_HEIGHT) {
		state = GameState.GAME_OVER;
		return;
	}
	
	for(GridPoint p : snake) {	// snake eat its own tail
		if(next.getX()==p.getX() && next.getY()==p.getY()) {
			state = GameState.GAME_OVER;
			return;
		}
	}
	
	snake.addFirst(next);
	
	// Insect has been eaten, snake grows longer
	if(next.getX()==insect.getX() && next.getY()==insect.getY()) {
		insect = new GridPoint((new Random()).nextInt(GRID_WIDTH), (new Random()).nextInt(GRID_HEIGHT));
		//TODO: replace insect somewhere else
	}
	else {
		snake.removeLast();
	}
	
    setChanged();
    notifyObservers(WorldEvents.STEP_FORWARD);
  }
}
