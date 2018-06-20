package com.dkc.snake;

import java.util.List;

import com.dkc.controller.Controller;
import com.dkc.model.Model;
import com.dkc.view.View;

public class SnakeGameController extends Controller
{
	@Override
	public View setView() { return new SnakeGameView(); }
	@Override
	public Model setModel() { return new SnakeGameModel(); }
	@Override
	protected void tick(List<String> input)
	{
		if ( input.contains("LEFT") ) ((SnakeGameModel) model).goLeft();
		if ( input.contains("RIGHT") ) ((SnakeGameModel) model).goRight();
	}
}
