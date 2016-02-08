package com.kamitokaze.editor.controller;

import com.kamitokaze.editor.ui.NewObjectPanel;

public class NewObjectPanelController {
	private NewObjectPanel view;
	
	private EditorController parent;
	
	public NewObjectPanelController(EditorController parentController) {
		this.parent = parentController;
		view = new NewObjectPanel(this);
	}
	
	public NewObjectPanel getView() {
		return view;
	}
	
}
