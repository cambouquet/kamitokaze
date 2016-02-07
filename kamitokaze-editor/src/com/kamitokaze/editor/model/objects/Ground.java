package com.kamitokaze.editor.model.objects;

import java.util.HashMap;
import java.util.Map;

import com.kamitokaze.editor.model.Position;

public class Ground extends MapObject {
	private Map<Position, SpriteElement> groundElements = new HashMap<>();

	public Map<Position, SpriteElement> getGroundElementList() {
		return groundElements;
	}

	public void addGroundElementList(Position position, SpriteElement sprite) {
		this.groundElements.put(position, sprite);
	}
	
	public void removeGroundElement(SpriteElement sprite) {
		this.groundElements.remove(sprite);
	}
}
