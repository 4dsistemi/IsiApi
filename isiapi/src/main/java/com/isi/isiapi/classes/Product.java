package com.isi.isiapi.classes;

import com.google.gson.annotations.SerializedName;

public class Product extends LastModifiedTables{

    
    public int id;

    
    public String name;

    
    public float price;

    
    public float price_banco;

    
    public Integer color;

    
    public int department;

    
    public int category_id;

    
    public String barcode_value;

    
    public String image;

    
    public String description;

    
    public Integer connection_product = null;

    
    public int priority_prod = 0;

    
    public int active = 1;

    
    public int guest = 1;


    public Product(String name, float price, float price_banco, int department, String barcode_value, Integer color, int category_id, String image, String description, Integer connection_product) {
        this.name = name;
        this.price = price;
        this.price_banco = price_banco;
        this.department = department;
        this.barcode_value = barcode_value;
        this.color = color;
        this.category_id = category_id;
        this.image = image;
        this.description = description;
        this.connection_product = connection_product;
    }

    @Override
    public String toString() {
        return name;
    }
}
