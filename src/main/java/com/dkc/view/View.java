package com.dkc.view;

import com.dkc.model.IDrawable;
import com.dkc.model.Model;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;

import java.util.List;

/**
 * Base class to be extended for each View to be associated with a game state, provides base functionality for drawing.
 */
public abstract class View
{
	protected GraphicsContext graphicsContext;
	private double canvasHeight;
	private double canvasWidth;
	protected Model model;
	private List<IDrawable> drawableObjects;

	/**
	 * Draws a sprite at the given cords, corresponding to the top left corner of the image.
	 * @param sprite sprite to draw.
	 * @param x x cord.
	 * @param y y cord with 0 at the top.
	 */
	private void drawSprite(Sprite sprite, double x, double y) { graphicsContext.drawImage(sprite.getImage(), x, y); }

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
	 * Draws an image on a graphics context.
	 *
	 * The image is drawn at (tlpx, tlpy) rotated by angle pivoted around the point:
	 *   (tlpx + image.getWidth() / 2, tlpy + image.getHeight() / 2)
	 *
	 * @param angle the angle of rotation.
	 * @param tlpx the top left x co-ordinate where the image will be plotted (in canvas co-ordinates).
	 * @param tlpy the top left y co-ordinate where the image will be plotted (in canvas co-ordinates).
	 */
	private void drawRotatedImage(Image image, double angle, double tlpx, double tlpy)
	{
		graphicsContext.save(); // saves the current state on stack, including the current transform
		rotate(angle, tlpx + image.getWidth() / 2, tlpy + image.getHeight() / 2);
		graphicsContext.drawImage(image, tlpx, tlpy);
		graphicsContext.restore(); // back to original state (before rotation)
	}

	/**
	 * Sets the transform for the GraphicsContext to rotate around a pivot point.
	 *
	 * @param angle the angle of rotation.
	 * @param px the x pivot co-ordinate for the rotation (in canvas co-ordinates).
	 * @param py the y pivot co-ordinate for the rotation (in canvas co-ordinates).
	 */
	private void rotate(double angle, double px, double py)
	{
		Rotate r = new Rotate(angle, px, py);
		graphicsContext.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
	}

	/**
	 * Fills the background of the canvas with a single sprite repeated.
	 * @param sprite sprite to be repeated for the background.
	 */
	private void fillBackground(Sprite sprite)
	{
		  for ( double i = 0; i <= canvasWidth; i += sprite.getWidth() )
			  for ( double j = 0; j <= canvasHeight; j += sprite.getHeight() )
				  drawSprite(sprite, i, j);
	}

	/**
	 * Used for setting a new controller/state.
	 * @param gc new GraphicsContext.
	 * @param h height of the canvas in the new GraphicsContext.
	 * @param w width of the canvas in the new GraphicsContext.
	 */
	public void setGraphicsContext(GraphicsContext gc, double h, double w)
	{ 
		graphicsContext = gc;
		canvasHeight = h;
		canvasWidth = w;
	}

	/**
	 * Sets the model associated with this view to be used by render().
	 * @param m new model to be set.
	 */
	public void setModel(Model m)
	{
		model = m;
		drawableObjects = model.getDrawableObjects();
	}

	/**
	 * Should handle rendering anything except game objects.
	 */
	public abstract void render();

	/**
	 *  Handles drawing game objects.
	 */
	public void preRender()
	{
		graphicsContext.clearRect(0, 0, canvasHeight, canvasWidth);
		fillBackground( model.getBackground() );
		for (IDrawable go : drawableObjects)
			if ( go.getVisible() )
				drawSprite(go.getSprite(), go.getX(), go.getY(), go.getAngle());
	}
}