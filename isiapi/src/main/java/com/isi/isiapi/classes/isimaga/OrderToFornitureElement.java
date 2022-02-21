package com.isi.isiapi.classes.isimaga;

import com.google.gson.annotations.SerializedName;

public class OrderToFornitureElement {

    @SerializedName("Id")
    public int id;

    @SerializedName("OrderToFornitureId")
    public int order_to_forniture_id;

    @SerializedName("ProductFornitureId")
    public int product_forniture_id;

    @SerializedName("Quantity")
    public int quantity;

    @SerializedName("TrueQuantity")
    public Integer true_quantity = 0;

    public OrderToFornitureElement(int product_forniture_id, int quantity) {
        this.product_forniture_id = product_forniture_id;
        this.quantity = quantity;
    }
}
