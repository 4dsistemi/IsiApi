package com.isi.isiapi.general.classes;

import com.google.gson.annotations.SerializedName;

public class StorageRemovingElement {

    @SerializedName("id")
    private int id;

    @SerializedName("quantity")
    private float quantity;


    public StorageRemovingElement(int id, float quantity) {
        this.id = id;
        this.quantity = quantity;
    }
}
