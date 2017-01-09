package it.unical.it.igpe2017.arkanoid.core;

import it.unical.it.igpe2017.arkanoid.core.utils.Vector2d;

import java.util.Iterator;
import java.util.List;


public abstract class AbstractStaticObject implements IStaticObject{

	protected Vector2d pos;
	protected List<IBoundingObject> boundingBoxes;
	
	@Override
	public Vector2d getPos() {
		return pos;		
	}
	
	@Override
	public boolean collide(IStaticObject other) {
		for (Iterator<IBoundingObject> iterator = boundingBoxes.iterator(); iterator.hasNext();) {
			IBoundingObject thisObj = (IBoundingObject)iterator.next();
			for (Iterator<IBoundingObject> iterator2 = boundingBoxes.iterator(); iterator2
					.hasNext();) {
				IBoundingObject otherObj = (IBoundingObject) iterator2.next();
				if(thisObj.collide(otherObj)) 
					return true;				
			}
		}
		return false;
	}
	
}
