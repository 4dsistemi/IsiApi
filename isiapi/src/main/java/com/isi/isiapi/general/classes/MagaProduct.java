package com.isi.isiapi.general.classes;

import com.google.gson.annotations.SerializedName;

public class MagaProduct {

    @SerializedName("Id")
    public int id;

    @SerializedName("Name")
    public String name;

    @SerializedName("BarcodeValue")
    public String barcode_value;

    @SerializedName("StorageCategoriesId")
    public String storage_categories_id;

    @SerializedName("UnityId")
    public String unity_id;

    @SerializedName("Price")
    public float price;

    @SerializedName("Quantity")
    public float quantity;

    @SerializedName("BlisterPieces")
    public int blister_pieces;

    @SerializedName("FornitureId")
    public Integer forniture_id;

    @SerializedName("CommercialLocalId")
    private String commercial_local_id;

    @SerializedName("Deadline")
    public float deadline;

    @SerializedName("Reorder")
    public int reorder;

    @SerializedName("InMaga")
    public float in_maga;

    public MagaProduct(String name, String barcode_value, String storage_categories_id, String unity_id, float price, float quantity, int blister_pieces, Integer forniture_id, float deadline, int reorder) {
        this.name = name;
        this.barcode_value = barcode_value;
        this.storage_categories_id = storage_categories_id;
        this.unity_id = unity_id;
        this.price = price;
        this.quantity = quantity;
        this.blister_pieces = blister_pieces;
        this.forniture_id = forniture_id;
        this.deadline = deadline;
        this.reorder = reorder;
    }
}

