package ecommerce.gui;

import ecommerce.core.ShoppingCart;
import ecommerce.core.Customer;

import ecommerce.persistence.PersistentCustomer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;

import javax.swing.*;

class ShoppingCartPane extends AbstractCustomerPane implements ActionListener {

    private ShoppingCart shoppingCart;
    private JButton checkoutButton;
    private JButton clearButton;
    private AbstractCustomerPane ordersPane;

    protected ShoppingCartPane(AbstractCustomerPane ordersPane) {
        super("Shopping Cart", ordersPane.getCustomer());
        this.shoppingCart = customer.getShoppingCart();
        this.ordersPane = ordersPane;
        checkoutButton = new JButton("Checkout");
        ActionListener customActionListener = new CustomActionListener(submitButton, clearButton);
        /*checkoutButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
				ae.
                if(shoppingCart.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Your shopping cart is empty!");
                    return;
                }
                if(JOptionPane.showConfirmDialog(null, "Are you sure you want to proceed with the checkout procedure?") == JOptionPane.OK_OPTION)
                    checkout();
            }
        });*/
		checkoutButton.addActionListener(customActionListener);
        clearButton = new JButton("Clear");
        /*clearButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                if(shoppingCart.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Your shopping cart is empty!");
                    return;
                }
                if(JOptionPane.showConfirmDialog(null, "Are you sure you want to clear your shopping cart?") == JOptionPane.OK_OPTION)
                    clear();
            }
        });*/
        clearButton.addActionListener(customActionListener);
        JPanel southPane = new JPanel();
        southPane.add(clearButton); //FlowLayout for JPanel, by default
        southPane.add(checkoutButton);
        pane.add(southPane, BorderLayout.SOUTH);
        pane.setPreferredSize(new Dimension(350, 200));
        update();
    }

    @Override
    protected void update() {
        textArea.setText(shoppingCart.forDisplay());
    }

    private void checkout(){
        shoppingCart.checkout();
        update();
        ordersPane.update();
        try {
            PersistentCustomer.save();
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Could not save your order!");
        }
    }

    private void clear(){
        shoppingCart.empty();
        update();
    }

    public void actionPerformed(ActionEvent ae){
		Object o = ae.getSource();
			if(o == submitButton){
				ldjdfgqskh
			}
			else if (o == clearButton){
		}
	}
}
