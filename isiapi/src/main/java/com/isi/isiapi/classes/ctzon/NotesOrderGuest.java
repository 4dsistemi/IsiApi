package com.isi.isiapi.classes.ctzon;

public class NotesOrderGuest {

    
    private final int id;
    
    private final int note_id;
    
    private final int element_id;
    
    private final String name;
    
    private final float price;

    public NotesOrderGuest(int id, int note_id, int element_id, String name, float price) {
        this.id = id;
        this.note_id = note_id;
        this.element_id = element_id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getNote_id() {
        return note_id;
    }

    public int getElement_id() {
        return element_id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }
}
