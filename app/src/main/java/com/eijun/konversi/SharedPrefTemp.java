package com.eijun.konversi;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

//menampilkan data sementara hasil perhitungan di menu utama
public class SharedPrefTemp {

    public static SharedPreferences sharedPreferences ;
    public static SharedPreferences.Editor editor ;

    public static void setTemperature1 (Context context, String temperature, int index ) {

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context) ;
        editor = sharedPreferences.edit();

        editor.putString("temp_symbol_1",temperature);
        editor.putInt("temp_index_1",index);
        editor.apply();
    }

    public static void setTemperature2 (Context context, String temperature, int index ) {

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context) ;
        editor = sharedPreferences.edit();

        editor.putString("temp_symbol_2",temperature);
        editor.putInt("temp_index_2",index);
        editor.apply();
    }

    public static String getTempSymbol1(Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString("temp_symbol_1", "");
    }


    public static String getTempSymbol2(Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString("temp_symbol_2", "");
    }

    public static  int getTempIndex1(Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getInt("temp_index_1",0) ;
    }


    public static  int getTempIndex2(Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getInt("temp_index_2",0) ;
    }


}
