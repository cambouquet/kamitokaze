package com.kamitokaze.editor.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.kamitokaze.editor.controller.NewObjectPanelController;
import com.kamitokaze.editor.controller.NewObjectPanelController.CategoryButtonListener;
import com.kamitokaze.editor.model.categories.Category;
import com.kamitokaze.editor.model.categories.ObjectCategory;

public class NewObjectPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private static int DEFAULT_WIDTH = 1000;
	private static int DEFAULT_HEIGHT = 300;
	
	private List<Category> categories = new ArrayList<>();
	
	private NewObjectPanelController controller;
	
	public NewObjectPanel(NewObjectPanelController newObjectPanelController) {
		this.controller = newObjectPanelController;
		this.setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
		this.setMinimumSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
		TitledBorder title = BorderFactory.createTitledBorder(UIStrings.NEWOBJECTPANEL_TITLE);
		this.setBorder(title);
		this.setLayout(new BorderLayout());
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
		this.add(categoryPanel, BorderLayout.WEST);
		repaint();
	}

	public void displayCategory(List<ObjectCategory> objectList) {
		JPanel objectPanel = new JPanel();
		objectPanel.setLayout(new GridLayout(3, categories.size() / 3 + categories.size() % 3));
		Iterator<ObjectCategory> ite = objectList.iterator();
		
		while(ite.hasNext()) {
			ObjectCategory object = ite.next();
			objectPanel.add(new JButton(object.getIcon()));
		}

		this.add(objectPanel, BorderLayout.CENTER);
		revalidate();
		repaint();
	}
}
