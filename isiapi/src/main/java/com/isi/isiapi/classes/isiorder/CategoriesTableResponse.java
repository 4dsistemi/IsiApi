package com.isi.isiapi.classes.isiorder;

import java.util.ArrayList;

public class CategoriesTableResponse {

    
    public ArrayList<IsiorderInformationOrders> isiorderInformationOrders;

    
    public ArrayList<IsiorderCategoryAndTables> isiorderCategoryAndTables;

    public CategoriesTableResponse(ArrayList<IsiorderInformationOrders> isiorderInformationOrders, ArrayList<IsiorderCategoryAndTables> isiorderCategoryAndTables) {
        this.isiorderInformationOrders = isiorderInformationOrders;
        this.isiorderCategoryAndTables = isiorderCategoryAndTables;
    }
}
