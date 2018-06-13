package com.dkc.snake.util;

import com.dkc.model.IDrawable;

import java.io.IOException;

import com.dkc.model.GameObject;
import com.dkc.model.Sprite;

public class Dot extends GameObject implements IDrawable {
	Sprite sprite; final String IMAGELOCATION = "Snake";
	final int SPRITEHEIGHT= 16; final int SPRITEWIDTH= 16;
	final int SPRITECOL = 2; final int SPRITEROW = 3;
	
	public Dot(int newX, int newY) throws IOException
	{
		x = newX; y = newY; 
		sprite = new Sprite(IMAGELOCATION, SPRITEHEIGHT, SPRITEWIDTH, SPRITECOL, SPRITEROW);
		sprite.setPos(x, y);
	}

	@Override
	public Sprite getSprite() { return sprite; }
	@Override
	public void refreshSprite() { sprite.setPos(x, y);}
}
