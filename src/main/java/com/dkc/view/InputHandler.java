package com.dkc.view;

import java.util.ArrayList;
import java.util.List;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

public class InputHandler {
	ArrayList<String> input = new ArrayList<>();
	interface IEventHandler { public void handle(KeyEvent e); }
	
	public InputHandler(Scene scene)
	{
		
        scene.setOnKeyPressed 
        (
                new EventHandler<KeyEvent>()
                {
                    public void handle(KeyEvent e)
                    {
                        String code = e.getCode().toString();
                        if ( !input.contains(code) ) input.add( code );
                    }
                }
        );
     
        scene.setOnKeyReleased
        (
                new EventHandler<KeyEvent>()
                {
                    public void handle(KeyEvent e)
                    {
                        input.remove( e.getCode().toString() );
                    }
                }
        );
	}
	
	public List<String> getInput() { return input; }
}
