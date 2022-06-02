package ecommerce.core;


class ProductNode {
    public Product product;
    public ProductNode next;
    
    public ProductNode(Product product){
        this.product = product;
        next = null;
    }
}
