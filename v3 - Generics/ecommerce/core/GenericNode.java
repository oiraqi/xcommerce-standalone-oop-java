package ecommerce.core;

import java.io.Serializable;

class GenericNode<T extends Displayable> implements Serializable{
    protected T object;
    protected GenericNode<T> next;
    
    protected GenericNode(T object){
        this.object = object;
        next = null;
    }
}