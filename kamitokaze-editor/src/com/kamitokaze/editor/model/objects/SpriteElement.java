package com.kamitokaze.editor.model.objects;

public class SpriteElement {
	private String spriteFileName;
	
	private int offsetx = 0;
	private int offsety = 0;
	
	private int width;
	private int height;
	
	public String getSpriteFileName() {
		return spriteFileName;
	}
	
	public void setSpriteFileName(String spriteFileName) {
		this.spriteFileName = spriteFileName;
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
}
