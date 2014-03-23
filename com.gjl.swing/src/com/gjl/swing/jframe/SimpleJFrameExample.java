package com.gjl.swing.jframe;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * TopLevel����֮JFrame
 *
 * @author Administrator
 *
 */
public class SimpleJFrameExample extends JFrame {
	private static final long serialVersionUID = -6543358942806362877L;

	public SimpleJFrameExample() {
		// window title
		setTitle("Simaple JFrame Example");

		// ��λpixel
		setSize(300, 200);

		// place the window in the center of the screen
		setLocationRelativeTo(null);
		// Exit the application using the System exit method
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// invokeLater��Ӧ��׷�ӵ�Swing���¼�����
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				SimpleJFrameExample ex = new SimpleJFrameExample();
				ex.setVisible(true);
			}
		});
	}

}
