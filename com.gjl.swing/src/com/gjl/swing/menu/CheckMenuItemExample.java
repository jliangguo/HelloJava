package com.gjl.swing.menu;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;

public class CheckMenuItemExample extends JFrame {

	private static final long serialVersionUID = 3081829741604480443L;
	private JLabel statusbar;

	public CheckMenuItemExample() {
		initUI();
	}

	private void initUI() {
		JMenuBar menubar = new JMenuBar();
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);

		JMenu view = new JMenu("View");
		view.setMnemonic(KeyEvent.VK_V);

		// CheckBox条目，最终要的方法是setState和监听器
		JCheckBoxMenuItem bar = new JCheckBoxMenuItem("Show StatusBar");
		bar.setState(true);

		bar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (statusbar.isVisible()) {
					statusbar.setVisible(false);
				} else {
					statusbar.setVisible(true);
				}
			}
		});

		view.add(bar);

		menubar.add(file);
		menubar.add(view);

		setJMenuBar(menubar);

		statusbar = new JLabel(" Statusbar");
		//
		statusbar.setBorder(BorderFactory
				.createEtchedBorder(EtchedBorder.RAISED));
		add(statusbar, BorderLayout.SOUTH);

		setTitle("CheckBox menu item");
		setSize(360, 250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				CheckMenuItemExample ex = new CheckMenuItemExample();
				ex.setVisible(true);
			}
		});
	}

}
