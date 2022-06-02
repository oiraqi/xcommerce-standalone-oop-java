package ecommerce.gui;

import ecommerce.core.Customer;
import ecommerce.core.Order;

import java.awt.*;
import javax.swing.*;

class OrdersPane extends AbstractCustomerPane {
    
    OrdersPane(Customer customer) {
        super("Orders History", customer);
        pane.setPreferredSize(new Dimension(350, 350));
        update();
    }

    @Override
    protected void update() {
        if(customer == null)
            return;
        Order[] orders = customer.getOrders();
        StringBuffer history = new StringBuffer();
        if(orders != null){
            for(Order order : orders)
                history.append(order.forDisplay() + "\n\n---------------------\n\n");
            textArea.setText(history.toString());
        }else
            textArea.setText("No orders placed yet!");
    }
}
