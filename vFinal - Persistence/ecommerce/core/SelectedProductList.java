package ecommerce.core;

class SelectedProductList {
    private SelectedProductNode head;
    private SelectedProductNode last;
    private int size;
    
    public SelectedProductList(){
        head = last = null;
        size = 0;
    }

    public void add(SelectedProduct selectedProduct) {
        if(head == null)
            head = last = new SelectedProductNode(selectedProduct);
        else{
            last.next = new SelectedProductNode(selectedProduct);
            last = last.next;
        }
        size++;
    }
    
    public void remove(String productId){
        if(head == null)
            return;
        if(head.selectedProduct.getProduct().getId().equals(productId)){ //caution: do not use ==
            if(last == head)
                last = head.next;   //do not forget to update last
            head = head.next;
            size--;
        }else{
            SelectedProductNode previous = head;
            for(; previous.next != null; previous = previous.next){
                if(previous.next.selectedProduct.getProduct().getId().equals(productId)){
                    if(last == previous.next)
                        last = previous;
                    previous.next = previous.next.next;
                    size--;
                    break;
                }
            }            
        }
    }

    public SelectedProduct[] toArray() {
        SelectedProduct[] selectedProducts = new SelectedProduct[size];
        int index = 0;
        for(SelectedProductNode walker = head; walker != null; walker = walker.next)
            selectedProducts[index++] = walker.selectedProduct;
        return selectedProducts;
    }
    
    public SelectedProduct searchByProduct(AbstractProduct product){
        for(SelectedProductNode walker = head; walker != null; walker = walker.next)
            if(walker.selectedProduct.getProduct() == product)
                return walker.selectedProduct;
        return null;
    }
    
    public SelectedProduct searchByProductId(String productId){
        for(SelectedProductNode walker = head; walker != null; walker = walker.next)
            if(walker.selectedProduct.getProduct().getId().equals(productId)) //caution: do not use ==
                return walker.selectedProduct;
        return null;
    }
    
    public String forDisplay(){
        StringBuffer selectedProductsForDisplay = new StringBuffer();
        for(SelectedProductNode walker = head; walker != null; walker = walker.next)
            selectedProductsForDisplay.append(walker.selectedProduct.forDisplay() + "\n");
        return selectedProductsForDisplay.toString();
    }
}
