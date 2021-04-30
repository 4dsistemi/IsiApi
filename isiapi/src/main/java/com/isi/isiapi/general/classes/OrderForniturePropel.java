package com.isi.isiapi.general.classes;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class OrderForniturePropel {

    @SerializedName("Id")
    public int id;
    @SerializedName("Arrival")
    public String arrival;
    @SerializedName("Status")
    public int status;
    @SerializedName("FornitureId")
    public int forniture_id;
    @SerializedName("CommercialLocalId")
    public String commercial;
    @SerializedName("OrdersToFornitureElementss")
    public ArrayList<OrderFornitureElementPropel> elements;
    @SerializedName("Forniture")
    public Forniture forniture;
}
