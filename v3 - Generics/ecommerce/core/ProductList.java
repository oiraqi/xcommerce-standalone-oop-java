package ecommerce.core;


class ProductList {
    private ProductNode head;
    private ProductNode last;
    private int size;
    
    protected ProductList(){
        head = last = null;
        size = 0;
    }

    protected void add(AbstractProduct product) {
        if(head == null)
            head = last = new ProductNode(product);
        else{
            last.next = new ProductNode(product);
            last = last.next;
        }
        size++;
    }


    protected AbstractProduct[] toArray() {
        if(size == 0)
            return null;
        AbstractProduct[] products = new AbstractProduct[size];
        int index = 0;
        for(ProductNode walker = head; walker != null; walker = walker.next)
            products[index++] = walker.product;
        return products;
    }    
}
