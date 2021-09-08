package com.isi.isiapi.general.classes;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class IsifitRicevutaUtilizzoGratuito {

    @SerializedName("Id")
    public int id;
    @SerializedName("Creation")
    public Date creation = new Date();
    @SerializedName("Customer")
    public Customer customer;
    @SerializedName("Son")
    public Customer son;
    @SerializedName("CommercialLocalId")
    public String commercialLocalId;
    @SerializedName("Type")
    public int type;

    public IsifitRicevutaUtilizzoGratuito(Customer customer, Customer son, int type) {
        this.customer = customer;
        this.son = son;
        this.type = type;
    }
}
