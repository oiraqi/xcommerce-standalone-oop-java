package ecommerce.core;


public class ShoppingCart {
    private SelectedProductList selectedProducts;
    private Customer customer;
    private float productsTotalPrice;
    private float shippingCost;    
    private static final float BASE_SHIPPING_COST = 25;    
    
    public ShoppingCart(Customer customer){
        this.customer = customer;
        selectedProducts = new SelectedProductList();
        productsTotalPrice = 0;
        shippingCost = 0;
    }

    public void addSelectedProduct(Product product, int quantity) {
        SelectedProduct selectedProduct = searchByProduct(product);
        if(selectedProduct == null){ //this is the first time that the customer selects and adds such a product, so let's create a new SelectedProduct object
            selectedProduct = new SelectedProduct(product, quantity);
            selectedProducts.add(selectedProduct);
        }else //the product has already been selected and added by the customer, so let's just update its selected quantity
            selectedProduct.updateSelectedQuantity(quantity);
        
        //now, let's update the shopping cart prices, based on the selected quantity change
        int selectedQuantityChange = selectedProduct.getSelectedQuantityChange();
        product.updateShoppingCart(this, selectedQuantityChange);
    }

    public void updateSelectedProductQuantity(String productId, int quantityChange) { //quantityChange can be positive for adding products or negative for removing them
        SelectedProduct selectedProduct = searchByProductId(productId);
        if(selectedProduct == null)
            return;
        selectedProduct.updateSelectedQuantity(quantityChange);
        
        //now, let's update the shopping cart prices, based on the selected quantity change
        int selectedQuantityChange = selectedProduct.getSelectedQuantityChange(); //caution: selectedQuantityChange may be different from quantityChange
        selectedProduct.getProduct().updateShoppingCart(this, selectedQuantityChange);
        
        //but what if, in the case of removal, the selected quantity has become null? remove the selected product in this case
        if(selectedProduct.getSelectedQuantity() == 0)
            removeSelectedProduct(productId);
    }

    public void removeSelectedProduct(String productId) {
        selectedProducts.remove(productId);
    }

    public String forDisplay() {
        return selectedProducts.forDisplay() + 
               "\nProducts Total Price: " + productsTotalPrice + " DH" + 
               "\nShipping Cost: " + shippingCost + " DH" + 
               "\nTotal Price: " + (productsTotalPrice + shippingCost) + " DH";
    }

    public float getProductsTotalPrice() {
        return productsTotalPrice;
    }

    public float getShippingCost() {
        return shippingCost;
    }

    public float getTotalPrice() {
        return productsTotalPrice + shippingCost;
    }

    public void checkout() {
        //if shipping cost is not null (shopping cart contains real products) then take into consideration the BASE_SHIPPING_COST
        shippingCost = (shippingCost == 0)? 0 : shippingCost + BASE_SHIPPING_COST;
        //create order and add it to the customer's list of orders
        new Order(customer, selectedProducts, productsTotalPrice, shippingCost);
        //empty shopping cart for next order, by calling private method empty()
        empty();
    }
    
    private void empty(){
        selectedProducts = new SelectedProductList();
        productsTotalPrice = 0;
        shippingCost = 0;
    }
    
    private SelectedProduct searchByProduct(Product product){
        return selectedProducts.searchByProduct(product);
    }
    
    private SelectedProduct searchByProductId(String productId){
        return selectedProducts.searchByProductId(productId);
    }

    public void setProductsTotalPrice(float productsTotalPrice) {
        this.productsTotalPrice = productsTotalPrice;
    }

    public void setShippingCost(float shippingCost) {
        this.shippingCost = shippingCost;
    }
}
