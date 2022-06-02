package ecommerce.core;

import java.io.Serializable;

import java.util.Random;


public abstract class AbstractProduct implements Displayable, Serializable{
    private String id;  //read-only
    private String name;
    private String brand;
    private float price;
    private Category category;
    private boolean active;
    private static Random random = new Random();

    protected AbstractProduct(String name, String brand, float price){
        this.id = "" + Math.abs(random.nextInt());
        this.name = name;
        this.brand = brand;
        this.price = price;
        category = null;
        active = false;        
    }
    
    protected abstract void updateShoppingCart(ShoppingCart shoppingCart, int selectedQuantityChange);

    public String getId() {
        return id;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }
    
    public String forRestrictedDisplay(){
        return brand + " " + name + ": " + price + " DH";
    }
    
    public String forDisplay(){
        return forRestrictedDisplay();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public boolean equals(Object object){
        if(!(object instanceof AbstractProduct))
            return false;
        return ((AbstractProduct)object).getId() == id;
    }
}
