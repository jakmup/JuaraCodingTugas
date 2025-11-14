package com.juaracoding.tugas;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String[][] belanja = {
            {"roti", "50000"},
            {"susu", "20000"},
            {"soda", "30000"},
            {"tisu", "10000"},
        };

        double grandTotal = 0;

        for(int i = 0; i < belanja.length; i++) {
            double harga = Double.parseDouble(belanja[i][1]);
            grandTotal += harga;
        }

        double diskon = 50;
        double hargaDiskon = grandTotal * (diskon / 100);
        double totalAfterDiskon = grandTotal - hargaDiskon;

        System.out.println("Summary");
        System.out.println("-----------------------");

        System.out.println("Harga before discount: " + grandTotal);
        System.out.println("Diskon: " + diskon + "%");
        System.out.println("Harga diskon: " + hargaDiskon);
        System.out.println("Harga after discount: " + totalAfterDiskon);
    }
}
