package ecommerce.core;


public class VirtualProduct extends Product {
    private String downloadURL;
    
    public VirtualProduct(String name, String brand, float price, String downloadURL){
        super(name, brand, price);
        this.downloadURL = downloadURL;
    }

    public void setDownloadURL(String downloadURL) {
        this.downloadURL = downloadURL;
    }

    public String getDownloadURL() {
        return downloadURL;
    }
    
    public String forDisplay(){
        return super.forDisplay() + " | Download here: " + downloadURL;
    }
    
    public void updateShoppingCart(ShoppingCart shoppingCart, int selectedQuantityChange){
        shoppingCart.setProductsTotalPrice(shoppingCart.getProductsTotalPrice() + (getPrice() * selectedQuantityChange));
    }
}