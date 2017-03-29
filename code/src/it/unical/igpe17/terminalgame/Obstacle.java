package it.unical.igpe17.terminalgame;

import collisions.Box;
import collisions.ICollidable;

public class Obstacle extends AbstractGameObject{

	public Obstacle(Vector2d _position, Vector2d _size) {
		super(_position, _size);
		boundingBox = new Box((int)position.getX(), (int)position.getY(),(int) size.getX(),(int) size.getY());

	}


	private Box boundingBox;






	@Override
	public Vector2d getVelocity() {
		return velocity;
	}

	@Override
	public Vector2d getPosition() {
		return position;

	}

	@Override
	public void move(final double dt) {

		super.move(dt);
		boundingBox.setX((int)position.getX());
		boundingBox.setY((int)position.getY());
	}

	@Override
	public boolean collide(ICollidable c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Vector2d getForce() {
		return force;
	}

	@Override
	public void setPosition(Vector2d pos) {
		this.position = pos;
	}

	@Override
	public void  setVelocity(Vector2d vel) {
		this.velocity = vel;
	}

	@Override
	public void setForce(Vector2d _force) {
		this.force = _force;
	}

	/**
	 * @return the boundingBox
	 */
	public Box getBoundingBox() {
		return boundingBox;
	}



}
