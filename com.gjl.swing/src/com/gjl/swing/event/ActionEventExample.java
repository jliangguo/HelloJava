package com.gjl.swing.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ActionEventExample extends JFrame implements ActionListener {

	private static final long serialVersionUID = 5189640790316847058L;

	@SuppressWarnings("rawtypes")
	private JList list;
	@SuppressWarnings("rawtypes")
	private DefaultListModel model;

	public ActionEventExample() {
		initUI();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private final void initUI() {
		JPanel panel = new JPanel();
		panel.setLayout(null);

		model = new DefaultListModel();
		list = new JList(model);
		list.setBounds(150, 30, 220, 150);

		JButton okButton = new JButton("OK");
		okButton.setBounds(30, 35, 80, 25);

		okButton.addActionListener(this);

		panel.add(okButton);
		panel.add(list);
		add(panel);

		setTitle("Event object");
		setSize(420, 250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		Locale locale = Locale.getDefault();
		Date date = new Date(e.getWhen());
		String s = DateFormat.getTimeInstance(DateFormat.SHORT, locale).format(
				date);

		if (!model.isEmpty()) {
			model.clear();
		}

		if (e.getID() == ActionEvent.ACTION_PERFORMED) {
			model.addElement(" Event Id: ACTION_PERFORMED");
		}

		model.addElement(" Time: " + s);

		String source = e.getSource().getClass().getName();
		model.addElement(" Source: " + source);

		// ÌØÊâ°´¼üShift/Alt/Ctrl/Meta
		int mod = e.getModifiers();

		StringBuffer buffer = new StringBuffer(" Modifiers: ");
		if ((mod & ActionEvent.ALT_MASK) > 0) {
			buffer.append(" Alt ");
		}

		if ((mod & ActionEvent.SHIFT_MASK) > 0) {
			buffer.append(" Shift ");
		}

		if ((mod & ActionEvent.META_MASK) > 0) {
			buffer.append(" Meta ");
		}

		if ((mod & ActionEvent.CTRL_MASK) > 0) {
			buffer.append(" Ctrl ");
		}

		model.addElement(buffer);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				ActionEventExample ex = new ActionEventExample();
				ex.setVisible(true);
			}
		});
	}

}
