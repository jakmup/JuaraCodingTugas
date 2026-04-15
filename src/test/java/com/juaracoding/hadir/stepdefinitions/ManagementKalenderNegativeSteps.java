package com.juaracoding.hadir.stepdefinitions;

import com.juaracoding.hadir.pages.admin.ManagementKalenderPage;
import com.juaracoding.hadir.utils.DriverUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.testng.Assert;

public class ManagementKalenderNegativeSteps {

    // Menggunakan Page Object ManagementKalenderPage
    private ManagementKalenderPage kalenderPage = new ManagementKalenderPage(DriverUtil.getDriver());

    // Diubah menjadi "input nama kalender dummy" agar tidak duplikat dengan "Aturan Cuti"
    @And("admin input nama kalender dummy {string}")
    public void inputKalenderNameNeg(String name) {
        kalenderPage.inputKalenderName(name); // Pastikan nama method di Page Object sesuai
        kalenderPage.clickSimpan(); // Method untuk klik tombol simpan/tambah
    }

    // Diubah menjadi "pesan kesalahan kalender" agar unik
    @Then("pesan kesalahan kalender {string} harus ditampilkan")
    public void pesan_kesalahan_kalender_ditampilkan(String expectedError) {
        String actualError = kalenderPage.getErrorMessage();
        Assert.assertTrue(actualError.toLowerCase().contains(expectedError.toLowerCase()), 
            "Ekspektasi error: " + expectedError + " tapi muncul: " + actualError);
    }
}