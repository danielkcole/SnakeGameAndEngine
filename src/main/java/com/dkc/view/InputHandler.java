package com.dkc.view;

import java.util.ArrayList;
import java.util.List;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

/**
 * Associates with a view in order to handle input, currently only keyboard inputs.
 */
public class InputHandler
{
	private final ArrayList<String> input = new ArrayList<>();

	/**
	 * Attaches the InputHandler to the given scene.
	 * @param scene scene to attach to
	 */
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

	/**
	 * Returns the input for the frame.
	 * @return input on given frame, like "LEFT".
	 */
	public List<String> getInput() { return input; }
}