package com.isi.isiapi.classes.isimaga;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;
import com.isi.isiapp.serverAndApi.database.classes.LastModifiedTables;

@Entity(tableName = "forniture")
public class Forniture extends LastModifiedTables {

    @PrimaryKey(autoGenerate = true)
    @SerializedName("Id")
    public int id;

    @SerializedName("Name")
    public String name;

    @SerializedName("Email")
    public String email;

    @SerializedName("Phone")
    public String phone;

    @SerializedName("Active")
    public boolean active;

    public Forniture(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
