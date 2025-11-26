package com.juaracoding.zakimufthi.swaglabs;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.juaracoding.zakimufthi.swaglabs.utils.MiscUtil;

public class SampleTest {
  @Test
  public void test() {
    ArrayList<BigDecimal> daftarHargaTakBerurut = new ArrayList<>(List.of(
        new BigDecimal("1000.00"),
        new BigDecimal("2500.50"),
        new BigDecimal("5000.00"),
        new BigDecimal("12500.25"),
        new BigDecimal("99000.99"),
        new BigDecimal("150000.00"),
        new BigDecimal("750.00"),
        new BigDecimal("3000.00"),
        new BigDecimal("4500.75"),
        new BigDecimal("1000000.00")
    ));
  
    ArrayList<BigDecimal> dataUrut = new ArrayList<>(List.of(
        new BigDecimal("0.01"),           // Terkecil
        new BigDecimal("50.00"),
        new BigDecimal("100.50"),
        new BigDecimal("500.00"),
        new BigDecimal("1250.75"),
        new BigDecimal("9999.99"),
        new BigDecimal("25000.00"),
        new BigDecimal("100000.00"),
        new BigDecimal("5500000.50"),
        new BigDecimal("999999999.99")    // Terbesar
    ));

    System.out.println("Hasil tak berurutan: " + MiscUtil.isSorted(daftarHargaTakBerurut));
    System.out.println("Hasil berurutan: " + MiscUtil.isSorted(dataUrut));
  } 
}
