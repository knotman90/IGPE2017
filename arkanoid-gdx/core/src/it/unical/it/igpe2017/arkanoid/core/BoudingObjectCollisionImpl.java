package it.unical.it.igpe2017.arkanoid.core;

import java.awt.Shape;
import java.awt.geom.Area;

public  class BoudingObjectCollisionImpl {

	
	public static boolean collide(Shape lhs, Shape rhs){
		Area a = new Area(lhs);
		a.intersect(new Area(rhs));
		return !a.isEmpty();		
	}

}
