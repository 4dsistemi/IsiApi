package com.isi.isiapi.classes.isiorder;

import com.google.gson.annotations.SerializedName;
import com.isi.isiapi.classes.Category;

public class IsiorderInformationOrders {

    @SerializedName("Category")
    public Category category;

    @SerializedName("ElementInQueue")
    public int elementInQueue;

    public IsiorderInformationOrders(Category category, int elementInQueue) {
        this.category = category;
        this.elementInQueue = elementInQueue;
    }
}
