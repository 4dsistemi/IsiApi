package com.isi.isiapi.classes.isimaga;

public class OrderToFornitureElement {

    
    public int id;

    
    public int order_to_forniture_id;

    
    public int product_forniture_id;

    
    public int quantity;

    
    public Integer true_quantity = 0;

    public OrderToFornitureElement(int product_forniture_id, int quantity) {
        this.product_forniture_id = product_forniture_id;
        this.quantity = quantity;
    }
}
