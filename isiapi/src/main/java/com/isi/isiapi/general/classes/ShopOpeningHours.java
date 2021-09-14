package com.isi.isiapi.general.classes;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

//Classe che riporta gli orari di apertura
public class ShopOpeningHours {
    @SerializedName("Id")
    private final int id;
    @SerializedName("CommercialLocalId")
    private String commercialLocalId;
    @SerializedName("Opening1")
    private Date opening1;
    @SerializedName("Closing1")
    private Date closing1;
    @SerializedName("Opening2")
    private Date opening2;
    @SerializedName("Closing2")
    private Date closing2;
    @SerializedName("Day")
    private int day;

    public ShopOpeningHours()
    {
        //settiamo il valore a 0 per avere un default
        id = 0;
    }

    public ShopOpeningHours(int id, String commercialLocalId, Date opening1, Date closing1, Date opening2, Date closing2, int day)
    {
        this.id = id;
        this.commercialLocalId = commercialLocalId;
        this.opening1 = opening1;
        this.closing1 = closing1;
        this.opening2 = opening2;
        this.closing2 = closing2;
        this.day = day;
    }

    public String getCommercialLocalId() {
        return commercialLocalId;
    }

    public Date getOpening1() {
        return opening1;
    }

    public void setOpening1(Date opening1) {
        this.opening1 = opening1;
    }

    public Date getClosing1() {
        return closing1;
    }

    public void setClosing1(Date closing1) {
        this.closing1 = closing1;
    }

    public Date getOpening2() {
        return opening2;
    }

    public void setOpening2(Date opening2) {
        this.opening2 = opening2;
    }

    public Date getClosing2() {
        return closing2;
    }

    public void setClosing2(Date closing2) {
        this.closing2 = closing2;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getId() {
        return id;
    }
}
