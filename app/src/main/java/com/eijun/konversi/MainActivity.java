package com.eijun.konversi;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {


    private TextView textViewHasil ;
    private AppCompatEditText editText_temp1, editText_temp2 ;
    private LinearLayout linearLayout_hasil ;
    private String[] temperatures = new String[]{
            "\u00B0C",
            "\u00B0R",
            "\u00B0F",
            "K"
    } ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout_hasil = findViewById(R.id.layout_hasil) ;
        textViewHasil = findViewById(R.id.tv_hasil) ;
        editText_temp1 = findViewById(R.id.et_1_tempr);

        editText_temp2 = findViewById(R.id.et_2_tempr);

        setUpToolbar();

    }

    private void setUpToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("konversi suhu");
    }
}