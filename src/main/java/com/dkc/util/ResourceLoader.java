package com.dkc.util;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

/**
 * Static class for loading resources at run time.
 */
public class ResourceLoader
{
	private static final String IMAGERESOURCEFOLDER = "/SpriteSheets/";
	private static final String IMAGEFILEEXTENSION = ".png";

	/**
	 * Loads an a sprite to a JavaFX Image.
	 * @param fileName the name of the file that holds the sprite.
	 * @return JavaFX Image of the sprite.
	 * @throws IOException if image is not found.
	 */
	public static Image getImage(String fileName) throws IOException
	{
		Image image;
		InputStream is = ResourceLoader.class.getResourceAsStream(IMAGERESOURCEFOLDER + fileName + IMAGEFILEEXTENSION);
		BufferedImage bufferedimage = ImageIO.read(is);
        image = SwingFXUtils.toFXImage(bufferedimage, null);
		return image;
	}

	/**
	 * Returns a sub image of an image as a JavaFX Image.
	 * @param fileName the name of the file that holds the sprite.
	 * @param h height of the sprite in pixels.
	 * @param w width of the sprite in pixels.
	 * @param col which column of the sprite sheet the sprite appears on.
	 * @param row which row of the sprite sheet the sprite appears on.
	 * @return JavaFX Image of the sprite.
	 * @throws IOException if image is not found.
	 */
	public static Image getImage(String fileName, int h, int w, int col, int row) throws IOException
	{
		Image image;
		InputStream is = ResourceLoader.class.getResourceAsStream(IMAGERESOURCEFOLDER + fileName + IMAGEFILEEXTENSION);
		BufferedImage bufferedimage = ImageIO.read(is);
		bufferedimage = bufferedimage.getSubimage(w*col, h*row, w, h);
        image = SwingFXUtils.toFXImage(bufferedimage, null);
		return image;
	}
}
