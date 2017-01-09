package it.unical.it.igpe2017.arkanoid.core;

import it.unical.it.igpe2017.arkanoid.core.utils.Vector2d;



public interface IStaticObject {
	
	Vector2d getPos();
	boolean collide(IStaticObject other);

}
