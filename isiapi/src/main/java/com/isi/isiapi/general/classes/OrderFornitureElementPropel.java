package com.isi.isiapi.general.classes;

import com.google.gson.annotations.SerializedName;

public class OrderFornitureElementPropel {

    @SerializedName("Id")
    public int id;
    @SerializedName("OrdersToFornitureId")
    public int orders;
    @SerializedName("ProductFornitureId")
    public int product;
    @SerializedName("Quantity")
    public int quantity;
    @SerializedName("TrueQuantity")
    public int trueQuantity;
    @SerializedName("CommercialLocalId")
    public String commercial;
    @SerializedName("ProductForniture")
    public MagaProduct magaProduct;

}
