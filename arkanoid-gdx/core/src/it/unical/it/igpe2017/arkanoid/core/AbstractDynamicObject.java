package it.unical.it.igpe2017.arkanoid.core;

import it.unical.it.igpe2017.arkanoid.core.utils.Vector2d;

public abstract class AbstractDynamicObject extends AbstractStaticObject implements IDynamicObject{

	protected Vector2d velocity;

	public AbstractDynamicObject(Vector2d _position, Vector2d _velocity) {
		this.position = _position;
		this.velocity = _velocity;
	}
	
	@Override
	public Vector2d getVelocity() {
		return this.velocity;
	}

	@Override
	public Vector2d getDirection() {
		return this.velocity.normalize();
	}
	
	public void advect(){
		this.position = this.position.add(this.velocity);
	}
	
	



}
