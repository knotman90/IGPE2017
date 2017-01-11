package it.unical.it.igpe2017.arkanoid.core.obstacle;


import it.unical.it.igpe2017.arkanoid.core.AbstractDynamicObject;
import it.unical.it.igpe2017.arkanoid.core.AbstractStaticObject;
import it.unical.it.igpe2017.arkanoid.core.utils.Vector2d;

public class Obstacle extends AbstractDynamicObject{

	int obstacle_score = 0;
	
	public Obstacle(Vector2d _position , int _obstacle_score) {
		this(_position, new Vector2d(0, 0),_obstacle_score);
		
	}	
	public Obstacle(Vector2d _position, Vector2d _velocity,int _obstacle_score) {
		super(_position, _velocity);
		obstacle_score=_obstacle_score;
	}
	
	@Override
	public void update() {
		
		
	}
	
	
	

}
