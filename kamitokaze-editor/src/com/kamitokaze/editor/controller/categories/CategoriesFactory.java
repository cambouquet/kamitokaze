package com.kamitokaze.editor.controller.categories;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kamitokaze.editor.model.categories.Category;
import com.kamitokaze.editor.model.categories.ObjectCategory;
import com.kamitokaze.editor.model.objects.MapObject;

public class CategoriesFactory {
	private static final String CONFIG_FILE = "object_config";
	private static final String PROPERTY_CLASS_NAME = "className";
	private static final String SPRITE_EXTENSION = ".png";
	
	private static final String OBJECTS_PATH = "resources/objects";
	
	private static final String OBJECTS_PACKAGE_PATH = "com.kamitokaze.editor.controller.categories";

	public List<Category> initCategories() {
		List<Category> categories = new ArrayList<>();
		
		Path objectsRootPath = Paths.get(OBJECTS_PATH);
		List<Path> categoryPaths = getPathsFromPath(objectsRootPath, null);
		for(Path path: categoryPaths) {
			categories.add(initCategory(path));
		}

		return categories;
	}

	private Category initCategory(Path path) {
		String categoryName = path.getFileName().toString();
		Category category = new Category(categoryName);
		
		File config = new File(path.toString() + "/" + CONFIG_FILE + ".properties");
		Properties properties = readProperties(config);
		
		String className = properties.getProperty(PROPERTY_CLASS_NAME);
		
		List<Path> paths = getPathsFromPath(path, SPRITE_EXTENSION);
		int objectNumber = 0;
		for (Path spritePath: paths) {
			ObjectCategory objectCategory = new ObjectCategory();
			Class<?> clazz;
			try {
				clazz = Class.forName(OBJECTS_PACKAGE_PATH + "." + className + "Builder");
				Constructor<?> ctor = clazz.getConstructor();
				ObjectBuilder objectBuilder = (ObjectBuilder) ctor.newInstance();
				List<MapObject> mapObjectList = objectBuilder.createFromConfig(spritePath, properties);
				
				objectCategory.setObjectVariations(mapObjectList);
				category.add(objectCategory);
				
			} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | IOException e) {
				System.err.println("Error when trying to create object for class " + className + ". Error: " + e.getMessage());
			}
			objectNumber++;
		}
		
		return category;
	}
	
	private List<Path> getPathsFromPath(Path directory, String extensionFilter) {
		List<Path> spritePaths = new ArrayList<>();
		PathMatcher pathMatcher = null;
		if (extensionFilter != null) {
			pathMatcher = FileSystems.getDefault().getPathMatcher("glob:**" + extensionFilter);
		}
		try(DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directory)) {
			for (Path path: directoryStream) {
				if (pathMatcher == null || pathMatcher.matches(path)) {
					spritePaths.add(path);
				}
			}
		} catch(IOException e) {
			System.err.println("IO error when trying to get files from " + directory + ". Error: " + e.getMessage());
		}
		
		return spritePaths;
	}

	private static Properties readProperties(File file) {
		FileReader fr;
		Properties prop = new Properties();

		try {
			fr = new FileReader(file);

			prop.load(fr);

			fr.close();

		} catch (FileNotFoundException e) {
			System.err.println("Config file not found. Error: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("IO errorr when trying to read config file. Error: " + e.getMessage());
		}

		return prop;
	}
}
