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

    @SerializedName("Bikes")
    public ArrayList<Integer> bikesIds;

    //new function added now
    @SerializedName("IsinoloBikeReservations")
    public ArrayList<IsiNoloBikeReservation> reservations;

    @SerializedName("CustomerId")
    public int customerId;

    @SerializedName("Customer")
    public Customer customer;

    @SerializedName("CommercialLocalId")
    public String commercial;

    @SerializedName("CreditCardNum")
    public String credit_card_num;

    @SerializedName("CreditCardExp")
    public String credit_card_exp;

    public Prenotazione(String dateStart, int duration, ArrayList<Integer> bikesIds, int customerId , String credit_card_num , String credit_card_exp) {
        this.dateStart = dateStart;
        this.duration = duration;
        this.bikesIds = bikesIds;
        this.customerId = customerId;
        this.credit_card_num = credit_card_num;
        this.credit_card_exp = credit_card_exp;
    }
  //added
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

    public String getCredit_card_num(){return  credit_card_num;}
    public String getCredit_card_exp(){ return  credit_card_exp;}
}


