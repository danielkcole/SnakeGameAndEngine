package com.dkc.model;

public abstract class GameObject {
	protected double x; protected double y; protected double degree = 0; 
	double[][] collisionBox = new double[4][2]; //holds 4 cords, bounds of the object
	
	public void setX(double newX) { x = newX; }
	public void setY(double newY) { y = newY; }
	public void setCollisionBox(double[] p0, double[] p1, double[] p2, double[] p3) 
	{ 
		collisionBox[0] = p0; collisionBox[1] = p1; collisionBox[2] = p2; collisionBox[3] = p3;
	}
	public double[][] getCollisionBox() { return collisionBox; }
	public double getX() { return x; }
	public double getY() { return y; }

}
