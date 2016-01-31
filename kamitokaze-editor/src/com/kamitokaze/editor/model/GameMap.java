package com.kamitokaze.editor.model;

public class GameMap {
	private MapProperties properties;
	
	public GameMap(MapProperties initialProperties) {
		this.properties = initialProperties;
	}
	
	public int getWidth() {
		return properties.getWidth();
	}
	
	public int getHeight() {
		return properties.getHeight();
	}
}
