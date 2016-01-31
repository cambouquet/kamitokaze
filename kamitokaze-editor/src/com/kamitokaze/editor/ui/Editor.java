package com.kamitokaze.editor.ui;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Editor {
	JFrame frame;
	JPanel container;
	JMenuBar menuBar;
	
	public Editor() {
		frame = new JFrame();
		initFrame();
		addMenu();
		
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

	private void addMenu() {
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);
		menuFile.setMnemonic('F');
		
		JMenuItem menuItemQuit = new JMenuItem("Quit");
		menuItemQuit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				System.exit(0);
			}
		});
		menuItemQuit.setMnemonic('Q');
		menuFile.add(menuItemQuit);
		
	}
}
