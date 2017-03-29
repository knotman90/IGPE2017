package it.unical.igpe17.terminalgame;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import jdk.nashorn.internal.runtime.regexp.joni.Config;

public class Game {

	private static  double speed = GameConfig.SPEED_PX_S;// pixels per second
	private Player player;
	protected Random r = new Random(System.currentTimeMillis());

	long lastSpawn=0;

	List<IGameObject> gameObjects;

	int WIDTH, HEIGHT;
	private boolean gameOver=false;

	private int nSpawn =0;
	
	
	public Game(final int _HEIGHT, final int _WIDTH) {
		WIDTH = _WIDTH;
		HEIGHT = _HEIGHT;
		player = new Player(new Vector2d(2,GameConfig.HEIGHT-1- GameConfig.SIZE_PLAYER_Y) ,
				new Vector2d(GameConfig.SIZE_PLAYER_X, GameConfig.SIZE_PLAYER_Y));
		gameObjects = new LinkedList<IGameObject>();

		//Obstacle ob = new Obstacle(new Vector2d(30, 10),new Vector2d(GameConfig.SIZE_OBSTALCE_X, GameConfig.SIZE_OBSTALCE_Y));
		//ob.setVelocity(new Vector2d(-1*speed, 0));
		//gameObjects.add(ob);
	}


	void evolve(double ms_dt){
		//convert dt from millisecond to second
		handleGameOver();
		handleCollisions();			
		double dt = ms_dt/1000.0;
		player.move(dt);
		//		System.out.println(player.force.getY());
		//		System.out.println(player.position.getY()+player.getSize().getY());
		//		System.out.println(GameConfig.HEIGHT);
		for (Iterator<IGameObject> iterator = gameObjects.iterator(); iterator.hasNext();) {
			IGameObject iGameObject = (IGameObject) iterator.next();
			iGameObject.move(dt);
			if(iGameObject.getPosition().getX()+iGameObject.getSize().getX() < 0){
				iterator.remove();
				player.score(GameConfig.PLAYER_SCORE);
			}

		}

		generateObstacles();

	}



	private void handleGameOver() {
		if(player.getPoints() < 0)
		{
			System.out.println("Game Over");
			this.gameOver=true;
		}
		
	}


	private void generateObstacles() {
		final long t = System.currentTimeMillis();
		if((t-lastSpawn)>=GameConfig.SPAWN_TIME){
			if(r.nextDouble() <= 0.4){
				nSpawn++;
				speed+=nSpawn%2==0 ? 1.0 : 0;
				Obstacle ob = new Obstacle(new Vector2d(GameConfig.WIDTH-GameConfig.SIZE_OBSTALCE_X-1, GameConfig.HEIGHT-GameConfig.SIZE_OBSTALCE_Y-1),new Vector2d(GameConfig.SIZE_OBSTALCE_X, GameConfig.SIZE_OBSTALCE_Y));
				ob.setVelocity(new Vector2d(-1*speed, 0));
				gameObjects.add(ob);
				
			}
			lastSpawn = t;
		}
	}


	private void handleCollisions() {
		//System.out.println(((Player)player).getBoundingBox().toString());
		for (Iterator<IGameObject> iterator = gameObjects.iterator(); iterator.hasNext();) {
			IGameObject iGameObject = (IGameObject) iterator.next();
			System.out.println(((Obstacle)iGameObject).getBoundingBox().toString());
			if(player.collide(iGameObject)){
				//System.out.println("COLLISION");	
				iterator.remove();	
				player.score(GameConfig.PLAYER_UNSCORE);
			}
		}

	}



	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}


	public boolean isGameOver() {
		return gameOver;
	}



}
