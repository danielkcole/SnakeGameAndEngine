package com.dkc.model;

import java.util.List;

public abstract class State {
	protected List<Sprite> sprites;
	protected boolean keepRunning = true;
	
	public List<Sprite> getSprites() {  return sprites; }
	public boolean keepRunning() { return keepRunning; }
	
	public abstract void tick();
}
