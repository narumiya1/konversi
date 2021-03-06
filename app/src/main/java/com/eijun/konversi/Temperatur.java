package com.eijun.konversi;

import android.content.Context;

public class Temperatur {
    private Context context;

    public Temperatur(Context context) {
        this.context = context;
    }

    /**
     * rumus celcius
     */

    public String CelciusToReamur(double celcius) {
        // R = (4/5) x C or R = C x 0,8
        double R = (4.0 / 5.0) * celcius;
        return check_after_decimal_point(R);
    }

    public String CeliusToFahrenheit(double celcius) {
        double F = (9.0 / 5.0) * celcius + 32;
        return check_after_decimal_point(F);
    }

    public String CelciusToKelvn(double celcius) {
        double K = celcius + 273.15;
        return check_after_decimal_point(K);
    }


    /**
     * rumus celcius
     */

    public String ReamurToCelcius(double reamur) {
        double C = reamur / 0.8;
        return check_after_decimal_point(C);
    }

    public String ReamurToFahrenheit(double reamur) {
        double F = reamur * 2.25 + 32;
        return check_after_decimal_point(F);
    }

    public String ReamurToKelvin(double reamur) {
        double K = reamur / 0.8 + 273.15;
        return check_after_decimal_point(K);
    }


    /**
     * rumus fahrenheit
     */

    public String FahrenheitToCelcius (double fahrenheit) {
      double C = (fahrenheit - 32) / 1.8 ;
      return  check_after_decimal_point(C) ;
    }

    public String FahrenheitToReamur(double fahrenheit) {
        double R =  (fahrenheit - 32) / 0.44;
        return check_after_decimal_point(R) ;
    }

    public  String FahrenheitToKelvn (double fahrenheit) {
        double K = (fahrenheit + 459.67) / 1.8 ;
        return  check_after_decimal_point( K ) ;
    }



    public String check_after_decimal_point(double decimal) {

        String result = null;

        String[] after_point = String.valueOf(decimal).split("[:.]");

        if (after_point[after_point.length - 1].equals("0")) {
            result = after_point[0];
        } else {
            result = String.valueOf(decimal).replace(".", ",");
        }

        return result;

    }

    public String getRumus(String symbol1, String symbol2, double value_to_coversion, String result) {

        String results = null;
        //Celsius
        if (symbol1.equals("\u00B0C") && symbol2.equals("\u00B0R")) {
            results = symbol2 + " = " + symbol1 + " x 0,8 \n" + symbol2 +
                    " = " + check_after_decimal_point(value_to_coversion) + " x 0,8\n " + symbol2 + " = " + result;
        } else if (symbol1.equals("\u00B0C") && symbol2.equals("\u00B0F")) {
            results = symbol2 + " = " + symbol1 + " x 9/5 \n" + symbol2 +
                    " = " + check_after_decimal_point(value_to_coversion) + " x 9/5\n" + symbol2 + " = " + result;
        } else if (symbol1.equals("\u00B0C") && symbol2.equals("K")) {
            results = symbol2 + " = " + symbol1 + " + 273,5 \n " + symbol1 +
                    " = " + check_after_decimal_point(value_to_coversion) + " +273,5 " + symbol2 + " = " + result;
        }
        //Reamur
        else if (symbol1.equals("\u00B0R") && symbol2.equals("\u00B0C")) {
            results = symbol2 + " = " + symbol1 + " * 0,8 \n" + symbol2 +
                    " = " + check_after_decimal_point(value_to_coversion) + " * 0,8 " + symbol2 + " = " + result;
        } else if (symbol1.equals("\u00B0R") && symbol2.equals("\u00B0F")) {
            results = symbol2 + " = " + symbol1 + " * 2,25 + 32 \n" + symbol2 +
                    " = " + check_after_decimal_point(value_to_coversion) + " *2,25 + 32" + symbol2 + " \n \t\t  = " + result;

        } else if (symbol1.equals("\u00B0R") && symbol2.equals("K")) {
            results = symbol2 + " = " + symbol1 + " / 0,8 + 273,15 \n " + symbol2 +
                    " = " + check_after_decimal_point(value_to_coversion) + " / 0,8 + 273,15 \n \t\t = " + result;

        }
        //Fahrenheit
        else  if (symbol1.equals("\u00B0F") && symbol2.equals("\u00B0C")) {
            results = symbol2 + " = " +symbol1+ " - 32 / 1,8 \n" +symbol2 +
                    " = " +check_after_decimal_point(value_to_coversion)+ " -32 / 1,8 \n \t\t" +result;

        }
        else  if (symbol1.equals("\u00B0F") && symbol2.equals("\u00B0R")) {
            results = symbol2 + " = " +symbol1+ " - 32 / 0,44 \n" +symbol2 +
                    " = " +check_after_decimal_point(value_to_coversion)+ " -32 / 0,44 \n \t\t" +result;

        }
        else  if (symbol1.equals("\u00B0F") && symbol2.equals("K")) {
            results = symbol2 + " = " +symbol1+ " - 32 / 1,8 \n" +symbol2 +
                    " = (" +check_after_decimal_point(value_to_coversion)+ "+ 459,67 ) / 1,8 \n \t\t" +result;

        }


        return results;
    }

}
