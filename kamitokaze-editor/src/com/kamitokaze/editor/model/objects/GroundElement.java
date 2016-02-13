package com.kamitokaze.editor.model.objects;

import java.nio.file.Path;
import java.util.Properties;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class GroundElement extends MapObject {
	private SpriteElement spriteElement;
	
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
		spriteElement.setOffsetx(objectNumber*(width + hgap));
		spriteElement.setOffsety(0);
		spriteElement.setSpritePath(path);
	}
	
}
