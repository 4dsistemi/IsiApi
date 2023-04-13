package com.isi.isiapi.classes;


public class Ingredients extends LastModifiedTables{

    
    public int id;

    
    public int product_forniture_id;

    
    public int product_id;

    
    public float quantity;

    public Ingredients(int product_forniture_id, int product_id, float quantity) {
        this.product_forniture_id = product_forniture_id;
        this.product_id = product_id;
        this.quantity = quantity;
    }
}
