package ecommerce.tests;

import ecommerce.core.Catalog;
import ecommerce.core.Category;
import ecommerce.core.Customer;
import ecommerce.core.RealProduct;
import ecommerce.core.VirtualProduct;

import ecommerce.gui.*;

import ecommerce.persistence.PersistentCustomer;

import javax.swing.LookAndFeel;
import javax.swing.UIManager;

public class GUITest {
    public GUITest() {
        super();
    }

    public static void main(String[] args) throws Exception {

        Customer customer = PersistentCustomer.getInstance();//instead of new Customer("", "", "");
        Catalog catalog = buildCatalog();

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        //UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        MainFrame mainFrame = new MainFrame(catalog, customer);
        do {
            AccountDialog accountDialog = new AccountDialog(mainFrame.getCustomerInfoPane());
        } while (customer.getName() == null || customer.getName().trim().equals("") ||
                 customer.getEmailAddress() == null || customer.getEmailAddress().trim().equals("") ||
                 customer.getAddress() == null || customer.getAddress().trim().equals(""));


    }

    private static Catalog buildCatalog() {
        Catalog catalog = new Catalog();

        Category phones = new Category("Phones");
        Category laptops = new Category("Laptops");
        Category software = new Category("Software");

        catalog.addCategory(phones);
        catalog.addCategory(laptops);
        catalog.addCategory(software);

        phones.addProduct(new RealProduct("Galaxy SI", "Samsung", 1000, 10, (float)0.3));
        phones.addProduct(new RealProduct("Galaxy SII", "Samsung", 2000, 20, (float)0.3));
        phones.addProduct(new RealProduct("Galaxy SIII", "Samsung", 3000, 30, (float)0.3));

        laptops.addProduct(new RealProduct("Latitude E6430", "Dell", 5500, 7, (float)1.5));
        laptops.addProduct(new RealProduct("Horizon D543", "Sony", 7500, 9, (float)1.3));

        software.addProduct(new VirtualProduct("iOS X", "Apple", 5000, "http://ios.com/x/download"));
        software.addProduct(new VirtualProduct("Windows 8", "Microsoft", 5000,
                                               "http://microsoft.com/windows/8/download"));

        return catalog;
    }
}
