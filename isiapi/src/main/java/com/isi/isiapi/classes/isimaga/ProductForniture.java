package com.isi.isiapi.classes.isimaga;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;
import com.isi.isiapp.serverAndApi.database.classes.LastModifiedTables;

@Entity(tableName = "product_forniture", foreignKeys = {@ForeignKey(entity = Forniture.class, parentColumns = "id", childColumns = "forniture_id")})
public class ProductForniture extends LastModifiedTables {

    @PrimaryKey(autoGenerate = true)
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
