package com.kamitokaze.editor.controller.categories;

import java.util.ArrayList;
import java.util.List;

import com.kamitokaze.editor.model.categories.Category;
import com.kamitokaze.editor.model.categories.ObjectCategory;
import com.kamitokaze.editor.model.objects.GroundElement;
import com.kamitokaze.editor.model.objects.MapObject;

public class CategoriesFactory {
	public List<Category> initCategories() {
		List<Category> categories = new ArrayList<>();
		
		Category category = new Category("Ground");
		ObjectCategory objectCategory = new ObjectCategory();
		MapObject object = new GroundElement();
		objectCategory.addObjectVariation(object);
		
		category.add(objectCategory);
		categories.add(category);
		
		return categories;
	}
}


