package ecommerce.tests;

import ecommerce.core.*;

public class Test {

    public static void main(String[] args) /*throws IllegalStatusChangeException*/{
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

        software.addProduct(new VirtualProduct("iOS X", "Apple", 5000, "http://ios.com/x/download"));


        AbstractProduct[] phoneProducts = phones.getProducts();
        AbstractProduct[] softwareProducts = software.getProducts();

        Customer customer = new Customer("Dr. Cavalli", "v.cavalli@aui.ma", "Hassan II avenue, Al Akhawayn University, Ifrane, Morocco");
        ShoppingCart shoppingCart = customer.getShoppingCart();
        shoppingCart.addSelectedProduct(phoneProducts[0], 1);
        shoppingCart.addSelectedProduct(phoneProducts[2], 3);

        System.out.println(shoppingCart.forDisplay());
        shoppingCart.checkout();

        System.out.println("--------------------");

        shoppingCart.addSelectedProduct(phoneProducts[1], 2);
        shoppingCart.addSelectedProduct(phoneProducts[2], 5);
        shoppingCart.addSelectedProduct(softwareProducts[0], 5);

        System.out.println(shoppingCart.forDisplay());
        shoppingCart.checkout();
        System.out.println("--------------------");
        Order[] orders = customer.getOrders();
        System.out.println(orders[0].forDisplay());
        System.out.println("--------------------");
        System.out.println(orders[1].forDisplay());
        try{
            /*orders[0].updateStatus(OrderStatus.DELIVERED);
            orders[0].updateStatus(OrderStatus.SHIPPED);*/
            customer.updateOrderStatus(1, OrderStatus.DELIVERED);
            customer.updateOrderStatus(1, OrderStatus.HANDLING);
        }catch(IllegalStatusChangeException ex){
            System.out.println(ex.getProblematicStatus() + " is not appropriate here!");
            ex.printStackTrace();//Just for debugging purposes.
        }
    }
}
