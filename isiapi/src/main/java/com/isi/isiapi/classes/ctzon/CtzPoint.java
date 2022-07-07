package com.isi.isiapi.classes.ctzon;

import com.google.gson.annotations.SerializedName;

public class CtzPoint {

    @SerializedName("Id")
    public int id;

    @SerializedName("AccountId")
    public int accountId;

    @SerializedName("CommercialLocalId")
    public String commercialLocalId;

    @SerializedName("Points")
    public int points;

}
