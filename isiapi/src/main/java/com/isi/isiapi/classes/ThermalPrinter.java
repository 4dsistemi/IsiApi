package com.isi.isiapi.classes;


public class ThermalPrinter extends LastModifiedTables{

    
    public int id;

    
    public String name;

    
    public String ip;

    
    public int preconto;

    
    public int active = 1;

    
    public int beep;

    public ThermalPrinter(String name, String ip, int preconto, int beep) {
        this.name = name;
        this.ip = ip;
        this.preconto = preconto;
        this.beep = beep;
    }
}
