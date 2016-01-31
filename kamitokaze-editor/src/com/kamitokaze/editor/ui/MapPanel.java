package com.kamitokaze.editor.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.kamitokaze.editor.model.GameMap;

public class MapPanel extends JPanel {
	private int width;
	private int height;
	
	private GameMap map;
	
	public MapPanel(int width, int height) {
		this.width = width;
		this.height = height;
		this.setPreferredSize(new Dimension(width, height));
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		// Dessine un rectangle noir englobant tout
		g.setColor(Color.BLACK);

		/*
		 * g.fillRect(0, 0, largeur * largeurCase, hauteur * hauteurCase);
		 */

		g.fillRect(0, 0, this.width, this.height);
		if (this.map != null) {
			g.setColor(Color.GRAY);
			g.fillRect(0, 0, this.map.getWidth(), this.map.getHeight());
		}
	}
	
	public void updateMap(GameMap newMap) {
		this.map = newMap;
		repaint();
	}
}
