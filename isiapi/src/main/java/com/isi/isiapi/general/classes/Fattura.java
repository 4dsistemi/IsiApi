package com.isi.isiapi.general.classes;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Fattura {

    @SerializedName("Id")
    public int id;
    @SerializedName("Arrival")
    public String arrival;
    @SerializedName("PaymentType")
    public boolean payed;
    @SerializedName("ElementBills")
    public ArrayList<ElementBill> elements;
    @SerializedName("Fattures")
    public ArrayList<FatturaIn> fattures;
}

