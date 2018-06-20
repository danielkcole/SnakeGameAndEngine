package com.dkc.model;

import java.util.ArrayList;
import java.util.List;

import com.dkc.view.Sprite;

/**
 * Should hold all of the data associated with a game state.
 */
public abstract class Model
{
	private final Sprite background; //TODO be able to handle sprite maps. Use strategy pattern?
	protected final ArrayList<IDrawable> drawableObjects = new ArrayList<>();

	/**
	 * Calls extended method to set the background.
	 */
	protected Model() { background = setBackground(); }

	/**
	 * Called once per frame, should perform all logic.
	 */
	public abstract void tick();

	/**
	 * Returns sprite to be repeated as the background.
	 * @return sprite to be repeated as the background.
	 */
	protected abstract Sprite setBackground();

	/**
	 * Returns sprite to be repeated as the background.
	 * @return sprite to be repeated as the background.
	 */
	public Sprite getBackground() { return background;}

	/**
	 * Returns objects that can be drawn.
	 * @return list of objects that can be drawn.
	 */
	public List<IDrawable> getDrawableObjects() { return drawableObjects; }
}
