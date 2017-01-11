package it.unical.it.igpe2017.arkanoid.core;

import it.unical.it.igpe2017.arkanoid.core.obstacle.Obstacle;
import it.unical.it.igpe2017.arkanoid.core.player.Ball;
import it.unical.it.igpe2017.arkanoid.core.player.PlayerBar;
import it.unical.it.igpe2017.arkanoid.core.utils.Vector2d;

import java.util.Iterator;
import java.util.List;

public class Scene {
	
	private int H;
	private int W;
	
	private int score;
	
	
	public static final int WORLD_STATE_RUNNING 	= 0;
	public static final int WORLD_STATE_GAME_OVER 	= 1;
	public static final int WORLD_STATE_NEXT_LEVEL 	= 2;
	
	int scene_state = WORLD_STATE_RUNNING;
	
	BoudingObjectRectangular wall_north;
	BoudingObjectRectangular wall_south;
	BoudingObjectRectangular wall_left;
	BoudingObjectRectangular wall_right;
	
	protected final PlayerBar player_bar;
	protected final Ball ball;
	protected final List<Obstacle> obstacles;
	
	Scene(final int _H, final int _W, final Level level){
		this.W = _W;
		this.H = _H;
		
		this.obstacles = level.generateLevel();		
		this.player_bar = new PlayerBar(new Vector2d(H-H/4 , W/2));
		this.ball = new Ball(player_bar.getPosition().add(new Vector2d(0, -10)));
		
		
	}
	
	
	public void update(){
		player_bar.update();
		ball.update();
		
		for (Iterator iterator = obstacles.iterator(); iterator.hasNext();) {
			Obstacle obstacle = (Obstacle) iterator.next();
			obstacle.update();
		}
		
		
		handleCollisions();
	}
	
	private void handleCollisions() {
		for (Iterator iterator = obstacles.iterator(); iterator.hasNext();) {
			Obstacle obstacle = (Obstacle) iterator.next();
			//ball hits a target
			if(obstacle.collide(ball)){
				handleCollision(obstacle,ball);
				break;
			}			
		}
				
	}
	
	/**
	  *this method manage the collision between a ball and an obstacle
	  *It decides the new velocity vector for the ball and what to do 
	  *with the collided obstacle
	**/
	private void handleCollision(Obstacle obstacle, Ball ball2) {
		//compute side of the obstacle that hav ebeen hit 
		// See(http://gamedev.stackexchange.com/questions/29786/a-simple-2d-rectangle-collision-algorithm-that-also-determines-which-sides-that)
		//http://gamedev.stackexchange.com/questions/24078/which-side-was-hit/24091#24091
		//https://en.wikipedia.org/wiki/Minkowski_addition
		
	}


	/**
	 * @return the player_bar
	 */
	public PlayerBar getPlayer_bar() {
		return player_bar;
	}


	/**
	 * @return the ball
	 */
	public Ball getBall() {
		return ball;
	}
	


	

}
