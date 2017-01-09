package it.unical.it.igpe2017.arkanoid.core;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class BoundingObjectElliptic extends Ellipse2D.Float implements IBoundingObject{

	@Override
	public boolean collide(Shape other) {
		return BoudingObjectCollisionImpl.collide(this, other);
	}

	
}
