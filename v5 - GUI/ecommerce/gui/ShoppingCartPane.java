package ecommerce.gui;

import ecommerce.core.ShoppingCart;
import ecommerce.core.Customer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class ShoppingCartPane extends AbstractCustomerPane {

    private ShoppingCart shoppingCart;
    private JButton checkoutButton;
    private JButton clearButton;
    private AbstractCustomerPane ordersPane;

    protected ShoppingCartPane(AbstractCustomerPane ordersPane) {
        super("Shopping Cart", ordersPane.getCustomer());
        this.shoppingCart = customer.getShoppingCart();
        this.ordersPane = ordersPane;
        checkoutButton = new JButton("Checkout");
        checkoutButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                if(shoppingCart.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Your shopping cart is empty!");
                    return;
                }
                if(JOptionPane.showConfirmDialog(null, "Are you sure you want to proceed with the checkout procedure?") == JOptionPane.OK_OPTION)
                    checkout();
            }
        });
        clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                if(shoppingCart.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Your shopping cart is empty!");
                    return;
                }
                if(JOptionPane.showConfirmDialog(null, "Are you sure you want to clear your shopping cart?") == JOptionPane.OK_OPTION)
                    clear();
            }
        });
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
    }

    private void clear(){
        shoppingCart.empty();
        update();
    }
}
