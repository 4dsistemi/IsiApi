package com.isi.isiapi.isiapp;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.isi.isiapi.general.HttpJson;
import com.isi.isiapi.general.classes.ApplicationList;
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


}


