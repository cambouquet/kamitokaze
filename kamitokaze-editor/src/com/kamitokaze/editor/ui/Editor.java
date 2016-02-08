package com.kamitokaze.editor.ui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import com.kamitokaze.editor.controller.EditorController;
import com.kamitokaze.editor.controller.map.MapController;
import com.kamitokaze.editor.ui.menu.MenuBuilder;

public class Editor implements UIStrings {
	JFrame frame;
	EditorController controller;
	JPanel container;
	MapPanel mapPanel;
	NewObjectPanel newObjectPanel;
	
	public Editor(EditorController mainController) {
		this.controller = mainController;
		
		frame = new JFrame();
		initFrame();
		
		frame.pack();
	}
	
	public void display(boolean display) {
		frame.pack();
		frame.setVisible(display);
	}

	private void initFrame() {
		frame.setTitle(UIStrings.EDITOR_TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		container = new JPanel();
		container.setLayout(new GridBagLayout());
		
		frame.setContentPane(container);
		frame.setResizable(true);
		frame.setMinimumSize(new Dimension(150, 50));
	}

	public void setMap(MapPanel mapView) {
		this.mapPanel = mapView;
		container.add(mapPanel, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_END, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
	}

	public void setNewObjectPanel(NewObjectPanel panel) {
		this.newObjectPanel = panel;
		container.add(newObjectPanel, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_END, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
	}
	
	public void setMenu(JMenuBar menuBar) {
		frame.setJMenuBar(menuBar);
	}
}
