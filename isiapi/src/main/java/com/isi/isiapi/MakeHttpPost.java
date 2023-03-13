package com.isi.isiapi;

import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MakeHttpPost{

    private final String intent;
    private final JsonObject data;
    private final String apiKey;
    private final WebControllers webController;

    public MakeHttpPost(String intent, JsonObject data, String apiKey, WebControllers webController){
        this.intent = intent;
        this.data = data;
        this.apiKey = apiKey;
        this.webController = webController;
    }

    public String post() throws IOException {

        final MediaType JSON
                = MediaType.get("application/json; charset=utf-8");

        HttpData data = new HttpData(intent, this.data);

        OkHttpClient client = new OkHttpClient.Builder().writeTimeout(5, TimeUnit.SECONDS).readTimeout(15, TimeUnit.SECONDS).connectTimeout(2, TimeUnit.SECONDS).build();

        RequestBody body = RequestBody.create(data.generateJson(data), JSON);
        Request request = new Request.Builder()
                .addHeader("authorization", apiKey)
                .url("http://"+ HttpRequest.serverIpAddress +":9000/api/" + webController.name() + "/")
                .post(body)
                .build();
        try {
            Response response = client.newCall(request).execute();
            if(response.body() != null){
                return Objects.requireNonNull(response.body()).string();
            }else{
                return "";
            }
        }catch (Exception ignored){
            return "";
        }
    }


}