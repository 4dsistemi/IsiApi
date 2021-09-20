package com.isi.isiapi.general.classes;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class IsicoinMovement {

    @SerializedName("Id")
    private int id;
    @SerializedName("Creation")
    private Date creation;
    @SerializedName("Amount")
    private int amount;
    @SerializedName("Description")
    private String description;
    @SerializedName("Type")
    private int type;
    @SerializedName("CommercialLocalId")
    private String CommercialLocalid;

    public IsicoinMovement(Date creation, int amount, String description, int type) {
        this.creation = creation;
        this.amount = amount;
        this.description = description;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCommercialLocalid() {
        return CommercialLocalid;
    }

    public void setCommercialLocalid(String commercialLocalid) {
        CommercialLocalid = commercialLocalid;
    }
}
