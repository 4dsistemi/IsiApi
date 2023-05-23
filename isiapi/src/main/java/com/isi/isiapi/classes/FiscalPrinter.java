package com.isi.isiapi.classes;

public class FiscalPrinter extends LastModifiedTables{

    
    public int id ;

    
    public String name;

    
    public String ip;

    
    public String matricola;

    
    public int type = 0;

    public FiscalPrinter(int id, String name, String ip, String matricola, int type) {
        this.id = id;
        this.name = name;
        this.ip = ip;
        this.matricola = matricola;
        this.type = type;
    }
}
