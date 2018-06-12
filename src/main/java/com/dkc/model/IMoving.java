package com.dkc.model;

public interface IMoving {
	void setDir(double newXDir, double newYDir);
	double getXDir();
	double getYDir();
	void move(); //should change x and y cords based on direction
}
