package com.dkc.view;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public class View extends Application
{
	GraphicsContext graphicsContext;
	ArrayList<String> input = new ArrayList<>();
	String windowName; Group rootGroup; Scene scene; Canvas canvas;
	
	public View() {
		launch();
	}

	@Override
	public void start(Stage stage) 
	{
	    stage.setTitle( windowName );
	    
	    rootGroup = new Group();
        scene = new Scene( rootGroup );
        stage.setScene( scene );
        
	    canvas = new Canvas( 512, 512 );
	    rootGroup.getChildren().add( canvas );
        
	    graphicsContext = canvas.getGraphicsContext2D();
	    stage.show();
	}
	
	public List<String> processInput()
	{
        scene.setOnKeyPressed(
                new EventHandler<KeyEvent>()
                {
                    public void handle(KeyEvent e)
                    {
                        String code = e.getCode().toString();
     
                        if ( !input.contains(code) )
                            input.add( code );
                    }
                });
     
        scene.setOnKeyReleased(
            new EventHandler<KeyEvent>()
            {
                public void handle(KeyEvent e)
                {
                    String code = e.getCode().toString();
                    input.remove( code );
                }
            });
        return input;
	}
	
	
	public void render()
	{
		//do work
		//processInput();
	}
	
	public ArrayList<String> getInput() { return input; }
}