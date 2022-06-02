package ecommerce.core;


public class SelectedProduct {
    private Product product;
    private int selectedQuantity;
    
    public SelectedProduct(Product product, int selectedQuantity){
        this.product = product;
        if(product instanceof RealProduct && selectedQuantity > ((RealProduct)product).getQuantity())
            this.selectedQuantity = ((RealProduct)product).getQuantity();
        else
            this.selectedQuantity = selectedQuantity;
    }
    
    public void updateSelectedQuantity(int delta){
        if (selectedQuantity + delta < 0)
            selectedQuantity = 0;
        else if(product instanceof RealProduct && selectedQuantity + delta > ((RealProduct)product).getQuantity())
            selectedQuantity = ((RealProduct)product).getQuantity();
        else
            selectedQuantity += delta;
    }
    
    public String forDisplay(){
        return product.forDisplay() + " x " + selectedQuantity;
    }
}
