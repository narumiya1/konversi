package com.eijun.konversi;

import android.content.Context;

public class Temperatur {
    private Context context ;

    public Temperatur(Context context) {
        this.context = context;
    }

    /**
     *
     * rumus celcius
     */

    public String CelciusToReamur(double celcius) {
        // R = (4/5) x C or R = C x 0,8
        double R = (4.0/5.0) * celcius ;
        return check_after_decimal_point(R) ;
    }

    public String CeliusToFahrenheit(double celcius) {
        double F = (9.0/5.0) * celcius + 32 ;
        return check_after_decimal_point(F) ;
    }

    public String CelciusToKelvn(double celcius) {
        double K = celcius + 273.15 ;
        return  check_after_decimal_point(K);
    }


    public String check_after_decimal_point(double decimal) {

        String result = null ;
        String[] after_point =  String.valueOf(decimal).split("[:.]") ;

        if (after_point[after_point.length-1].equals("0")) {
            result =  after_point[0];
        }else {
            result = String.valueOf(decimal).replace(".",",") ;
        }

        return result ;

    }

    public String getRumus(String symbol1, String symbol2, double value_to_coversion, String result) {

        String results = null ;
        //C to R
        if ( symbol1.equals("\u00B0C") && symbol2.equals("\u00B0R")) {
            results = symbol2 + " = " +symbol1+ " x 0,8 \n" + symbol2 +
                    " = " +check_after_decimal_point(value_to_coversion) +" x 0,8\n " +symbol2+ " = " +result;
        }
        //C -> F
        else if(symbol1.equals("\u00B0C") && symbol2.equals("\u00B0F")) {
            results = symbol2 + " = " +symbol1+ " x 9/5 \n" + symbol2 +
                    " = " +check_after_decimal_point(value_to_coversion) + " x 9/5\n" +symbol2+ " = " +result ;
        }else if(symbol1.equals("\u00B0C") && symbol2.equals("K")) {
            results = symbol2 + " = " +symbol1+ " + 273,5 \n " +symbol1 +
                    " = " +check_after_decimal_point(value_to_coversion) + " +273,5 " +symbol2+ " = " +result ;
        }

        return results ;
    }

}
