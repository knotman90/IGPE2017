package it.unical.igpe17.terminalgame;

import collisions.ICollidable;

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
	
	
	public void  move(final double dt);
	
		
}
