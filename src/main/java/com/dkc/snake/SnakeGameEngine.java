package com.dkc.snake;

import java.io.IOException;

import com.dkc.model.GameEngine;

public class SnakeGameEngine extends GameEngine {
	
	public static void main(String[] args) throws IOException { play( new SnakeGameController() ); }
	
}
