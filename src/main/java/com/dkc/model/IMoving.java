package com.dkc.model;

/**
 * An object should implement IMoving if it moves.
 */
public interface IMoving
{
	/**
	 * Sets the direction the object is moving.
	 * @param newXDir The new change in X per frame.
	 * @param newYDir The new change in Y per frame.
	 */
	void setDir(double newXDir, double newYDir);

	/**
	 * Returns the change in X per frame.
	 * @return The change in X per frame.
	 */
	double getXDir();

	/**
	 * Returns the change in Y per frame.
	 * @return The change in Y per frame.
	 */
	double getYDir();

	/**
	 * Should usually be x += xDir, y -+= yDir,
	 * y is minus because position is drawn from top to bottom.
	 */
	void move(); //should change x and y cords based on direction
}
