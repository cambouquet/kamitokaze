package com.kamitokaze.editor.model.objects;

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
}
