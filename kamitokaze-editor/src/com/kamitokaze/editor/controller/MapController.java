package com.kamitokaze.editor.controller;

import com.kamitokaze.editor.model.GameMap;
import com.kamitokaze.editor.model.MapProperties;
import com.kamitokaze.editor.ui.MapPanel;

public class MapController {
	private MapPanel mapPanel;
	private GameMap map;
	
	public MapController(MapPanel theMapPanel) {
		this.mapPanel = theMapPanel;
	}
	
	public void createMap(MapProperties properties) {
		this.map = new GameMap(properties);
		mapPanel.updateMap(map);
	}
}
