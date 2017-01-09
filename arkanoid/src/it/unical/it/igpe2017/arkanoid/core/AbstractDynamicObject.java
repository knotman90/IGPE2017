package it.unical.it.igpe2017.arkanoid.core;

import it.unical.it.igpe2017.arkanoid.core.utils.Vector2d;

public abstract class AbstractDynamicObject extends AbstractStaticObject implements IDynamicObject{

	protected Vector2d velocity;

	@Override
	public Vector2d getVelocity() {
		return this.velocity;
	}

	@Override
	public Vector2d getDirection() {
		return this.velocity.normalize();
	}



}
