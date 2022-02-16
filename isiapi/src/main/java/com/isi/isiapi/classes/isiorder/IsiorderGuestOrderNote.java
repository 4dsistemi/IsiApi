package com.isi.isiapi.classes.isiorder;

import com.google.gson.annotations.SerializedName;

public class IsiorderGuestOrderNote {

    @SerializedName("Id")
    public int id;

    @SerializedName("IsiorderNoteId")
    public int isiorder_note_id;

    @SerializedName("IsiorderGuestOrderElementId")
    public int isiorder_guest_order_element_id;

    @SerializedName("Name")
    public String name;

    @SerializedName("Price")
    public float price;

}