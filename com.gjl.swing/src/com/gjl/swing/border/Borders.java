package com.gjl.swing.border;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

public class Borders extends JApplet {

	private static final long serialVersionUID = 8801841996072803407L;

	static JPanel showBorder(Border b) {
		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());
		String nm = b.getClass().toString();
		nm = nm.substring(nm.lastIndexOf(".") + 1);
		jp.add(new JLabel(nm, JLabel.CENTER), BorderLayout.CENTER);
		jp.setBorder(b);
		return jp;
	}

	@Override
	public void init() {
		Container cp = getContentPane();
		cp.setLayout(new GridLayout(2, 4));
		// ±êÌâ±ß¿ò
		cp.add(showBorder(new TitledBorder("Title")));
		// Ê´¿Ì±ß¿ò
		cp.add(showBorder(new EtchedBorder()));
		// ÑÕÉ«ÏßÌõ±ß¿ò
		cp.add(showBorder(new LineBorder(Color.BLUE)));
		// ´Ö±ß¿ò
		cp.add(showBorder(new MatteBorder(5, 5, 30, 30, Color.GREEN)));
		// Ð±Ãæ±ß¿ò
		cp.add(showBorder(new BevelBorder(BevelBorder.RAISED)));
		// ÈáÐ±Ãæ±ß¿ò
		cp.add(showBorder(new SoftBevelBorder(BevelBorder.LOWERED)));
		// ¸´ºÏ±ß¿ò
		cp.add(showBorder(new CompoundBorder(new EtchedBorder(),
				new LineBorder(Color.RED))));
	}

	public static void run(JApplet applet, int width, int height) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(applet);
		frame.setSize(width, height);
		applet.init();
		applet.start();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		run(new Borders(), 500, 500);
	}

}
