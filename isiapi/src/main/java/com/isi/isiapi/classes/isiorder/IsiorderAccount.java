package com.isi.isiapi.classes.isiorder;

import com.isi.isiapi.classes.LastModifiedTables;

import java.util.Date;

public class IsiorderAccount extends LastModifiedTables {

    
    public int id;

    
    public String name;

    
    public String surname;

    
    public String password;

    
    public int privilege;

    
    public Date last_login;

    
    public String email;

    
    public int active = 1;

    
    public Integer account_id;

    public IsiorderAccount(String name, String surname, String password, int privilege, String email, Integer account_id) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.privilege = privilege;
        this.email = email;
        this.account_id = account_id;
    }
}
