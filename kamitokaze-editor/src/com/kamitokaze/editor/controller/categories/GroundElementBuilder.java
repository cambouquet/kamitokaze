package com.kamitokaze.editor.controller.categories;

import java.awt.Image;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.imageio.ImageIO;

import com.kamitokaze.editor.model.objects.GroundElement;
import com.kamitokaze.editor.model.objects.MapObject;
import com.kamitokaze.editor.model.objects.SpriteElement;

public class GroundElementBuilder extends ObjectBuilder {
	
	int elementWidth;
	int elementHeight;
	int hgap;
	int vgap;

	@Override
	public List<MapObject> createFromConfig(Path path, Properties properties) throws IOException {
		List<MapObject> objectList = new ArrayList<>();
		Image image = ImageIO.read(path.toFile());
		int width = image.getWidth(null);
		int height = image.getHeight(null);
		
		elementWidth = Integer.valueOf(properties.getProperty(PropertiesTags.SPRITE_WIDTH));
		elementHeight = Integer.valueOf(properties.getProperty(PropertiesTags.SPRITE_HEIGHT));
		hgap = Integer.valueOf(properties.getProperty(PropertiesTags.SPRITE_HGAP));
		vgap = Integer.valueOf(properties.getProperty(PropertiesTags.SPRITE_VGAP));
		
		if (width < elementWidth || height < elementHeight) {
			return null;
		}
		
		int numberOfElements = width / elementWidth;
		int i = 0;
		while (i < numberOfElements) {
			GroundElement ground = new GroundElement();
			ground.setSpriteElement(createElement(path, i));
			objectList.add(ground);
			i++;
		}
		
		return objectList;
	}
	
	public SpriteElement createElement(Path path, int objectNumber) {
		SpriteElement spriteElement = new SpriteElement();
		
		spriteElement.setHeight(elementHeight);
		spriteElement.setWidth(elementWidth);
		spriteElement.setOffsetx(objectNumber*(elementWidth + hgap));
		spriteElement.setOffsety(0);
		spriteElement.setSpritePath(path);
		
		return spriteElement;
	}
	

}
