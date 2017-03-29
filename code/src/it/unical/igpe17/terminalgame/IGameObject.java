package it.unical.igpe17.terminalgame;

import collisions.ICollidable;

public interface IGameObject extends ICollidable{

	public Vector2d getSize();
	public Vector2d getPosition();
	public Vector2d getForce();
	public Vector2d getVelocity();
	
	
	public void setPosition(Vector2d _position);
	public void setVelocity(Vector2d _velocity);
	public void setForce(Vector2d _force);
	public void setSize(Vector2d _size);
	
	
	public void  move(final double dt);
	
	
	
	
}
