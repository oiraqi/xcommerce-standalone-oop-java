package ecommerce.core;


public class RealProduct extends Product {
    private int quantity;
    private float weight;
    private static final float UNIT_SHIPPING_COST = 15;

    public RealProduct(String name, String brand, float price, int quantity, float weight) {
        super(name, brand, price);
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
        return super.forDisplay() + " | Quantity in Stock: " + quantity + " | Weight: " + weight + " Kg";
    }
    
    public void updateShoppingCart(ShoppingCart shoppingCart, int selectedQuantityChange){
        shoppingCart.setProductsTotalPrice(shoppingCart.getProductsTotalPrice() + (getPrice() * selectedQuantityChange));
        shoppingCart.setShippingCost(shoppingCart.getShippingCost() + (getWeight() * selectedQuantityChange) * UNIT_SHIPPING_COST);
    }
}
