package com.gjl.swing.menu;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

public class ToolbarsExample extends JFrame {

	private static final long serialVersionUID = -2256368221210294372L;

	public ToolbarsExample() {
		initUI();
	}

	private void initUI() {
		JToolBar toolbar1 = new JToolBar();
		JToolBar toolbar2 = new JToolBar();

		JPanel panel = new JPanel();
		// 设置垂直的BoxLayout
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		ImageIcon newi = new ImageIcon("new.png");
		ImageIcon open = new ImageIcon("open.png");
		ImageIcon save = new ImageIcon("save.png");
		ImageIcon exit = new ImageIcon("exit.png");

		JButton newb = new JButton(newi);
		JButton openb = new JButton(open);
		JButton saveb = new JButton(save);

		toolbar1.add(newb);
		toolbar1.add(openb);
		toolbar1.add(saveb);
		// 垂直对齐，按X轴依次放置
		toolbar1.setAlignmentX(0);

		JButton exitb = new JButton(exit);
		toolbar2.add(exitb);
		toolbar2.add(exitb);
		toolbar2.setAlignmentX(0);

		exitb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		panel.add(toolbar1);
		panel.add(toolbar2);

		add(panel, BorderLayout.NORTH);

		setTitle("Toolbars");
		setSize(360, 250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				ToolbarsExample ex = new ToolbarsExample();
				ex.setVisible(true);
			}
		});
	}

}
