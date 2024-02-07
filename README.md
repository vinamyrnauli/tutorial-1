## **Refleksi 1**
Pada tutorial ini, saya sudah menerapkan prinsip *clean code*. Penamaan variabel sudah saya aplikasikan dengan baik untuk menggambarkan data yang diwakili. Tak hanya itu, penamaan fungsi sudah jelas menggambarkan tujuan dari tiap metode. Pada metode dalam *controller*, sudah cukup singkat dan bertanggung jawab untuk satu tugas tertentu. Metode dalam `ProductRepository` juga mempertahankan fungsinya dalam melakukan operasi *Create, Read, Update, Delete* (CRUD) terhadap entitas produk.

Pada kode saya juga tidak terdapat beberapa komentar, namun dapat dipahami karena nama metode dan variabel yang deskriptif. Selain itu, kode saya sudah diatur dengan baik dalam hal tata letak dan pemformatan. Hal ini memungkinkan untuk kode menjadi lebih mudah dimengerti dan dibaca. Saya juga menggunakan struktur objek yang sesuai.

Namun, saya juga melakukan beberapa kesalahan. Kode saya mengalami *error* karena menggunakan fitur-fitur *Thymeleaf* dalam aplikasi Spring Boot. Solusinya adalah dengan menambahkan `implementation("org.springframework.boot:spring-boot-starter-thymeleaf")` pada `build.gradle.kts`. Selain itu, saya juga salah meletakkan *test functions* ke dalam *folder main* sehingga *Code Editor* tidak dapat mendeteksi penggunaan *JUnit*. Solusinya adalah dengan meletakkan *test functions* ke dalam  *folder test*.
<br>

## **Refleksi 2**
Saya merasa lebih yakin bahwa kode yang diketik dapat berfungsi sesuai yang diharapkan. Sebenarnya, tidak ada jawaban pasti untuk banyaknya *unit test* yang harus dilakukan dalam satu *class*. Hal ini bergantung pada beberapa faktor, contohnya adalah kompleksitas *class*, ukuran proyek, dan lainnya. Namun, disarankan untuk menulis *unit test* yang cukup untuk menguji semua fungsionalitas kelas.

Untuk memastikan bahwa *unit test* cukup memverifikasi program adalah dengan menggunakan konsep *code coverage*. *Code coverage* ini digunakan untuk mengukur berapa banyak kode dalam program yang diuji oleh *unit-test*. Tak hanya itu, kita juga harus menguji tiap fitur yang ada dalam program agar tidak ada kasus yang tidak tertangani. Menurut saya, 100% *code coverage* tidak menjamin bahwa kode bebas dari kesalahan atau *bug*. Maka dari itu, penting juga untuk memastikan kualitas kode kita.

Terdapat duplikasi kode pada metode `CreateProduct_isCorrect()`. Hal ini dapat menyulitkan pemeliharaan kode jika ingin melakukan pengubahan. Solusinya adalah dengan mengekstraksi kode yang serupa ke dalam metode utilitas dan memanggilnya dari metode tersebut.
<br>