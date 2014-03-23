package com.gjl.swing.layout.boxlayout;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TwoButtonsExample extends JFrame {

	private static final long serialVersionUID = 1881381920249229532L;

	public TwoButtonsExample() {
		initUI();
	}

	/**
	 * 1、先从顶向底依次放置basic和bottom；<br>
	 * 2、bottom中组件从右向左放置（setAlignmentX中值大于等于1.0f）；
	 */
	private final void initUI() {
		JPanel basic = new JPanel();
		basic.setLayout(new BoxLayout(basic, BoxLayout.Y_AXIS));// 从顶向底放置
		add(basic);

		// 放置胶合部分
		basic.add(Box.createVerticalGlue());

		// 放置bottom部分
		JPanel bottom = new JPanel();
		bottom.setAlignmentX(1f);// 垂直对齐
		bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));// 从左向右放置

		JButton ok = new JButton("OK");
		JButton close = new JButton("Close");

		bottom.add(ok);
		bottom.add(Box.createRigidArea(new Dimension(5, 0)));// 创建不可见组件，dimension指定区域大小
		bottom.add(close);
		bottom.add(Box.createRigidArea(new Dimension(15, 0)));

		basic.add(bottom);
		basic.add(Box.createRigidArea(new Dimension(0, 15)));// 距底部15

		setTitle("Two Buttons");
		setSize(300, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				TwoButtonsExample ex = new TwoButtonsExample();
				ex.setVisible(true);
			}
		});
	}

}
