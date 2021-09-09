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
    @SerializedName("Birthplace")
    private String birthplace;
    @SerializedName("Gender")
    private int gender;
    @SerializedName("DocType")
    private String docType;
    @SerializedName("DocSerial")
    private String docSerial;
    @SerializedName("DocRelease")
    private String docRelease;
    @SerializedName("DocExpire")
    private String docExpire;
    @SerializedName("CommercialComunication")
    private boolean commercialComunication;

    public Customer(String name, String surname, String iva, String email, String address, String city, String province, String zip, String country, String phone, String pec, String aeCode, String birthday, String society, String fiscal, boolean commercialComunication) {
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
        this.commercialComunication = commercialComunication;
    }

    public Customer(int id, String name, String surname, String iva, String email, String address, String city, String province, String zip, String country, String phone, String pec, String aeCode, String birthday, String society, String fiscal, boolean commercialComunication) {
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
        this.commercialComunication = commercialComunication;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPec(String pec) {
        this.pec = pec;
    }

    public void setAeCode(String aeCode) {
        this.aeCode = aeCode;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setSociety(String society) {
        this.society = society;
    }

    public void setFiscal(String fiscal) {
        this.fiscal = fiscal;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public int getGender() {
        return gender;
    }

    public String getDocType() {
        return docType;
    }

    public String getDocSerial() {
        return docSerial;
    }

    public String getDocRelease() {
        return docRelease;
    }

    public String getDocExpire() {
        return docExpire;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public void setDocSerial(String docSerial) {
        this.docSerial = docSerial;
    }

    public void setDocRelease(String docRelease) {
        this.docRelease = docRelease;
    }

    public void setDocExpire(String docExpire) {
        this.docExpire = docExpire;
    }

    public boolean isCommercialComunication() {
        return commercialComunication;
    }

    public void setCommercialComunication(boolean commercialComunication) {
        this.commercialComunication = commercialComunication;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}