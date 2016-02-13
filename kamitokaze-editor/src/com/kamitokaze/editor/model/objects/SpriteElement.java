package com.kamitokaze.editor.model.objects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class SpriteElement {
	private Path spritePath;
	
	private int offsetx = 0;
	private int offsety = 0;
	
	private int width;
	private int height;
	
	public Path getSpritePath() {
		return spritePath;
	}
	
	public void setSpritePath(Path spritePath) {
		this.spritePath = spritePath;
	}
	
	public int getOffsetx() {
		return offsetx;
	}
	
	public void setOffsetx(int offsetx) {
		this.offsetx = offsetx;
	}
	
	public int getOffsety() {
		return offsety;
	}
	
	public void setOffsety(int offsety) {
		this.offsety = offsety;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}

	public Icon getImage() {
		Image image;
		BufferedImage bfImage = null;
		try {
			image = ImageIO.read(spritePath.toFile());
		bfImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics g = bfImage.createGraphics();
		g.drawImage(image, 0, 0, null);
		g.dispose();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ImageIcon(bfImage);
	}
}
