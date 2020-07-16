package com.eijun.konversi;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {


    private TextView textViewHasil;
    private AppCompatEditText editText_temp1, editText_temp2;
    private LinearLayout linearLayout_hasil;
    private String[] temperatures = new String[]{
            "\u00B0C",
            "\u00B0R",
            "\u00B0F",
            "K"
    };

    private Temperatur temperatur;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        temperatur = new Temperatur(this);

        linearLayout_hasil = findViewById(R.id.layout_hasil);
        textViewHasil = findViewById(R.id.tv_hasil);

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

                String temp_symbol1 = temperatures[position];
                SharedPrefTemp.setTemperature1(MainActivity.this, temp_symbol1, position);
                editText_temp1.setHint(temperatures[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //spinner y adater 2
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, temperatures);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        AppCompatSpinner appCompatSpinner2 = findViewById(R.id.spinner_2_tempr);
        appCompatSpinner2.setAdapter(arrayAdapter2);
        appCompatSpinner2.setSelection(SharedPrefTemp.getTempIndex2(MainActivity.this));
        appCompatSpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String temp_symbol2 = temperatures[position];
                SharedPrefTemp.setTemperature2(MainActivity.this, temp_symbol2, position);
                editText_temp2.setHint(temperatures[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        AppCompatButton btn_count = findViewById(R.id.btn_count);
        btn_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Objects.requireNonNull(editText_temp1.getText()).toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Masukan nilai suhu yang ingin dikonversi", Toast.LENGTH_SHORT).show();
                } else {

                    if (linearLayout_hasil.getVisibility() == View.GONE) {
                        linearLayout_hasil.setVisibility(View.VISIBLE);
                    }

                    String symbol_temp1 = SharedPrefTemp.getTempSymbol1(MainActivity.this);
                    String symbol_temp2 = SharedPrefTemp.getTempSymbol2(MainActivity.this);

                    double value_to_convertion = Double.parseDouble(editText_temp1.getText().toString());

                    if (symbol_temp1.equals("\u00B0C") && symbol_temp2.equals("\u00B0R")) {
                        editText_temp2.setText(temperatur.CelciusToReamur(value_to_convertion));
                        textViewHasil.setText(temperatur.getRumus("\u00B0C", "\u00B0R",
                                value_to_convertion, temperatur.CelciusToReamur(value_to_convertion)));

                    } else if (symbol_temp1.equals("\u00B0C") && symbol_temp2.equals("\u00B0F")) {
                        editText_temp2.setText(temperatur.CeliusToFahrenheit(value_to_convertion));
                        textViewHasil.setText(temperatur.getRumus("\u00B0C", "\u00B0F",
                                value_to_convertion, temperatur.CeliusToFahrenheit(value_to_convertion)));

                    } else if (symbol_temp1.equals("\u00B0C") && symbol_temp2.equals("K")) {
                        editText_temp2.setText(temperatur.CelciusToKelvn(value_to_convertion));
                        textViewHasil.setText(temperatur.getRumus("\u00B0C", "K",
                                value_to_convertion, temperatur.CelciusToKelvn(value_to_convertion)));

                    }

                    // Reamur

                    else if (symbol_temp1.equals("\u00B0R") && symbol_temp2.equals("\u00B0C")) {
                        editText_temp2.setText(temperatur.ReamurToCelcius(value_to_convertion));
                        textViewHasil.setText(temperatur.getRumus("\u00B0R", "\u00B0C",
                                value_to_convertion, temperatur.ReamurToCelcius(value_to_convertion)));
                    } else if (symbol_temp1.equals("\u00B0R") && symbol_temp2.equals("\u00B0F")) {
                        editText_temp2.setText(temperatur.ReamurToFahrenheit(value_to_convertion));
                        textViewHasil.setText(temperatur.getRumus("\u00B0R", "\u00B0F",
                                value_to_convertion, temperatur.ReamurToFahrenheit(value_to_convertion)));
                    } else if (symbol_temp1.equals("\u00B0R") && symbol_temp2.equals("K")) {
                        editText_temp2.setText(temperatur.ReamurToKelvin(value_to_convertion));
                        textViewHasil.setText(temperatur.getRumus("\u00B0R", "K",
                                value_to_convertion, temperatur.ReamurToKelvin(value_to_convertion)));
                    }

                    //Fahrenheit
                    else if(symbol_temp1.equals("\u00B0F") & symbol_temp2.equals("\u00B0C")) {
                        editText_temp2.setText(temperatur.FahrenheitToCelcius(value_to_convertion));
                        textViewHasil.setText(temperatur.getRumus("\u00B0F", "\u00B0C",
                                value_to_convertion, temperatur.FahrenheitToCelcius(value_to_convertion)));

                    }

                    else if(symbol_temp1.equals("\u00B0F") & symbol_temp2.equals("\u00B0R")) {
                        editText_temp2.setText(temperatur.FahrenheitToReamur(value_to_convertion));
                        textViewHasil.setText(temperatur.getRumus("\u00B0F", "\u00B0R",
                                value_to_convertion, temperatur.FahrenheitToReamur(value_to_convertion)));

                    }

                    else if(symbol_temp1.equals("\u00B0F") & symbol_temp2.equals("K")) {
                        editText_temp2.setText(temperatur.FahrenheitToCelcius(value_to_convertion));
                        textViewHasil.setText(temperatur.getRumus("\u00B0F", "K",
                                value_to_convertion, temperatur.FahrenheitToKelvn(value_to_convertion)));

                    }

                    else if (symbol_temp1.equals("\u00B0C") && symbol_temp2.equals("\u00B0C")) {
                        editText_temp2.setText(temperatur.check_after_decimal_point(value_to_convertion));
                        textViewHasil.setText("\u00B0C  =  " + temperatur.check_after_decimal_point(value_to_convertion));
                    } else if (symbol_temp1.equals("\u00B0R") && symbol_temp2.equals("\u00B0R")) {
                        editText_temp2.setText(temperatur.check_after_decimal_point(value_to_convertion));
                        textViewHasil.setText(" \u00B0R = " + temperatur.check_after_decimal_point(value_to_convertion));


                    } else if (symbol_temp1.equals("\u00B0F") && symbol_temp2.equals("\u00B0F")) {
                        editText_temp2.setText(temperatur.check_after_decimal_point(value_to_convertion));
                        textViewHasil.setText("\u00B0F  =  " + temperatur.check_after_decimal_point(value_to_convertion));
                    }

                    else if (symbol_temp1.equals("K") && symbol_temp2.equals("K")){
                        editText_temp2.setText(temperatur.check_after_decimal_point(value_to_convertion));
                        textViewHasil.setText("K = " +temperatur.check_after_decimal_point(value_to_convertion)  );
                    }


                }
            }
        });


    }

    private void setUpToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Konversi suhu");
    }
}