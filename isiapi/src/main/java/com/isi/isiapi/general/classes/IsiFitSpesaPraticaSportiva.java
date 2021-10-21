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
    public IsiFitCausalePagamento isiFitCausalePagamento;
    @SerializedName("IsifitSport")
    public IsiFitSport isiFitSport;
    @SerializedName("Customer")
    public Customer customer;
    @SerializedName("CommercialLocalId")
    public String commercialLocalId;
    @SerializedName("PaymentType")
    public String paymentType;

    public IsiFitSpesaPraticaSportiva(float amount, IsiFitCausalePagamento isiFitCausalePagamento, IsiFitSport isiFitSport, Customer customer, String paymentType) {
        this.amount = amount;
        this.isiFitCausalePagamento = isiFitCausalePagamento;
        this.isiFitSport = isiFitSport;
        this.customer = customer;
        this.paymentType = paymentType;
    }
}
