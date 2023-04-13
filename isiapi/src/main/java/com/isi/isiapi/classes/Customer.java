package com.isi.isiapi.classes;

public class Customer extends LastModifiedTables {

    
    public int id;
    
    public String name;
    
    public String surname;
    
    public String iva;
    
    public String email;
    
    public String address;
    
    public String city;
    
    public String province;
    
    public String zip;
    
    public String country;
    
    public String phone;
    
    public String pec;
    
    public String aeCode;
    
    public String birthday;
    
    public String society;
    
    public String fiscal;
    
    public String birthplace;
    
    public int gender;
    
    public String docType;
    
    public String docSerial;
    
    public String docRelease;
    
    public String docExpire;
    
    public boolean commercial_comunication;
    
    public int active = 1;

    public Customer(String name, String surname, String iva, String email, String address, String city, String province, String zip, String country, String phone, String pec, String aeCode, String birthday, String society, String fiscal, boolean commercialComunication) {
        this.name = name;
        this.surname = surname;
        this.iva = iva;
        this.email = email;
        this.address = address;
        this.city = city;
        this.province = province;
        this.zip = zip;
        this.country = country;
        this.phone = phone;
        this.pec = pec;
        this.aeCode = aeCode;
        this.birthday = birthday;
        this.society = society;
        this.fiscal = fiscal;
        this.commercial_comunication = commercialComunication;
    }
}