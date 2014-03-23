package com.gjl.swing.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

public class PopupMenuExample extends JFrame {

	private static final long serialVersionUID = -4146413287390993339L;

	private JPopupMenu pmenu;

	public PopupMenuExample() {
		initUI();
	}

	private void initUI() {
		pmenu = new JPopupMenu();
		JMenuItem maxitem = new JMenuItem("Maximize");

		// 菜单的事件响应
		maxitem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});

		pmenu.add(maxitem);

		JMenuItem quititem = new JMenuItem("Quit");
		quititem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		pmenu.add(quititem);

		// JFrame的鼠标响应事件
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3) {
					pmenu.show(e.getComponent(), e.getX(), e.getY());
				}
			}
		});

		setTitle("JPopupMenu");
		setSize(300, 250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				PopupMenuExample pm = new PopupMenuExample();
				pm.setVisible(true);
			}
		});
	}

}
