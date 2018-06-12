package com.dkc.util;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

public class ResourceLoader {
	
	public static Image getImage(String name) throws IOException
	{
		Image image;
		InputStream is = ResourceLoader.class.getResourceAsStream("/SpriteSheets/" + name + ".png");
		BufferedImage bufferedimage = ImageIO.read(is);
        image = SwingFXUtils.toFXImage(bufferedimage, null);
		return image;
	}
	
	public static Image getImage(String name, int h, int w, int col, int row) throws IOException
	{
		Image image;
		InputStream is = ResourceLoader.class.getResourceAsStream("/SpriteSheets/" + name + ".png");
		BufferedImage bufferedimage = ImageIO.read(is);
		bufferedimage = bufferedimage.getSubimage(w*col, h*row, w, h);
        image = SwingFXUtils.toFXImage(bufferedimage, null);
		return image;
	}
}
