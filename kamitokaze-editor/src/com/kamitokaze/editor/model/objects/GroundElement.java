package com.kamitokaze.editor.model.objects;

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
		return new ImageIcon("ground.png");
	}
	
}
