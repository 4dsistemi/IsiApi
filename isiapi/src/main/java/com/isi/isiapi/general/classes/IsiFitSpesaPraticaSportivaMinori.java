package com.isi.isiapi.general.classes;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class IsiFitSpesaPraticaSportivaMinori {

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
    @SerializedName("Son")
    public Customer son;
    @SerializedName("CommercialLocalId")
    public String commercialLocalId;
    @SerializedName("PaymentType")
    public String paymentType;

    public IsiFitSpesaPraticaSportivaMinori(float amount, IsiFitCausalePagamento isiFitCausalePagamento, IsiFitSport isiFitSport, Customer customer, Customer son, String paymentType) {
        this.amount = amount;
        this.isiFitCausalePagamento = isiFitCausalePagamento;
        this.isiFitSport = isiFitSport;
        this.customer = customer;
        this.son = son;
        this.paymentType = paymentType;

    }
}
