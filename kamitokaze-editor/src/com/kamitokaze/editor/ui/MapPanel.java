package com.kamitokaze.editor.ui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MapPanel extends JPanel {
	int width;
	int height;
	
	public MapPanel(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		// Dessine un rectangle noir englobant tout
		g.setColor(Color.DARK_GRAY);

		/*
		 * g.fillRect(0, 0, largeur * largeurCase, hauteur * hauteurCase);
		 */

		g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}
}
