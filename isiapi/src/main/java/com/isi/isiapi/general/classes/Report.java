package com.isi.isiapi.general.classes;

import com.google.gson.annotations.SerializedName;

public class Report {

    @SerializedName("Id")
    private final int id;

    @SerializedName("Arrival")
    private final String arrival;

    @SerializedName("DiscountValor")
    private final float discount_valor;

    @SerializedName("DiscountType")
    private final int discount_type;

    @SerializedName("SerialListLocalId")
    private final String commercial_id;

    @SerializedName("AccountId")
    private final int account_id;

    @SerializedName("PaymentType")
    private final String payment_type;

    @SerializedName("ElementBills")
    private final ElementBill[] elements;

    public Report(int id, String arrival, float discount_valor, int discount_type, String commercial_id, int account_id, String payment_type, ElementBill[] elements) {
        this.id = id;
        this.arrival = arrival;
        this.discount_valor = discount_valor;
        this.discount_type = discount_type;
        this.commercial_id = commercial_id;
        this.account_id = account_id;
        this.payment_type = payment_type;
        this.elements = elements;
    }


    public int getId() {
        return id;
    }

    public String getArrival() {
        return arrival;
    }

    public float getDiscount_valor() {
        return discount_valor;
    }

    public int getDiscount_type() {
        return discount_type;
    }

    public String getCommercial_id() {
        return commercial_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public ElementBill[] getElements() {
        return elements;
    }

    public String getPayment_type() {
        return payment_type;
    }
}

