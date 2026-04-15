@admin @managementdayoff @Zaki
Feature: Management Day Off;

    Background:
        Given admin sudah login

    Scenario: Melihat daftar Day Off
        When admin membuka halaman day off 
        Then daftar day off harus ditampilkan