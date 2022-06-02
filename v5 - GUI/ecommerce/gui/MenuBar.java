package ecommerce.gui;

import ecommerce.core.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

class MenuBar extends JMenuBar {
    private JMenu menuFile = new JMenu("File");
    private JMenuItem menuFileSave = new JMenuItem("Save");
    private JMenuItem menuFileExit = new JMenuItem("Exit");
    private JMenu menuAccount = new JMenu("Account");
    private JMenuItem menuItemAccountManage = new JMenuItem("Manage");
    private AbstractCustomerPane customerPane;

    protected MenuBar(AbstractCustomerPane aCustomerPane){
        super();
        customerPane = aCustomerPane;
        menuFile.add(menuFileSave);
        menuFile.add(menuFileExit);
        add(menuFile);
        menuAccount.add(menuItemAccountManage);
        add(menuAccount);
        menuFileExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        menuItemAccountManage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new AccountDialog(customerPane);
            }
        });
    }
}
