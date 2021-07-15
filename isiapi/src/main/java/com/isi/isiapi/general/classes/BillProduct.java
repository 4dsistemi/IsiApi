package com.isi.isiapi.general.classes;

import com.google.gson.annotations.SerializedName;

public class BillProduct {
    @SerializedName("Quantity")
    private int quantity = 1;
    @SerializedName("Id")
    private final Integer id;
    @SerializedName("Name")
    private final String name;
    @SerializedName("Price")
    private final float price;
    @SerializedName("Discount")
    private Discount discount = null;
    @SerializedName("Rep")
    private final int rep;

    public BillProduct(Integer product_id, String name, float price, int rep) {
        this.name = name;
        this.price = price;
        this.rep = rep;
        id = product_id;
    }

    public BillProduct(Integer id, String name, float price, int rep, int quantity) {
        this.quantity = quantity;
        this.id = id;
        this.name = name;
        this.price = price;
        this.rep = rep;
    }

    public int getCode() {
        return this.rep;
    }

    public String getName() {
        return this.name;
    }

    public float getPrice() {
        return this.price;
    }

    public void increaseQuantity(int quantity) {
        this.quantity += quantity;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public Discount getDiscount() {
        return this.discount;
    }

    public Integer getId() {
        return id;
    }
}