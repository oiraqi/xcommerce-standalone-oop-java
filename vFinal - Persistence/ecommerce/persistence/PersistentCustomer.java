package ecommerce.persistence;

import ecommerce.core.Customer;
import ecommerce.core.Order;
import ecommerce.core.ShoppingCart;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;

public class PersistentCustomer {
    private static final String customerStore = "customer.ser";
    private static Customer customer;
    private static ObjectInputStream customerIn;
    private static ObjectOutputStream customerOut;

    private PersistentCustomer(){
        //don't let anyone instantiate me
    }

    public static Customer getInstance(){
        if(customer == null){
            try{
                customerIn = new ObjectInputStream(new FileInputStream(customerStore));
                customer = (Customer)customerIn.readObject();
                customer.init();
                customerIn.close();
            }catch(Exception ex){
                customer = new Customer("", "", "");
            }
        }
        return customer;
    }

    public static void save() throws IOException {
        saveCustomer();
        saveOrderId();
    }

    public static void saveCustomer() throws IOException {
        if(customer == null)
            return;
        customerOut = new ObjectOutputStream(new FileOutputStream(customerStore));
        customerOut.writeObject(customer);
        customerOut.close();
    }

    private static void saveOrderId() throws IOException{
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("OrderCounter.bin"));
		dos.writeInt(Order.LASTID);
        dos.close();
	}
}
