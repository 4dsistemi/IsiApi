package com.isi.isiapi.classes.isicash;

import com.isi.isiapi.classes.LastModifiedTables;

import java.util.Date;


public class IsiCashBill extends LastModifiedTables {

    
    public int id;
    
    public Date arrival = new Date();
    
    public float discount_valor;
    
    public int discount_type;
    
    public int account_id;
    
    public String payment_type;
    
    public float total;
    
    public int closure_number;
    
    public int document_number;
    
    public int status = 0;
    
    public Integer user_id;
    
    public int points_collected = 0;
    
    public int points_used = 0;

    public IsiCashBill(float discount_valor, int discount_type, int account_id, String payment_type, float total, int closure_number, int document_number) {
        this.discount_valor = discount_valor;
        this.discount_type = discount_type;
        this.account_id = account_id;
        this.payment_type = payment_type;
        this.total = total;
        this.closure_number = closure_number;
        this.document_number = document_number;
    }
}
