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
	 * Returns true if the object is visible.
	 * @return true if the object is visible.
	 */
	boolean getVisible();
}
