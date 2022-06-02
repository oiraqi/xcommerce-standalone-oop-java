package ecommerce.gui;

import ecommerce.core.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainFrame extends JFrame {
    private JPanel mainPanel = new JPanel();
    private JPanel eastPanel = new JPanel();
    private CatalogPane catalogPane;
    private AbstractCustomerPane customerInfoPane, shoppingCartPane, ordersPane;

    public MainFrame(Catalog catalog, Customer customer) {
        customerInfoPane = new CustomerInfoPane(customer);
        ordersPane = new OrdersPane(customer);
        shoppingCartPane = new ShoppingCartPane(ordersPane);
        catalogPane = new CatalogPane(catalog, shoppingCartPane);

        JLabel versionLabel = new JLabel("ECommerce System v1.0");
        versionLabel.setFont(new Font("Verdana", Font.BOLD, 12));

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(versionLabel, BorderLayout.SOUTH);
        getContentPane().add(mainPanel, BorderLayout.CENTER);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(catalogPane, BorderLayout.CENTER);
        mainPanel.add(eastPanel, BorderLayout.EAST);

        eastPanel.setLayout(new BorderLayout());
        eastPanel.add(customerInfoPane, BorderLayout.NORTH);
        eastPanel.add(shoppingCartPane, BorderLayout.CENTER);
        eastPanel.add(ordersPane, BorderLayout.SOUTH);
        eastPanel.setPreferredSize(new Dimension(420, 700));

        setTitle("ECommerce System");
        setJMenuBar(new MenuBar(customerInfoPane)); //ecommerce.gui.MenuBar
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public AbstractCustomerPane getCustomerInfoPane() {
        return customerInfoPane;
    }
}
