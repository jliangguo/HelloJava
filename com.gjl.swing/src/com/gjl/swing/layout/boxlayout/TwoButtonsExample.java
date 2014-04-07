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
	 * 1���ȴӶ�������η���basic��bottom��<br>
	 * 2��bottom���������������ã�setAlignmentX��ֵ���ڵ���1.0f����
	 */
	private final void initUI() {
		JPanel basic = new JPanel();
		basic.setLayout(new BoxLayout(basic, BoxLayout.Y_AXIS));// �Ӷ���׷���
		add(basic);

		// ���ý��ϲ���
		basic.add(Box.createVerticalGlue());

		// ����bottom����
		JPanel bottom = new JPanel();
		bottom.setAlignmentX(1f);// ��ֱ����
		bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));// �������ҷ���

		JButton ok = new JButton("OK");
		JButton close = new JButton("Close");

		bottom.add(ok);
		bottom.add(Box.createRigidArea(new Dimension(5, 0)));// �������ɼ������dimensionָ�������С
		bottom.add(close);
		bottom.add(Box.createRigidArea(new Dimension(15, 0)));

		basic.add(bottom);
		basic.add(Box.createRigidArea(new Dimension(0, 15)));// ��ײ�15

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
