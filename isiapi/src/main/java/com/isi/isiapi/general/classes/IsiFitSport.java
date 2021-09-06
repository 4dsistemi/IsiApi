package com.isi.isiapi.general.classes;

import com.google.gson.annotations.SerializedName;

public class IsiFitSport {

    @SerializedName("Id")
    public int id;
    @SerializedName("Description")
    public String description;
    @SerializedName("Active")
    public int active = 1;
    @SerializedName("CommercialLocalId")
    public String commercialLocalId;

    public IsiFitSport(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
