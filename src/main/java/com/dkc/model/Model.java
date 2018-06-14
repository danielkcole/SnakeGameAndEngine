package com.dkc.model;

import java.util.ArrayList;
import java.util.List;

import com.dkc.view.Sprite;

public abstract class Model {
	Sprite background;
	protected ArrayList<Sprite> sprites = new ArrayList<>();
	
	public Model() { setBackground(); }
	
	public abstract void tick();
	public abstract void setBackground();
	public List<Sprite> getSprites() { return sprites; }
	public Sprite getBackground() { return background;} //TODO change to handle sprite map backgrounds with strategy maybe?
}
