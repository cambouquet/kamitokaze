package com.kamitokaze.editor.controller.map;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.kamitokaze.editor.model.MapProperties;
import com.kamitokaze.editor.ui.UIStrings;
import com.kamitokaze.editor.ui.menu.NewMapDialog;

public class NewMapListener implements ActionListener {
		MapController mapController;
		
		public NewMapListener(MapController mapController) {
			this.mapController = mapController;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			NewMapDialog dialogNew = new NewMapDialog(null);

			boolean validated = dialogNew.showDialog();

			if (validated) {
				MapProperties prop = dialogNew.getResult();
				JOptionPane.showMessageDialog(null, UIStrings.CODGINPHASE_COMINGSOON + "\nNew map with " + prop.getLevelMax() + " levels. Players at level " + prop.getPlayerLevel() + ".");
				mapController.createMap(prop);
			}
		}
}
