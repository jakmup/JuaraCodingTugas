@admin @managementkalender @Zaki
Feature: Management Kalender;

    Background:
        Given admin sudah login

    Scenario: Melihat daftar kalender
        When admin membuka halaman manajemen kalender
        Then daftar kalender harus ditampilkan

    Scenario: Mencari kalender berdasarkan nama
        When admin membuka halaman manajemen kalender
        And admin mencari kalender dengan kata kunci "Cuti"
        Then daftar kalender menampilkan hasil yang sesuai

    Scenario: Mereset pencarian kalender
        When admin membuka halaman manajemen kalender
        And admin mencari kalender dengan kata kunci "Cuti"
        And admin menekan tombol reset pencarian
        Then daftar kalender kembali ke tampilan awal

    Scenario: Menambahkan kalender baru
        When admin membuka halaman manajemen kalender
        And admin menekan tombol Tambahkan Kalender
        And admin mengisi nama kalender "Test Kalender QA"
        Then daftar kalender harus ditampilkan
    
    Scenario: Menambahkan detail kalender pada kalender baru
        When admin membuka halaman manajemen kalender 
        And admin menekan tombol Tambahkan Kalender
        And admin mengisi nama kalender "Cuti Negara"
        And admin membuka unit kalender "Cuti Negara"
        And admin menekan tombol Tambahkan Kalender Detail
        And admin memilih Tanggal Cuti "03/21/2026"
        And admin memilih Tipe Cuti "CUTI BERSAMA"
        And admin mengisi Deskripsi Tanggal "Ulang Tahun Kantor"
        Then daftar kalender harus ditampilkan

    Scenario: Mengedit kalender
        When admin membuka halaman manajemen kalender
        And admin mengubah nama kalender "Test Kalender" menjadi "Kalender Edit"
        Then daftar kalender harus ditampilkan

    Scenario: Menghapus kalender
        When admin membuka halaman manajemen kalender
        And admin menghapus kalender "Kalender Edit"
        Then daftar kalender harus ditampilkan
