package com.kamitokaze.editor.model.objects;

import java.nio.file.Path;
import java.util.Properties;

public interface InitalizableFromConfig {
	void createFromConfig(Path path, Properties properties, int objectNumber);
}
