package com.kamitokaze.editor.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

import org.apache.commons.lang3.math.NumberUtils;

import com.kamitokaze.editor.model.MapProperties;

public class NewMapDialog extends JDialog implements UIStrings {
	private boolean validated = false;
	
	private MapProperties mapProperties = new MapProperties();
	private List<JTextField> textFields = new LinkedList<>();
	
	private JButton okButton;
	private JButton cancelButton;
	
	public NewMapDialog(JFrame parent) {
		super(parent, DIALOG_NEWMAP_TITLE, true);
		JPanel mainPanel = createMainPanel();
		this.add(mainPanel, BorderLayout.CENTER);
		
		JPanel buttonPanel = createButtonPanel();
		this.add(buttonPanel, BorderLayout.SOUTH);
		
		this.pack();
	}
	
	public boolean showDialog() {
		this.setVisible(true);
		
		return validated;
	}
	
	public MapProperties getResult() {
		return mapProperties;
	}

	private JPanel createMainPanel() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridBagLayout());

		addNewPropertyToPanel(mainPanel, DIALOG_NEWMAP_MAXLEVEL, 0);
		addNewPropertyToPanel(mainPanel, DIALOG_NEWMAP_PLAYERLEVEL, 1);
		
		return mainPanel;
	}
	
	private void addNewPropertyToPanel(JPanel panel, String label, int line) {
		panel.add(new JLabel(label), new GridBagConstraints(0, line, 1, 1, 0.0,
				0.0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH,
				new Insets(5, 20, 5, 10), 0, 0));
		JTextField textField = new JTextField(8);
		textFields.add(textField);
		panel.add(textField, new GridBagConstraints(1, line, 1, 1, 0.0,
				0.0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH,
				new Insets(5, 20, 5, 10), 0, 0));
	}

	private JPanel createButtonPanel() {
		JPanel buttonPanel = new JPanel();
		okButton = new JButton(DIALOG_NEWMAP_OKBUTTON);
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (validateData()) {
					validated = true;
					fillMapProperties();
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, DIALOG_NEWMAP_INVALIDDATA_CONTENT, DIALOG_NEWMAP_INVALIDDATA_TITLE, JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		cancelButton = new JButton(DIALOG_NEWMAP_CANCELBUTTON);
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				validated = false;
				setVisible(false);
			}
		});
		
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(cancelButton);
		buttonPanel.add(okButton);
		
		return buttonPanel;
	}
	
	private boolean validateData() {
		boolean isValid = true;
		
		for (JTextField textField: textFields) {
			String text = textField.getText();
			
			if (text.isEmpty() || !NumberUtils.isNumber(text) || Integer.valueOf(text) < 1) {
				isValid = false;
				break;
			}
		}
		
		return isValid;
	}
	
	private void fillMapProperties() {
		mapProperties.setLevelMax(Integer.valueOf(textFields.get(0).getText()));
		mapProperties.setPlayerLevel(Integer.valueOf(textFields.get(1).getText()));
	}
}
