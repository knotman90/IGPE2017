package it.unical.it.igpe2017.arkanoid.core.player;

import it.unical.it.igpe2017.arkanoid.core.AbstractDynamicObject;
import it.unical.it.igpe2017.arkanoid.core.IBoundingObject;
import it.unical.it.igpe2017.arkanoid.core.utils.Vector2d;

import java.util.ArrayList;


public class PlayerBar extends AbstractDynamicObject{

	PlayerBar(final Vector2d initialPos, final Vector2d initialVelocity){
		boundingBoxes = new ArrayList<IBoundingObject>();
		pos=initialPos;
		velocity =initialVelocity;
		
	}
	@Override
	public void update() {
		
		
	}




}
