package com.kamitokaze.editor.model;

public class Position {
	private int x = 0;
	private int y = 0;
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		if (x < 0) {
			x = 0;
		}
		
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		if (y < 0) {
			y = 0;
		}
		
		this.y = y;
	}
}
