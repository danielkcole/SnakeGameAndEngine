package com.dkc.view;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public abstract class View extends Application
{
	protected GraphicsContext graphicsContext;
	Group rootGroup;
	Scene scene; 
	Canvas canvas;
	ArrayList<String> input = new ArrayList<>();
	protected int windowHeight; 
	protected int windowWidth; 
	protected String windowName;
	
	public View(int wh, int ww, String wn) 
	{ 	
		windowHeight = wh;
		windowWidth = ww;
		windowName = wn;
	}
	
	public abstract void play();

	@Override
	public void start(Stage stage) 
	{
		stage.setTitle(windowName);
		rootGroup = new Group();
	    scene = new Scene(rootGroup);
	    canvas = new Canvas(windowWidth, windowHeight);
	    rootGroup.getChildren().add( canvas );
	    graphicsContext = canvas.getGraphicsContext2D();
	    stage.setScene(scene);
	    stage.show();
	}
	
	public void processInput()
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
	}
	
	void drawSprite(Sprite sprite) 
	  {
		  if (sprite.getDegree() != 0)
			  drawRotatedImage(graphicsContext, sprite.getImage(), sprite.getDegree(), sprite.getX(), sprite.getY());
		  else graphicsContext.drawImage(sprite.getImage(), sprite.getX(), sprite.getY());
	  }
	  
	private void drawRotatedImage(GraphicsContext gc, Image image, double angle, double tlpx, double tlpy)
	{
		gc.save(); // saves the current state on stack, including the current transform
		rotate(gc, angle, tlpx + image.getWidth() / 2, tlpy + image.getHeight() / 2);
		gc.drawImage(image, tlpx, tlpy);
		gc.restore(); // back to original state (before rotation)
	}
	  
	private void rotate(GraphicsContext gc, double angle, double px, double py) 
	{
		Rotate r = new Rotate(angle, px, py);
		gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
	}
	
	public void fillBackground(Sprite sprite)
	{
		  for ( double i = 0; i < windowWidth; i += sprite.getWidth() ) 
			  for ( double j = 0; j < windowHeight; j += sprite.getHeight() )
				  drawSprite(sprite);
	}
	
	private void fillBackground(List<Sprite> sprites)
	{
		for (Sprite sprite : sprites) drawSprite(sprite);
	}
	
	public void drawSprites(List<Sprite> sprites) {
		for (Sprite sprite : sprites) drawSprite(sprite);
	}
	
	public ArrayList<String> getInput() { return input; }
	
	public abstract void render();
}