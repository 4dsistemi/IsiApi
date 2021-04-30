package com.isi.isiapi.general.classes;

import com.google.gson.annotations.SerializedName;

public class ElementBill{

    @SerializedName("Id")
    private final int id;

    @SerializedName("BillId")
    private final int bill_id;

    @SerializedName("ProductId")
    private final int product_id;

    @SerializedName("Name")
    private final String name;

    @SerializedName("Price")
    private final float price;

    @SerializedName("DepartmentId")
    private final int department_id;

    @SerializedName("DiscountValor")
    private final float discount_valor;

    @SerializedName("DiscountType")
    private final int discount_type;

    public ElementBill(int id, int bill_id, int product_id, String name, float price, int department_id, float discount_valor, int discount_type) {
        this.id = id;
        this.bill_id = bill_id;
        this.product_id = product_id;
        this.name = name;
        this.price = price;
        this.department_id = department_id;
        this.discount_valor = discount_valor;
        this.discount_type = discount_type;
    }

    public int getId() {
        return id;
    }

    public int getBill_id() {
        return bill_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public float getDiscount_valor() {
        return discount_valor;
    }

    public int getDiscount_type() {
        return discount_type;
    }
}
