package com.isi.isiapi;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.JsonObject;
import com.isi.isiapi.general.CTZON_SERVICE;
import com.isi.isiapi.general.HttpData;
import com.isi.isiapi.general.Service;
import com.isi.isiapi.general.Website;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class MakeHttpPost extends AsyncTask<Void, Void, String> {

    private final String intent;
    private final JsonObject data;
    private final String apiKey;
    private final boolean debug;
    private final String service;

    public MakeHttpPost(CTZON_SERVICE service, String intent, JsonObject data, String apiKey, boolean debug){
        this.intent = intent;
        this.data = data;
        this.apiKey = apiKey;
        this.service = Service.getService(service);
        this.debug = debug;
    }

    @Override
    protected String doInBackground(Void... params) {

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;

        URL url;
        try {

            String urlReferred = Website.release;

            if(debug){
                urlReferred = Website.debug;
            }

            urlReferred += service;

            url = new URL(urlReferred);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000);
            urlConnection.setConnectTimeout(15000);
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setRequestProperty("content-type", "application/json");
            urlConnection.setRequestProperty("authorization", apiKey);

            HttpData data = new HttpData(intent, this.data);

            DataOutputStream os = new DataOutputStream(urlConnection.getOutputStream());
            os.writeBytes(data.generateJson(data));
            os.close();

            int statusCode = urlConnection.getResponseCode();

            if(statusCode == 200){
                InputStream inputStream = urlConnection.getInputStream();
                StringBuilder buffer = new StringBuilder();
                if (inputStream == null) {
                    return "";
                }
                reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

                String line;
                while ((line = reader.readLine()) != null){
                    buffer.append(line).append("\n");
                }


                if (buffer.length() == 0){
                    return "";
                }

                return buffer.toString();
            }else{
                return "";
            }

        } catch (IOException e) {
            e.printStackTrace();
            //exception = e;
            return "";
        } finally {

            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (final IOException e) {
                    Log.e("test", "Error closing stream", e);
                }
            }
        }
    }

}