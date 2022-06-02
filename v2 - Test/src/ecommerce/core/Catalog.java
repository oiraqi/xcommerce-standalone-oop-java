package ecommerce.core;

public class Catalog {
    private Category[] categories;
    private int numberOfCategories;
    private static final int MAX_NUMBER_OF_CATEGORIES = 10;

    public Catalog(){
        categories = new Category[MAX_NUMBER_OF_CATEGORIES];
        numberOfCategories = 0;
    }
    public void addCategory(Category category) {
        categories[numberOfCategories++] = category;
    }

    public Category[] getCategories() {
        return categories;
    }


    public int getNumberOfCategories() {
        return numberOfCategories;
    }
}
