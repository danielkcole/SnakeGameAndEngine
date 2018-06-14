package com.dkc.snake;

import java.util.List;

import com.dkc.controller.Controller;
import com.dkc.model.Model;
import com.dkc.view.View;;

public class SnakeGameController extends Controller {

	@Override
	public void handleInput(List<String> input) {
		if ( input.contains("Left") ) ((SnakeGameModel) model).goLeft();
		if ( input.contains("Right") ) ((SnakeGameModel) model).goRight();
	}

	@Override
	public View setView() { return new SnakeGameView(); }

	@Override
	public Model setModel() { return new SnakeGameModel(); }
}
