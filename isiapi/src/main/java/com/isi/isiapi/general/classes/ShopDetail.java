package com.isi.isiapi.general.classes;

import com.google.gson.annotations.SerializedName;

//Classe dei dettagli di uno shop
public class ShopDetail {

    @SerializedName("Id")
    private final int id;
    @SerializedName("Name")
    private String name;
    @SerializedName("Society")
    private String society;
    @SerializedName("Property")
    private String property;
    @SerializedName("Address")
    private String address;
    @SerializedName("Phone")
    private String phone;
    @SerializedName("Iva")
    private String iva;
    @SerializedName("Website")
    private String webSite;
    @SerializedName("Cap")
    private String cap;
    @SerializedName("Email")
    private String email;
    @SerializedName("Description")
    private String description;

    public ShopDetail(int id, String name, String society, String property, String address, String phone, String iva, String webSite
            , String cap, String email, String description) {
        this.id = id;
        this.name = name;
        this.society = society;
        this.property = property;
        this.address = address;
        this.phone = phone;
        this.iva = iva;
        this.webSite = webSite;
        this.cap = cap;
        this.email = email;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSociety() {
        return society;
    }

    public void setSociety(String society) {
        this.society = society;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
