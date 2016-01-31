package com.kamitokaze.editor.ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.kamitokaze.editor.model.MapProperties;

public class NewMapDialog extends JDialog implements UIStrings {
	private boolean validated = false;
	
	private JButton okButton;
	private JButton cancelButton;
	
	public NewMapDialog() {
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
		
		this.add(buttonPanel);
		this.pack();
	}
	
	public boolean showDialog() {
		this.setVisible(true);
		
		return validated;
	}
}
