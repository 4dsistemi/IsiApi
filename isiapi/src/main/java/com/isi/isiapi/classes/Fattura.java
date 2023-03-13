package com.isi.isiapi.classes;

import com.google.gson.annotations.SerializedName;


public class Fattura extends LastModifiedTables{

    
    public int id;
    
    public int bill_id;
    
    public String customer;
    
    public String recover_code;
    
    public String datetime;
    
    public int status;
    
    public int deleted;
    
    public int incremental_number;

    public Fattura(int bill_id, String customer, String recover_code, String datetime, int status, int deleted, int incremental_number) {
        this.bill_id = bill_id;
        this.customer = customer;
        this.recover_code = recover_code;
        this.datetime = datetime;
        this.status = status;
        this.deleted = deleted;
        this.incremental_number = incremental_number;
    }
}
