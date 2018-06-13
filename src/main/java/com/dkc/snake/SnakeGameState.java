package com.dkc.snake;

import java.io.IOException;

import com.dkc.engine.State;

public class SnakeGameState extends State {

	public SnakeGameState() throws IOException {
		currentModel = new SnakeGameModel(); 
		currentView = new SnakeGameView(); 
		currentController = new SnakeGameController((SnakeGameModel) currentModel);
	}

}
