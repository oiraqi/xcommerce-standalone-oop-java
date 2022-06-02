package ecommerce.core;

import java.io.Serializable;

import java.util.ArrayList;

class GenericList<T extends Displayable> implements Displayable, Serializable{
    private GenericNode<T> head;
    private GenericNode<T> last;
    private int size;

    protected GenericList(){
        head = last = null;
        size = 0;
    }

    protected void add(T object) {
        if(head == null)
            head = last = new GenericNode<T>(object);
        else{
            last.next = new GenericNode<T>(object);
            last = last.next;
        }
        size++;
    }

    protected T get(int index){
        if(index < 0 && index >= size)
            throw new ArrayIndexOutOfBoundsException(index);
        GenericNode<T> walker = head;
        int i = 0;
        for(; walker != null && i <= index; walker = walker.next);
        return walker.object;
    }

    protected Object[] toArray() {
        if(size == 0)
            return null;
        Object[] objects = new Object[size];
        int index = 0;
        for(GenericNode<T> walker = head; walker != null; walker = walker.next)
            objects[index++] = walker.object;
        return objects;
    }

    public String forDisplay(){
        StringBuffer sb = new StringBuffer();
        for(GenericNode<T> walker = head; walker != null; walker = walker.next){
            sb.append(walker.object.forDisplay());
            sb.append("\n");
        }
        return sb.toString();
    }

    protected T search(T object){
        for(GenericNode<T> walker = head; walker != null; walker = walker.next)
            if(walker.object.equals(object))
                return walker.object;
        return null;
    }
}
