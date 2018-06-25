package com.dkc.snake.util;

import com.dkc.model.IDrawable;

import java.io.IOException;

import com.dkc.model.GameObject;
import com.dkc.model.IMoving;
import com.dkc.view.Sprite;


public class BodyPart extends GameObject implements IDrawable, IMoving
{
	private final int SPRITEHEIGHT= 16;
	private final int SPRITEWIDTH= 16;
	int SPRITECOL = 0;
	int SPRITEROW = 3;
	private final String IMAGELOCATION = "Snake";
	private double xDir;
	private double yDir;
	private Sprite sprite;
	private boolean visible = true;
	
	private BodyPart(double newX, double newY)
	{
		x = newX; y = newY;
		xDir = 0; yDir = 0;
		try {
			sprite = new Sprite(IMAGELOCATION, SPRITEHEIGHT, SPRITEWIDTH, SPRITECOL, SPRITEROW);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public BodyPart(double newX, double newY, double newXDir, double newYDir)
	{
		this(newX, newY); xDir = newXDir; yDir = newYDir;
	}

	public void changeToHead()
	{
		try {
			sprite.setImage(IMAGELOCATION, SPRITEHEIGHT, SPRITEWIDTH, 0, 0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void changeToTail()
	{
		try {
			sprite.setImage(IMAGELOCATION, SPRITEHEIGHT, SPRITEWIDTH, 0, 1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void changeToBody()
	{
		try {
			sprite.setImage(IMAGELOCATION, SPRITEHEIGHT, SPRITEWIDTH, SPRITECOL, SPRITEROW);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void move() { x += xDir*2; y -= yDir*2;}
	@Override
	public Sprite getSprite() { return sprite; }
	@Override
	public boolean getVisible() { return visible; }
	@Override
	public void setVisible(boolean v) { visible = v; }
	@Override
	public void setDir(double newXDir, double newYDir) { xDir = newXDir; yDir = newYDir; }
	@Override
	public double getXDir() { return xDir; }
	@Override
	public double getYDir() { return yDir; }
}
