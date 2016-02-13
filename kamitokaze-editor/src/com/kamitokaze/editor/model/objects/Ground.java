package com.kamitokaze.editor.model.objects;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.swing.Icon;

import com.kamitokaze.editor.model.Position;

public class Ground extends MapObject {
	private Map<Position, GroundElement> groundElements = new HashMap<>();

	public Map<Position, GroundElement> getGroundElementList() {
		return groundElements;
	}

	public void addGroundElementList(Position position, GroundElement sprite) {
		this.groundElements.put(position, sprite);
	}
	
	public void removeGroundElement(GroundElement sprite) {
		this.groundElements.remove(sprite);
	}

	@Override
	public Icon getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createFromConfig(Path path, Properties properties, int objectNumber) {
		// TODO Auto-generated method stub
		
	}
}
