package com.isi.isiapi.classes.isiorder;

import com.google.gson.annotations.SerializedName;
import com.isi.isiapi.classes.isiorder.IsiorderCategoryAndTables;
import com.isi.isiapi.classes.isiorder.IsiorderInformationOrders;

import java.util.ArrayList;

public class CategoriesTableResponse {

    @SerializedName("informations")
    public ArrayList<IsiorderInformationOrders> isiorderInformationOrders;

    @SerializedName("categories")
    public ArrayList<IsiorderCategoryAndTables> isiorderCategoryAndTables;

    public CategoriesTableResponse(ArrayList<IsiorderInformationOrders> isiorderInformationOrders, ArrayList<IsiorderCategoryAndTables> isiorderCategoryAndTables) {
        this.isiorderInformationOrders = isiorderInformationOrders;
        this.isiorderCategoryAndTables = isiorderCategoryAndTables;
    }
}
