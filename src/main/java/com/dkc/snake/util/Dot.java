package com.dkc.snake.util;

import com.dkc.model.IDrawable;
import com.dkc.view.Sprite;

import java.io.IOException;

import com.dkc.model.GameObject;

public class Dot extends GameObject implements IDrawable {
	private Sprite sprite;
	private boolean visible = true;

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
	}

	@Override
	public Sprite getSprite() { return sprite; }
	@Override
	public boolean getVisible() { return visible; }
	@Override
	public void setVisible(boolean v) { visible = v; }
}
