package ecommerce.core;


import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

public class Order {
    private SelectedProduct[] selectedProducts;
    private Customer customer;
    private static int LASTID = 0;
    private int id;
    private Date date;
    private Date lastUpdateDate;
    private OrderStatus status;
    private float productsPrice;
    private float shippingCost;

    public Order(SelectedProduct[] selectedProducts, Customer customer){
        this.selectedProducts = selectedProducts;
        this.customer = customer;
        //add me to customer's orders
        id = ++LASTID;
        date = lastUpdateDate = Calendar.getInstance().getTime();
        status = OrderStatus.HANDLING;
    }
    public void updateStatus(OrderStatus newStatus) {
        status = newStatus;
        lastUpdateDate = Calendar.getInstance().getTime();
        //use JavaMail API to send a notification to the customer by email
    }
    

    public String forDisplay() {
        StringBuffer selectedProductsForDisplay = new StringBuffer();
        for(int i = 0; i < selectedProducts.length; i++)
            selectedProductsForDisplay.append(selectedProducts[i].forDisplay() + "\n");
        return "Order n°: " + id + " | Status: " + status + 
               "\nOrder Date: " + new SimpleDateFormat("EEE, MMM d, yyyy 'at' HH:mm:ss Z").format(date) + 
                "\nLast Updated: " + new SimpleDateFormat("EEE, MMM d, yyyy 'at' HH:mm:ss Z").format(lastUpdateDate) + 
                "\nOrdered Products:\n" + selectedProductsForDisplay.toString() +
                "\nShipping Address: " + customer.getAddress() +
                "\nProducts Total Price: " + productsPrice +
                "\nShipping Cost: " + shippingCost +
                "\nTotal Price: " + (productsPrice + shippingCost);
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public OrderStatus getStatus() {
        return status;
    }
}
