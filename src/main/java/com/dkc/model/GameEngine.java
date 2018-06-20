package com.dkc.model;

import com.dkc.controller.Controller;
import com.dkc.view.InputHandler;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

/**
 * Should be extended to create the entry point for your game, children are encouraged to implement main as the line
 * "launch(args);".
 */
@SuppressWarnings("SameReturnValue")
public abstract class GameEngine extends Application
{
	public void start(Stage stage) 
	{
		String windowTitle = setWindowTitle();
		int windowWidth = setWindowWidth();
		int windowHeight = setWindowHeight();
		
		stage.setTitle(windowTitle);
		Group rootGroup = new Group();
		Scene scene = new Scene(rootGroup);
		Canvas canvas = new Canvas(windowWidth, windowHeight);
	    rootGroup.getChildren().add(canvas);
		GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
	    stage.setScene(scene);
        stage.setResizable(false);
        stage.sizeToScene();
	    stage.show();

		Controller controller = setController();
		InputHandler inputHandler = new InputHandler(scene);
	    controller.setInputHandler(inputHandler);
	    controller.setGraphicsContext(graphicsContext, canvas.getHeight(), canvas.getWidth());
	    controller.start();
	}

	/**
	 * Should return the title for the game window.
	 * @return The title for the game window.
	 */
	protected abstract String setWindowTitle();

	/**
	 * Should return the width for the game window.
	 * @return The width for the game window.
	 */
	protected abstract int setWindowWidth();

	/**
	 * Should return the height for the game window.
	 * @return The height for the game window.
	 */
	protected abstract int setWindowHeight();

	/**
	 * Should return the Controller to handle the entry point for the game, like the main menu.
	 * @return The initial controller for the game.
	 */
	protected abstract Controller setController();
}
