package com.isi.isiapi.general.classes;

import com.google.gson.annotations.SerializedName;

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

    @SerializedName("IsinoloBicyclesId")
    public int isNoloBicyclesId;

    @SerializedName("CustomerId")
    public int customerId;

    @SerializedName("CommercialLocalId")
    public String commercial;

    public Prenotazione(int id, String dateStart, int duration , String dateEnd, boolean isActive, int isNoloBicyclesId , int customerId , String commercial  ){
        this.id = id;
        this.dateStart = dateStart;
        this.duration = duration;
        this.dateEnd = dateEnd;
        this.isActive = isActive;
        this.isNoloBicyclesId = isNoloBicyclesId;
        this.customerId = customerId;
        this.commercial = commercial;
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

    public int getIsNoloBicyclesId(){
        return isNoloBicyclesId;
    }

    public int getCustomerId(){
        return customerId;
    }
    public String getCommercial(){
        return commercial;
    }
}


