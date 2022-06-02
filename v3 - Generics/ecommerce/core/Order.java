package ecommerce.core;


import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.RandomAccess;

public class Order implements Displayable, Serializable{
    private GenericList<SelectedProduct> selectedProducts;
    private Customer customer;
    public static int LASTID = 0;
    private int id;
    private Date date;
    private Date lastUpdateDate;
    private OrderStatus status;
    private float productsTotalPrice;
    private float shippingCost;
    private static final float TAX_RATE = (float)0.2;

	public Order(int id){
		this.id = id;
	}

    public Order(Customer customer, GenericList<SelectedProduct> selectedProducts, float productsTotalPrice, float shippingCost){
        this.selectedProducts = selectedProducts;
        this.customer = customer;
        customer.addOrder(this);   //add me to customer's orders
        id = ++LASTID;
        date = lastUpdateDate = Calendar.getInstance().getTime();
        status = OrderStatus.HANDLING;
        this.productsTotalPrice = productsTotalPrice;
        this.shippingCost = shippingCost;
    }
    public void updateStatus(OrderStatus newStatus){
        status = newStatus;
        lastUpdateDate = Calendar.getInstance().getTime();
        //use JavaMail API to send a notification to the customer by email
    }


    public String forDisplay() {
        String selectedProductsForDisplay = selectedProducts.forDisplay();
        return "Order n° " + id + " | Status: " + status +
               "\nOrder Date: " + new SimpleDateFormat("EEE, MMM d, yyyy 'at' HH:mm:ss Z").format(date) +
                "\nLast Updated: " + new SimpleDateFormat("EEE, MMM d, yyyy 'at' HH:mm:ss Z").format(lastUpdateDate) +
                "\n\nOrdered Products:\n" + selectedProductsForDisplay +
                "\nProducts Total Price: " + productsTotalPrice + " DH" +
               "\n\nShipping Address: " + customer.getName() + " - " + customer.getAddress() +
                "\nShipping Cost: " + shippingCost + " DH" +
                "\n\nTotal Price: " + (productsTotalPrice + shippingCost) + " DH" +
                "\nIncluding Tax: " + (productsTotalPrice + shippingCost)/(1 + TAX_RATE)*(TAX_RATE) + " DH";
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

    public boolean equals(Object other){
		if(other == null || !(other instanceof Order))
			return false;
		return id == ((Order)other).getId();
	}
}
