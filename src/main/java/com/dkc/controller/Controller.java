package com.dkc.controller;

import java.util.List;

import com.dkc.model.State;

public abstract class Controller {
	protected boolean isRunning;
	protected State nextState;
	
	
	public abstract State tick(List<String> list);
	public boolean getIsRunning() { return isRunning; }
}
