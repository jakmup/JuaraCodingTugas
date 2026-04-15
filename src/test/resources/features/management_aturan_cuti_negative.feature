@admin @managementaturannegative @Zaki
Feature: Management Aturan Cuti Negative Path

    Background:
        Given admin sudah login
        When admin membuka halaman aturan cuti

    Scenario: Gagal menambahkan aturan cuti karena nama kosong
        And admin menekan tombol Tambahkan Aturan Cuti
        And admin mengisi Nama Aturan Cuti dummy ""
        Then pesan kesalahan "Nama aturan cuti harus diisi" harus ditampilkan

    Scenario: Gagal menambahkan aturan cuti karena nama tidak valid
        And admin menekan tombol Tambahkan Aturan Cuti
        And admin mengisi Nama Aturan Cuti dummy "dshagdj"
        And pesan kesalahan "Nama aturan harus valid!" harus ditampilkan

    Scenario: Gagal menambahkan aturan cuti dengan nama duplikat
        And admin menekan tombol Tambahkan Aturan Cuti
        And admin mengisi Nama Aturan Cuti dummy "Cuti Khusus x"
        And admin menekan tombol Tambahkan Aturan Cuti
        And admin mengisi Nama Aturan Cuti dummy "Cuti Khusus x"
        Then pesan kesalahan "Nama aturan sudah digunakan" harus ditampilkan

