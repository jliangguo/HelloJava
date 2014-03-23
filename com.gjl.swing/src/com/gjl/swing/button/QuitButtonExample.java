package com.gjl.swing.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class QuitButtonExample extends JFrame {

	private static final long serialVersionUID = 3014490333426870347L;

	public QuitButtonExample() {
		initUI();
	}

	/**
	 * ��UI��ʼ�����뵥����ȡ��������һ�������У����õı��ʵ������
	 */
	private void initUI() {
		JPanel panel = new JPanel();
		getContentPane().add(panel);

		// Ĭ����FlowLayout�����ﲻ���ã�����Ҫ�õ�setBounds
		panel.setLayout(null);

		JButton quitButton = new JButton("Quit");
		// The new location of the top-left corner is specified by x and y, and
		// the new size is specified by width and height.
		quitButton.setBounds(50, 60, 80, 30);
		quitButton.setToolTipText("A Button component");

		quitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		panel.add(quitButton);

		setTitle("Quit Button");
		setSize(300, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				QuitButtonExample ex = new QuitButtonExample();
				ex.setVisible(true);
			}
		});
	}

}
