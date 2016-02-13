package com.kamitokaze.editor.model.objects;

import java.nio.file.Path;
import java.util.Properties;

import javax.swing.Icon;

public class Door extends MapObject {
	private SpriteElement spriteElement = new SpriteElement();
	
	public SpriteElement getSpriteElement() {
		return spriteElement;
	}

	public void setSpriteElement(SpriteElement spriteElement) {
		this.spriteElement = spriteElement;
	}

	@Override
	public Icon getImage() {
		return spriteElement.getImage();
	}
	
	@Override
	public void createFromConfig(Path path, Properties properties, int objectNumber) {
		spriteElement = new SpriteElement();
		int width = Integer.valueOf(properties.getProperty(PropertiesTags.SPRITE_WIDTH));
		int height = Integer.valueOf(properties.getProperty(PropertiesTags.SPRITE_HEIGHT));
		int hgap = Integer.valueOf(properties.getProperty(PropertiesTags.SPRITE_HGAP));
		int vgap = Integer.valueOf(properties.getProperty(PropertiesTags.SPRITE_VGAP));
		
		spriteElement.setHeight(height);
		spriteElement.setWidth(width);
		spriteElement.setOffsetx(0);
		spriteElement.setOffsety(objectNumber*(height + vgap));
		spriteElement.setSpritePath(path);
	}
}
