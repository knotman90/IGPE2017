package it.unical.it.igpe2017.arkanoid.core;

import java.util.Iterator;
import java.util.Set;

import it.unical.it.igpe2017.arkanoid.core.obstacle.Obstacle;
import it.unical.it.igpe2017.arkanoid.core.player.Ball;
import it.unical.it.igpe2017.arkanoid.core.player.PlayerBar;
import it.unical.it.igpe2017.arkanoid.core.utils.Vector2d;

public class GameManager {
	public static int DEFAULT_WINDOW_H = 800;
	public static int DEFAULT_WINDOW_W = 600;
	GameManager(){
		this(DEFAULT_WINDOW_H,DEFAULT_WINDOW_W);
	}
	GameManager(final int H, final int W){
		this.WINDOW_H = H;
		this.WINDOW_W = W;
	}
	
	private int WINDOW_H = DEFAULT_WINDOW_H;
	private int WINDOW_W = DEFAULT_WINDOW_W;
	
	private Scene world;
	
	
	private void update(){
		world.update();
	}
	

}
