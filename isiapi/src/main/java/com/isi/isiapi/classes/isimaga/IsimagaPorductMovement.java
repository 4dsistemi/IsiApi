package com.isi.isiapi.classes.isimaga;

import com.google.gson.annotations.SerializedName;
import com.isi.isiapi.classes.LastModifiedTables;

import java.util.Date;

public class IsimagaPorductMovement extends LastModifiedTables {

    @SerializedName("Id")
    public int id;

    @SerializedName("Arrival")
    public Date arrival = new Date();

    @SerializedName("ProductFornitureId")
    public int product_forniture_id;

    @SerializedName("Quantity")
    public float quantity;

    @SerializedName("isPlus")
    public boolean is_plus;

    @SerializedName("fatturaNr")
    public String fattura_nr;

    public IsimagaPorductMovement(int product_forniture_id, float quantity, boolean is_plus, String fattura_nr) {
        this.product_forniture_id = product_forniture_id;
        this.quantity = quantity;
        this.is_plus = is_plus;
        this.fattura_nr = fattura_nr;
    }
}
