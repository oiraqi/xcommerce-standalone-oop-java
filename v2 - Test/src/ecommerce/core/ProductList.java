package ecommerce.core;


class ProductList {
    private ProductNode head;
    private ProductNode last;
    private int size;
    
    public ProductList(){
        head = last = null;
        size = 0;
    }

    public void add(Product product) {
        if(head == null)
            head = last = new ProductNode(product);
        else{
            last.next = new ProductNode(product);
            last = last.next;
        }
        size++;
    }


    public Product[] toArray() {
        Product[] products = new Product[size];
        int index = 0;
        for(ProductNode walker = head; walker != null; walker = walker.next)
            products[index++] = walker.product;
        return products;
    }    
}
