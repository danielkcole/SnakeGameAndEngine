package com.dkc.view;

import java.io.IOException;

import com.dkc.util.ResourceLoader;

import javafx.scene.image.Image;

public class Sprite {
	//TODO comments
	private Image image;
	private double height;
	private double width;
	
	
	@SuppressWarnings("unused")
	private Sprite(String imageName) throws IOException { setImage(imageName); }

	public Sprite(String imageLocation, int h, int w, int col, int row) throws IOException
	{
		setImage(imageLocation, h, w, col, row);
	}

	private void setImage(String imageName) throws IOException
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
	public double getWidth() { return width; }
	public double getHeight() { return height; }
}
