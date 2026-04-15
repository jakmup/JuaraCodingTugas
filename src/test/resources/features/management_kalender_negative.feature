@admin @managementkalendernegative @Zaki
Feature: Management Kalender Negative Path

    Background:
        Given admin sudah login
        When admin membuka halaman manajemen kalender

    Scenario: Gagal menambahkan kalender karena nama kosong
        And admin menekan tombol Tambahkan Kalender
        And admin input nama kalender dummy ""
        Then pesan kesalahan kalender "Nama kalender harus diisi" harus ditampilkan

    Scenario: Gagal menambahkan kalender karena nama tidak valid
        And admin menekan tombol Tambahkan Kalender
        And admin input nama kalender dummy "xyz123!"
        Then pesan kesalahan kalender "Nama kalender harus valid!" harus ditampilkan

    Scenario: Gagal menambahkan kalender dengan nama duplikat
        And admin menekan tombol Tambahkan Kalender
        And admin input nama kalender dummy "Cuti Negara"
        Then pesan kesalahan kalender "Nama kalender sudah digunakan" harus ditampilkan