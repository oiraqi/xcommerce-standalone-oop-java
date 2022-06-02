package ecommerce.core;

import java.io.Serializable;


public class SelectedProduct implements Displayable, Serializable{
    private AbstractProduct product;
    private int selectedQuantity;
    private int selectedQuantityChange; //the change in the selected quantity since its last update
    
    protected SelectedProduct(AbstractProduct product, int selectedQuantity){
        this.product = product;
        if(product instanceof RealProduct && selectedQuantity > ((RealProduct)product).getQuantity())
            this.selectedQuantity = ((RealProduct)product).getQuantity();
        else
            this.selectedQuantity = selectedQuantity;
        selectedQuantityChange = selectedQuantity;
    }
    
    protected void updateSelectedQuantity(int delta){
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

    protected int getSelectedQuantity() {
        return selectedQuantity;
    }

    protected int getSelectedQuantityChange() {
        return selectedQuantityChange;
    }

    protected AbstractProduct getProduct() {
        return product;
    }
    
    public boolean equals(Object object){
        if(!(object instanceof SelectedProduct))
            return false;
        return ((SelectedProduct)object).getProduct().equals(product);
    }
}
