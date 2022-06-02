package ecommerce.core;

import java.io.Serializable;

import java.util.Arrays;
import java.util.Random;


public class Customer implements Displayable, Serializable{
    protected String id; //read-only
    protected String name;
    protected String emailAddress;
    protected String address;
    protected transient ShoppingCart shoppingCart;
    protected GenericList<Order> orders;
    protected static Random random = new Random();

    public Customer(String name, String emailAddress, String address){
        this.id = "" + Math.abs(random.nextInt());
        this.name = name;
        this.emailAddress = emailAddress;
        this.address = address;
        shoppingCart = new ShoppingCart(this);
        orders = new GenericList<Order>();
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
        Object[] temp = orders.toArray();
        if(temp == null)
            return null;
        Order[] ordersArray = new Order[temp.length];
        int index = 0;
        for(Object object : temp)
            ordersArray[index++] = (Order)object;
        return ordersArray;
    }

    public String forDisplay(){
        return "Welcome dear " + ((name != null && !name.isEmpty())? name : "customer") + "!\nYour email @ddress: " + ((emailAddress != null && !emailAddress.isEmpty())? emailAddress : "Not yet specified") + " - Your id: " + id;
    }

    public void init(){
        shoppingCart = new ShoppingCart(this);
    }

    public void updateOrderStatus(int orderId, OrderStatus newStatus) throws IllegalStatusChangeException{
		//search for the corresponding
		Order order = searchOrderById(orderId);
		//Order order = orders.search(new Order(orderId));
		order.updateStatus(newStatus);
	}

	private Order searchOrderById(int orderId){
		return orders.search(new Order(orderId));
	}
}
