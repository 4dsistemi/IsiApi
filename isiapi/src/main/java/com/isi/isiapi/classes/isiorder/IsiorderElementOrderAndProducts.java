package com.isi.isiapi.classes.isiorder;

import com.isi.isiapi.classes.Product;

import java.util.ArrayList;
import java.util.List;

public class IsiorderElementOrderAndProducts {

    public IsiorderElementOrder elementOrder;

    public Product products;

    public List<IsiorderNotesAndNoteOrder> notesAndNoteOrders = new ArrayList<>();

    public IsiorderElementOrderAndProducts(IsiorderElementOrder elementOrder, Product products) {
        this.elementOrder = elementOrder;
        this.products = products;
    }

    public double getTotal(){

        double total = elementOrder.newPrice;

        for (IsiorderNotesAndNoteOrder isiorderNotesAndNoteOrder : notesAndNoteOrders){

            if(isiorderNotesAndNoteOrder.notes != null){
                total += isiorderNotesAndNoteOrder.notes.price;
            }

        }

        return total;

    }

}
