package com.isi.isiapi.general.classes;

import com.google.gson.annotations.SerializedName;

public class ElementBill{

    @SerializedName("Id")
    public int id;
    @SerializedName("BillId")
    public int billId;
    @SerializedName("ProductId")
    public Integer productId;
    @SerializedName("Name")
    public String name;
    @SerializedName("Price")
    public float price;
    @SerializedName("DepartmentId")
    public int departmentId;
    @SerializedName("DiscountValor")
    public int discountValor;
    @SerializedName("DiscountType")
    public int discountType;

    public ElementBill(Integer productId, String name, float price, int departmentId, int discountValor, int discountType) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.departmentId = departmentId;
        this.discountValor = discountValor;
        this.discountType = discountType;
    }
}
