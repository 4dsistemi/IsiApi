package com.isi.isiapi.general.classes;

import com.google.gson.annotations.SerializedName;

public class Operator {

    @SerializedName("Id")
    public int id;

    @SerializedName("OperatorCode")
    public String operator_code = "0000";

    @SerializedName("Privilege")
    public int privilege;

    @SerializedName("Name")
    public String name;

    @SerializedName("Surname")
    public String surname;

    @SerializedName("Address")
    public String address;

    @SerializedName("Phone")
    public String phone;

    @SerializedName("Email")
    public String email;

    @SerializedName("Nfc")
    public String nfc;

    @SerializedName("CtzonCard")
    public String ctzonCard;

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
