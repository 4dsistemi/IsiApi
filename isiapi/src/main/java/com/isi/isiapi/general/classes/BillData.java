package com.isi.isiapi.general.classes;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BillData {

    @SerializedName("Id")
    public int id;
    @SerializedName("Arrival")
    public String arrival;
    @SerializedName("Payed")
    public boolean payed;
    @SerializedName("Color")
    public int color;
    @SerializedName("Master")
    public int master;
    @SerializedName("elements")
    public ArrayList<ElementData> elements;

}

