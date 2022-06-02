package ecommerce.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

class CustomActionListener implements ActionListener{

	private JButton submitButton;
	private JButton clearButton;

	public CustomActionListener(JButton submitButton, JButton clearButton){
		this.submitButton = submitButton;
		this.clearButton = clearButton;
	}

	public void actionPerformed(ActionEvent ae){
		Object o = ae.getSource();

	}
}