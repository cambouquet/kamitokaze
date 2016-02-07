package com.kamitokaze.editor.ui;

import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.kamitokaze.editor.controller.map.MapController;

public class Editor implements UIStrings {
	JFrame frame;
	JPanel container;
	MapPanel mapPanel;
	
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
		mapPanel = new MapPanel(200, 400);
		frame.add(mapPanel);
	}
}
