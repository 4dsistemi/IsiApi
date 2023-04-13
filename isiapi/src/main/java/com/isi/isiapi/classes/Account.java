package com.isi.isiapi.classes;

import com.isi.isiapi.classes.ctzon.CtzPoint;

import java.util.Date;
import java.util.List;

public class Account {

    public int id;

    public String name;

    public String surname;

    public String email;

    public String address;

    public Float latitude;

    public Float longitude;

    public Date birthday;

    public int gender = 0;

    public String pic;

    public String phone;

    public String password;

    public String email_verification;

    public String phone_verification;

    public String general_verification;

    public String login_code = "0000";
    
    public String nfc;

    public String secret;
    
    public String ctzonCard;

    public List<CtzPoint> ctz_points;

}