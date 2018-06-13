package com.dkc.controller;

import java.io.IOException;
import java.util.List;

import com.dkc.engine.State;

public abstract class Controller {
	protected boolean keepRunning = true;
	protected State nextState = null;
	
	
	public abstract State tick(List<String> input) throws IOException;
	public boolean keepRunning() { return keepRunning; }
}
