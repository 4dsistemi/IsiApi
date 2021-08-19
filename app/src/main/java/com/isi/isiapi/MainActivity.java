package com.isi.isiapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.isi.isiapi.general.classes.ctzon.CtzonOrder;
import com.isi.isiapi.isiapp.HttpRequest;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String apiKey = "a6b602d858ae0da189dacd297";
    public static String serial = "TN1119BW40088";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<CtzonOrder> orders = new HttpRequest(apiKey).getCtzonOrder(serial);

    }
}