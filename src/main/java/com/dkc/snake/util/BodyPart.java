package com.dkc.snake.util;

import com.dkc.model.IDrawable;
import com.dkc.model.GameObject;
import com.dkc.model.IMoving;
import com.dkc.model.Sprite;


public class BodyPart extends GameObject implements IDrawable, IMoving {
	double degree; double xDir; double yDir; Sprite sprite;
	final int SPRITEHEIGHT= 16; final int SPRITEWIDTH= 16;
	final int SPRITECOL = 0; final int SPRITEROW = 3;
	
	public BodyPart(double newX, double newY, String imageLocation)
	{
		x = newX; y = newY;
		xDir = 0; yDir = 0;
		sprite = new Sprite(imageLocation, SPRITEHEIGHT, SPRITEWIDTH, SPRITECOL, SPRITEROW);
		sprite.setDegree(degree); sprite.setPos(x, y);
	}
	
	public BodyPart(double newX, double newY, double newXDir, double newYDir, String imageLocation)
	{
		this(newX, newY, imageLocation); xDir = newXDir; yDir = newYDir;
	}

	@Override
	public void move() { x += xDir; y += yDir;}
	@Override
	public Sprite getSprite() { return sprite; }
	@Override
	public void setDir(double newXDir, double newYDir) { xDir = newXDir; yDir = newYDir; }
	@Override
	public double getXDir() { return xDir; }
	@Override
	public double getYDir() { return yDir; }
	@Override
	public void refreshSprite() { sprite.setPos(x, y); sprite.setDegree(degree);}
	
}
