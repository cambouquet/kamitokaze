package com.kamitokaze.editor.controller;

import com.kamitokaze.editor.controller.map.MapController;
import com.kamitokaze.editor.controller.map.NewMapListener;
import com.kamitokaze.editor.ui.Editor;
import com.kamitokaze.editor.ui.menu.MenuBuilder;

public class EditorController {
	private Editor editorView;
	
	private MapController mapController;
	private NewObjectPanelController newObjectController;
	
	public EditorController() {
		editorView = new Editor(this);
		
		mapController = new MapController(this);
		editorView.setMap(mapController.getMapView());
		
		newObjectController = new NewObjectPanelController(this);
		editorView.setNewObjectPanel(newObjectController.getView());
		
		editorView.setMenu(new MenuBuilder().createMenu(new NewMapListener(mapController)));
		
		editorView.display(true);
	}
}
