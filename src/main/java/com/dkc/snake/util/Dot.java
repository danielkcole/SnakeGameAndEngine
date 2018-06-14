package com.dkc.snake.util;

import com.dkc.model.IDrawable;
import com.dkc.view.Sprite;

import java.io.IOException;

import com.dkc.model.GameObject;

public class Dot extends GameObject implements IDrawable {
	Sprite sprite; final String IMAGELOCATION = "Snake";
	final int SPRITEHEIGHT= 16; final int SPRITEWIDTH= 16;
	final int SPRITECOL = 2; final int SPRITEROW = 3;
	
	public Dot(int newX, int newY)
	{
		x = newX; y = newY; 
		try { sprite = new Sprite(IMAGELOCATION, SPRITEHEIGHT, SPRITEWIDTH, SPRITECOL, SPRITEROW); }
		catch (IOException e) { e.printStackTrace(); }
		sprite.setPos(x, y);
	}

	@Override
	public Sprite getSprite() { return sprite; }
	@Override
	public void refreshSprite() { sprite.setPos(x, y);}
}
