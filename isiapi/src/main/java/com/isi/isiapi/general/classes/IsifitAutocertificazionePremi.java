package com.isi.isiapi.general.classes;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class IsifitAutocertificazionePremi {

    @SerializedName("Id")
    public int id;
    @SerializedName("Creation")
    public Date creation = new Date();
    @SerializedName("Euro")
    public Float euro;
    @SerializedName("Iban")
    public String iban;
    @SerializedName("Type")
    public int type;
    @SerializedName("Customer")
    public Customer customer;
    @SerializedName("CommercialLocalId")
    public String commercialLocalId;

    public IsifitAutocertificazionePremi(Float euro, String iban, int type, Customer customer) {
        this.euro = euro;
        this.iban = iban;
        this.type = type;
        this.customer = customer;
    }
}
