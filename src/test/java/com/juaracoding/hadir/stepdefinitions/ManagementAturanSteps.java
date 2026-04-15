package com.juaracoding.hadir.stepdefinitions;

import com.juaracoding.hadir.pages.admin.ManagementAturanCuti;
import com.juaracoding.hadir.utils.DriverUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class ManagementAturanSteps {
    private ManagementAturanCuti aturanPage = new ManagementAturanCuti(DriverUtil.getDriver());

    @And("admin menekan tombol Tambahkan Aturan Cuti")
    public void clickAddAturan() {
        aturanPage.clickTambahAturan();
    }

    @And("admin mengisi Nama Aturan Cuti {string}")
    public void inputAturanName(String name) {
        aturanPage.inputNama(name);
    }

    @And("admin mengisi Eligible Pengaturan Cuti {string}")
    public void inputEligibleNum(String num) {
        aturanPage.inputEligible(num);
    }

    @And("admin mengisi Tanggal Batas Sisa Cuti {string}")
    public void inputTanggalBatas(String date) {
        aturanPage.inputTglBatas(date);
    }

    @And("admin mengisi Bulan Batas Sisa Cuti {string}")
    public void inputBulanBatas(String date) {
        aturanPage.inputBulanBatas(date);
    }

    @And("admin mengisi Maksimal Sisa Cuti {string}")
    public void inputMaxSisaCuti(String num) {
        aturanPage.inputMaxSisa(num);
    }

    @And("admin mengisi Jumlah Bulan Kerja Sisa Cuti {string}")
    public void inputBulanSisa(String num) {
        aturanPage.inputBulanKerja(num);
    }

    @And("admin mengisi Minimal Bulan Bekerja {string}")
    public void inputMinBulan(String num) {
        aturanPage.inputMinimKerja(num);
        aturanPage.saveAturanDialog();
    }

    @And("admin mengisi Total Cuti {string}")
    public void inputTotCut(String num) {
        aturanPage.inputTotalCuti(num);
    }

    @And("admin membuka aturan cuti {string}")
    public void bukaAturanDetail(String name) {
        aturanPage.inputSearchKeyword(name);
        aturanPage.clickSearchButton();
        aturanPage.clickMenuAction(name);
        aturanPage.selectOption("View");

        aturanPage.waitForPageLoad();
    }

    @And("admin menekan tombol Tambahkan Detail Aturan Cuti")
    public void addDetail() {
        aturanPage.clickTambahDetail();
    }

    // This handles the Edit click and name change
    @And("admin mengubah Nama Aturan Cuti {string} menjadi {string}")
    public void editAturan(String oldName, String newName) {
        aturanPage.inputSearchKeyword(oldName);
        aturanPage.clickSearchButton();
        aturanPage.clickMenuAction(oldName);
        aturanPage.selectOption("Edit");
        aturanPage.inputNama(newName);
        aturanPage.saveAturanDialog();
    }

    @And("admin menghapus Nama Aturan Cuti {string}")
    public void hapusAturan(String name) {
        aturanPage.inputSearchKeyword(name);
        aturanPage.clickSearchButton();
        aturanPage.clickMenuAction(name);
        aturanPage.selectOption("Delete");
        aturanPage.saveAturanDel();

    }
}