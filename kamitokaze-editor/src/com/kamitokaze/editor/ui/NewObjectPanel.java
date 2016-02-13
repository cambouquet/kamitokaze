package com.kamitokaze.editor.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.kamitokaze.editor.controller.NewObjectPanelController;
import com.kamitokaze.editor.model.categories.Category;
import com.kamitokaze.editor.model.categories.ObjectCategory;

public class NewObjectPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private static int DEFAULT_WIDTH = 1000;
	private static int DEFAULT_HEIGHT = 300;
	
	private List<Category> categories = new ArrayList<>();
	
	private NewObjectPanelController controller;
	
	private JPanel objectPanel = new JPanel();
	
	public NewObjectPanel(NewObjectPanelController newObjectPanelController) {
		this.controller = newObjectPanelController;
		this.setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
		this.setMinimumSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
		TitledBorder title = BorderFactory.createTitledBorder(UIStrings.NEWOBJECTPANEL_TITLE);
		this.setBorder(title);
		this.setLayout(new BorderLayout());
		objectPanel.setLayout(new GridBagLayout());
		this.add(objectPanel, BorderLayout.CENTER);
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
		
		JPanel categoryPanel = new JPanel();
		categoryPanel.setLayout(new GridLayout(categories.size() / 2 + categories.size() % 2, 2));
		Iterator<Category> ite = categories.iterator();
		
		while(ite.hasNext()) {
			Category category = ite.next();
			JButton categoryButton = new JButton(category.getName());
			categoryButton.addActionListener(controller.new CategoryButtonListener(category));
			categoryPanel.add(categoryButton);
		}
		categoryPanel.setMaximumSize(new Dimension(200, DEFAULT_HEIGHT));
		repaint();
		this.add(categoryPanel, BorderLayout.WEST);
	}

	public void displayCategory(List<ObjectCategory> objectList) {
		objectPanel.removeAll();
		Iterator<ObjectCategory> ite = objectList.iterator();
		
		int objectNumber = 0;
		
		while(ite.hasNext()) {
			ObjectCategory object = ite.next();
			JButton objectButton = new JButton(object.getIcon());
			objectButton.setMaximumSize(new Dimension(40, 40));
			objectButton.setPreferredSize(new Dimension(40, 40));
			objectPanel.add(objectButton, getNextButtonPosition(objectNumber));
			objectNumber++;
		}

		revalidate();
		repaint();
	}
	
	private static GridBagConstraints getNextButtonPosition(int buttonNumber) {
		int columnNumber = buttonNumber / 3;
		int rowNumber = buttonNumber % 3;
		return new GridBagConstraints(columnNumber, rowNumber, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
	}
}
