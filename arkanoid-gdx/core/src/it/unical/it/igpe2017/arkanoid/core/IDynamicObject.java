package it.unical.it.igpe2017.arkanoid.core;

import it.unical.it.igpe2017.arkanoid.core.utils.Vector2d;

public interface IDynamicObject {

	Vector2d getVelocity();
	Vector2d getDirection();
	
	
	void update();
}
