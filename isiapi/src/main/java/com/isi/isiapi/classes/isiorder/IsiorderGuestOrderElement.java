package com.isi.isiapi.classes.isiorder;

import java.util.List;

public class IsiorderGuestOrderElement {
    
    public int id;

    public int product_id;
    
    public int quantity;
    
    public int isiorder_guest_order_id;

    public String name;

    public float price;

    List<IsiorderGuestElementNote> isiorder_guest_order_notes;

}
