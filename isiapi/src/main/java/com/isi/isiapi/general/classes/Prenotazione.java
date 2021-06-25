package com.isi.isiapi.general.classes;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Prenotazione{

    @SerializedName("Id")
    public int id;

    @SerializedName("DateStart")
    public String dateStart;

    @SerializedName("Duration")
    public int duration;

    @SerializedName("DateEnd")
    public String dateEnd;

    @SerializedName("IsActive")
    public boolean isActive;

    //changes from a string to arraylist>list
    @SerializedName("Bikes")
    public ArrayList<Integer> bikesIds;

    @SerializedName("CustomerId")
    public int customerId;

    @SerializedName("CommercialLocalId")
    public String commercial;

    public Prenotazione(String dateStart, int duration, ArrayList<Integer> bikesIds, int customerId) {
        this.dateStart = dateStart;
        this.duration = duration;
        this.bikesIds = bikesIds;
        this.customerId = customerId;
    }

    public int getId() {
        return id;
    }

    public String getDateStart(){
        return dateStart;
    }

    public int getDuration(){
        return duration;
    }

    public String getDateEnd(){
        return  dateEnd;
    }

    public boolean isActive(){
        return isActive;
    }

    public ArrayList<Integer> getBikesIds() {
        return bikesIds;
    }

    public int getCustomerId(){
        return customerId;
    }
    public String getCommercial(){
        return commercial;
    }
}


