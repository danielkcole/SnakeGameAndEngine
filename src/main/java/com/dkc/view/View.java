package com.dkc.view;

import java.util.List;

import com.dkc.model.Model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;

public abstract class View
{
	protected GraphicsContext graphicsContext;
	protected double canvasHeight;
	protected double canvasWidth;
	protected Model model;
	
	void drawSprite(Sprite sprite) 
    {
        if (sprite.getDegree() != 0)
			  drawRotatedImage(graphicsContext, sprite.getImage(), sprite.getDegree(), sprite.getX(), sprite.getY());
        else graphicsContext.drawImage(sprite.getImage(), sprite.getX(), sprite.getY());
    }

    void drawSprite(Sprite sprite, double x, double y)
    {
        if (sprite.getDegree() != 0)
            drawRotatedImage(graphicsContext, sprite.getImage(), sprite.getDegree(), x, y);
        else graphicsContext.drawImage(sprite.getImage(), x, y);
    }
	  
	void drawRotatedImage(GraphicsContext gc, Image image, double angle, double tlpx, double tlpy)
	{
		gc.save(); // saves the current state on stack, including the current transform
		rotate(gc, angle, tlpx + image.getWidth() / 2, tlpy + image.getHeight() / 2);
		gc.drawImage(image, tlpx, tlpy);
		gc.restore(); // back to original state (before rotation)
	}
	  
	void rotate(GraphicsContext gc, double angle, double px, double py) 
	{
		Rotate r = new Rotate(angle, px, py);
		gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
	}
	
	protected void fillBackground(Sprite sprite)
	{
		  for ( double i = 0; i <= canvasWidth; i += sprite.getWidth() )
			  for ( double j = 0; j <= canvasHeight; j += sprite.getHeight() )
				  drawSprite(sprite, i, j);
	}
	
	public void drawSprites(List<Sprite> sprites) {
		for (Sprite sprite : sprites) drawSprite(sprite);
	}
	
	public void setGraphicsContext(GraphicsContext gc, double h, double w)
	{ 
		graphicsContext = gc;
		canvasHeight = h;
		canvasWidth = w;
	}
	
	public void setModel(Model tdm) { model = tdm; }

	public abstract void render();
}