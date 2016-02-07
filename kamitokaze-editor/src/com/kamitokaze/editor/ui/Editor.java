package com.kamitokaze.editor.ui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.kamitokaze.editor.controller.map.MapController;
import com.kamitokaze.editor.ui.menu.MenuBuilder;

public class Editor implements UIStrings {
	JFrame frame;
	JPanel container;
	MapPanel mapPanel;
	NewObjectPanel newObjectPanel;
	
	public Editor() {
		frame = new JFrame();
		initFrame();
		MapController mapController = new MapController(mapPanel);
		
		frame.setJMenuBar(new MenuBuilder().createMenu(mapController));
		
		frame.pack();
	}
	
	public void display(boolean display) {
		frame.setVisible(display);
	}

	private void initFrame() {
		frame.setTitle("KamiToKaze - Map Editor");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		container = new JPanel();
		container.setLayout(new GridBagLayout());
		
		frame.setContentPane(container);
		frame.setResizable(true);
		frame.setMinimumSize(new Dimension(150, 50));
		mapPanel = new MapPanel();
		newObjectPanel = new NewObjectPanel();
		container.add(mapPanel, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_END, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		container.add(newObjectPanel, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_END, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
	}
}
