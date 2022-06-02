package ecommerce.core;


class ProductNode {
    protected AbstractProduct product;
    protected ProductNode next;
    
    public ProductNode(AbstractProduct product){
        this.product = product;
        next = null;
    }
}
