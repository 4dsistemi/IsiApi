package com.isi.isiapi.classes.ctzon;

import com.isi.isiapi.classes.Account;
import com.isi.isiapi.classes.isiorder.IsiorderTableElement;

import java.util.ArrayList;

public class OrderGuest {

    
    private final int id;
    
    private final String timestamp;
    
    private final int account_id;
    
    private final int table_id;
    
    private int status;
    
    private final int payment;
    
    private final String commercial_id;
    
    private final ArrayList<OrderGuestElement> elements;
    
    public Account account;
    
    public IsiorderTableElement table;

    public OrderGuest(int id, String timestamp, int account_id, int table_id, int status, int payment, String commercial_id, ArrayList<OrderGuestElement> elements) {
        this.id = id;
        this.timestamp = timestamp;
        this.account_id = account_id;
        this.table_id = table_id;
        this.status = status;
        this.payment = payment;
        this.commercial_id = commercial_id;
        this.elements = elements;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ArrayList<OrderGuestElement> getElements() {
        return elements;
    }

    public int getId() {
        return id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public int getAccount_id() {
        return account_id;
    }

    public int getTable_id() {
        return table_id;
    }

    public int getStatus() {
        return status;
    }

    public int getPayment() {
        return payment;
    }

    public String getCommercial_id() {
        return commercial_id;
    }
}
