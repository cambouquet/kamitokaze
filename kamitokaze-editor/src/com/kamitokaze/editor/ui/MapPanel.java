package com.kamitokaze.editor.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.kamitokaze.editor.model.GameMap;

public class MapPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private static int DEFAULT_WIDTH = 1000;
	private static int DEFAULT_HEIGHT = 600;
	
	private GameMap map;
	
	public MapPanel() {
		this.setMinimumSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
		this.setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
		this.setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.DEFAULT_WIDTH, this.DEFAULT_HEIGHT);
	}
	
	public void updateMap(GameMap newMap) {
		this.map = newMap;
		repaint();
	}
}
