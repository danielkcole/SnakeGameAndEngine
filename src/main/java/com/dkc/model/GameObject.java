package com.dkc.model;

/**
 * Generic object to be extended with interfaces to generate functionality.
 */
public abstract class GameObject
{
	protected double x;
	protected double y;
	private double angle;

	/**
	 * @param newX new X cord
	 */
	public void setX(double newX) { x = newX; }

	/**
	 * @param newY new Y cord
	 */
	public void setY(double newY) { y = newY; }

	/**
	 * @return current X cord
	 */
	public double getX() { return x; }

	/**
	 * @return current X cord
	 */
	public double getY() { return y; }

	/**
	 * @param newAngle new angle
	 */
	public void setAngle( double newAngle )
	{
		while (newAngle > 360) newAngle -= 360;
		while (newAngle < 0) newAngle += 360;
		angle = newAngle;
	}

	/**
	 * @return current angle
	 */
	public double getAngle() { return angle; }
}
