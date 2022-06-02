package ecommerce.core;

class ObjectNode {
    protected Object object;
    protected ObjectNode next;
    
    protected ObjectNode(Object object){
        this.object = object;
        next = null;
    }
}