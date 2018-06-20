package com.dkc.model;

/**
 * Generic object to be extended with interfaces to generate functionality.
 */
public abstract class GameObject
{
	protected double x;
	protected double y;
	private double angle;
	//double[][] collisionBox = new double[4][2]; //holds 4 cords, bounds of the object

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

//	public void setCollisionBox(double[] p0, double[] p1, double[] p2, double[] p3)
//	{
//		collisionBox[0] = p0; collisionBox[1] = p1; collisionBox[2] = p2; collisionBox[3] = p3;
//	}
//	public double[][] getCollisionBox() { return collisionBox; }
}
