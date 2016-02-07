package com.kamitokaze.editor.ui;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.kamitokaze.editor.model.GameMap;

public class NewObjectPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private static int DEFAULT_WIDTH = 1000;
	private static int DEFAULT_HEIGHT = 300;
	
	private GameMap map;
	
	public NewObjectPanel() {
		this.setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
		this.setMinimumSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
		TitledBorder title;
		title = BorderFactory.createTitledBorder(UIStrings.NEWOBJECTPANEL_TITLE);
		this.setBorder(title);
	}
}
