package it.unical.it.igpe2017.arkanoid.core;

import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

public  class BoudingObjectRectangular extends Rectangle2D.Float implements IBoundingObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean collide(Shape other) {
		return BoudingObjectCollisionImpl.collide(this, other);
	}


}
