package com.dkc.snake.util;

import com.dkc.model.IDrawable;
import com.dkc.view.Sprite;

import java.io.IOException;

import com.dkc.model.GameObject;

public class Dot extends GameObject implements IDrawable {
	private Sprite sprite;

	public Dot(int newX, int newY)
	{
		x = newX; y = newY; 
		try {
			int SPRITEROW = 3;
			int SPRITECOL = 2;
			int SPRITEWIDTH = 16;
			int SPRITEHEIGHT = 16;
			String IMAGELOCATION = "Snake";
			sprite = new Sprite(IMAGELOCATION, SPRITEHEIGHT, SPRITEWIDTH, SPRITECOL, SPRITEROW); }
		catch (IOException e) { e.printStackTrace(); }
		sprite.setPos(x, y);
	}

	@Override
	public Sprite getSprite() { return sprite; }
	@Override
	public void refreshSprite() { sprite.setPos(x, y);}
}
