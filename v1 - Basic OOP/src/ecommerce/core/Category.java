package ecommerce.core;


public class Category {
    private ProductList products;
    private String name; //read-only

    public Category(String name){
        this.name = name;
        products = new ProductList();
    }

    public void addProduct(Product product) {
        products.add(product);
        product.setCategory(this); //add category to product
    }

    public String getName() {
        return name;
    }

    public Product[] getProducts(){
        return products.toArray();
    }
}
