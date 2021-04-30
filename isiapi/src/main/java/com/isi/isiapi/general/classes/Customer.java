package com.isi.isiapi.general.classes;

import com.google.gson.annotations.SerializedName;

public class Customer {

    @SerializedName("Id")
    private int id = 0;
    @SerializedName("Name")
    private String name;
    @SerializedName("Surname")
    private String surname;
    @SerializedName("Iva")
    private String iva;
    @SerializedName("Email")
    private String email;
    @SerializedName("Address")
    private String address;
    @SerializedName("City")
    private String city;
    @SerializedName("Province")
    private String province;
    @SerializedName("Zip")
    private String zip;
    @SerializedName("Country")
    private String country;
    @SerializedName("Phone")
    private String phone;
    @SerializedName("Pec")
    private String pec;
    @SerializedName("AeCode")
    private String aeCode;
    @SerializedName("Birthday")
    private String birthday;
    @SerializedName("Society")
    private String society;
    @SerializedName("Fiscal")
    private String fiscal;

    public Customer(String name, String surname, String iva, String email, String address, String city, String province, String zip, String country, String phone, String pec, String aeCode, String birthday, String society, String fiscal) {
        this.name = name;
        this.surname = surname;
        this.iva = iva;
        this.email = email;
        this.address = address;
        this.city = city;
        this.province = province;
        this.zip = zip;
        this.country = country;
        this.phone = phone;
        this.pec = pec;
        this.aeCode = aeCode;
        this.birthday = birthday;
        this.society = society;
        this.fiscal = fiscal;
    }

    public Customer(int id, String name, String surname, String iva, String email, String address, String city, String province, String zip, String country, String phone, String pec, String aeCode, String birthday, String society, String fiscal) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.iva = iva;
        this.email = email;
        this.address = address;
        this.city = city;
        this.province = province;
        this.zip = zip;
        this.country = country;
        this.phone = phone;
        this.pec = pec;
        this.aeCode = aeCode;
        this.birthday = birthday;
        this.society = society;
        this.fiscal = fiscal;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getProvince() {
        return province;
    }

    public String getZip() {
        return zip;
    }

    public String getIva() {
        return iva;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getPec() {
        return pec;
    }

    public String getAeCode() {
        return aeCode;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getSociety() {
        return society;
    }

    public String getFiscal() {
        return fiscal;
    }
}