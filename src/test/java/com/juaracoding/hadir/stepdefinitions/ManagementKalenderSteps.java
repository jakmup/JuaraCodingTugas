package com.juaracoding.hadir.stepdefinitions;

import com.juaracoding.hadir.pages.admin.ManagementKalenderPage;
import com.juaracoding.hadir.utils.DriverUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class ManagementKalenderSteps {
    private ManagementKalenderPage kalenderPage = new ManagementKalenderPage(DriverUtil.getDriver());

 
    @And("admin menekan tombol Tambahkan Kalender")
    public void clickAdd() {
        kalenderPage.clickTambahKalender();
    }

    @And("admin menekan tombol Tambahkan Kalender Detail")
    public void clickAddDetail() {
        kalenderPage.clickTambahKalenderDetail();
    }

    @And("admin mengisi nama kalender {string}")
    public void inputName(String name) {
        kalenderPage.inputKalenderName(name);
        kalenderPage.saveAturanDialog();
    }

    @And("admin membuka unit kalender {string}")
    public void bukaKalender(String name) {
        kalenderPage.inputSearchKeyword(name);
        kalenderPage.clickSearchButton();
        kalenderPage.clickMenuAction(name);
        kalenderPage.selectOption("View");
        
        // ADD THIS: Wait for the new page/view to actually be ready 
        // before the next "Tambahkan Kalender" button is clicked
        kalenderPage.waitForPageLoad(); 
    }

    @And("admin memilih Tanggal Cuti {string}")
    public void tanggalCuti(String date) {
        kalenderPage.inputTanggal(date);
    }

    @And("admin memilih Tipe Cuti {string}")
    public void tipeCuti(String optionText) {
        kalenderPage.selectTipeCuti(optionText);
    }

    @And("admin mengisi Deskripsi Tanggal {string}")
    public void tanggalDeskripsi(String description) {
        kalenderPage.inputDeskripsi(description);
        kalenderPage.saveAturanDialog();
    }

    @And("admin mengubah nama kalender {string} menjadi {string}")
    public void editKalender(String oldName, String newName) {
        kalenderPage.inputSearchKeyword(oldName);
        kalenderPage.clickSearchButton();
        kalenderPage.clickMenuAction(oldName);
        kalenderPage.selectOption("Edit");
        kalenderPage.inputKalenderName(newName);
        kalenderPage.saveAturanDialog();
    }

    @And("admin menghapus kalender {string}")
    public void deleteKalender(String name) {
        kalenderPage.inputSearchKeyword(name);
        kalenderPage.clickSearchButton();
        kalenderPage.clickMenuAction(name);
        kalenderPage.selectOption("Delete");
        kalenderPage.saveKalender();
    }

}