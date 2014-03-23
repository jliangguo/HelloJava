package com.gjl.swing.layout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class BorderLayoutExample extends JFrame {

	private static final long serialVersionUID = -9132972570772039391L;

	public BorderLayoutExample() {
		initUI();
	}

	private final void initUI() {
		JPanel panel = new JPanel(new BorderLayout());
		JPanel top = new JPanel();

		top.setBackground(Color.gray);
		top.setPreferredSize(new Dimension(250, 150));
		panel.add(top);

		// An Insets object is a representation of the borders of a container.
		panel.setBorder(new EmptyBorder(new Insets(20, 20, 20, 20)));

		add(panel);

		pack();

		setTitle("Border Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				BorderLayoutExample ex = new BorderLayoutExample();
				ex.setVisible(true);
			}
		});
	}

}
