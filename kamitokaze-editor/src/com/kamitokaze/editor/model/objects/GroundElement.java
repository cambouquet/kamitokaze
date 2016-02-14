package com.kamitokaze.editor.model.objects;

import javax.swing.Icon;

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
}
