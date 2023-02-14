package com.isi.isiapi.classes;


import com.google.gson.annotations.SerializedName;

public class ThermalPrinter extends LastModifiedTables{

    @SerializedName("Id")
    public int id;

    @SerializedName("Name")
    public String name;

    @SerializedName("Ip")
    public String ip;

    @SerializedName("Preconto")
    public int preconto;

    @SerializedName("Active")
    public int active = 1;

    @SerializedName("Beep")
    public int beep;

    public ThermalPrinter(String name, String ip, int preconto, int beep) {
        this.name = name;
        this.ip = ip;
        this.preconto = preconto;
        this.beep = beep;
    }
}
