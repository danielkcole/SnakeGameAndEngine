package com.dkc.snake;

import java.io.IOException;

import com.dkc.engine.GameEngine;
import com.dkc.engine.State;

public class SnakeGameEngine extends GameEngine {
	static State state; static State nextState;
	
	public static void main(String[] args) throws IOException
	{
		state = new SnakeGameState();
		
		while(state.getModel().keepRunning())
		{
			nextState = state.getController().tick( state.getView().getInput() );
			if (nextState != null) state = nextState;
			state.getView().render();
		}
	}
}
