package com.isi.isiapi.general.classes;

import com.google.gson.annotations.SerializedName;

public class Account {

    @SerializedName("Id")
    public int Id;
    @SerializedName("Name")
    public String Name;
    @SerializedName("Surname")
    public String Surname;
    @SerializedName("Email")
    public String Email;
    @SerializedName("Telephone")
    public String Telephone;


}
