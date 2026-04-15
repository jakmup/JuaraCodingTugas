@admin @managementaturan @Zaki
Feature: Management Aturan Cuti;

    Background:
        Given admin sudah login

    Scenario: Melihat daftar aturan cuti
        When admin membuka halaman aturan cuti
        Then daftar aturan cuti harus ditampilkan

    Scenario: Mencari aturan cuti berdasarkan nama
        When admin membuka halaman aturan cuti
        And admin mencari aturan cuti dengan kata kunci "Cuti"
        Then daftar aturan cuti menampilkan hasil yang sesuai

    Scenario: Mereset pencarian aturan cuti
        When admin membuka halaman aturan cuti
        And admin mencari aturan cuti dengan kata kunci "Cuti"
        And admin menekan tombol reset pencarian
        Then daftar aturan cuti kembali ke tampilan awal

    Scenario: Menambahkan aturan cuti baru
        When admin membuka halaman aturan cuti
        And admin menekan tombol Tambahkan Aturan Cuti
        And admin mengisi Nama Aturan Cuti "Cuti Khusus x"
        And admin mengisi Eligible Pengaturan Cuti "2"
        And admin mengisi Tanggal Batas Sisa Cuti "3"
        And admin mengisi Bulan Batas Sisa Cuti "4"
        And admin mengisi Maksimal Sisa Cuti "3"
        And admin mengisi Jumlah Bulan Kerja Sisa Cuti "5"
        Then daftar aturan cuti harus ditampilkan

    Scenario: Menambahkan detail aturan pada aturan cuti baru
        When admin membuka halaman aturan cuti 
        And admin membuka aturan cuti "Cuti Khusus x"
        And admin menekan tombol Tambahkan Detail Aturan Cuti
        And admin mengisi Minimal Bulan Bekerja "3"
        And admin mengisi Total Cuti "5"
        Then daftar aturan cuti harus ditampilkan
    
    Scenario: Mengedit aturan cuti
        When admin membuka halaman aturan cuti
        And admin mengubah Nama Aturan Cuti "Cuti Khusus x" menjadi "Cuti Khusus y"
        Then daftar aturan cuti harus ditampilkan

    Scenario: Menghapus aturan cuti
        When admin membuka halaman aturan cuti
        And admin menghapus Nama Aturan Cuti "Cuti Khusus y"
        Then daftar aturan cuti harus ditampilkan