package com.dkc.controller;

import java.io.IOException;

public abstract class Controller {
	protected Controller nextController = this;
	protected boolean keepRunning = true;
	
	
	public Controller tickAndRender() throws IOException {
		tick();
		render();
		return nextController;
	}
	public abstract void tick() throws IOException;
	public abstract void render();
	public boolean keepRunning() { return keepRunning; }
}
