package com.isi.isiapi.classes;


import com.google.gson.annotations.SerializedName;

public class Ingredients extends LastModifiedTables{

    @SerializedName("Id")
    public int id;

    @SerializedName("ProductFornitureId")
    public int product_forniture_id;

    @SerializedName("ProductId")
    public int product_id;

    @SerializedName("Quantity")
    public float quantity;

    public Ingredients(int product_forniture_id, int product_id, float quantity) {
        this.product_forniture_id = product_forniture_id;
        this.product_id = product_id;
        this.quantity = quantity;
    }
}
