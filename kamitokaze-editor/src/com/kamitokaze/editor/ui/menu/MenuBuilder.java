package com.kamitokaze.editor.ui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import com.kamitokaze.editor.controller.map.MapController;
import com.kamitokaze.editor.controller.map.NewMapListener;
import com.kamitokaze.editor.ui.UIStrings;

public class MenuBuilder implements UIStrings {
	public JMenuBar createMenu(NewMapListener newMapListener) {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menuFile = new JMenu(MENU_FILE);
		menuBar.add(menuFile);
		menuFile.setMnemonic('F');
		
		JMenuItem menuItemQuit = createMenuItem(MENU_QUIT, new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				System.exit(0);
			}
		}, Integer.valueOf('Q'), KeyEvent.VK_Q);
		
		JMenuItem menuItemNew = createMenuItem(MENU_NEW, newMapListener, Integer.valueOf('N'), KeyEvent.VK_N);
		
		menuFile.add(menuItemNew);
		menuFile.add(menuItemQuit);
		
		return menuBar;
	}
	
	private JMenuItem createMenuItem(String title, ActionListener action, Integer mnemonic, Integer accelerator) {
		JMenuItem menuItem = new JMenuItem(title);
		menuItem.addActionListener(action);
		
		if (mnemonic != null) {
			menuItem.setMnemonic(mnemonic);
		}
		
		if (accelerator != null) {
			menuItem.setAccelerator(KeyStroke.getKeyStroke(accelerator, KeyEvent.CTRL_MASK));
		}
		
		return menuItem;
	}
}
