package com.isi.isiapi.classes.isicash;

import com.isi.isiapi.classes.LastModifiedTables;


public class IsiCashElementBill extends LastModifiedTables {

    
    public int id;
    
    public int bill_id;
    
    public Integer product_id;
    
    public String name;
    
    public float price;
    
    public int department;
    
    public float discount_valor;
    
    public int discount_type;
    
    public int quantity = 1;

    public IsiCashElementBill(Integer product_id, String name, float price, int department, float discount_valor, int discount_type, int quantity) {
        this.product_id = product_id;
        this.name = name;
        this.price = price;
        this.department = department;
        this.discount_valor = discount_valor;
        this.discount_type = discount_type;
        this.quantity = quantity;
    }
}
