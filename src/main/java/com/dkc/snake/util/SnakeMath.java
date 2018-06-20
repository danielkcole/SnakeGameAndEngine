package com.dkc.snake.util;

import com.dkc.model.GameObject;
import com.dkc.model.IDrawable;

public class SnakeMath {
	private SnakeMath() { throw new IllegalStateException("Utility class"); }
	
	public static double toAngle(double x, double y)
	{
		double angle = Math.toDegrees( Math.atan2(y, x) );
		if (angle < 0) angle += 360; if (angle > 360) angle -= 360;
		return angle;
	}
	
	public static double angleToXDir(double degree) { return Math.sin( Math.toRadians( degree ) ); }
	
	public static double angleToYDir(double degree) { return Math.cos( Math.toRadians( degree ) ); }

	public static double angleBetweenObjects(GameObject go1, GameObject go2) {
		double angle = Math.toDegrees(Math.atan2(0-go1.getY() - 0-go2.getY(), go1.getX() - go2.getX()));
		angle -= 90;
		while (angle < 0) angle += 360; while (angle >360) angle -= 360;
		return angle;
	}

	public double distanceBetweenObjects(IDrawable go1, IDrawable go2) {
		double go1CenterX = go1.getX() + go1.getSprite().getWidth()/2;
		double go1CenterY = go1.getY() + go1.getSprite().getHeight()/2;
		double go2CenterX = go2.getX() + go2.getSprite().getWidth()/2;
		double go2CenterY = go2.getY() + go2.getSprite().getHeight()/2;
		return (Math.hypot(go1CenterX-go2CenterX, go1CenterY-go2CenterY));
	}
}
