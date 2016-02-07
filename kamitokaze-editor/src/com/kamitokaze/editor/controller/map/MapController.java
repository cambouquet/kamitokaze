package com.kamitokaze.editor.controller.map;

import com.kamitokaze.editor.model.GameMap;
import com.kamitokaze.editor.model.MapProperties;
import com.kamitokaze.editor.ui.MapPanel;

public class MapController {
	private MapPanel mapPanel;
	private GameMap map;
	
	public MapController(MapPanel view) {
		this.mapPanel = view;
	}
	
	public void createMap(MapProperties properties) {
		this.map = new GameMap(properties);
		mapPanel.updateMap(map);
	}
}
