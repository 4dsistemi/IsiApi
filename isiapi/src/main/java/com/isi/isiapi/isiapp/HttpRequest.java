package com.isi.isiapi.isiapp;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.isi.isiapi.MakeHttpPost;
import com.isi.isiapi.general.CTZON_SERVICE;
import com.isi.isiapi.general.HttpJson;
import com.isi.isiapi.general.classes.ApplicationList;
import com.isi.isiapi.general.classes.Operator;
import com.isi.isiapi.general.classes.Reservation;
import com.isi.isiapi.general.classes.ctzon.CtzonOrder;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class HttpRequest {

    private final String apiKey;
    private boolean debug = false;

    public HttpRequest(String apiKey) {
        this.apiKey = apiKey;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public ArrayList<ApplicationList> getApplicationActive(String serial){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIAPP, "getApplications", json.getData(), apiKey, debug);

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

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIAPP, "removeShadow", json.getData(), apiKey, debug);

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

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIAPP, "addShadow", json.getData(), apiKey, debug);

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

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIAPP, "removeAppActive", json.getData(), apiKey, debug);

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

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIAPP, "movePriority", json.getData(), apiKey, debug);

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

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIAPP, "setPositionMenu", json.getData(), apiKey, debug);

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

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIAPP, "updateNfc", json.getData(), apiKey, debug);

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

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIAPP, "updateLocation", json.getData(), apiKey, debug);

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

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIAPP, "getReservation", json.getData(), apiKey, debug);

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

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIAPP, "addReservation", json.getData(), apiKey, debug);

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

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIAPP, "modifyReservation", json.getData(), apiKey, debug);

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

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIAPP, "setReservationStatus", json.getData(), apiKey, debug);

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

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIAPP, "getCtzonOrders", json.getData(), apiKey, debug);

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


        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIAPP, "confirmCtzonOrder", json.getData(), apiKey, debug);

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


        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIAPP, "updateCtzonOrder", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean checkCapDelivery(String cap){

        HttpJson json = new HttpJson();
        json.addData("cap", cap);


        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIAPP, "checkCap", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            return response.trim().equals("true");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean updateCap(String cap, String serial){

        HttpJson json = new HttpJson();
        json.addData("cap", cap);
        json.addData("serial", serial);


        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIAPP, "updateCap", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }

    public Operator searchAccountFromCard(String card, String serial){
        HttpJson json = new HttpJson();
        json.addData("card", card);
        json.addData("serial", serial);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIAPP, "searchAccountFromCard", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            return new Gson().fromJson(response, Operator.class);

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean addPointAccount(String card, String serial, int point){

        HttpJson json = new HttpJson();
        json.addData("account", card);
        json.addData("serial", serial);
        json.addData("point", point);


        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIAPP, "addPointAccount", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean removePointAccount(String card, String serial, int point){

        HttpJson json = new HttpJson();
        json.addData("account", card);
        json.addData("serial", serial);
        json.addData("point", point);


        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIAPP, "removePointAccount", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            return response.trim().equals("ok");

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }

}


