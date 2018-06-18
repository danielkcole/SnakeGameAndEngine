package com.dkc.snake.util;

public class SnakeMath {
	private SnakeMath() { throw new IllegalStateException("Utility class"); }
	
	public static double toAngle(double x, double y) { return Math.toDegrees( Math.atan2(y, x) ); }
	
	public static double angleToXDir(double degree) { return Math.sin( Math.toRadians( degree ) ); }
	
	public static double angleToYDir(double degree) { return Math.cos( Math.toRadians( degree ) ); }
}
