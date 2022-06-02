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


    public SelectedProduct[] toArray() {
        SelectedProduct[] selectedProducts = new SelectedProduct[size];
        int index = 0;
        for(SelectedProductNode walker = head; walker != null; walker = walker.next)
            selectedProducts[index++] = walker.selectedProduct;
        return selectedProducts;
    }
}
