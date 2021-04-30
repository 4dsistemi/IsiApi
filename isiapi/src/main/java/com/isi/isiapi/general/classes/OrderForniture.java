package com.isi.isiapi.general.classes;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class OrderForniture {

    @SerializedName("forniture")
    private final Forniture forniture;
    private final ArrayList<OrderFornitureElement> elements;

    public OrderForniture(Forniture forniture, ArrayList<OrderFornitureElement> elements) {
        this.forniture = forniture;
        this.elements = elements;
    }

    public Forniture getForniture() {
        return forniture;
    }

    public ArrayList<OrderFornitureElement> getElements() {
        return elements;
    }
}