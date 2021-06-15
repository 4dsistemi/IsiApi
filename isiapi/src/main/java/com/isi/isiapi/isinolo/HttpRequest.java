package com.isi.isiapi.isinolo;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.isi.isiapi.general.HttpJson;
import com.isi.isiapi.general.classes.Bike;
import com.isi.isiapi.general.classes.Prenotazione;
import com.isi.isiapi.general.classes.Sede;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class HttpRequest {

    private final String apiKey;

    @Deprecated
    public HttpRequest(String serial, String apiKey) {
        this.apiKey = apiKey;
    }


    public HttpRequest(String apiKey) {
        this.apiKey = apiKey;
    }

     // created new public class test that retrieves data from isiCashierapi.api
    public ArrayList<Bike> getBikes (String serial){
        HttpJson json = new HttpJson();
        json.addData("serial", serial);

        MakeHttpPost post = new MakeHttpPost("getBikes", json.getData(), apiKey);

        try {
            String response = post.execute().get();

            Log.e("TAG", "getBikes: " + response);

            return new Gson().fromJson(response, new TypeToken<ArrayList<Bike>>(){}.getType());

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    public boolean deleteBike(int id){
        HttpJson json = new HttpJson();
        json.addData("id", id);

        MakeHttpPost post = new MakeHttpPost("deleteBike", json.getData(), apiKey);

        try {
            String response = post.execute().get();

            if(response.trim().equals("ok")){
                return true;
            }

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean deletePreno(int id){
        HttpJson json = new HttpJson();
        json.addData("id", id);

        MakeHttpPost post = new MakeHttpPost("deletePreno", json.getData(), apiKey);

        try {
            String response = post.execute().get();

            if(response.trim().equals("ok")){
                return true;
            }

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean modifyBike(Bike bike){
        HttpJson json = new HttpJson();
        json.addData("id", bike.id);
        json.addData("model", bike.model);
        json.addData("matric", bike.matricNumber);

        MakeHttpPost post = new MakeHttpPost("modifyBike", json.getData(), apiKey);

        try {
            String response = post.execute().get();

            if(response.trim().equals("ok")){
                return true;
            }

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;
    }


    public ArrayList<Prenotazione> getPreno (String serial){
        HttpJson json = new HttpJson();
        json.addData("serial", serial);

        MakeHttpPost post = new MakeHttpPost("getPreno", json.getData(), apiKey);

        try {
            String response = post.execute().get();

            Log.e("TAG", "getPreno: " + response);

            return new Gson().fromJson(response, new TypeToken<ArrayList<Prenotazione>>(){}.getType());

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }


    //this is the function on getsede that we passed in http request must have details below
    //also remember to create it in php getSede orelse its not gonna work on here

    public ArrayList<Sede> getSede(String serial){
        HttpJson json = new HttpJson();
        json.addData("serial", serial);

        MakeHttpPost post = new MakeHttpPost("getSede", json.getData(), apiKey);

        try {
            String response = post.execute().get();

            Log.e("TAG", "getSede: " + response);

            return new Gson().fromJson(response, new TypeToken<ArrayList<Sede>>(){}.getType());

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }


    public boolean modifySede(Sede sedea){
        HttpJson json = new HttpJson();
        json.addData("id", sedea.id);
        json.addData("nome" , sedea.nome);
        json.addData("city", sedea.citta);
        json.addData("address", sedea.indirizzo);
        json.addData( "zip" , sedea.zip);
        json.addData("country" , sedea.country);

        MakeHttpPost post = new MakeHttpPost("modifySede", json.getData(), apiKey);

        try {
            String response = post.execute().get();

            if(response.trim().equals("ok")){
                return true;
            }

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;
    }


    public boolean deleteSede(int id){
        HttpJson json = new HttpJson();
        json.addData("id", id);

        MakeHttpPost post = new MakeHttpPost("deleteSede", json.getData(), apiKey);

        try {
            String response = post.execute().get();

            if(response.trim().equals("ok")){
                return true;
            }

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean addSede(Sede sedea, String serial){
        HttpJson json = new HttpJson();
        json.addData("nome" , sedea.nome);
        json.addData("city", sedea.citta);
        json.addData("address", sedea.indirizzo);
        json.addData( "zip" , sedea.zip);
        json.addData("stato" , sedea.stato);
        json.addData("country" , sedea.country);
        json.addData("serial", serial);


        MakeHttpPost post = new MakeHttpPost("addSede", json.getData(), apiKey);

        try {
            String response = post.execute().get();

            if(response.trim().equals("ok")){
                return true;
            }

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;
    }


}


