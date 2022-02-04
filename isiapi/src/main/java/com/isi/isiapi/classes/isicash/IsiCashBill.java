package com.isi.isiapi.classes.isicash;

import com.google.gson.annotations.SerializedName;
import com.isi.isiapi.classes.LastModifiedTables;

import java.util.Date;


public class IsiCashBill extends LastModifiedTables {

    @SerializedName("Id")
    public int id;
    @SerializedName("Arrival")
    public Date arrival = new Date();
    @SerializedName("DiscountValor")
    public float discount_valor;
    @SerializedName("DiscountType")
    public int discount_type;
    @SerializedName("AccountId")
    public int account_id;
    @SerializedName("PaymentType")
    public String payment_type;
    @SerializedName("Total")
    public float total;
    @SerializedName("ClosureNumber")
    public int closure_number;
    @SerializedName("DocumentNumber")
    public int document_number;
    @SerializedName("Status")
    public int status = 0;

    public IsiCashBill(float discount_valor, int discount_type, int account_id, String payment_type, float total, int closure_number, int document_number) {
        this.discount_valor = discount_valor;
        this.discount_type = discount_type;
        this.account_id = account_id;
        this.payment_type = payment_type;
        this.total = total;
        this.closure_number = closure_number;
        this.document_number = document_number;
    }
}
