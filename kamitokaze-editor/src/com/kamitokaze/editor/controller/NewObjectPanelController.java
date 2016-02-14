package com.kamitokaze.editor.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import com.kamitokaze.editor.controller.categories.CategoriesFactory;
import com.kamitokaze.editor.model.categories.Category;
import com.kamitokaze.editor.model.categories.ObjectCategory;
import com.kamitokaze.editor.ui.NewObjectPanel;

public class NewObjectPanelController {
	private NewObjectPanel view;
	
	private EditorController parent;
	
	private List<Category> categories = new ArrayList<>();
	
	private Category currentCategory = null;
	private ObjectCategory currentObjectCategory = null;
	
	public NewObjectPanelController(EditorController parentController) {
		this.parent = parentController;
		view = new NewObjectPanel(this);
		
		initCategories();
		view.setCategories(categories);
	}
	
	public NewObjectPanel getView() {
		return view;
	}
	
	private void initCategories() {
		categories = new CategoriesFactory().initCategories();
	}

	public void displayCategory(Category newCategory) {
		if (currentCategory == null || currentCategory != newCategory) {
			currentCategory = newCategory;
			view.displayCategory(newCategory.getObjectList());
		}
	}
	
	public void displayObjectsFromObjectCategory(ObjectCategory newObjectCategory) {
		if (currentObjectCategory == null || currentObjectCategory != newObjectCategory) {
			currentObjectCategory = newObjectCategory;
			view.displayObjectVariations(newObjectCategory.getObjects());
		}
	}
	
	public class CategoryButtonListener implements ActionListener {
		private Category category;
		
		public CategoryButtonListener(Category category) {
			this.category = category;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			displayCategory(category);
		}

	}
	
	public class ObjectCategoryButtonListener implements ActionListener {
		private ObjectCategory objectCategory;
		
		public ObjectCategoryButtonListener(ObjectCategory objectCategory) {
			this.objectCategory = objectCategory;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			displayObjectsFromObjectCategory(objectCategory);
		}

	}
}
