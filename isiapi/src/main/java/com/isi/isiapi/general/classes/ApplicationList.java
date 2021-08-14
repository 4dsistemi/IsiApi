package com.isi.isiapi.general.classes;

import java.util.ArrayList;

public class ApplicationList {

    public int Id;
    public String Name;
    public String Package;
    public String Description;
    public ArrayList<AppActivation> AppActivations;

    public AppActivation getAppActivation(){
        return AppActivations.get(0);
    }

}
