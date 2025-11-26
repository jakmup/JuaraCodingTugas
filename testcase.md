# Test Case Login saucedemo.com

## Test Case 1: Login Berhasil

*   **Test Case ID:** TC-LOGIN-001
*   **Judul:** Login berhasil dengan kredensial yang valid
*   **Skenario:**
    Pengguna memasukkan username `standard_user` dan password `secret_sauce` yang valid, kemudian menekan tombol login.
*   **Langkah-langkah:**
    1.  Buka browser dan navigasi ke https://www.saucedemo.com/
    2.  Masukkan `standard_user` di kolom username.
    3.  Masukkan `secret_sauce` di kolom password.
    4.  Klik tombol "Login".
*   **Hasil yang Diharapkan:**
    Pengguna berhasil login dan diarahkan ke halaman inventaris produk (`/inventory.html`).

## Test Case 2: Login Gagal - Username Salah

*   **Test Case ID:** TC-LOGIN-002
*   **Judul:** Login gagal dengan username yang salah
*   **Skenario:**
    Pengguna memasukkan username yang salah dan password yang benar.
*   **Langkah-langkah:**
    1.  Buka browser dan navigasi ke https://www.saucedemo.com/
    2.  Masukkan `invalid_user` di kolom username.
    3.  Masukkan `secret_sauce` di kolom password.
    4.  Klik tombol "Login".
*   **Hasil yang Diharapkan:**
    Pengguna gagal login dan pesan error "Epic sadface: Username and password do not match any user in this service" ditampilkan.

## Test Case 3: Login Gagal - Password Salah

*   **Test Case ID:** TC-LOGIN-003
*   **Judul:** Login gagal dengan password yang salah
*   **Skenario:**
    Pengguna memasukkan username yang benar dan password yang salah.
*   **Langkah-langkah:**
    1.  Buka browser dan navigasi ke https://www.saucedemo.com/
    2.  Masukkan `standard_user` di kolom username.
    3.  Masukkan `invalid_password` di kolom password.
    4.  Klik tombol "Login".
*   **Hasil yang Diharapkan:**
    Pengguna gagal login dan pesan error "Epic sadface: Username and password do not match any user in this service" ditampilkan.

## Test Case 4: Login Gagal - Kredensial Kosong

*   **Test Case ID:** TC-LOGIN-004
*   **Judul:** Login gagal dengan username dan password kosong
*   **Skenario:**
    Pengguna tidak memasukkan username dan password, lalu menekan tombol login.
*   **Langkah-langkah:**
    1.  Buka browser dan navigasi ke https://www.saucedemo.com/
    2.  Biarkan kolom username kosong.
    3.  Biarkan kolom password kosong.
    4.  Klik tombol "Login".
*   **Hasil yang Diharapkan:**
    Pengguna gagal login dan pesan error "Epic sadface: Username is required" ditampilkan.

## Test Case 5: Login Gagal - Hanya Username

*   **Test Case ID:** TC-LOGIN-005
*   **Judul:** Login gagal dengan password kosong
*   **Skenario:**
    Pengguna hanya memasukkan username, lalu menekan tombol login.
*   **Langkah-langkah:**
    1.  Buka browser dan navigasi ke https://www.saucedemo.com/
    2.  Masukkan `standard_user` di kolom username.
    3.  Biarkan kolom password kosong.
    4.  Klik tombol "Login".
*   **Hasil yang Diharapkan:**
    Pengguna gagal login dan pesan error "Epic sadface: Password is required" ditampilkan.

# Test Case Inventory (Integration Test)

## Test Case Positive

### Test Case 1: Menambahkan satu produk ke keranjang

*   **Test Case ID:** TC-INV-001
*   **Judul:** Pengguna menambahkan satu produk ke keranjang dari halaman inventaris.
*   **Skenario:**
    Setelah login, pengguna berada di halaman inventaris dan menambahkan satu item ke keranjang belanja.
*   **Langkah-langkah:**
    1.  Login sebagai `standard_user`.
    2.  Di halaman inventaris, cari produk "Sauce Labs Backpack".
    3.  Klik tombol "Add to cart" pada produk tersebut.
*   **Hasil yang Diharapkan:**
    1.  Tombol pada produk "Sauce Labs Backpack" berubah menjadi "Remove".
    2.  Ikon keranjang belanja di pojok kanan atas menampilkan angka "1".

### Test Case 2: Menambahkan beberapa produk ke keranjang

*   **Test Case ID:** TC-INV-002
*   **Judul:** Pengguna menambahkan beberapa produk ke keranjang.
*   **Skenario:**
    Setelah login, pengguna menambahkan tiga produk berbeda ke keranjang belanja.
*   **Langkah-langkah:**
    1.  Login sebagai `standard_user`.
    2.  Di halaman inventaris, klik "Add to cart" pada produk "Sauce Labs Backpack".
    3.  Klik "Add to cart" pada produk "Sauce Labs Bike Light".
    4.  Klik "Add to cart" pada produk "Sauce Labs Bolt T-Shirt".
*   **Hasil yang Diharapkan:**
    1.  Tombol pada ketiga produk tersebut berubah menjadi "Remove".
    2.  Ikon keranjang belanja di pojok kanan atas menampilkan angka "3".

### Test Case 3: Menghapus produk dari keranjang melalui halaman inventaris

*   **Test Case ID:** TC-INV-003
*   **Judul:** Pengguna menghapus produk yang sudah ada di keranjang dari halaman inventaris.
*   **Skenario:**
    Pengguna telah menambahkan sebuah produk ke keranjang dan ingin menghapusnya langsung dari halaman inventaris.
*   **Langkah-langkah:**
    1.  Login sebagai `standard_user`.
    2.  Tambahkan produk "Sauce Labs Backpack" ke keranjang.
    3.  Pastikan ikon keranjang menampilkan angka "1".
    4.  Klik tombol "Remove" pada produk "Sauce Labs Backpack".
*   **Hasil yang Diharapkan:**
    1.  Tombol pada produk "Sauce Labs Backpack" kembali menjadi "Add to cart".
    2.  Ikon keranjang belanja di pojok kanan atas tidak lagi menampilkan angka (atau kembali ke 0).

### Test Case 4: Mengurutkan produk berdasarkan harga (rendah ke tinggi)

*   **Test Case ID:** TC-INV-004
*   **Judul:** Pengguna mengurutkan produk berdasarkan harga terendah ke tertinggi.
*   **Skenario:**
    Pengguna ingin melihat produk yang diurutkan berdasarkan harga, dimulai dari yang paling murah.
*   **Langkah-langkah:**
    1.  Login sebagai `standard_user`.
    2.  Klik dropdown filter di pojok kanan atas halaman inventaris.
    3.  Pilih opsi "Price (low to high)".
*   **Hasil yang Diharapkan:**
    Produk di halaman diurutkan berdasarkan harga, dengan produk termurah ("Sauce Labs Onesie" seharga $7.99) muncul di posisi pertama.

## Test Case Negative

### Test Case 1: Mengakses halaman inventaris tanpa login

*   **Test Case ID:** TC-INV-005
*   **Judul:** Pengguna mencoba mengakses halaman inventaris secara langsung tanpa login.
*   **Skenario:**
    Pengguna yang belum login mencoba mengakses URL `/inventory.html` secara langsung.
*   **Langkah-langkah:**
    1.  Buka browser dalam keadaan session kosong (atau setelah logout).
    2.  Navigasi langsung ke https://www.saucedemo.com/inventory.html
*   **Hasil yang Diharapkan:**
    1.  Sistem menolak akses.
    2.  Pengguna diarahkan kembali ke halaman login.
    3.  Pesan error "Epic sadface: You can only access '/inventory.html' when you are logged in." ditampilkan.

### Test Case 2: Mereset status aplikasi setelah menambahkan produk

*   **Test Case ID:** TC-INV-006
*   **Judul:** Pengguna mereset status aplikasi setelah beberapa produk ditambahkan ke keranjang.
*   **Skenario:**
    Pengguna menambahkan beberapa item ke keranjang, kemudian menggunakan fitur "Reset App State" untuk mengosongkan keranjang dan mengembalikan status tombol.
*   **Langkah-langkah:**
    1.  Login sebagai `standard_user`.
    2.  Tambahkan "Sauce Labs Backpack" dan "Sauce Labs Bike Light" ke keranjang.
    3.  Pastikan ikon keranjang menampilkan angka "2".
    4.  Klik menu burger di pojok kiri atas.
    5.  Klik opsi "Reset App State".
*   **Hasil yang Diharapkan:**
    1.  Ikon keranjang belanja di pojok kanan atas kembali kosong.
    2.  Tombol "Remove" pada semua produk yang sebelumnya ditambahkan akan kembali menjadi "Add to cart".