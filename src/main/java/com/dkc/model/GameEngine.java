package com.dkc.model;

import com.dkc.controller.Controller;
import com.dkc.view.InputHandler;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public abstract class GameEngine extends Application{
	Controller controller;
	protected GraphicsContext graphicsContext;
	Group rootGroup;
	Scene scene; 
	Canvas canvas;
	String windowTitle = "Set windowName ";
	int windowWidth;
	int windowHeight;
	InputHandler inputHandler;
	
	public void start(Stage stage) 
	{
		windowTitle = setWindowTitle();
		windowWidth = setWindowWidth();
		windowHeight = setWindowHeight();
		
		stage.setTitle(windowTitle);
		rootGroup = new Group();
	    scene = new Scene(rootGroup);
	    canvas = new Canvas(windowWidth, windowHeight);
	    rootGroup.getChildren().add( canvas );
	    graphicsContext = canvas.getGraphicsContext2D();
	    stage.setScene(scene);
        stage.setResizable(false);
        stage.sizeToScene();
	    stage.show();
	    
	    controller = setController();
	    inputHandler = new InputHandler(scene);
	    controller.setInputHandler(inputHandler);
	    controller.setGraphicsContext(graphicsContext, canvas.getHeight(), canvas.getWidth());
	    controller.start();
	}
	
	protected abstract String setWindowTitle();
	protected abstract int setWindowWidth();
	protected abstract int setWindowHeight();
	protected abstract Controller setController();
}
