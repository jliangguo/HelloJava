package com.gjl.swing.menu;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

public class ToolbarExample extends JFrame {

	private static final long serialVersionUID = -7071877027752371538L;

	public ToolbarExample() {
		initUI();
	}

	private void initUI() {
		JMenuBar menubar = new JMenuBar();
		JMenu file = new JMenu("File");
		menubar.add(file);
		setJMenuBar(menubar);

		// 工具栏
		JToolBar toolbar = new JToolBar();
		ImageIcon icon = new ImageIcon("exit.png");
		JButton exitButton = new JButton(icon);
		toolbar.add(exitButton);
		exitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		// 将组件追加到容器里
		add(toolbar, BorderLayout.NORTH);

		setTitle("Simple toolbar");
		setSize(300, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				ToolbarExample ex = new ToolbarExample();
				ex.setVisible(true);
			}
		});
	}

}
