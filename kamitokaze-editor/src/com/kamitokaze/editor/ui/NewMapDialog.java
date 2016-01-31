package com.kamitokaze.editor.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kamitokaze.editor.model.MapProperties;

public class NewMapDialog extends JDialog implements UIStrings {
	private boolean validated = false;
	
	private MapProperties mapProperties;
	
	private JButton okButton;
	private JButton cancelButton;
	
	public NewMapDialog() {
		JPanel mainPanel = createMainPanel();
		this.add(mainPanel, BorderLayout.CENTER);
		
		JPanel buttonPanel = createButtonPanel();
		this.add(buttonPanel, BorderLayout.SOUTH);
		
		this.pack();
	}
	
	private JPanel createMainPanel() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridBagLayout());
		addNewPropertyToPanel(mainPanel, DIALOG_NEWMAP_WIDTH, 0);
		addNewPropertyToPanel(mainPanel, DIALOG_NEWMAP_HEIGHT, 1);
		addNewPropertyToPanel(mainPanel, DIALOG_NEWMAP_MAXLEVEL, 2);
		addNewPropertyToPanel(mainPanel, DIALOG_NEWMAP_PLAYERLEVEL, 3);
		
		return mainPanel;
	}
	
	private void addNewPropertyToPanel(JPanel panel, String label, int line) {
		panel.add(new JLabel(label), new GridBagConstraints(0, line, 1, 1, 0.0,
				0.0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH,
				new Insets(5, 20, 5, 10), 0, 0));
		panel.add(new JTextField(8), new GridBagConstraints(1, line, 1, 1, 0.0,
				0.0, GridBagConstraints.LINE_START, GridBagConstraints.BOTH,
				new Insets(5, 20, 5, 10), 0, 0));
		
	}

	public boolean showDialog() {
		this.setVisible(true);
		
		return validated;
	}

	private JPanel createButtonPanel() {
		JPanel buttonPanel = new JPanel();
		okButton = new JButton(DIALOG_NEWMAP_OKBUTTON);
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				validated = true;
				setVisible(false);
				JOptionPane.showMessageDialog(null, CODGINPHASE_COMINGSOON);
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
}
