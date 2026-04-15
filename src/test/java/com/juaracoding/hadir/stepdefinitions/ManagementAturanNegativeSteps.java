package com.juaracoding.hadir.stepdefinitions;

import com.juaracoding.hadir.pages.admin.ManagementAturanCuti;
import com.juaracoding.hadir.utils.DriverUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.testng.Assert;

public class ManagementAturanNegativeSteps {

    private ManagementAturanCuti aturanPage = new ManagementAturanCuti(DriverUtil.getDriver());

    @And("admin mengisi Nama Aturan Cuti dummy {string}")
    public void inputAturanNameNeg(String name) {
        aturanPage.inputNama(name);
        aturanPage.clickSimpan();
    }



    @Then("pesan kesalahan {string} harus ditampilkan")
    public void pesan_kesalahan_harus_ditampilkan(String expectedError) {
        String actualError = aturanPage.getErrorMessage();
        Assert.assertTrue(actualError.toLowerCase().contains(expectedError.toLowerCase()), 
            "Ekspektasi error: " + expectedError + " tapi muncul: " + actualError);
    }

    @Then("tabel harus menampilkan pesan {string}")
    public void tabel_harus_menampilkan_pesan(String expectedMsg) {
        // Mengecek apakah teks pesan muncul di dalam body tabel/halaman
        boolean isDisplayed = DriverUtil.getDriver().getPageSource().contains(expectedMsg);
        Assert.assertTrue(isDisplayed, "Pesan '" + expectedMsg + "' tidak muncul di layar!");
    }
}