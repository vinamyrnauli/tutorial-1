[![coverage](https://sonarcloud.io/api/project_badges/measure?project=advance-programming-tutorial_tutorial-1&metric=coverage)](https://sonarcloud.io/summary/new_code?id=vinamyrnauli_tutorial-1)

[![quality gate](https://sonarcloud.io/api/project_badges/measure?project=advance-programming-tutorial_tutorial-1&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=vinamyrnauli_tutorial-1)

[![code smells](https://sonarcloud.io/api/project_badges/measure?project=advance-programming-tutorial_tutorial-1&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=vinamyrnauli_tutorial-1)

<details>
<summary>Tutorial 1</summary>

### **Refleksi 1**
Pada tutorial ini, saya sudah menerapkan prinsip *clean code*. Penamaan variabel sudah saya aplikasikan dengan baik untuk menggambarkan data yang diwakili. Tak hanya itu, penamaan fungsi sudah jelas menggambarkan tujuan dari tiap metode. Pada metode dalam *controller*, sudah cukup singkat dan bertanggung jawab untuk satu tugas tertentu. Metode dalam `ProductRepository` juga mempertahankan fungsinya dalam melakukan operasi *Create, Read, Update, Delete* (CRUD) terhadap entitas produk.

Pada kode saya juga tidak terdapat beberapa komentar, namun dapat dipahami karena nama metode dan variabel yang deskriptif. Selain itu, kode saya sudah diatur dengan baik dalam hal tata letak dan pemformatan. Hal ini memungkinkan untuk kode menjadi lebih mudah dimengerti dan dibaca. Saya juga menggunakan struktur objek yang sesuai.

Namun, saya juga melakukan beberapa kesalahan. Kode saya mengalami *error* karena menggunakan fitur-fitur *Thymeleaf* dalam aplikasi Spring Boot. Solusinya adalah dengan menambahkan `implementation("org.springframework.boot:spring-boot-starter-thymeleaf")` pada `build.gradle.kts`. Selain itu, saya juga salah meletakkan *test functions* ke dalam *folder main* sehingga *Code Editor* tidak dapat mendeteksi penggunaan *JUnit*. Solusinya adalah dengan meletakkan *test functions* ke dalam  *folder test*.
<br>

### **Refleksi 2**
Saya merasa lebih yakin bahwa kode yang diketik dapat berfungsi sesuai yang diharapkan. Sebenarnya, tidak ada jawaban pasti untuk banyaknya *unit test* yang harus dilakukan dalam satu *class*. Hal ini bergantung pada beberapa faktor, contohnya adalah kompleksitas *class*, ukuran proyek, dan lainnya. Namun, disarankan untuk menulis *unit test* yang cukup untuk menguji semua fungsionalitas kelas.

Untuk memastikan bahwa *unit test* cukup memverifikasi program adalah dengan menggunakan konsep *code coverage*. *Code coverage* ini digunakan untuk mengukur berapa banyak kode dalam program yang diuji oleh *unit-test*. Tak hanya itu, kita juga harus menguji tiap fitur yang ada dalam program agar tidak ada kasus yang tidak tertangani. Menurut saya, 100% *code coverage* tidak menjamin bahwa kode bebas dari kesalahan atau *bug*. Maka dari itu, penting juga untuk memastikan kualitas kode kita.

Terdapat duplikasi kode pada metode `CreateProduct_isCorrect()`. Hal ini dapat menyulitkan pemeliharaan kode jika ingin melakukan pengubahan. Solusinya adalah dengan mengekstraksi kode yang serupa ke dalam metode utilitas dan memanggilnya dari metode tersebut.

</details>

<details>
<summary>Tutorial 2</summary>

### List the code quality issue(s) that you fixed during the exercise and explain your strategy on fixing them.
1. Tidak diperlukannya *modifier*. Seharusnya *class* dan metode pengujian JUnit5 memiliki visibilitas *default*. Penggunaan *modifier public* pada *class* atau metode tidak direkomendasikan. Jika visibilitasnya *default*, hal ini dapat membantu menjaga isolasi pengujuan dan mencegah akses yang tidak diinginkan.
   **Solusi:** mengubah visibilitasnya dengan menghapus kata kunci *public* atau *protected* menjadi *modifier default*.
   <br>

2. Tidak diperlukannya *import*. Adanya *unnecessary import*, dapat menyebabkan berbagai masalah, termasuk meningkatkan kompleksitas kode, memperlambat proses kompilasi, dan membuat kode sulit dipahami.

   **Solusi:** menghapus *import* yang tidak diperlukan serta menambahkan *import* secara manual yang benar-benar diperlukan dalam kode kita.
   <br>

3. *Framework* dependensi Spring membutuhkan *dependency injection* melalui notasi @Inject dan @Autowired. Anotasi ini digunakan untuk menginjeksi *beans* melalui konstruktor, *setter*, dan *field injection*. Hal ini dapat menyebabkan berbagai masalah terkait dengan mutabilitas dan *behavior* yang tidak dapat diprediksi.

   **Solusi:** mengganti objek yang menggunakan injeksi @Autowired dengan menginisialisasi *class*-nya secara langsung.
   <br>

### Look at your CI/CD workflows (GitHub)/pipelines (GitLab). Do you think the current implementation has met the definition of Continuous Integration and Continuous Deployment? Explain the reasons (minimum 3 sentences)!
Menurut saya, implementasinya telah memenuhi prinsip-prinsip *Continuous Integration* dan *Continuous Deployment* (CI/CD) dengan baik. Dalam GitHub *workflows*, proyek saya sudah otomatis melakukan *Continuous Integration* (CI) dengan uji coba dan pemindaian kode menggunakan SonarCloud tiap kali *push* ke repositori GitHub. Hal ini dapat memastikan bahwa tiap perubahan kode yang ada di repositori melalui *push* sudah melalui pengujian dan analisis yang memadai sebelu diintegrasikan ke dalam proyek.

Tak hanya itu, sistem otomatisasi *Continuous Deployment* (CD) akan mengelola proses *deployment* ke platform Koyeb secara langsung tiap kali ada *push* atau *pull request* ke suatu *branch* repositori GitHub saya.Dengan demikian, tiap kali ada perubahan atau permintaan untuk perubahan kode, sistem secara otomatis akan mengelola proses *deployment* tanpa perlu ikut campur *developer*.

Dengan demikian, implementasi bukan hanya memenuhi prinsip-prinsip CI/CD dengan baik, namun juga mengintegrasikan alur kerja otomatis yang efisien dan dapat diandalkan. Kita juga harus memastikan kualitas dan keamanan kode yang dihasilkan.

<br>

</details>

<details>
<summary>Tutorial 3</summary>

### **Explain what principles you apply to your project!**
- **Single Responsibility Principle (SRP):**
Awalnya saya menggabungkan `CarController` dan `ProductController` ke dalam `ProductController.java`. Setelah mengimplementasikan SRP, saya memisahkan `CarController` karena masing-masing memiliki fungsi yang berbeda.
<br>

- **Open Closed Principle (OCP):**
Pada `model`, saya menambahkan metode *update* sehingga pemanggilan metode tersebut akan menjadi lebih mudah. Hal ini memungkinkan pemanggilan metode yang lebih umum pada `repository` tanpa perlu modifikasi secara langsung.
<br>

- **Interface Segregation Principle (ISP):**
Saya memisahkan *interface* `ProductService` dan `CarService` sehingga dapat membedakan *interface* antara keduanya. Hal ini memungkinkan moduleritas yang lebih baik daripada menggabungkan keduanya menjadi satu. Pendekatan ini dapat meningkatkan efisiensi dalam mengimplementasikan metode abstrak dan struktur kode menjadi lebih fleksibel.
<br>

- **Dependency Inversion Principle (DIP):**
Pada `CarRepository`, saya mengganti objek dari `CarServiceImpl` yang merupakan kelas konkret menjadi `CarService` yang merupakan antarmuka. Jadi, prinsip ini memanfaatkan objek yang terhubung dengan antarmuka atau abstraksi, bukan kelas konkret. Hal ini dapat mengurangi atau menghilangkan hubungan antar komponen-komponen kelas konkret yang dapat disebut sebagai *decoupling*.

<br>

### **Explain the advantages of applying SOLID principles to your project with examples.**
- **Single Responsibility Principle (SRP):** kode menjadi lebih terorganisir dengan cara memisahkan tanggung jawab tiap kelas, memudahkan pemeliharan, pemahaman dan komunikasi antar pengembang.
  <br>

- **Open Closed Principle (OCP):** dapat meningkatkan fleksibilitas dan meminimalkan dampak perubahan. Selain itu, memungkinkan penambahan fitur baru tanpa mengubah kode yang sudah ada.
  <br>

- **Liskov Substitution Principle (LSP):** dapat mengurangi ketergantungan antar kelas dan memungkinkan polimorfisme yang lebih baik.
  <br>

- **Interface Segregation Principle (ISP):** sama seperti LSP, yaitu dapat memungkinkan polimorfisme yang lebih baik dan mengurangi ketergantungan antar kelas.
  <br>

- **Dependency Inversion Principle (DIP):** dapat membantu dalam mengurangi dampak perubahan pada satu bagian kode terhadap bagian kode lainnya.
  
<br>

### **Explain the disadvantages of not applying SOLID principles to your project with examples.**
- **Risiko antara `Controller` dan Implementasi:**
  Jika tidak mengikuti DIP dan OCP, dapat mengakibatkan keterikatan yang kuat antara
  `controller` dan implementasi. Hal ini dapat menghasilkan *environment* pengujian yang buruk dan sulit untuk beralih antara implementasi untuk pengujian.
<br>

- **Kesulitan Pemahaman dan Pemeliharan Kode:**
  Kesulitan dalam memahami dan memelihara kode karena ketidakpatuhan terhadap SRP dan penanganan banyak tanggung jawab oleh `controller`, `repository`, atau `model`. Hal ini dapat menyebabkan *bug*, meningkatkan kompleksitas, dan menyulitkan komunikasi.
<br>

- **Ketergantungan Tinggi antara Modul atau Metode:** Jika tidak mengikuti ISP dan LSP, basis kode terikat erat dan kurang fleksibel karena antarmuka, abstraksi, atau kelas dasar dengan metode maupun dependensi yang tidak perlu.
</details>