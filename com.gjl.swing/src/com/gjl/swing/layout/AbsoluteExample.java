package com.gjl.swing.layout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * ��ʹ��Layout Manager��ʹ�þ���λ�úʹ�С�������
 *
 * @author Administrator
 *
 */
public class AbsoluteExample extends JFrame {

	private static final long serialVersionUID = -82152489205277054L;

	public AbsoluteExample() {
		initUI();
	}

	public final void initUI() {

		setLayout(null);

		JButton ok = new JButton("OK");
		// top-left���Է���
		ok.setBounds(50, 50, 80, 25);

		JButton close = new JButton("Close");
		close.setBounds(150, 50, 80, 25);

		add(ok);
		add(close);

		setTitle("Absolute positioning");
		setSize(300, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				AbsoluteExample ex = new AbsoluteExample();
				ex.setVisible(true);
			}
		});
	}

}
