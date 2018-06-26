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
		if ( input.contains("UP") && ((SnakeGameModel) model).getWonLost() == 2 ) ((SnakeGameModel) model).start();
		if ( input.contains("LEFT") && ((SnakeGameModel) model).getWonLost() == 0 ) ((SnakeGameModel) model).goLeft();
		if ( input.contains("RIGHT") && ((SnakeGameModel) model).getWonLost() == 0 ) ((SnakeGameModel) model).goRight();
		if ( input.contains("DOWN") &&
				( ((SnakeGameModel) model).getWonLost() == -1 ||
				((SnakeGameModel) model).getWonLost() == 1 ) ) nextController( new SnakeGameController() );
	}
}
