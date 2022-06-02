package ecommerce.core;


class OrderNode {
    public Order order;
    public OrderNode next;
    
    public OrderNode(Order order){
        this.order = order;
    }
}
