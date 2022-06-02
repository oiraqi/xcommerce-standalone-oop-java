package ecommerce.core;


class OrderNode {
    protected Order order;
    protected OrderNode next;
    
    public OrderNode(Order order){
        this.order = order;
    }
}
