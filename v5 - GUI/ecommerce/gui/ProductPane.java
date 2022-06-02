package ecommerce.gui;

import ecommerce.core.Customer;
import ecommerce.core.AbstractProduct;
import ecommerce.core.RealProduct;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import oracle.jdeveloper.layout.XYConstraints;
import oracle.jdeveloper.layout.XYLayout;

class ProductPane extends JPanel {
    private XYLayout xYLayout = new XYLayout();
    private JTextArea productTextArea = new JTextArea();
    private JButton addToCartButton = new JButton();
    private JComboBox productQuantityComboBox = new JComboBox(new Integer[]{1, 2, 3, 4, 5});
    private AbstractProduct product;
    private Customer customer;
    private AbstractCustomerPane shoppingCartPane;

    public ProductPane(AbstractProduct product, AbstractCustomerPane shoppingCartPane) {
        this.product = product;
        this.customer = shoppingCartPane.getCustomer();
        this.shoppingCartPane = shoppingCartPane;
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setLayout(xYLayout);
        this.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        this.setBackground(new Color(231, 231, 231));
        xYLayout.setWidth(265);
        xYLayout.setHeight(90);
        productTextArea.setEditable(false);
        productTextArea.setLineWrap(true);
        productTextArea.setText(product.forRestrictedDisplay());
        productTextArea.setBackground(new Color(231, 231, 231));
        addToCartButton.setText("Add To Cart");
        addToCartButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
					//we could use ae to retrieve information about the event
                    customer.getShoppingCart().addSelectedProduct(product, productQuantityComboBox.getSelectedIndex() + 1);
        			shoppingCartPane.update();
                }
            });
        this.add(productQuantityComboBox, new XYConstraints(93, 58, 45, 25));
        this.add(addToCartButton, new XYConstraints(148, 58, 110, 25));
        this.add(productTextArea, new XYConstraints(3, 3, 255, 40));
    }
}
