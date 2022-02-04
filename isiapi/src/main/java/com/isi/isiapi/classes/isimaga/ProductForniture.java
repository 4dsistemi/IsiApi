package com.isi.isiapi.classes.isimaga;


import com.google.gson.annotations.SerializedName;
import com.isi.isiapi.classes.LastModifiedTables;

public class ProductForniture extends LastModifiedTables {

    @SerializedName("Id")
    public int id;

    @SerializedName("Name")
    public String name;

    @SerializedName("BarcodeValue")
    public String barcode_value;

    @SerializedName("UnityId")
    public int unity_id;

    @SerializedName("Price")
    public float price;

    @SerializedName("Quantity")
    public float quantity;

    @SerializedName("BlisterPieces")
    public int blister_pieces;

    @SerializedName("FornitureId")
    public Integer forniture_id;

    @SerializedName("Deadline")
    public float deadline;

    @SerializedName("Reorder")
    public int reorder;

    @SerializedName("InMaga")
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
