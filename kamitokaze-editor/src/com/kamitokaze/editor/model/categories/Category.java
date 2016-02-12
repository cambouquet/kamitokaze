package com.kamitokaze.editor.model.categories;

import java.util.ArrayList;
import java.util.List;

public class Category {
	private String name;
	
	private List<ObjectCategory> objects = new ArrayList<>();
	
	public Category(String name) {
		this.name = name;
	}

	public void add(ObjectCategory object) {
		objects.add(object);
	}

	public String getName() {
		return name;
	}
	
	public List<ObjectCategory> getObjectList() {
		return objects;
	}
}
