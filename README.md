# Tutorial APAP
## Authors
* **Nevil Philia Pramuda** - *1806191553* - *A*
---
## Tutorial 1
### What I have learned today
(Masukkan pertanyaan yang diikuti jawaban di setiap nomor, contoh seperti dibawah. Anda juga boleh
menambahkan catatan apapun di bagian ini)
### Github
1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker? <br/>
Media bagi developer maupun orang yang terlibat dalam project untuk memberikan masukan terhadap masalah yang ada dan mempermudah developer untuk memberikan solusi. Issue-issue yang dapat diselesaikan antara lain: bug issue, enchantment, documentation issue, dan lain-lain.
2. Apa perbedaan dari git merge dan git merge --squash? <br/>
Ketika menggunakan git merge, setiap commit akan dimerge satu persatu ke master. Jika menggunakan git merge --squash, setiap commit yang ada di branch disatukan dahulu sebelum di merge ke master.
3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan suatu
aplikasi? <br/>
Keunggulan menggunakan version control adalah memudahkan programmer dalam menulis code secara paralel tanpa terjadi timpang tindih dengan pekerjaan yang lain. Selain itu, programmer dapat melihat riwayat dari project agar lebih mudah diketahui kapan terjadi error yang siapa yang membuat error.
### Spring
4. Apa itu library & dependency? <br/>
Library merupakan sekumpulan package berisi class dan method-method yang dapat diimpor dan digunakan untuk mempermudah suatu pekerjaan. Dependency adalah hubungan antar class dimana suatu class membutuhkan class lain untuk bisa dijalankan.
5. Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven? <br/>
Karena maven merupakan salah satu yang dapat dibuka di berbagai IDE. Maven juga mempermudah untuk mengatur dependency karena maven dapat mendownload secara otomatis JAR-JAR yang digunakan setelah kita mendefinisikan dependency yang diingkan. Selain itu, maven dapat bekerja dengan spring framework. Alternatif untuk build tools selain maven adalah Microsoft Team Foundation Server, CircleCI, Bamboo, Postman, TeamCity, dan lain-lain.
6. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring framework? <br/>
- Menghubungkan suatu aplikasi dengan database
- Membuat aplikasi messaging
- Program I/O
- Pembuatan prototype
7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya menggunakan
@RequestParam atau @PathVariable? <br/>
@RequestParam digunakan untuk digunakan untuk mengextract query parameter, sedangkan @PathVariable digunakan untuk mengextract data dari URI. @RequestParam lebih 

## Tutorial 2
1. Cobalah untuk menambahkan sebuah Hotel dengan mengakses link berikut:
http://localhost:8080/hotel/add?idHotel=1&namaHotel=Papa%20APAP&alamat=Quanta%20Fasilkom&noTelepon=081xxx <br/>
Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi <br/>
Jawaban: Whitelabel Error Page, karena template yang diminta oleh controller dari program traveloke tidak ditemukan sehingga terjadi kegagalan pada saat rendering html. 

2. Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam konteks service dan controller yang telah kamu buat <br/>
Jawaban: anotasi @Autowired merupakan implementasi dari konsep dependency injection. Autowired akan melakukan injection beans secara otomatis dengan melihat @Controller dan @Component yang ada di kelas lain.

3. Cobalah untuk menambahkan sebuah Hotel dengan mengakses link berikut:
http://localhost:8080/hotel/add?idHotel=1&namaHotel=Papa%20APAP&alamat=Quanta%20Fasilkom <br/>
Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.<br/>
Jawaban: Whitelabel Error Page, karena bagian controller meminta request parameter noTelepon, akan tetapi nomor telepon tidak diberikan pada link tersebut.

4. Jika Papa APAP ingin melihat Hotel dengan nama Papa APAP, link apa yang harus
diakses?<br/>
Jawaban: http://localhost:8080/hotel/view?idHotel=1

5. Tambahkan 1 contoh Hotel lainnya sesukamu. Lalu cobalah untuk mengakses
http://localhost:8080/hotel/viewall , apa yang akan ditampilkan? Sertakan juga bukti screenshotmu.<br/>
Jawaban: Laman yang ditampilkan adalah informasi dua hotel, yaitu hotel yang baru saja dibuat dan hotel yang dibuat pada pertanyaan 1.<br/>
Link foto: https://drive.google.com/drive/folders/1t8_gz3OHKj_ro01pfi1UUOxjpQW8XR6z?usp=sharing

## Tutorial 3
1. Pada class KamarDb , terdapat method findAllByHotelId , apakah kegunaan dari method tersebut? <br>
Jawaban: Method findAllByHotelId berguna untuk memperoleh list berisi object kamar yang berasosiasi dengan sebuah ID hotel. Method ini me-extend JPA Repository untuk melakukan select dari database kamar tanpa menggunakan query.

2. Pada class HotelController , jelaskan perbedaan method addHotelFormPage dan addHotelSubmit ?<br>
Jawaban: AddHotelFormPage merupakan method bertipe GET yang digunakan untuk membuat objek baru yaitu Hotel. Sedangkan addHotelSubmit merupakan method bertipe POST yang digunakan untuk mengambil seluruh nilai dari form yang diisi saat menambahkan objek baru dan memasukkan data tersebut ke dalam database.
3. Jelaskan kegunaan dari JPA Repository ! <br>
Jawaban: JPA Repository merupakan sebuah interface berisi method-method yang membantu sebuah aplikasi melakukan CRUD ke dalam database. Umumnya, interface ini digunakan untuk menghubungkan dan menyimpan sebuah objek dengan idnya ke dalam repository.
4. Sebutkan dan jelaskan di bagian kode mana sebuah relasi antara HotelModel dan KamarModel dibuat? <br>
Jawaban: @OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
             private List<KamarModel> listKamar; <br><br>
             @ManyToOne(fetch = FetchType.EAGER,optional = false)
                 @JoinColumn(name = "hotelId", referencedColumnName = "id", nullable = false)
                 @OnDelete(action = OnDeleteAction.CASCADE)
                 @JsonIgnore
                 private HotelModel hotel; <br><br>
Pada kode di atas, kita membuat relasi One-To-Many antara HotelModel dan KamarModel. Sebuah object hotel diasosiasikan dengan sebuah list kamar dan berlaku sebaliknya untuk banyak list kamar berasosiasi dengan sebuah hotel.

5. Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL , dan FetchType.EAGER ! <br>
Jawaban: FetchType merupakan module yang berada pada javax.persistence yang berguna untuk mengambil data dari database. Umumnya, penggunaan FetchType bergantung pada kardinalitas yang berlaku pada dua objek. 
         Jika kardinalitas Many-To-One, maka pengambilan data menggunakan FetchType.EAGER, karena FetchType ini akan memuat setiap field yang ada pada child sekalipun belum dibutuhkan. 
         Sedangkan kardinalitas One-To-Many, pengambilan data menggunakan FetchType.LAZY. 
         CascadeType.ALL merupakan respon untuk constraint terhadap perubahan data parent terhadap child pada database. Jika menggunakan metode ini, maka semua perubahan data yang terjadi pada parent, akan mempengaruhi child.

## Tutorial 4
1. Jelaskan perbedaan th:include dan th:replace! <br>
th:include digunakan untuk memasukan fragment ke dalam sebuah tag HTML, sedangkan th:replace digunakan untuk  menimpa sebuah tag dengan fragment
2. Jelaskan apa fungsi dari th:object! <br>
th: object digunakan untuk menspesifikasi objek yang nantinya akan dikirim melalui form
3. Jelaskan perbedaan dari * dan $ pada saat penggunaan th:object! Kapan harus dipakai?<br>
Notasi * digunakan untuk mendapatkan atribut dari th:object, umumnya lebih mudah digunakan ketika kita fokus pada suatu objek tertentu. Notasi * akan banyak ditemukan ketika kita mengerjakan suatu form dengan thymeleaf. Notasi ${} merupakan notasi yang umum digunakan untuk setiap pemanggilan thymeleaf, sehingga tidak ada kondisi spesifik untuk menggunakanya. Dalam beberapa kasus, penggunaan * dan ${} tidak jauh berbeda, seperti pada baris kode berikut:
```html
<div class="box">
  <p><b>Full Name:</b> <span th:utext="*{person.fullName}"></span></p>
  <p><b>Email:</b> <span th:utext="*{person.email}"></span></p>
</div>
<div class="box">
  <p><b>Full Name:</b> <span th:utext="${person.fullName}"></span></p>
  <p><b>Email:</b> <span th:utext="${person.email}"></span></p>
</div>
```

<br>
4. Bagaimana kamu menyelesaikan latihan nomor 3? <br>
Saya menyelesaikan nomor 3 dengan membuat variabel String yang didefininisikan pada banyak method sesuai dengan nama template yang dirender. Setelah itu, saya mengirimkan variabel String tersebut ke templates untuk bisa ditampilkan pada navbar. Saya menggunakan thymeleaf, yaitu dengan syntax th:text${nama_variable} untuk memanggil variabel yang dikirimkan oleh controller pada navbar yang telah dibuat.

## Tutorial 5
1. Apa itu Postman? Apa kegunaannya? <br>
Postman merupakan aplikasi yang berguna sebagai REST Client untuk uji coba REST API. Postman biasa digunakan untuk membuat dan menguji API.

2. Jelaskan fungsi dari anotasi @JsonIgnoreProperties dan @JsonProperty. <br>
@JsonIgnoreProperties  digunakan untuk mengabaikan beberapa properti atau atribut dari sebuah objek pada saat membaca JSON.
@JsonProperty merupakan anotasi yang berguna untuk mengisi atribut objek yang berasal dari relasi objek dengan objek lain

3. Apa kegunaan atribut WebClient?<br>
Atribut WebClient digunakan untuk menghubungkan service dengan API melalui URl.


4. Apa itu ResponseEntity dan BindingResult? Apa kegunaannya? <br>
ResponseEntity class yang berfungsi untuk mengirimkan HTTP response yang berisi status code, headers dan body. Binding result merupakan suatu interface yang merepresentasikan hasil dari proses binding objek.

## Tutorial 6
1. Jelaskan secara singkat perbedaan Otentikasi dan Otorisasi! Di bagian mana (dalam kode yang telah anda
buat) konsep tersebut diimplementasi?<br>
2. Apa itu BCryptPasswordEncoder? Jelaskan secara singkat cara kerja dan tujuannya.<br>
3. Jelaskan secara singkat apa itu UUID beserta penggunaannya!<br>
4. Apa kegunaan class UserDetailsServiceImpl.java? Mengapa harus ada class tersebut padahal kita sudah
memiliki class UserRoleServiceImpl.java?<br>


### What I did not understand
- [ ] Kapan sebaiknya menggunakan @RequestParam atau @PathVariable ?
- [ ] Mengapa bisa terjadi kegagalan saat install maven pada intelij?
- [ ] Cara melakukan Binding List
- [ ] Apa itu itemStat? Kapan harus menggunakanya?

