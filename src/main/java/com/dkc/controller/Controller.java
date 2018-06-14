package com.dkc.controller;

import java.util.List;

import com.dkc.model.Model;
import com.dkc.view.InputHandler;
import com.dkc.view.View;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

public abstract class Controller extends AnimationTimer{
	protected View view;
	protected Model model;
	InputHandler inputHandler;
	
	public Controller()
	{
		view = setView();
		model = setModel();
		view.setModel(model);
	}
	
	public abstract void handleInput( List<String> input );
	public abstract View setView();
	public abstract Model setModel();
	
	@Override
	public void handle(long now) {
		handleInput(inputHandler.getInput());
		model.tick();
		view.render();
	}
	
	public void setNewController(Controller newController)
	{
		stop();
		newController.setInputHandler(inputHandler);
		newController.start();
	}

	public void setInputHandler(InputHandler ih) { inputHandler = ih; }
	public void setGraphicsContext(GraphicsContext gc, double h, double w) { view.setGraphicsContext(gc, h, w); }
}
