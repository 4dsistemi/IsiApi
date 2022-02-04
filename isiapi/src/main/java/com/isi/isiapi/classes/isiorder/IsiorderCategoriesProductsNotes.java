package com.isi.isiapi.classes.isiorder;

import com.isi.isiapi.classes.Category;
import com.isi.isiapi.classes.Product;


import java.util.List;

public class IsiorderCategoriesProductsNotes {

    public Category categories;

    public List<Product> products;

    public List<IsiorderNote> notes;

    public IsiorderCategoriesProductsNotes(Category categories, List<Product> products, List<IsiorderNote> notes) {
        this.categories = categories;
        this.products = products;
        this.notes = notes;
    }
}
