package com.dkc.view;

import java.io.IOException;

import com.dkc.util.ResourceLoader;

import javafx.scene.image.Image;

public class Sprite {
	Image image; 
	double x; 
	double y; 
	double degree = 0; 
	double height; 
	double width;
	
	
	public Sprite(String imageName) throws IOException { setImage(imageName); }
	
	public Sprite(String imageLocation, double newDegree) throws IOException { this(imageLocation); degree = newDegree; }
	
	public Sprite(String imageLocation, double newX, double newY) throws IOException 
	{ 
		this(imageLocation); 
		x = newX; y = newY;
	}
	
	public Sprite(String imageLocation, double newX, double newY, double newDegree) throws IOException 
	{ 
		this(imageLocation, newX, newY); 
		degree = newDegree;
	}
	
	public Sprite(String imageLocation, int h, int w, int col, int row) throws IOException 
	{	
		setImage(imageLocation, h, w, col, row);
	}
	
	public Sprite(String imageLocation, int h, int w, int col, int row, double newDegree) throws IOException
	{	
		setImage(imageLocation, h, w, col, row);
		degree = newDegree;
	}
	
	public Sprite(String imageLocation, int h, int w, int col, int row, double newX, double newY) throws IOException
	{	
		setImage(imageLocation, h, w, col, row);
		x = newX; y = newY;
	}
	
	public Sprite(String imageLocation, int h, int w, int col, int row, double newX, double newY, double newDegree) throws IOException
	{	
		this(imageLocation, h, w, col, row, newX, newY);
		degree = newDegree;
	}

	public void setImage(String imageName) throws IOException
	{	
		image = ResourceLoader.getImage(imageName);
		height = image.getHeight(); width = image.getWidth();
	}
	
	public void setImage(String imageName, int h, int w, int col, int row) throws IOException
	{	
		image = ResourceLoader.getImage(imageName, h, w, col, row);
		height = h; width = w;
	}
	
	public Image getImage() { return image; }
	public void setDegree( double newDegree ) { degree = newDegree; }
	public void setPos(double newX, double newY) { x = newX; y = newY; }
	public double getX() { return x; }
	public double getY() { return y; }
	public double getDegree() { return degree; }
	public double getWidth() { return width; }
	public double getHeight() { return height; }
	
}
