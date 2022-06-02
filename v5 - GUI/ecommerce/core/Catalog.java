package ecommerce.core;

import java.util.Arrays;

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
        Category[] cats = new Category[numberOfCategories];
        for(int i = 0; i < numberOfCategories; i++)
            cats[i] = categories[i];        
        return cats;
    }
    
    public int getNumberOfCategories() {
        return numberOfCategories;
    }
}
