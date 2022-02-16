package com.isi.isiapi.classes.isiorder;

import com.google.gson.annotations.SerializedName;

public class IsiorderGuestOrderElement {

    @SerializedName("Id")
    public int id;

    @SerializedName("ProductId")
    public int product_id;

    @SerializedName("Quantity")
    public int quantity;

    @SerializedName("IsiorderGuestOrderId")
    public int isiorder_guest_order_id;

    @SerializedName("Name")
    public String name;

    @SerializedName("Price")
    public float price;

}
