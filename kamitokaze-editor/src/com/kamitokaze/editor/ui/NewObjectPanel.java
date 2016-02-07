package com.kamitokaze.editor.ui;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.kamitokaze.editor.controller.NewObjectPanelController;
import com.kamitokaze.editor.model.ObjectCategory;

public class NewObjectPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private static int DEFAULT_WIDTH = 1000;
	private static int DEFAULT_HEIGHT = 300;
	
	private List<ObjectCategory> categories = new ArrayList<>();
	
	private NewObjectPanelController controller;
	
	public NewObjectPanel() {
		this.setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
		this.setMinimumSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
		TitledBorder title;
		title = BorderFactory.createTitledBorder(UIStrings.NEWOBJECTPANEL_TITLE);
		this.setBorder(title);
		
		addCategories();
	}

	private void addCategories() {
		
	}
}
