package it.unical.it.igpe2017.arkanoid.core.player;

import it.unical.it.igpe2017.arkanoid.core.AbstractDynamicObject;
import it.unical.it.igpe2017.arkanoid.core.IBoundingObject;
import it.unical.it.igpe2017.arkanoid.core.utils.Vector2d;

import java.util.ArrayList;


public class PlayerBar extends AbstractDynamicObject{

	public static final int PLAYER_BAR_MOVING_RIGHT = 0;
	public static final int PLAYER_BAR_MOVING_LEFT  = 1;
	public static final int PLAYER_BAR_NOT_MOVING = 2;

	public static final Vector2d DIRECTION_RIGHT = new Vector2d(1, 0);
	public static final Vector2d DIRECTION_LEFT = new Vector2d(-1, 0);

	public static final int PLAYER_BAR_MOVING_SPEED  = 1;



	int player_bar_state = PLAYER_BAR_NOT_MOVING;
	
	public PlayerBar(final Vector2d initialPos){
		this(initialPos, new Vector2d(0,0));
	}
	
	public PlayerBar(final Vector2d _position, final Vector2d _velocity){
		super(_position, _velocity);

	}

	void updateVelocity(final Vector2d direction, final int speed){
		this.velocity = this.velocity.scale(speed);
	}
	
	@Override
	public void update() {
		switch (player_bar_state) {
		case PLAYER_BAR_MOVING_LEFT:
			this.velocity = DIRECTION_LEFT.scale(PLAYER_BAR_MOVING_SPEED);
			break;
		case PLAYER_BAR_MOVING_RIGHT:
			this.velocity = DIRECTION_RIGHT.scale(PLAYER_BAR_MOVING_SPEED);
			break;
		default:
			break;
		}
		
		super.advect();
		player_bar_state = PLAYER_BAR_NOT_MOVING;
		


	}




}
