package com.isi.isiapi.general.classes;

import com.google.gson.annotations.SerializedName;

public class Forniture {

    @SerializedName("Id")
    public int id;

    @SerializedName("CommercialLocalId")
    public String commercial_local_id;

    @SerializedName("Name")
    public String name;

    @SerializedName("Email")
    public String email;

    @SerializedName("Phone")
    public String phone;

    @SerializedName("Active")
    public boolean active;

    public Forniture(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
