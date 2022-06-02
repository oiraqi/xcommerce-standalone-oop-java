package ecommerce.core;


public class ShoppingCart {
    private SelectedProductList selectedProducts;
    private Customer customer;
    
    public ShoppingCart(Customer customer){
        this.customer = customer;
        selectedProducts = new SelectedProductList();
    }

    public void addSelectedProduct(Product product, int quantity) {
    }

    public void updateSelectedProductQuantity(String productId, int quantity) {
    }

    public void removeSelectedProduct(String productId) {
    }

    public String forDisplay() {
        return null;
    }

    public void getProductsTotalPrice() {
    }

    public void getShippingCost() {
    }

    public void getTotalPrice() {
    }

    public void checkout() {
        //create order and add it to the customer's list of orders
        //empty shopping cart for next order, by calling private method empty()
    }
    
    private void empty(){
        
    }
}
