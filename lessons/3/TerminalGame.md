#Interfacce Grafice e Programmazione ad Eventi - IGPE

---

##Register on Google Classroom using the code: fe3y6i

---

#Terminal Game 

In this assignment, we will write a simple text-based game.
The final results will look like as in this video: 

[![IGPE2017 - Terminal Game](http://img.youtube.com/vi/clQ75KMXnLY/0.jpg)](https://www.youtube.com/watch?v=clQ75KMXnLY "IGPE2017 - Terminal Game")

##Game Overview

This is a single player game and the client controls it by using the `Enter` key of the keyboard. The player sits in the leftmost part of the game screen and when `Enter` is pressed it jumps. Tanks appear in the rightmost part of the game screen and move to the left. The goal of the player is to avoid collision with the greatest number of tanks that move to the left. The game ends whenever player's score drops negative.


##Game Implementation
You are asked to code this **super complex** game using plain `Java` and not external libraries whatsoever.

We will reuse some of the work from the last week (on collisions).

The Logic of the Game is handled by the class `Game` which stores info about a `Player` and a Collection of `Obstacles`.

```
public class Game {

	
	private Player player;
	private List<IGameObject> gameObjects;
	private int WIDTH, HEIGHT;
	private boolean gameOver=false;

	
	
	public Game(final int _HEIGHT, final int _WIDTH) {
		WIDTH = _WIDTH;
		HEIGHT = _HEIGHT;
		player = new Player(new Vector2d(2,GameConfig.HEIGHT-1- GameConfig.SIZE_PLAYER_Y) ,
				new Vector2d(GameConfig.SIZE_PLAYER_X, GameConfig.SIZE_PLAYER_Y));
		gameObjects = new LinkedList<IGameObject>();
	}


	void evolve(double ms_dt){
		
	}



	private void handleGameOver() {
		
	}


	private void generateObstacles() {
		
	}


	private void handleCollisions() {
		

	}

}
```

**function `evolve`takes care of moving all objects in the scene checking for gameOver and handling collisions**.

Note that each object of this game will implement the following interface.

```java
public interface IGameObject extends ICollidable{
	//return the size in pixels of the object
	public Vector2d getSize();
	//returns the coordinate of the upper left corner 
	public Vector2d getPosition();
	//return the force which is applied to the object
	public Vector2d getForce();
	//returns the velocity of the object
	public Vector2d getVelocity();
	
	public void setPosition(Vector2d _position);
	public void setVelocity(Vector2d _velocity);
	public void setForce(Vector2d _force);
	public void setSize(Vector2d _size);
	/**
	 * Apply physics laws to move the object
	 * @param dt time between two frames
	 */
	public void  move(final double dt);	
}
```

and will have as superclass the following abstract class.

```java
public abstract class AbstractGameObject implements IGameObject{
	
	protected Vector2d position;
	protected Vector2d size;
	protected Vector2d velocity 	= new Vector2d(0.0, 0.0);	
	protected Vector2d force 		= GameConfig.GRAVITY;
	

	public AbstractGameObject(Vector2d _position, Vector2d _size) {
		this.position = _position;
		this.size = _size;
	}
	
		public String toString() {
		String s ="[";
		s+=" pos: "+position.toString();
		s+=" vel: "+velocity.toString();
		s+=" for: "+force.toString();
		s+="]";
		return s;
	}
	
	@Override
	public void move(final double dt) {
		applyGravity(dt);
		
		Vector2d newVelocity = computeNewVelocity(getVelocity(), getForce(), dt);
		
		setVelocity(newVelocity);
		
		if((int)(position.getY()+size.getY()) >= GameConfig.HEIGHT && velocity.getY()>0){
			Vector2d nv = new Vector2d(getVelocity().getX(), 0);
			setVelocity(nv);
		}
		
		Vector2d newPosition = computeNewPosition(getPosition(),getVelocity(),dt);
		
		setPosition(newPosition);
		if(getPosition().getY()+getSize().getY() >= GameConfig.HEIGHT)
			getPosition().setY((int)GameConfig.HEIGHT-getSize().getY());
	
	}
	

```
- move implements the movement of an object. 
- You have to write your own version of `computeNewPosition` and `computeNewVelocity`


`Vector2D` is a class that models a 2D euclidean vector and implements common operations on vectors (scale, add, minus, lenght etc.)
```
public  class Vector2d {

		public static Vector2d ZERO = new Vector2d(0, 0);
	
	    private  double x;
	    private  double y;
	   
	   public Vector2d(double x, double y){
	        this.x = x;
	        this.y = y;
	        
	    }

	    public Vector2d scale(final double scalefactor) {
	        return new Vector2d(x * scalefactor, y * scalefactor);
	    }

	    public double dot(Vector2d o) {
	        return x * o.x + y * o.y ;
	    }

	    public double abs() {
	        return Math.sqrt(x * x + y * y );
	    }

....
}
```


#Game GUI
The GUI is completely separated from the `Game` class. 

```java
public class GameGUI {

	private  int WIDTH, HEIGHT;


private 	long frame =0;
private 	Game g;


private 	IDrawer pd = new PlayerDrawer(); //player drawers
private 	ObstacleDrawer od = new ObstacleDrawer();
private 	List<IDrawer> osd; //obstacoles Drawers

private 	StringBuilder sb ;
private 	char[][] pixels;
	
	GameGUI(final int H , final int W){
		WIDTH = W;
		HEIGHT = H;
		pixels = new char[HEIGHT][WIDTH];
		sb = new StringBuilder();
		buildBorder();
		createGame();
	}


	void createGame(){

		g = new Game(HEIGHT,WIDTH);
	}


	private void wipeFrame(){
		sb.delete(0, sb.length());
		for(int i=0;i<pixels.length;i++)
			for(int j=0 ; j < pixels[i].length ; j++)
				pixels[i][j] = ' ';


	}
	private void buildBorder() {
		for(int i=0;i<WIDTH;i++){
			pixels[0][i] = '-';
			pixels[HEIGHT-1][i] = '_';
		}

	}
	
	
	private void write(final String s, final int start, final int cstart){
		for (int i = 0; i < s.length(); i++) {
			pixels[start][cstart + i]=s.charAt(i);
			
		}
	}
	
	void buildScore(){
		int rstart =GameConfig.SCORE_ROW;
		int cstart =GameConfig.SCORE_COL;
		write("SCORE:",rstart , cstart );
		cstart+=new String("SCORE:").length();
		
		int score = g.getPlayer().getPoints();
		int i=0;
		do{
			int d = score%10;
			score/=10;
			pixels[rstart][cstart+i]=(char)((int)'0'+d);
		}while(score>0);
	}


	void buildFrame(){
//wipe the current frame first, then draw the player and the rest of the objects.	
//finally call buildScore to render the score.		

	}

	@Override
	public String toString() {


	}


void clrsc(){
	System.out.print("\033[H\033[2J");
	System.out.flush();
}

	void mainLoop(){
		Scanner s = new Scanner(System.in);
		long start = System.currentTimeMillis();
		long end;
		
		//keyboard listener is being started
		Thread jt = new Thread(new JumpListener(this));
		jt.start();
		
		while(true){

			//code here 
			//for printing the matrix pixel on screen (using toString)
			//and for calling evolve of the Game
			
		}
	}
	
	public Game getGame() {
		return g;
	}

	public static void main(String[] args) {
		GameGUI g = new GameGUI(GameConfig.HEIGHT,GameConfig.WIDTH);
		g.mainLoop();
	}



	
```

`IDrawer` is the following interface:
```java
public interface IDrawer {
	//draw obj on the matrix pixels which has size H * W
	void  draw(IGameObject obj, final int H, final int W, char[][] pixels);
	//checks if (x,y) lies within pixels margins 
	public static boolean isVisible(final int x, final int y, final int W, final int H){
		return (x >=0 && x< W && y >=0 && y<H);
	}

}
```

- You can create your own implementation of a Drawer for the player and for the obstacle. I'm proving you with a basic one which draws the objects as a rectangle.

```java

public class BasicDrawer implements IDrawer{

	char c='.';
	
	@Override
	public void draw(IGameObject p, int H, int W, char[][] pixels) {
		int starty = (int) p.getPosition().getY() ;
		int endy = (int) Math.min(p.getPosition().getY()+p.getSize().getY(), H);

		int startx = (int) p.getPosition().getX() ;
		int endx = (int) Math.min(p.getPosition().getX()+p.getSize().getX(), W);

		for (int j = starty; j < endy; j++) {
			for(int i=startx ;  i < endx ; i++){
				if(IDrawer.isVisible(i, j, W, H))
					pixels[j][i] = c;

			}
		}
		
	}
}

```

#Input Listener
The following is the `JumpListner` class which takes care of signaling to the `Game` whenever the user hits the `enter` key.

```java
public class JumpListener implements Runnable{
	
	final GameGUI gameGUI;
	final Scanner s = new Scanner(System.in);
	public JumpListener(final GameGUI _gameGUI) {
		this.gameGUI = _gameGUI;
	}
	
	@Override
	public void run() {
		while(true){
			s.nextLine();
			gameGUI.getGame().getPlayer().jump();
		}
	}

}
```

#A note on clrcs
There is not a standard method for clearing the terminal. I'll give you a method which successfully clears the screen on my terminal (and on a large number of Linux terminals).
Search online about how to clear the screen on you system.
```java
void clrsc(){
	System.out.print("\033[H\033[2J");
	System.out.flush();
}
```
