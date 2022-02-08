package com.isi.isiapi.classes;

import java.util.List;


public class CategoryAndProduct {
    public Category category;

    public List<Product> product;

    @Override
    public String toString() {
        return category.name;
    }
}
