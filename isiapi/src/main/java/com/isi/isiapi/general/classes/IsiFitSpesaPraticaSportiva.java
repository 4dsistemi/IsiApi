package com.isi.isiapi.general.classes;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class IsiFitSpesaPraticaSportiva {

    @SerializedName("Id")
    public int id;
    @SerializedName("Creation")
    public Date creation = new Date();
    @SerializedName("Amount")
    public float amount;
    @SerializedName("IsifitCausalePagamento")
    public com.isi.isifit.newApi.IsiFitCausalePagamento isiFitCausalePagamento;
    @SerializedName("IsifitSport")
    public com.isi.isifit.newApi.IsiFitSport isiFitSport;
    @SerializedName("Customer")
    public Customer customer;
    @SerializedName("CommercialLocalId")
    public String commercialLocalId;

    public IsiFitSpesaPraticaSportiva(float amount, com.isi.isifit.newApi.IsiFitCausalePagamento isiFitCausalePagamento, com.isi.isifit.newApi.IsiFitSport isiFitSport, Customer customer) {
        this.amount = amount;
        this.isiFitCausalePagamento = isiFitCausalePagamento;
        this.isiFitSport = isiFitSport;
        this.customer = customer;
    }
}
