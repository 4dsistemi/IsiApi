package com.isi.isiapi.general.classes;

import com.google.gson.annotations.SerializedName;

public class InformationAboutCommercial {

    @SerializedName("Id")
    private final int id;
    @SerializedName("SerialListLocalId")
    private final String serial_list_local_id;
    @SerializedName("Name")
    private final String name;
    @SerializedName("Society")
    private final String society;
    @SerializedName("Property")
    private final String property;
    @SerializedName("Address")
    private final String address;
    @SerializedName("Phone")
    private final String phone;
    @SerializedName("Iva")
    private final String iva;
    @SerializedName("Website")
    private final String website;
    @SerializedName("Cap")
    private final String cap;

    public InformationAboutCommercial(int id, String serial_list_local_id, String name, String society, String property, String address, String phone, String iva, String website, String cap) {
        this.id = id;
        this.serial_list_local_id = serial_list_local_id;
        this.name = name;
        this.society = society;
        this.property = property;
        this.address = address;
        this.phone = phone;
        this.iva = iva;
        this.website = website;
        this.cap = cap;
    }

    public int getId() {
        return id;
    }

    public String getSerial_list_local_id() {
        return serial_list_local_id;
    }

    public String getName() {
        return name;
    }

    public String getSociety() {
        return society;
    }

    public String getProperty() {
        return property;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getIva() {
        return iva;
    }

    public String getWebsite() {
        return website;
    }

    public String getCap() {
        return cap;
    }
}
