package com.eijun.konversi;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

    private Temperatur temperatur ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        temperatur = new Temperatur(this);

        linearLayout_hasil = findViewById(R.id.layout_hasil) ;
        textViewHasil = findViewById(R.id.tv_hasil) ;

        setUpToolbar();

        editText_temp1 = findViewById(R.id.et_1_tempr);
        editText_temp1.setHint(SharedPrefTemp.getTempSymbol1(MainActivity.this));

        editText_temp2 = findViewById(R.id.et_2_tempr);
        editText_temp2.setHint(SharedPrefTemp.getTempSymbol2(MainActivity.this));
        editText_temp2.setKeyListener(null);
        editText_temp2.setClickable(false);




        //spinner y adapter
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_item, temperatures);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        AppCompatSpinner appCompatSpinner1 = findViewById(R.id.spinner_1_tempr);
        appCompatSpinner1.setAdapter(arrayAdapter1);

        //set selection
        appCompatSpinner1.setSelection(SharedPrefTemp.getTempIndex1(MainActivity.this));
        appCompatSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String temp_symbol1 = temperatures[position] ;
                SharedPrefTemp.setTemperature1(MainActivity.this, temp_symbol1, position );
                editText_temp1.setHint(temperatures[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, temperatures) ;
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        AppCompatSpinner appCompatSpinner2 = findViewById(R.id.spinner_2_tempr);
        appCompatSpinner2.setSelection(SharedPrefTemp.getTempIndex2(MainActivity.this));
        appCompatSpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String temp_symbol2 = temperatures[position] ;
                SharedPrefTemp.setTemperature2(MainActivity.this, temp_symbol2, position);
                editText_temp2.setHint(temperatures[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void setUpToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("konversi suhu");
    }
}