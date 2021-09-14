package com.isi.isiapi.general.classes;

import com.google.gson.annotations.SerializedName;

public class CommercialCategory {

    @SerializedName("Id")
    private final int id;
    @SerializedName("Description")
    private String description;

    public CommercialCategory(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

