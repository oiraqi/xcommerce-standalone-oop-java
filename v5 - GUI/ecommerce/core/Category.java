package ecommerce.core;

import java.io.Serializable;

public class Category implements Serializable{
    //private ProductList products;
    private GenericList<AbstractProduct> products;
    private String name; //read-only

    public Category(String name){
        this.name = name;
        //products = new ProductList();
        products = new GenericList<AbstractProduct>();
    }
    public void addProduct(AbstractProduct product) {
        products.add(product);        
        product.setCategory(this); //add category to product
    }

    public String getName() {
        return name;
    }
    
    public AbstractProduct[] getProducts(){
        Object[] temp = products.toArray();
        if(temp == null)
            return null;
        AbstractProduct[] productsArray = new AbstractProduct[temp.length];
        int index = 0;
        for(Object object : temp)
            productsArray[index++] = (AbstractProduct)object;
        return productsArray;
    }
}
