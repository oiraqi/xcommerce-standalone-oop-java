package ecommerce.core;


class OrderList {
    private OrderNode head;
    private OrderNode last;
    private int size;
    
    public OrderList(){
        head = last = null;
        size = 0;
    }

    public void add(Order order) {
        if(head == null)
            head = last = new OrderNode(order);
        else{
            last.next = new OrderNode(order);
            last = last.next;
        }
        size++;
    }


    public Order[] toArray() {
        Order[] orders = new Order[size];
        int index = 0;
        for(OrderNode walker = head; walker != null; walker = walker.next)
            orders[index++] = walker.order;
        return orders;
    }
}
