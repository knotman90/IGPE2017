package it.unical.it.igpe2017.arkanoid.core.player;

import it.unical.it.igpe2017.arkanoid.core.AbstractDynamicObject;
import it.unical.it.igpe2017.arkanoid.core.utils.Vector2d;

public class Ball extends AbstractDynamicObject{

	
	public Ball(Vector2d _postions) {
		this(_postions, new Vector2d(0, 0));
	}
	
	public Ball(Vector2d _position, Vector2d _velocity) {
		super(_position,_velocity);
	}
	
	@Override
	public void update() {
		super.advect();		
	}

}
