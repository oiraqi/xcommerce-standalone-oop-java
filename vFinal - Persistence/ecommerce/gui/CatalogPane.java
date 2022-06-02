package ecommerce.gui;

import ecommerce.core.Catalog;
import ecommerce.core.Customer;
import ecommerce.core.Category;
import ecommerce.core.AbstractProduct;

import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


class CatalogPane extends JTabbedPane {

    protected CatalogPane(Catalog catalog, AbstractCustomerPane shoppingCartPane) {
        Category[] categories = catalog.getCategories();
        setFont(new Font("Verdana", Font.BOLD, 12));
        for(Category category : categories){
            AbstractProduct[] products = category.getProducts();
            if(products == null)
                continue;
            JPanel productsPane = new JPanel();
            for(AbstractProduct product : products)
                productsPane.add(new ProductPane(product, shoppingCartPane));
            add(category.getName(), productsPane);
        }
    }
}