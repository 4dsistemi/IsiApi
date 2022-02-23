package com.isi.isiapi.classes.isishop;


import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class IsicoinMovement {

    @SerializedName("Id")
    public int id;

    @SerializedName("Creation")
    public Date creation = new Date();

    @SerializedName("Amount")
    public int amount;

    @SerializedName("Description")
    public String description;

    @SerializedName("Type")
    public int type;

    public IsicoinMovement(int amount, String description, int type) {
        this.amount = amount;
        this.description = description;
        this.type = type;
    }
}
