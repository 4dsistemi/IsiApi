package com.isi.isiapi.general.classes;

import com.google.gson.annotations.SerializedName;

public class Bike {

    @SerializedName("Id")
    public int id;

    @SerializedName("MatricNumber")
    public String matricNumber;

    @SerializedName("Model")
    public String model;

    @SerializedName("IsReserved")
    public boolean reserved;

    @SerializedName("CommercialLocalId")
    public String commercial;


    @SerializedName("BikeHourPrice")
    public float price;


    public Bike(int id, String matricNumber, String model, boolean reserved, String commercial , float price) {
        this.id = id;
        this.matricNumber = matricNumber;
        this.model = model;
        this.reserved = reserved;
        this.commercial = commercial;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getMatricNumber() {
        return matricNumber;
    }

    public String getModel() {
        return model;
    }

    public boolean isReserved() {
        return reserved;
    }

    public String getCommercial() {
        return commercial;
    }

    public float getPrice(){return price;}

    @Override
    public String toString() {
        return matricNumber;
    }
}
