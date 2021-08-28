package com.isi.isiapi.isiorder;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.isi.isiapi.MakeHttpPost;
import com.isi.isiapi.general.CTZON_SERVICE;
import com.isi.isiapi.general.HttpJson;
import com.isi.isiapi.general.classes.Commercial;
import com.isi.isiapi.general.classes.OrderGuest;
import com.isi.isiapi.general.classes.QueryToSync;
import com.isi.isiapi.general.classes.SerialList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class HttpRequest {

    private final String apiKey;
    private boolean debug= false;

    @Deprecated
    public HttpRequest(String serial, String apiKey) {
        this.apiKey = apiKey;
    }

    public void setDebug(boolean debug) {
        this.debug= debug;
    }

    public HttpRequest(String apiKey) {
        this.apiKey = apiKey;
    }


    public SerialList getSerial(String serial){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIORDER, "getSerial", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            return new Gson().fromJson(response, SerialList.class);

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;

    }

    public Commercial getInformation(String serial){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIORDER, "informationAboutMe", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            return new Gson().fromJson(response, Commercial.class);

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;

    }

    public Map<PaymentError.PAYMENT_ERROR, Integer> updateUserPayment(String serial, String privilege){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("privilege", privilege);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIORDER, "updateUserPayment", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            Map<PaymentError.PAYMENT_ERROR, Integer> returned = new HashMap<>();

            if(response.trim().equals("notSet")){
                returned.put(PaymentError.PAYMENT_ERROR.NOT_SET, 0);
            }else if(response.trim().equals("notEnoughMoney")){
                returned.put(PaymentError.PAYMENT_ERROR.NOT_ENOUGHT_MONEY, 0);
            }else{
                returned.put(PaymentError.PAYMENT_ERROR.OK, Integer.parseInt(response.trim().split(":")[1]));
            }

            return returned;

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;

    }

    public Map<PaymentError.PAYMENT_ERROR, Integer> updateWeeklyPayment(String serial, int printer, int guest, int reservation, int chat){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("printer", printer);
        json.addData("guest", guest);
        json.addData("reservation", reservation);
        json.addData("chat", chat);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIORDER, "updateWeeklyPayment", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            Map<PaymentError.PAYMENT_ERROR, Integer> returned = new HashMap<>();

            if(response.trim().equals("notSet")){
                returned.put(PaymentError.PAYMENT_ERROR.NOT_SET, 0);
            }else if(response.trim().equals("notEnoughMoney")){
                returned.put(PaymentError.PAYMENT_ERROR.NOT_ENOUGHT_MONEY, 0);
            }else{
                returned.put(PaymentError.PAYMENT_ERROR.OK, Integer.parseInt(response.trim().split(":")[1]));
            }

            return returned;

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;

    }

    public Map<PaymentError.PAYMENT_ERROR, Integer> activateOrderGuest(String serial, int activation){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("activation", activation);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIORDER, "activateOrderGuest", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            Map<PaymentError.PAYMENT_ERROR, Integer> returned = new HashMap<>();

            switch (response.trim()) {
                case "notSet":
                    returned.put(PaymentError.PAYMENT_ERROR.NOT_SET, 0);
                    break;
                case "notEnoughMoney":
                    returned.put(PaymentError.PAYMENT_ERROR.NOT_ENOUGHT_MONEY, 0);
                    break;
                case "deactivation success":
                    returned.put(PaymentError.PAYMENT_ERROR.DEACTIVATION_SUCCESS, 0);
                    break;
                default:
                    returned.put(PaymentError.PAYMENT_ERROR.OK, Integer.parseInt(response.trim().split(":")[1]));
                    break;
            }

            return returned;

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;

    }

    public Map<PaymentError.PAYMENT_ERROR, Integer> activateReservation(String serial, int activation){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("activation", activation);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIORDER, "activateReservation", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            Map<PaymentError.PAYMENT_ERROR, Integer> returned = new HashMap<>();

            switch (response.trim()) {
                case "notSet":
                    returned.put(PaymentError.PAYMENT_ERROR.NOT_SET, 0);
                    break;
                case "notEnoughMoney":
                    returned.put(PaymentError.PAYMENT_ERROR.NOT_ENOUGHT_MONEY, 0);
                    break;
                case "deactivation success":
                    returned.put(PaymentError.PAYMENT_ERROR.DEACTIVATION_SUCCESS, 0);
                    break;
                default:
                    returned.put(PaymentError.PAYMENT_ERROR.OK, Integer.parseInt(response.trim().split(":")[1]));
                    break;
            }

            return returned;

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;

    }

    public Map<PaymentError.PAYMENT_ERROR, Integer> activateChat(String serial, int activation){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("activation", activation);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIORDER, "activateChat", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            Map<PaymentError.PAYMENT_ERROR, Integer> returned = new HashMap<>();

            switch (response.trim()) {
                case "notSet":
                    returned.put(PaymentError.PAYMENT_ERROR.NOT_SET, 0);
                    break;
                case "notEnoughMoney":
                    returned.put(PaymentError.PAYMENT_ERROR.NOT_ENOUGHT_MONEY, 0);
                    break;
                case "deactivation success":
                    returned.put(PaymentError.PAYMENT_ERROR.DEACTIVATION_SUCCESS, 0);
                    break;
                default:
                    returned.put(PaymentError.PAYMENT_ERROR.OK, Integer.parseInt(response.trim().split(":")[1]));
                    break;
            }

            return returned;

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;

    }

    public boolean insertAllDao(String serial, JsonArray allDao, String tableName, String upload){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("allDao", allDao);
        json.addData("table_name", tableName);
        json.addData("upload", upload);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIORDER, "insertAllDao", json.getData(), apiKey, debug);

        try {
            String response = post.execute().get();

            if(response.trim().equals("endTrasition")){
                return true;
            }

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return false;

    }

    public String downloadAllDatabase(String serial){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIORDER, "downloadAllDatabase", json.getData(), apiKey, debug);

        try {

            return post.execute().get();

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return "";

    }

    public String getCategoryPic(){
        HttpJson json = new HttpJson();
        json.addData("", "");

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIORDER, "categoryPics", json.getData(), apiKey, debug);

        try {

            return post.execute().get();

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return "";
    }

    public String getProductPic(){
        HttpJson json = new HttpJson();
        json.addData("", "");

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIORDER, "productPics", json.getData(), apiKey, debug);

        try {

            return post.execute().get();

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return "";
    }

    public void sendMail(String message, String to){
        HttpJson json = new HttpJson();
        json.addData("message", message);
        json.addData("to", to);


        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIORDER, "sendMail", json.getData(), apiKey, debug);

        try {

            post.execute().get();

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<OrderGuest> getOrderGuest(String serial){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);


        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIORDER, "getOrderGuest", json.getData(), apiKey, debug);

        try{
            String result = post.execute().get();

            return new Gson().fromJson(result, new TypeToken<ArrayList<OrderGuest>>(){}.getType());

        }catch (Exception e){e.printStackTrace();}

        return null;


    }

    public boolean approveOrderGuest(int id){

        HttpJson json = new HttpJson();
        json.addData("id", id);


        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIORDER, "approveOrderGuest", json.getData(), apiKey, debug);

        try{
            String result = post.execute().get();
            return result.trim().equals("ok");

        }catch (Exception e){e.printStackTrace();}

        return false;

    }

    public boolean cancelorderGuest(int id){

        HttpJson json = new HttpJson();
        json.addData("id", id);


        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIORDER, "cancelOrderGuest", json.getData(), apiKey, debug);

        try{
            String result = post.execute().get();
            return result.trim().equals("ok");

        }catch (Exception e){e.printStackTrace();}

        return false;

    }

    public String updateDatabaseVersion(String serial, int version){
        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("version", version);

        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIORDER, "updateDatabaseVersion", json.getData(), apiKey, debug);

        try{

            return post.execute().get();

        }catch (Exception e){e.printStackTrace();}

        return "";

    }

    public boolean uploadProduct(String serial, JsonElement jsonIn){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("json", jsonIn);


        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIORDER, "updateProduct", json.getData(), apiKey, debug);

        try{
            String result = post.execute().get();

            return result.trim().equals("ok");

        }catch (Exception e){e.printStackTrace();}

        return false;

    }

    public boolean uploadCategories(String serial, JsonElement jsonIn){

        HttpJson json = new HttpJson();
        json.addData("serial", serial);
        json.addData("json", jsonIn);


        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIORDER, "uploadCategories", json.getData(), apiKey, debug);

        try{
            String result = post.execute().get();

            return result.trim().equals("ok");

        }catch (Exception e){e.printStackTrace();}

        return false;

    }

    public ArrayList<QueryToSync> getQueryToSync(String serial){
        HttpJson json = new HttpJson();
        json.addData("serial", serial);


        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIORDER, "getQueriesToSync", json.getData(), apiKey, debug);

        try{
            String result = post.execute().get();

            return new Gson().fromJson(result, new TypeToken<ArrayList<QueryToSync>>(){}.getType());

        }catch (Exception e){e.printStackTrace();}

        return null;
    }

    public boolean setQueryExecuted(QueryToSync queryToSync, int status){

        HttpJson json = new HttpJson();
        json.addData("query", queryToSync.Id);
        json.addData("json", status);


        MakeHttpPost post = new MakeHttpPost(CTZON_SERVICE.ISIORDER, "setQueryExecuted", json.getData(), apiKey, debug);

        try{
            String result = post.execute().get();

            return result.trim().equals("ok");

        }catch (Exception e){e.printStackTrace();}

        return false;

    }


}


