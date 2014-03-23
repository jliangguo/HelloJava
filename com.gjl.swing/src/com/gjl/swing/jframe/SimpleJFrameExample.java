package com.gjl.swing.jframe;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * TopLevel容器之JFrame
 *
 * @author Administrator
 *
 */
public class SimpleJFrameExample extends JFrame {
	private static final long serialVersionUID = -6543358942806362877L;

	public SimpleJFrameExample() {
		// window title
		setTitle("Simaple JFrame Example");

		// 单位pixel
		setSize(300, 200);

		// place the window in the center of the screen
		setLocationRelativeTo(null);
		// Exit the application using the System exit method
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// invokeLater将应用追加到Swing的事件队列
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				SimpleJFrameExample ex = new SimpleJFrameExample();
				ex.setVisible(true);
			}
		});
	}

}
