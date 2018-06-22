package com.dkc.view;

import java.io.IOException;

import com.dkc.util.ResourceLoader;

import javafx.scene.image.Image;

public class Sprite {
	private Image image;
	private double height;
	private double width;


	/**
	 * Constructor for sprites where the sprite is the full file.
	 * @param imageName name of sprite's file.
	 * @throws IOException if file is not found.
	 */
	private Sprite(String imageName) throws IOException { setImage(imageName); }

	/**
	 * Constructor for a sprite within a sprite sheet.
	 * @param imageName name of sprite's file.
	 * @param h height in pixels of the sprite.
	 * @param w width in pixels of the sprite.
	 * @param col column of the sprite within the sprite sheet.
	 * @param row row of the sprite within the sprite sheet.
	 * @throws IOException if file is not found.
	 */
	public Sprite(String imageName, int h, int w, int col, int row) throws IOException
	{
		setImage(imageName, h, w, col, row);
	}

	/**
	 * Setter used for changes the image of the sprite.
	 * @param imageName name of sprite's file.
	 * @throws IOException if file is not found.
	 */
	public void setImage(String imageName) throws IOException
	{	
		image = ResourceLoader.getImage(imageName);
		height = image.getHeight(); width = image.getWidth();
	}

	/**
	 * Setter used for changes the image of the sprite.
	 * @param imageName name of sprite's file.
	 * @param h height in pixels of the sprite.
	 * @param w width in pixels of the sprite.
	 * @param col column of the sprite within the sprite sheet.
	 * @param row row of the sprite within the sprite sheet.
	 * @throws IOException if file is not found.
	 */
	public void setImage(String imageName, int h, int w, int col, int row) throws IOException
	{	
		image = ResourceLoader.getImage(imageName, h, w, col, row);
		height = h; width = w;
	}
	
	public Image getImage() { return image; }
	public double getWidth() { return width; }
	public double getHeight() { return height; }
}
