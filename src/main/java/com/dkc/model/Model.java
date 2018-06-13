package com.dkc.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.dkc.view.Sprite;

public abstract class Model {
	protected List<Sprite> sprites = new ArrayList<Sprite>();
	protected boolean keepRunning = true;
	
	public List<Sprite> getSprites() {  return sprites; }
	public boolean keepRunning() { return keepRunning; }
	public abstract void tick(List<String> input) throws IOException;
}
