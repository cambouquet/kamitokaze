package com.kamitokaze.editor.controller.categories;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Properties;

import com.kamitokaze.editor.model.objects.MapObject;

public abstract class ObjectBuilder {
	public abstract List<MapObject> createFromConfig(Path path, Properties properties) throws IOException;
}
