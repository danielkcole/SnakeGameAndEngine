package com.dkc.controller;

import java.util.List;

import com.dkc.model.Model;
import com.dkc.view.InputHandler;
import com.dkc.view.View;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

/**
 * Controller is the abstract class responsible for the game loop and handling input.
 * setView and setModel should return the model and view that are too be associated with
 * this controller.
 */
public abstract class Controller extends AnimationTimer
{
	private final View view;
	protected final Model model;
	private InputHandler inputHandler;

	/**
	 * Calls the extended methods in order to initiate the Controller.
	 */
	protected Controller()
	{
		view = setView();
		model = setModel();
		view.setModel(model);
	}

	/**
	 * Should return View to be associated with this controller.
	 * @return View to be associated with this controller.
	 */
	protected abstract View setView();

	/**
	 * Should return Model to be associated with this controller.
	 * @return Model to be associated with this controller.
	 */
	protected abstract Model setModel();

	/**
	 * Should call methods in the Model to handle the input and hold the logic to determine if there is a controller
	 * change, do nothing to continue with the same controller,
	 * to switch controllers instantiate the next controller and pass it to nextController().
	 * @param input holds all of the keys pressed for this frame like "LEFT".
	 */
	protected abstract void tick(List<String> input);

	/**
	 * Calls Controller tick then gets input and calls handleInput on it,
	 * then calls the Model tick and finally renders to the current View.
	 * @param now current time for position extrapolation.
	 */
	@Override
	public void handle(long now)
	{
		tick(inputHandler.getInput());
		if ( inputHandler.getInput().contains("UP") )
		{
			model.tick();
			view.preRender();
			view.render();
		}
	}

	/**
	 * Stops current game loop and passes the input handler down to the next Controller, then starts it.
	 * @param newController the controller to switch to
	 */
	@SuppressWarnings("unused")
	public void nextController(Controller newController)
	{
		//TODO create a controller stack in order to return to previous states
		stop();
		newController.setInputHandler(inputHandler);
		newController.start();
	}

	/**
	 * Used for setting a new controller.
	 * @param ih cuurent InputHandler
	 */
	public void setInputHandler(InputHandler ih) { inputHandler = ih; }

	/**
	 * Used for setting a new controller.
	 * @param gc current GraphicsContext
	 * @param h height of GraphicsContext
	 * @param w width of GraphicsContext
	 */
	public void setGraphicsContext(GraphicsContext gc, double h, double w) { view.setGraphicsContext(gc, h, w); }
}
