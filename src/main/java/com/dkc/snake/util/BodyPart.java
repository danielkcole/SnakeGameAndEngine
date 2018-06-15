package com.dkc.snake.util;

import com.dkc.model.IDrawable;

import java.io.IOException;

import com.dkc.model.GameObject;
import com.dkc.model.IMoving;
import com.dkc.view.Sprite;


public class BodyPart extends GameObject implements IDrawable, IMoving {
	double degree; double xDir; double yDir; Sprite sprite;
	final int SPRITEHEIGHT= 16; final int SPRITEWIDTH= 16;
	final int SPRITECOL = 0; final int SPRITEROW = 3;
	final String IMAGELOCATION = "Snake";
	
	public BodyPart(double newX, double newY)
	{
		x = newX; y = newY;
		xDir = 0; yDir = 0;
		try {
			sprite = new Sprite(IMAGELOCATION, SPRITEHEIGHT, SPRITEWIDTH, SPRITECOL, SPRITEROW);
		} catch (IOException e) {
			e.printStackTrace();
		}
		refreshSprite();
	}
	
	public BodyPart(double newX, double newY, double newXDir, double newYDir)
	{
		this(newX, newY); xDir = newXDir; yDir = newYDir;
	}
	
	public void setDegree( double newDegree ) { degree = newDegree; }
	public double getDegree() { return degree; }
	@Override
	public void move() { x -= xDir; y -= yDir; refreshSprite();}

	public void changeToHead()
	{
        try {
            sprite.setImage(IMAGELOCATION, SPRITEHEIGHT, SPRITEWIDTH, 0, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
