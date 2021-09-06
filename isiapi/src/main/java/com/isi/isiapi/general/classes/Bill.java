package com.isi.isiapi.general.classes;

import com.google.gson.annotations.SerializedName;
import com.isi.isiapi.general.classes.ElementBill;

import java.util.ArrayList;
import java.util.Date;

public class Bill {

    @SerializedName("Id")
    public int id;
    @SerializedName("Arrival")
    public Date arrival;
    @SerializedName("DiscountValor")
    public int discountValor;
    @SerializedName("DiscountType")
    public int discountType;
    @SerializedName("SerialListLocalId")
    public String commercial;
    @SerializedName("AccountId")
    public int accountId;
    @SerializedName("PaymentType")
    public String paymentType;
    @SerializedName("Total")
    public float total;
    @SerializedName("ElementBills")
    public ArrayList<ElementBill> elements;

    public Bill(int discountValor, int discountType, int accountId, String paymentType, float total, ArrayList<ElementBill> elements) {
        this.discountValor = discountValor;
        this.discountType = discountType;
        this.accountId = accountId;
        this.paymentType = paymentType;
        this.total = total;
        this.elements = elements;
    }
}
