package com.isi.isiapi.general.classes;

import com.google.gson.annotations.SerializedName;

public class OrderFornitureElement {

    @SerializedName("Quantity")
    private int quantity;
    @SerializedName("Product")
    private final MagaProduct product;

    public OrderFornitureElement(int quantity, MagaProduct product) {
        this.quantity = quantity;
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public MagaProduct getProduct() {
        return product;
    }
}