package com.isi.isiapi.classes.isiorder;

import androidx.annotation.NonNull;
import com.google.gson.annotations.SerializedName;
import com.isi.isiapi.classes.LastModifiedTables;

public class IsiorderTableCategory extends LastModifiedTables {

    @SerializedName("Id")
    public int id;

    @SerializedName("Name")
    public String name;

    @SerializedName("Active")
    public int active = 1;

    @SerializedName("Guest")
    public int guest = 1;

    public IsiorderTableCategory(String name) {
        this.name = name;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
