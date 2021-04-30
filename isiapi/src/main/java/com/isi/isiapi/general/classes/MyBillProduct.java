package com.isi.isiapi.general.classes;

import com.google.gson.annotations.SerializedName;

public class MyBillProduct extends BillProduct{

    @SerializedName("number")
    private int number = 0;
    @SerializedName("id")
    private int id;

    public MyBillProduct(String name, float price, int rep) {
        super(0, name, price, rep);
    }

    public void setNumber(int barcode) {
        this.number = barcode;
    }

    public int getNumber() {
        return number;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
