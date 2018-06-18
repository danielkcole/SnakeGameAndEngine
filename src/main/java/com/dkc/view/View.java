package com.dkc.view;

import java.util.List;

import com.dkc.model.Model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;

/**
 * Base class to be extended for each View to be associated with a game state, provides base functionality for drawing.
 */
public abstract class View
{
	protected GraphicsContext graphicsContext;
	protected double canvasHeight;
	protected double canvasWidth;
	protected Model model;
	protected Rotate rotate;

//	private void drawSprite(Sprite sprite)
//    {
//        if (sprite.getAngle() != 0)
//			  drawRotatedImage(graphicsContext, sprite.getImage(), sprite.getAngle(), sprite.getX(), sprite.getY());
//        else
//        	graphicsContext.drawImage(sprite.getImage(), sprite.getX(), sprite.getY());
//    }

	/**
	 * Draws a sprite at the given cords, corresponding to the top left corner of the image.
	 * @param sprite sprite to draw.
	 * @param x x cord.
	 * @param y y cord with 0 at the top.
	 */
	private void drawSprite(Sprite sprite, double x, double y)
	{
		graphicsContext.drawImage(sprite.getImage(), x, y);
	}

	/**
	 * Draws a sprite at the given cords, corresponding to the top left corner of the image, handles rotated sprites.
	 * @param sprite sprite to draw.
	 * @param x x cord.
	 * @param y y cord with 0 at the top.
	 * @param angle angle to be drawn at.
	 */
	private void drawSprite(Sprite sprite, double x, double y, double angle)
	{
		if (angle != 0)
			drawRotatedImage(sprite.getImage(), angle, x, y);
		else graphicsContext.drawImage(sprite.getImage(), x, y);
	}

	/**
	 * Handles rotated images
	 * @param image image to draw.
	 * @param angle angle of rotation around center.
	 * @param x x pos.
	 * @param y y pos.
	 */
	private void drawRotatedImage(Image image, double angle, double x, double y)
	{
		graphicsContext.save(); // saves the current state on stack, including the current transform
		rotate = new Rotate(angle);
		graphicsContext.setTransform(rotate.getMxx(), rotate.getMyx(), rotate.getMxy(), rotate.getMyy(),
				rotate.getTx(), rotate.getTy());
		graphicsContext.drawImage(image, x, y);
		graphicsContext.restore(); // back to original state (before rotation)
	}

//	private void drawSprite(Sprite sprite, double x, double y, double angle)
//    {
//        if (angle != 0)
//            drawRotatedImage(graphicsContext, sprite.getImage(), angle, x, y);
//        else graphicsContext.drawImage(sprite.getImage(), x, y);
//    }
//
//	private void drawRotatedImage(GraphicsContext gc, Image image, double angle, double tlpx, double tlpy)
//	{
//		gc.save(); // saves the current state on stack, including the current transform
//		rotate(gc, angle, tlpx + image.getWidth() / 2, tlpy + image.getHeight() / 2);
//		gc.drawImage(image, tlpx, tlpy);
//		gc.restore(); // back to original state (before rotation)
//	}
//
//	private void rotate(GraphicsContext gc, double angle, double px, double py)
//	{
//		Rotate r = new Rotate(angle, px, py);
//		gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
//	}
	
	protected void fillBackground(Sprite sprite)
	{
		  for ( double i = 0; i <= canvasWidth; i += sprite.getWidth() )
			  for ( double j = 0; j <= canvasHeight; j += sprite.getHeight() )
				  drawSprite(sprite, i, j);
	}
	
	protected void drawSprites(List<Sprite> sprites) {
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