package it.unical.it.igpe2017.arkanoid.core;

import java.awt.Shape;

public interface IBoundingObject extends Shape{

	boolean collide(Shape other);
}
