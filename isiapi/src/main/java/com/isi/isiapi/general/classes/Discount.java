package com.isi.isiapi.general.classes;

import com.google.gson.annotations.SerializedName;

public class Discount {

    @SerializedName("DiscountType")
    private final DISCOUNT_TYPE type;
    @SerializedName("Valor")
    private final float valor;

    public Discount(DISCOUNT_TYPE type, float valor) {
        this.type = type;
        this.valor = valor;
    }

    public DISCOUNT_TYPE getType() {
        return type;
    }

    public float getValor() {
        return valor;
    }

    public enum DISCOUNT_TYPE{
        PERCENT,
        CASH
    }

}
