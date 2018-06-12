package com.dkc.snake;

import com.dkc.controller.Controller;
import com.dkc.controller.GameEngine;
import com.dkc.model.State;
import com.dkc.view.GameView;

public class SnakeGameEngine extends GameEngine {
	static final String WINDOWNAME = "Snake";
	static final GameView GAMEVIEW = new GameView(WINDOWNAME);
	static State currentState = new SnakeGameState();
	static Controller controller = new SnakeGameController((SnakeGameState) currentState);
	
	public static void main(String[] args)
	{
		while(currentState.keepRunning())
		{
			GAMEVIEW.render();
			currentState = controller.tick(GAMEVIEW.getInput());
		}
	}
}
