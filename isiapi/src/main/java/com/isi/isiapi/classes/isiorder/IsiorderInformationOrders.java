package com.isi.isiapi.classes.isiorder;

import com.isi.isiapi.classes.Category;

public class IsiorderInformationOrders {

    
    public Category category;

    
    public int elementInQueue;

    public IsiorderInformationOrders(Category category, int elementInQueue) {
        this.category = category;
        this.elementInQueue = elementInQueue;
    }
}
