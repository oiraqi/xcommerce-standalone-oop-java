package ecommerce.core;


public class SelectedProduct {
    private Product product;
    private int selectedQuantity;
    private int selectedQuantityChange; //the change in the selected quantity since its last update
    
    public SelectedProduct(Product product, int selectedQuantity){
        this.product = product;
        if(product instanceof RealProduct && selectedQuantity > ((RealProduct)product).getQuantity())
            this.selectedQuantity = ((RealProduct)product).getQuantity();
        else
            this.selectedQuantity = selectedQuantity;
        selectedQuantityChange = selectedQuantity;
    }
    
    public void updateSelectedQuantity(int delta){
        if (selectedQuantity + delta < 0) //trying to remove more than what has been selected
            selectedQuantityChange = - selectedQuantity;
        else if(product instanceof RealProduct && selectedQuantity + delta > ((RealProduct)product).getQuantity())
            selectedQuantityChange = ((RealProduct)product).getQuantity() - selectedQuantity;
        else
            selectedQuantityChange = delta;        
        selectedQuantity += selectedQuantityChange;
    }
    
    public String forDisplay(){
        return "[" + product.forRestrictedDisplay() + "] x " + selectedQuantity + "\t= " + (product.getPrice() * selectedQuantity) + " DH";
    }

    public int getSelectedQuantity() {
        return selectedQuantity;
    }

    public int getSelectedQuantityChange() {
        return selectedQuantityChange;
    }

    public Product getProduct() {
        return product;
    }
}
