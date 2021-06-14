package com.isi.isiapi.general.classes;

import com.google.gson.annotations.SerializedName;
// Create a class and name it base on wat makes sense
//create function on here to get all data from function we created in php
// then later pass the function http request.
//we definitely pass the Id and commercial id on here but not on the page in SediActivity
//make sure this function sede begins the strig with a capital letter as shown below


public class Sede{

    @SerializedName("Id")
    public int id;

    @SerializedName("CommercialLocalId")
    public String commercial;

    @SerializedName("Name")
    public String nome;

    @SerializedName("Address")
    public String indirizzo;

    @SerializedName("City")
    public String citta;

    @SerializedName("Zip")
    public String zip;

    @SerializedName("State")
    public String stato;

    @SerializedName("Country")
    public String country;

    public Sede(int id , String nome , String indirizzo , String citta , String zip , String stato , String country , String commercial ){
        this.id = id;
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.citta = citta;
        this.zip = zip;
        this.stato = stato;
        this.country = country;
        this.commercial = commercial;

    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public String getCitta() {
        return citta;
    }

    public String getZip() {
        return zip;
    }

    public String getStato() {
        return stato;
    }

    public String getCountry() {
        return country;
    }

    public String getCommercial() {
        return commercial;
    }
}


