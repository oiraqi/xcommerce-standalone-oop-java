package ecommerce.gui;

import ecommerce.core.Customer;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.*;

abstract class AbstractCustomerPane extends JTabbedPane {
    protected Customer customer;
    protected JPanel pane;
    protected JTextArea textArea;

    protected AbstractCustomerPane(String title, Customer customer) {
        super();
        this.customer = customer;
        pane = new JPanel();
        setFont(new Font("Verdana", Font.BOLD, 12));
        add(title, pane);
        textArea = new JTextArea();
        textArea.setEnabled(false);
        textArea.setFont(new Font("Verdana", Font.BOLD, 12));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        pane.setLayout(new BorderLayout());
        pane.add(new JScrollPane(textArea), BorderLayout.CENTER);
    }

    protected abstract void update();

    public Customer getCustomer() {
        return customer;
    }
}
