package com.isi.isiapi.general.classes;

import com.google.gson.annotations.SerializedName;
import com.isi.isiapi.general.classes.ctzon.LoyaltyPoint;

import java.util.Date;

public class Operator {

    @SerializedName("Id")
    public int id;

    @SerializedName("LoginCode")
    public String operator_code = "0000";

    @SerializedName("Privilege")
    public int privilege;

    @SerializedName("Name")
    public String name;

    @SerializedName("Surname")
    public String surname;

    @SerializedName("Address")
    public String address;

    @SerializedName("Telephone")
    public String phone;

    @SerializedName("Email")
    public String email;

    @SerializedName("Birthday")
    public Date birthday;

    @SerializedName("Nfc")
    public String nfc;

    @SerializedName("CtzonCard")
    public String ctzonCard;

    @SerializedName("Points")
    public LoyaltyPoint points;

    public Operator(int id, int privilege, String name, String surname, String address, String phone, String email, String operator_code, String nfc) {
        this.privilege = privilege;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.operator_code = operator_code;
        this.id = id;
        this.nfc = nfc;
    }
}
