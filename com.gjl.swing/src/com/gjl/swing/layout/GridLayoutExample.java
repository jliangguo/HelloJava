package com.gjl.swing.layout;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * 使用栅格布局管理器。
 *
 * @author Administrator
 *
 */
public class GridLayoutExample extends JFrame {

	private static final long serialVersionUID = 705082351799969865L;

	public GridLayoutExample() {
		initUI();
	}

	private final void initUI() {
		JPanel panel = new JPanel();
		// 设置边界：上、左、下和右
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panel.setLayout(new GridLayout(5, 4, 5, 5));

		String[] buttons = { "Cls", "Bck", "", "Close", "7", "8", "9", "/",
				"4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+" };

		for (int i = 0; i < buttons.length; i++) {
			// 空白“键”处理
			if (i == 2)
				panel.add(new JLabel(buttons[i]));
			else
				panel.add(new JButton(buttons[i]));
		}

		add(panel);

		setTitle("GridLayout");
		setSize(350, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {

				GridLayoutExample ex = new GridLayoutExample();
				ex.setVisible(true);
			}
		});
	}

}
