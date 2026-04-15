package com.juaracoding.hadir.stepdefinitions;

import com.juaracoding.hadir.pages.admin.ManagementAturanCuti;
import com.juaracoding.hadir.pages.admin.ManagementKalenderPage;
import com.juaracoding.hadir.utils.DriverUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CommonSteps {
    private ManagementAturanCuti aturanPage = new ManagementAturanCuti(DriverUtil.getDriver());
    private ManagementKalenderPage kalenderPage = new ManagementKalenderPage(DriverUtil.getDriver());

    private org.openqa.selenium.support.ui.WebDriverWait wait = new org.openqa.selenium.support.ui.WebDriverWait(DriverUtil.getDriver(), java.time.Duration.ofSeconds(10));

    private String baseUrl = "https://magang.dikahadir.com";

    @Given("admin sudah login")
    public void admin_sudah_login() {
        //login already in AdminLoginPage.java
    }

    @When("^admin membuka halaman (aturan cuti|manajemen kalender|day off)$")
    public void admin_membuka_halaman(String pageName) {
        String targetUrl;

        switch (pageName.toLowerCase()) {
            case "manajemen kalender":
                targetUrl = baseUrl + "/management/calendar";
                break;
            case "aturan cuti":
                targetUrl = baseUrl + "/management/unit-leave";
                break;
            case "day off":
                targetUrl = baseUrl + "/management/day-off";
                break;
            default:
                throw new IllegalArgumentException("Halaman tidak dikenal: " + pageName);
    }

    DriverUtil.getDriver().get(targetUrl);
    
    // Explicit wait using the internal driver from DriverUtil
    new org.openqa.selenium.support.ui.WebDriverWait(DriverUtil.getDriver(), java.time.Duration.ofSeconds(10))
        .until(org.openqa.selenium.support.ui.ExpectedConditions.urlContains(targetUrl.replace(baseUrl, "")));
}

    // ===== SEARCH & RESET LOGIC =====

    // REGEX: Matches "admin mencari kalender dengan kata kunci 'Cuti'" 
    // also matches for "aturan cuti" if you update your feature text.
    @And("^admin mencari (?:kalender|aturan cuti) dengan kata kunci \"([^\"]*)\"$")
    public void admin_mencari_dengan_kata_kunci(String keyword) {
        // Check the current URL to decide which Page Object to use
        if (DriverUtil.getDriver().getCurrentUrl().contains("unit-leave")) {
            aturanPage.inputSearchKeyword(keyword);
            aturanPage.clickSearchButton();
        } else {
            kalenderPage.inputSearchKeyword(keyword);
            kalenderPage.clickSearchButton();
        }
    }

    @And("admin menekan tombol reset pencarian")
    public void admin_menekan_tombol_reset_pencarian() {
        if (DriverUtil.getDriver().getCurrentUrl().contains("unit-leave")) {
            aturanPage.clickResetButton();
        } else {
            kalenderPage.clickResetButton();
        }
    }

    // ===== VERIFICATIONS =====

    @Then("^daftar (.+) harus ditampilkan$")
    public void daftar_harus_ditampilkan(String moduleName) {
        Assert.assertTrue(DriverUtil.getDriver().getCurrentUrl().contains("management"));
    }

    // Matches search success and reset success
    @Then("^daftar (?:kalender|aturan cuti) (?:menampilkan hasil yang sesuai|kembali ke tampilan awal)$")
    public void verify_table_state() {
        // Using the page object to verify table visibility
        Assert.assertTrue(kalenderPage.isKalenderTableDisplayed(), "Table is not displayed after action!");
    }

}