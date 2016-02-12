package com.kamitokaze.editor.model.objects;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class GroundElement extends MapObject {
	private SpriteElement spriteElement = new SpriteElement();
	
	public GroundElement() {
		spriteElement.setHeight(32);
		spriteElement.setWidth(32);
		spriteElement.setOffsetx(0);
		spriteElement.setOffsety(0);
		spriteElement.setSpriteFileName("ground.png");
	}

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
