package com.isi.isiapi.classes;

import com.google.gson.annotations.SerializedName;

public class Product extends LastModifiedTables{

    @SerializedName("Id")
    public int id;

    @SerializedName("Name")
    public String name;

    @SerializedName("Price")
    public float price;

    @SerializedName("PriceBanco")
    public float price_banco;

    @SerializedName("Color")
    public Integer color;

    @SerializedName("Department")
    public int department;

    @SerializedName("CategoryId")
    public int category_id;

    @SerializedName("BarcodeValue")
    public String barcode_value;

    @SerializedName("Image")
    public String image;

    @SerializedName("Description")
    public String description;

    @SerializedName("ConnectionProduct")
    public Integer connection_product = null;

    @SerializedName("PriorityProd")
    public int priority_prod = 0;

    @SerializedName("Active")
    public int active = 1;

    @SerializedName("Guest")
    public int guest = 1;


    public Product(String name, float price, float price_banco, int department, String barcode_value, Integer color, int category_id, String image, String description, Integer connection_product) {
        this.name = name;
        this.price = price;
        this.price_banco = price_banco;
        this.department = department;
        this.barcode_value = barcode_value;
        this.color = color;
        this.category_id = category_id;
        this.image = image;
        this.description = description;
        this.connection_product = connection_product;
    }

    @Override
    public String toString() {
        return name;
    }
}
