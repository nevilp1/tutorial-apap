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

##Tutorial 2
Pertanyaan 1: Cobalah untuk menambahkan sebuah Hotel dengan mengakses link berikut:
http://localhost:8080/hotel/add?idHotel=1&namaHotel=Papa%20APAP&alamat=Quanta%20Fasilkom&noTelepon=081xxx
Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi <br/>
Jawaban: Whitelabel Error Page, karena template yang diminta oleh controller dari program traveloke tidak ditemukan sehingga terjadi kegagalan pada saat rendering html. 

Pertanyaan 2: Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam konteks service dan controller yang telah kamu buat
Jawaban: anotasi @Autowired merupakan implementasi dari konsep

Pertanyaan 3: Cobalah untuk menambahkan sebuah Hotel dengan mengakses link berikut:
http://localhost:8080/hotel/add?idHotel=1&namaHotel=Papa%20APAP&alamat=Quanta%20Fasilkom
Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.
Jawaban: Whitelabel Error Page, karena bagian controller meminta request parameter noTelepon, akan tetapi nomor telepon tidak diberikan pada link tersebut.

Pertanyaan 4: Jika Papa APAP ingin melihat Hotel dengan nama Papa APAP, link apa yang harus
diakses?
Jawaban: http://localhost:8080/hotel/view?idHotel=1

Pertanyaan 5: Tambahkan 1 contoh Hotel lainnya sesukamu. Lalu cobalah untuk mengakses
http://localhost:8080/hotel/viewall , apa yang akan ditampilkan? Sertakan juga bukti screenshotmu.
Jawaban: Laman yang ditampilkan adalah informasi dua hotel, yaitu hotel yang baru saja dibuat dan hotel yang dibuat pada pertanyaan 1.
Link foto: https://drive.google.com/drive/folders/1t8_gz3OHKj_ro01pfi1UUOxjpQW8XR6z?usp=sharing


### What I did not understand
- [ ] Kapan sebaiknya menggunakan @RequestParam atau @PathVariable ?
- [ ] Mengapa bisa terjadi kegagalan saat install maven pada intelij?

