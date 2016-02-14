package com.kamitokaze.editor.model.categories;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;

import com.kamitokaze.editor.model.objects.MapObject;

public class ObjectCategory {
	private List<MapObject> objectVariations = new ArrayList<>();
	
	public void setObjectVariations(List<MapObject> newObjectVariationList) {
		objectVariations = newObjectVariationList;
	}
	
	public void addObjectVariation(MapObject newObjectVariation) {
		objectVariations.add(newObjectVariation);
	}

	public Icon getIcon() {
		return objectVariations.get(0).getImage();
	}
}
