package com.isi.isiapi.classes;

public class Fattura extends LastModifiedTables{

    
    public int id;
    
    public int bill_id;
    
    public String customer;
    
    public String recover_code;
    
    public String datetime;
    
    public int status;
    
    public int fattura_deleted;
    
    public int incremental_number;

    public Fattura(int bill_id, String customer, String recover_code, String datetime, int status, int fattura_deleted, int incremental_number) {
        this.bill_id = bill_id;
        this.customer = customer;
        this.recover_code = recover_code;
        this.datetime = datetime;
        this.status = status;
        this.fattura_deleted = fattura_deleted;
        this.incremental_number = incremental_number;
    }
}
