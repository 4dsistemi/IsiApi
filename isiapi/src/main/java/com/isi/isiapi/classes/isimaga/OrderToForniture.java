package com.isi.isiapi.classes.isimaga;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class OrderToForniture {

    @SerializedName("Id")
    public int id;

    @SerializedName("Arrival")
    public Date arrival = new Date();

    @SerializedName("Status")
    public int status = 0;

    @SerializedName("FornitureId")
    public int forniture_id;

    public OrderToForniture(int forniture_id) {
        this.forniture_id = forniture_id;
    }
}
