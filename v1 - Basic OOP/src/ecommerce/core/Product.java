package ecommerce.core;


public abstract class Product {
    private String id;  //read-only
    private float price;
    private String name;
    private String brand;
    private Category category;
    private boolean active;

    protected Product(String id, float price, String name, String brand){
        this.id = id;
        this.price = price;
        this.name = name;
        this.brand = brand;
        category = null;
        active = false;
    }

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

    public String forDisplay(){
        return brand + " " + name + " | " + price + " DH";
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
}
