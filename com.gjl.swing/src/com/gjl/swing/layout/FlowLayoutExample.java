package com.gjl.swing.layout;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.SwingUtilities;

/**
 * 默认是布局管理器是FlowLayout。
 *
 * <br>
 *
 * 注意：最重要是是合理设置组件的Preferred Size。
 *
 * @author Administrator
 *
 */
public class FlowLayoutExample extends JFrame {

	private static final long serialVersionUID = 6705506219092382743L;

	public FlowLayoutExample() {
		initUI();
	}

	private final void initUI() {
		JPanel panel = new JPanel();

		JTextArea area = new JTextArea("text area");
		// 不设置Preferred Size就缩放至文本大小
		area.setPreferredSize(new Dimension(100, 100));

		JButton button = new JButton("button");
		panel.add(button);

		JTree tree = new JTree();
		panel.add(tree);

		panel.add(area);

		add(panel);

		// 缩放组件到合适的尺寸和布局
		pack();

		setTitle("FlowLayout Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {

				FlowLayoutExample ex = new FlowLayoutExample();
				ex.setVisible(true);
			}
		});
	}
}
