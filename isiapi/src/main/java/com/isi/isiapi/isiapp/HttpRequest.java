package com.isi.isiapi.isiapp;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.isi.isiapi.general.HttpJson;
import com.isi.isiapi.general.classes.ApplicationList;
import com.isi.isiapi.general.classes.Reservation;
import com.isi.isiapi.general.classes.ctzon.CtzonOrder;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class HttpRequest {

    private final String apiKey;

    public HttpRequest(String apiKey) {
        this.apiKey = apiKey;
    }

    public ArrayList<ApplicationList> getApplicationActive(String serial){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);

        MakeHttpPost post = new MakeHttpPost("getApplications", json.getData(), apiKey);

        try {
            String response = post.execute().get();

            return new Gson().fromJson(response, new TypeToken<ArrayList<ApplicationList>>(){}.getType());

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;

    }

    public boolean removeShadow(int id, int position){

        HttpJson json = new HttpJson();
        json.addData("id", id);
        json.addData("position", position);

        MakeHttpPost post = new MakeHttpPost("removeShadow", json.getData(), apiKey);

        try {
            String response = post.execute().get();

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean addShadow(String serial, int position){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("position", position);

        MakeHttpPost post = new MakeHttpPost("addShadow", json.getData(), apiKey);

        try {
            String response = post.execute().get();

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean removeAppActivation(int id){

        HttpJson json = new HttpJson();
        json.addData("id", id);

        MakeHttpPost post = new MakeHttpPost("removeAppActive", json.getData(), apiKey);

        try {
            String response = post.execute().get();

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean movePriority(int id, int idSecond){

        HttpJson json = new HttpJson();
        json.addData("id", id);
        json.addData("id_second", idSecond);

        MakeHttpPost post = new MakeHttpPost("movePriority", json.getData(), apiKey);

        try {
            String response = post.execute().get();

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean setPositionInMenu(int id, int position){

        HttpJson json = new HttpJson();
        json.addData("id", id);
        json.addData("position", position);

        MakeHttpPost post = new MakeHttpPost("setPositionMenu", json.getData(), apiKey);

        try {
            String response = post.execute().get();

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean updateNfc(int id, String nfc){

        HttpJson json = new HttpJson();
        json.addData("id", id);
        json.addData("nfc", nfc);

        MakeHttpPost post = new MakeHttpPost("updateNfc", json.getData(), apiKey);

        try {
            String response = post.execute().get();

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean updateLocation(double lat, double lon, String serial){

        HttpJson json = new HttpJson();
        json.addData("lat", lat);
        json.addData("lon", lon);
        json.addData("serial", serial);

        MakeHttpPost post = new MakeHttpPost("updateLocation", json.getData(), apiKey);

        try {
            String response = post.execute().get();

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }

    public ArrayList<Reservation> getReservations(String serial){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);

        MakeHttpPost post = new MakeHttpPost("getReservation", json.getData(), apiKey);

        try {
            String response = post.execute().get();

            return new Gson().fromJson(response, new TypeToken<ArrayList<Reservation>>(){}.getType());

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;

    }

    public boolean addReservation(Reservation reservation, String serial){

        HttpJson json = new HttpJson();
        json.addData("reservation", new Gson().toJsonTree(reservation));
        json.addData("serial", serial);

        MakeHttpPost post = new MakeHttpPost("addReservation", json.getData(), apiKey);

        try {
            String response = post.execute().get();

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean modifyReservation(Reservation reservation){

        HttpJson json = new HttpJson();
        json.addData("reservation", new Gson().toJsonTree(reservation));

        MakeHttpPost post = new MakeHttpPost("modifyReservation", json.getData(), apiKey);

        try {
            String response = post.execute().get();

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean setReservationStatus(Reservation reservation, int status){

        HttpJson json = new HttpJson();
        json.addData("reservation", reservation.Id);
        json.addData("status", status);

        MakeHttpPost post = new MakeHttpPost("setReservationStatus", json.getData(), apiKey);

        try {
            String response = post.execute().get();

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }

    public ArrayList<CtzonOrder> getCtzonOrder(String serial){
        HttpJson json = new HttpJson();
        json.addData("serial", serial);

        MakeHttpPost post = new MakeHttpPost("getCtzonOrders", json.getData(), apiKey);

        try {
            String response = post.execute().get();

            return new Gson().fromJson(response, new TypeToken<ArrayList<CtzonOrder>>(){}.getType());

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;

    }

    public boolean confirmCtzonOrder(int id, boolean confirm, boolean isidelWith){

        HttpJson json = new HttpJson();
        json.addData("id", id);
        json.addData("confirm", confirm);
        json.addData("isidelWith", isidelWith);


        MakeHttpPost post = new MakeHttpPost("confirmCtzonOrder", json.getData(), apiKey);

        try {
            String response = post.execute().get();

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }


    public boolean updateCtzonOrder(int id, int status){

        HttpJson json = new HttpJson();
        json.addData("id", id);
        json.addData("status", status);


        MakeHttpPost post = new MakeHttpPost("updateCtzonOrder", json.getData(), apiKey);

        try {
            String response = post.execute().get();

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }

}


