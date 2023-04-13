package com.isi.isiapi.classes.ctzon;


import com.isi.isiapi.classes.Account;

import java.util.ArrayList;
import java.util.Date;

public class CtzonOrder {

    public int Id;
    public Date Arrival;
    
    public Account account;
    public int AccountId;
    public Date RequestTime;
    public String Address;
    public double Latitude;
    public double Longitude;
    public String ComuneCap;
    public String Note;
    public ArrayList<CtzonSubOrder> CityzonSuborders;

}
