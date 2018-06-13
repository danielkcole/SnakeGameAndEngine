package com.dkc.model;

import java.io.IOException;

import com.dkc.controller.Controller;

public abstract class GameEngine {
	static Controller controller;
	
	protected static void play(Controller c) throws IOException 
	{
		controller = c;
		while(controller.keepRunning())
		{
			controller = controller.tickAndRender();
		}
	}
}
