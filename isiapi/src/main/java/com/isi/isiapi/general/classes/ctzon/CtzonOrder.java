package com.isi.isiapi.general.classes.ctzon;

import com.isi.isiapi.general.classes.Operator;

import java.util.ArrayList;
import java.util.Date;

public class CtzonOrder {

    public int Id;
    public Date Arrival;
    public Operator Account;
    public int AccountId;
    public Date RequestTime;
    public String Address;
    public double Latitude;
    public double Longitude;
    public String ComuneCap;
    public String Note;
    public ArrayList<CtzonSubOrder> CityzonSuborders;

}
