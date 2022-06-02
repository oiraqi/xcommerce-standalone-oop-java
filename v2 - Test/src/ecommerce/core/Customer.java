package ecommerce.core;

import java.util.Random;


public class Customer {
    private String id; //read-only
    private String name;
    private String emailAddress;
    private String address;
    private ShoppingCart shoppingCart;
    private OrderList orders;
    private static Random random = new Random();

    public Customer(String name, String emailAddress, String address){
        this.id = "" + random.nextInt();
        this.name = name;
        this.emailAddress = emailAddress;
        this.address = address;
        shoppingCart = new ShoppingCart(this);
        orders = new OrderList();
    }

    public String getName() {
        return name;
    }


    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void addOrder(Order order){
        orders.add(order);
    }


    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public Order[] getOrders() {
        return orders.toArray();
    }
}
