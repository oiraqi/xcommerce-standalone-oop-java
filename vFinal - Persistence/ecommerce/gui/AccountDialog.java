package ecommerce.gui;

import ecommerce.core.Customer;

import ecommerce.persistence.PersistentCustomer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.swing.border.LineBorder;

import oracle.jdeveloper.layout.XYConstraints;
import oracle.jdeveloper.layout.XYLayout;

public class AccountDialog extends JDialog {
    private XYLayout xYLayout1 = new XYLayout();
    private JTextField nameTextField = new JTextField();
    private JTextField emailAddressTextField = new JTextField();
    private JLabel nameLabel = new JLabel();
    private JLabel emailAddressLabel = new JLabel();
    private JLabel addressLabel = new JLabel();
    private JTextArea addressTextArea = new JTextArea();
    private JTextArea greetingsTextArea = new JTextArea();
    private JButton submitButton = new JButton();
    private Customer customer;
    private AbstractCustomerPane customerInfoPane = null;

    public AccountDialog(AbstractCustomerPane customerInfoPane){
        this(null, "Manage your Account", true);
        this.customerInfoPane = customerInfoPane;
        greetingsTextArea.setText("Manage your account information");
        this.customer = customerInfoPane.getCustomer();
        nameTextField.setText(customer.getName());
        emailAddressTextField.setText(customer.getEmailAddress());
        addressTextArea.setText(customer.getAddress());
        setVisible(true);
    }

    public AccountDialog(Frame parent, String title, boolean modal) {
        super(parent, title, modal);
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setSize(new Dimension(400, 300));
        this.setLocation(400, 100);
        this.getContentPane().setLayout(xYLayout1);
        nameLabel.setText("Name(*):");
        emailAddressLabel.setText("Email address(*): ");
        addressLabel.setText("Address(*):");
        nameTextField.setBorder(new LineBorder(Color.BLACK, 1));
        emailAddressTextField.setBorder(new LineBorder(Color.BLACK, 1));
        addressTextArea.setBorder(new LineBorder(Color.BLACK, 1));
        addressTextArea.setLineWrap(true);
        addressTextArea.setWrapStyleWord(true);
        greetingsTextArea.setEnabled(false);
        greetingsTextArea.setFont(new Font("Verdana", Font.BOLD, 12));
        submitButton.setText("OK");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                boolean success = true;
                if(nameTextField.getText() == null || nameTextField.getText().trim().equals("")){
                    nameLabel.setForeground(Color.RED);
                    success = false;
                }
                else
                    customer.setName(nameTextField.getText().trim());
                if(emailAddressTextField.getText() == null || emailAddressTextField.getText().trim().equals("")){
                    emailAddressLabel.setForeground(Color.RED);
                    success = false;
                }
                else
                    customer.setEmailAddress(emailAddressTextField.getText().trim());
                if(addressTextArea.getText() == null || addressTextArea.getText().trim().equals("")){
                    addressLabel.setForeground(Color.RED);
                    success = false;
                }
                else
                    customer.setAddress(addressTextArea.getText().trim());
                if(success){
                    if(customerInfoPane != null)
                        customerInfoPane.update();
                    dispose();
                    try {
                        PersistentCustomer.saveCustomer();
                    } catch (IOException ioe) {
                        JOptionPane.showMessageDialog(null, "Could not save your profile!");
                    }
                }
            }
        });
        this.getContentPane().add(submitButton, new XYConstraints(295, 230, 75, 21));
        this.getContentPane().add(greetingsTextArea, new XYConstraints(90, 5, 225, 25));
        this.getContentPane().add(addressTextArea, new XYConstraints(115, 140, 170, 85));
        this.getContentPane().add(addressLabel, new XYConstraints(15, 170, 75, 20));
        this.getContentPane().add(emailAddressLabel, new XYConstraints(15, 95, 95, 20));
        this.getContentPane().add(nameLabel, new XYConstraints(15, 50, 75, 20));
        this.getContentPane().add(emailAddressTextField, new XYConstraints(115, 95, 170, 20));
        this.getContentPane().add(nameTextField, new XYConstraints(115, 50, 170, 20));
    }
}
