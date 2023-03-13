package com.isi.isiapi.classes.ctzon;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class OrderGuestElement {

    
    private final int id;
    
    private final int product_id;
    
    private final int quantity;
    
    private final int order_id;
    
    private final String name;
    
    private final float price;
    
    private final ArrayList<NotesOrderGuest> notesOrderGuests;

    public OrderGuestElement(int id, int product_id, int quantity, int order_id, String name, float price, ArrayList<NotesOrderGuest> notesOrderGuests) {
        this.id = id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.order_id = order_id;
        this.name = name;
        this.price = price;
        this.notesOrderGuests = notesOrderGuests;
    }

    public int getProduct_id() {
        return product_id;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getOrder_id() {
        return order_id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public ArrayList<NotesOrderGuest> getNotesOrderGuests() {
        return notesOrderGuests;
    }

}
