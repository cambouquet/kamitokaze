package com.kamitokaze.editor.ui;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.kamitokaze.editor.model.categories.ObjectCategory;
import com.kamitokaze.editor.model.objects.MapObject;

public class ObjectVariationsDialog extends JDialog implements UIStrings {
	private boolean validated = false;
	
	private List<MapObject> objects;
	private MapObject selectedMapObject;
	
	private static final int NUMBER_COLUMNS_MAX = 4;
	private static final int BUTTON_SIZE = 40;
	
	public ObjectVariationsDialog(JFrame parentFrame, List<MapObject> objects) {
		super(parentFrame, UIStrings.DIALOG_OBJECTS_TITLE, true);
		this.objects = objects;
		int numberOfObjects = objects.size();
		int numberOfRows = computeNumberOfRows(numberOfObjects);
		int numberOfColumns = computeNumberOfColumns(numberOfObjects);
		this.setPreferredSize(new Dimension(numberOfColumns * BUTTON_SIZE, numberOfRows * BUTTON_SIZE));
		
		this.getContentPane().setLayout(new GridLayout(numberOfRows, numberOfColumns));
		createMainPanel();

		this.pack();
	}
	
	private int computeNumberOfRows(int numberOfObjects) {
		return (int) Math.ceil(numberOfObjects/4);
	}

	private int computeNumberOfColumns(int numberOfObjects) {
		int width = NUMBER_COLUMNS_MAX * BUTTON_SIZE;
		if (numberOfObjects <= NUMBER_COLUMNS_MAX) {
			width = numberOfObjects * BUTTON_SIZE;
		}
		
		return width;
	}

	public boolean showDialog() {
		this.setVisible(true);
		
		return validated;
	}
	
	public MapObject getResult() {
		return selectedMapObject;
	}

	private JPanel createMainPanel() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridBagLayout());

		int i = 0;
		for (MapObject object: objects) {
			addObject(object, i);
			i++;
		}
		
		return mainPanel;
	}
	
	private void addObject(MapObject object, int i) {
		JButton objectButton = new JButton(object.getImage());
		
		objectButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				validated = true;
				JOptionPane.showMessageDialog(null, "" , UIStrings.CODGINPHASE_COMINGSOON, JOptionPane.INFORMATION_MESSAGE, object.getImage());
			}
		});
		this.add(objectButton);
	}
}
