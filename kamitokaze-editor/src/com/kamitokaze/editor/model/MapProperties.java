package com.kamitokaze.editor.model;

public class MapProperties {
	private int width;

	private int height;

	private int levelMax;
	
	private int playerLevel;

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

	public int getLevelMax() {
		return levelMax;
	}

	public void setLevelMax(int levelMax) {
		this.levelMax = levelMax;
	}
	
	public int getPlayerLevel() {
		return playerLevel;
	}

	public void setPlayerLevel(int playerLevel) {
		this.playerLevel = playerLevel;
	}
}
