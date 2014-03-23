package com.gjl.swing.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

public class SimpleMenuExample extends JFrame {

	private static final long serialVersionUID = -8203279103865308150L;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				SimpleMenuExample ex = new SimpleMenuExample();
				ex.setVisible(true);
			}
		});
	}

	public SimpleMenuExample() {
		initUI();
	}

	private void initUI() {
		// 菜单栏
		JMenuBar menuBar = new JMenuBar();
		ImageIcon icon = new ImageIcon("exit.png");

		// 菜单
		JMenu file = new JMenu("File");
		// 快捷键（Alt+F）
		file.setMnemonic(KeyEvent.VK_F);

		// 菜单条目
		JMenuItem menuItem = new JMenuItem("Exit", icon);
		menuItem.setMnemonic(KeyEvent.VK_E);
		menuItem.setToolTipText("Exit Application");
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		file.add(menuItem);

		menuBar.add(file);
		setJMenuBar(menuBar);
		setTitle("Simple Menu Example");
		setSize(300, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
