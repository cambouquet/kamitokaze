package com.kamitokaze.editor.ui;

import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Editor {
	JFrame frame;
	JPanel container;
	
	public Editor() {
		frame = new JFrame();
		frame.setTitle("KamiToKaze - Map Editor");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		container = new JPanel();
		container.setLayout(new GridBagLayout());
		
		frame.setContentPane(container);
		frame.setResizable(true);
		frame.setMinimumSize(new Dimension(150, 50));
		
		frame.pack();
	}
	
	public void display(boolean display) {
		frame.setVisible(display);
	}
}