package com.dkc.model;

import com.dkc.view.Sprite;

/**
 * An object should implement IDrawable if it has a sprite associated with it.
 */
public interface IDrawable
{
	/**
	 * Returns sprite associated with an game object.
	 * @return sprite associated with the game object.
	 */
	Sprite getSprite();

	/**
	 * Should return true if the object is visible.
	 * @return true if the object is visible.
	 */
	boolean getVisible();

	/**
	 * @param v true if object should be drawn
	 */
	void setVisible(boolean v);

	/**
	 * @return current X cord
	 */
	double getX();

	/**
	 * @return current X cord
	 */
	double getY();

	/**
	 * @return current angle
	 */
	double getAngle();

	/**
	 * @param newX new X cord
	 */
	void setX( double newX );

	/**
	 * @param newY new Y cord
	 */
	void setY( double newY );

	/**
	 * @param newAngle new angle
	 */
	void setAngle( double newAngle );
}
