package com.isi.isiapi.general.classes;

import com.google.gson.annotations.SerializedName;

public class IsiFitCessioneBeni {

    @SerializedName("Id")
    public int id;
    @SerializedName("CustomerId")
    public int customerId;
    @SerializedName("BillId")
    public int billid;
    @SerializedName("Bill")
    public Bill bill;
    @SerializedName("Customer")
    public Customer customer;

    public IsiFitCessioneBeni(Bill bill, Customer customer) {
        this.bill = bill;
        this.customer = customer;
    }
}
