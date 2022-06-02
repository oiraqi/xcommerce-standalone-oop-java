package ecommerce.core;


public class RealProduct extends Product {
    private int quantity;
    private float weight;

    public RealProduct(String id, float price, String name, String brand, int quantity, float weight) {
        super(id, price, name, brand);
        this.quantity = quantity;
        this.weight = weight;
    }


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }

    public String forDisplay() {
        return super.forDisplay() + " | Quantity in Stock: " + quantity + " | Weight: " + weight;
    }
}
