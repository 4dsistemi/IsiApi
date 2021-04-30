package com.isi.isiapi.general.classes;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Printer {

    @SerializedName("Id")
    public int id ;

    @SerializedName("Name")
    public String name;

    @SerializedName("Ip")
    public String ip;

    @SerializedName("IsPref")
    public int isPref = 0;

    @SerializedName("IntestazioneId")
    public Integer intestazione_id = null;

    @SerializedName("Cortesia")
    public String cortesia = null;

    @SerializedName("Pubblicita")
    public String pubblicita = null;

    @SerializedName("Type")
    public int type = 0;


    public Printer(String name, String ip, int type) {
        this.name = name;
        this.ip = ip;
        this.type = type;
    }

    public Printer(int id, String name, String ip, int isPref, Integer intestazione_id, String cortesia, String pubblicita, int type) {
        this.id = id;
        this.name = name;
        this.ip = ip;
        this.isPref = isPref;
        this.intestazione_id = intestazione_id;
        this.cortesia = cortesia;
        this.pubblicita = pubblicita;
        this.type = type;
    }

    public static Printer getPrinterById(ArrayList<Printer> printers, int id){

        for(Printer pr : printers){
            if(pr.id == id){
                return pr;
            }
        }
        return null;
    }
}