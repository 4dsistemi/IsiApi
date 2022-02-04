package com.isi.isiapi.classes.isiorder;

import com.isi.isiapi.classes.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class    IsiorderOrdersProductElement {

    public IsiorderOrder orders;
    public List<IsiorderElementOrderAndProducts> elementOrderAndProducts = new ArrayList<>();

    public List<IsiorderElementOrderAndProducts> getElementAlreadySent(){
        return elementOrderAndProducts.stream().filter(isiorderElementOrderAndProducts -> isiorderElementOrderAndProducts.elementOrder.id != 0).collect(Collectors.toList());
    }

    public List<IsiorderElementOrderAndProducts> getElementToSend(){
        return elementOrderAndProducts.stream().filter(isiorderElementOrderAndProducts -> isiorderElementOrderAndProducts.elementOrder.id == 0).collect(Collectors.toList());
    }

    public void addElementToSent(Product product, int exit){

        IsiorderElementOrder isiorderElementOrder = new IsiorderElementOrder(product.id,exit, orders.id, 1);
        isiorderElementOrder.newName = product.name;
        isiorderElementOrder.newPrice = product.price;

        elementOrderAndProducts.add(new IsiorderElementOrderAndProducts(isiorderElementOrder, product));
    }

    public IsiorderOrdersProductElement(IsiorderOrder orders) {
        this.orders = orders;
    }
}
