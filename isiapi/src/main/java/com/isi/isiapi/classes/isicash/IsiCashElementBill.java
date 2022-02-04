package com.isi.isiapi.classes.isicash;

import com.google.gson.annotations.SerializedName;
import com.isi.isiapi.classes.LastModifiedTables;


public class IsiCashElementBill extends LastModifiedTables {

    @SerializedName("Id")
    public int id;
    @SerializedName("BillId")
    public int bill_id;
    @SerializedName("ProductId")
    public Integer product_id;
    @SerializedName("Name")
    public String name;
    @SerializedName("Price")
    public float price;
    @SerializedName("Department")
    public int department;
    @SerializedName("DiscountValor")
    public float discount_valor;
    @SerializedName("DiscountType")
    public int discount_type;
    @SerializedName("Quantity")
    public int quantity = 1;

    public IsiCashElementBill(Integer product_id, String name, float price, int department, float discount_valor, int discount_type, int quantity) {
        this.product_id = product_id;
        this.name = name;
        this.price = price;
        this.department = department;
        this.discount_valor = discount_valor;
        this.discount_type = discount_type;
        this.quantity = quantity;
    }
}
