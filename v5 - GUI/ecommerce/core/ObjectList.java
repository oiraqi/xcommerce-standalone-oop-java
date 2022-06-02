package ecommerce.core;


class ObjectList {
    private ObjectNode head;
    private ObjectNode last;
    private int size;
    
    protected ObjectList(){
        head = last = null;
        size = 0;
    }

    protected void add(Object object) {
        if(head == null)
            head = last = new ObjectNode(object);
        else{
            last.next = new ObjectNode(object);
            last = last.next;
        }
        size++;
    }


    protected Object[] toArray() {
        if(size == 0)
            return null;
        Object[] objects = new Object[size];
        int index = 0;
        for(ObjectNode walker = head; walker != null; walker = walker.next)
            objects[index++] = walker.object;
        return objects;
    }    
}
