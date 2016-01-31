package com.kamitokaze.editor.ui;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class Editor implements UIStrings {
	JFrame frame;
	JPanel container;
	
	public Editor() {
		frame = new JFrame();
		initFrame();
		frame.setJMenuBar(MenuBuilder.createMenu());
		
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
		
		frame.add(new MapPanel(200, 400));
	}
}
