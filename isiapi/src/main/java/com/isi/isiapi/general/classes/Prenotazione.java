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
    public String isNoloBicyclesId;

    @SerializedName("CustomerId")
    public String customerId;

    @SerializedName("CommercialLocalId")
    public String commercial;

    public Prenotazione(int id, String dateStart, int duration , String dateEnd, boolean isActive, String isNoloBicyclesId , String customerId , String commercial  ){
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

    public String getIsNoloBicyclesId(){
        return isNoloBicyclesId;
    }

    public String getCustomerId(){
        return customerId;
    }
    public String getCommercial(){
        return commercial;
    }
}


