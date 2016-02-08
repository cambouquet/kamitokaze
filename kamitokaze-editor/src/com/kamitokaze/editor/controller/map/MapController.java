package com.kamitokaze.editor.controller.map;

import com.kamitokaze.editor.controller.EditorController;
import com.kamitokaze.editor.model.GameMap;
import com.kamitokaze.editor.model.MapProperties;
import com.kamitokaze.editor.ui.MapPanel;

public class MapController {
	private MapPanel mapPanel;
	private GameMap map;
	
	private EditorController parentController;
	
	public MapController(EditorController parent) {
		this.parentController = parent;
		this.mapPanel = new MapPanel(this);
	}
	
	public void createMap(MapProperties properties) {
		this.map = new GameMap(properties);
		mapPanel.updateMap(map);
	}

	public MapPanel getMapView() {
		return mapPanel;
	}
}
