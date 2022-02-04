package com.isi.isiapi.classes.isiorder;

import com.google.gson.annotations.SerializedName;
import com.isi.isiapi.classes.LastModifiedTables;


import java.util.Date;

public class IsiorderAccount extends LastModifiedTables {

    @SerializedName("Id")
    public int id;

    @SerializedName("Name")
    public String name;

    @SerializedName("Surname")
    public String surname;

    @SerializedName("Password")
    public String password;

    @SerializedName("Privilege")
    public int privilege;

    @SerializedName("LastLogin")
    public Date last_login;

    @SerializedName("Email")
    public String email;

    @SerializedName("Active")
    public int active = 1;

    @SerializedName("AccountId")
    public Integer account_id;

    public IsiorderAccount(String name, String surname, String password, int privilege, String email, int account_id) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.privilege = privilege;
        this.email = email;
        this.account_id = account_id;
    }
}
