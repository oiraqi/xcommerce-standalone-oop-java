package ecommerce.core;


class SelectedProductNode {
    public SelectedProduct selectedProduct;
    public SelectedProductNode next;
    
    public SelectedProductNode(SelectedProduct selectedProduct){
        this.selectedProduct = selectedProduct;
        next = null;
    }
}
