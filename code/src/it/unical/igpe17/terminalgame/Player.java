package it.unical.igpe17.terminalgame;

import java.util.Vector;

import collisions.Box;
import collisions.ICollidable;

public class Player extends AbstractGameObject implements IPlayer{

	private int points=0;

@Override
public String toString() {
	String s ="Player: ";
	
	return s+" "+super.toString();
}
	public Player(Vector2d _position, Vector2d _size) {
		super(_position, _size);
		boundingBox = new Box((int)position.getX(), (int)position.getY(),(int) size.getX(),(int) size.getY());
		

	}

	private Box boundingBox;



@Override
	public void move(double dt) {
	
		super.move(dt);
		boundingBox.setX((int)position.getX());
		boundingBox.setY((int)position.getY());
	}

	@Override
	public boolean collide(ICollidable c) {
		if(c instanceof Obstacle)
			return boundingBox.collide(((Obstacle)c).getBoundingBox());
		return false;
	}

	@Override
	public void jump() {
		
		if((int)(position.getY()+size.getY()) >= GameConfig.HEIGHT)
		this.velocity.setY( GameConfig.JUMP_VELOCITY);
		//System.out.println(this.velocity.getY());

	}

	@Override
	public void fire() {
		// TODO Auto-generated method stub

	}
	public Object getBoundingBox() {
		return boundingBox;
	}


	private void setY(final int y) {
		this.position.setY(y);
		boundingBox.setY(y);

	}


	public void score(final int _score){
		points+=_score;
	}
	/**
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}
	
	





}
