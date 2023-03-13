package com.isi.isiapi.classes.isimaga;


import com.google.gson.annotations.SerializedName;
import com.isi.isiapi.classes.LastModifiedTables;

public class ProductForniture extends LastModifiedTables {

    
    public int id;

    
    public String name;

    
    public String barcode_value;

    
    public int unity_id;

    
    public float price;

    
    public float quantity;

    
    public int blister_pieces;

    
    public Integer forniture_id;

    
    public float deadline;

    
    public int reorder;

    
    public float in_maga;

    public ProductForniture(String name, String barcode_value, int unity_id, float price, float quantity, int blister_pieces, Integer forniture_id, float deadline, int reorder) {
        this.name = name;
        this.barcode_value = barcode_value;
        this.unity_id = unity_id;
        this.price = price;
        this.quantity = quantity;
        this.blister_pieces = blister_pieces;
        this.forniture_id = forniture_id;
        this.deadline = deadline;
        this.reorder = reorder;
    }
}
