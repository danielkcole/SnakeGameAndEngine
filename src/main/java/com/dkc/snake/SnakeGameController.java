package com.dkc.snake;

import java.io.IOException;

import com.dkc.controller.Controller;;

public class SnakeGameController extends Controller {
	SnakeGameModel model;
	SnakeGameView view;
	
	public SnakeGameController() throws IOException
	{
		model = new SnakeGameModel();
		view = new SnakeGameView();
		//view.play();
	}
	
	public void tick() throws IOException 
	{
		model.tick(view.getInput());
	}

	public void render() 
	{
		view.render( model.getBackGround(), model.getSprites(), model.getScore() );
	}
}
