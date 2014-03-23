package com.gjl.swing.menu;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.SwingUtilities;

/**
 * 右侧菜单示例
 * 
 * @author Administrator
 *
 */
public class RightMenuExample extends JFrame {

	private static final long serialVersionUID = -3299276613071246013L;

	public RightMenuExample() {
		initUI();
	}

	private void initUI() {
		JMenuBar menubar = new JMenuBar();

		JMenu filem = new JMenu("File");
		JMenu viewm = new JMenu("View");
		JMenu toolsm = new JMenu("Tools");
		JMenu helpm = new JMenu("Help");

		menubar.add(filem);
		menubar.add(viewm);
		menubar.add(toolsm);
		menubar.add(Box.createHorizontalGlue());// Glue占用所有空余空间，自然将help挤到最右侧
		menubar.add(helpm);

		setJMenuBar(menubar);

		setTitle("Right menu");
		setSize(300, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				RightMenuExample ex = new RightMenuExample();
				ex.setVisible(true);
			}
		});
	}

}
