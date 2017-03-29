package it.unical.igpe17.terminalgame;

public class GameConfig {

	public static final long MIN_RENDERING_TIME_MS=100;
	
	public static double SPEED_PX_S = 30; 
	
	public static Vector2d GRAVITY = new Vector2d(0, +28.81);
	
	public static Vector2d JUMP_FORCE = new Vector2d(0, 0);
	
	public static final int WIDTH = 200;
	public static final int HEIGHT = 40;

	public static final double JUMP_VELOCITY = -40;
	
	public static final int  DS_X = 10;
	public static final int  DS_Y = 10;

	public static final double SIZE_PLAYER_X = 26;

	public static final double SIZE_PLAYER_Y = 7;

	public static final double SIZE_OBSTALCE_Y = 4;

	public static final double SIZE_OBSTALCE_X =24 ;

	public static final long SPAWN_TIME = 2500;

	public static final int SCORE_ROW = 2;
	public static final int SCORE_COL = 2;

	public static final int PLAYER_UNSCORE = -1;
	public static final int PLAYER_SCORE = 1;

	
	
}
