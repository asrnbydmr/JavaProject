# Ders ve Öğrenci Kayıt Uygulaması

* Bu proje, ders ve öğrenci kayıt projesidir.
* Eclipse IDE ile yapılmıştır.
* Eclipse Marketplace ile WindowBuilder yüklenmiştir.
* Projeye harici olarak json-simple-1.1.1.jar eklenmiştir.
* Projede 3 package (default package ile 4 package), 3 form, 5 sınıf (form sınıfları ile birlikte 8 sınıf) bulunmaktadır.

## Kullanılan Kütüphaneler

### Java SDK Kütüphaneleri
- java.io
- java.util

### WindowBuilder Kütüphaneleri
- java.awt
- java.awt.event
- javax.swing

### json-simple-1.1.1.jar Kütüphaneleri
- org.json.simple
- org.json.simple.parser

## Nasıl Çalışır

1. Default package kısmında bulunan mainForm çalıştırılır.
2. Ders eklemek için açılan pencerede Course Form'a tıklanır.
3. Öğrenci eklemek için açılan pencerede Student Form'a tıklanır.
* Not: İlk önce ders eklenir sonra öğrenci eklenir. Ders eklemeden öğrenci ekleme penceresi açılmaz. 
4. Ders eklemek için tüm alanlar doldurulur. Tüm alanlar doldurulmaz ise işlem gerçekleştirilmez.
5. Öğrenci eklemek için tüm alanlar doldurulur. Tüm alanlar doldurulmaz ise işlem gerçekleştirilmez.

## Packageler

- Default package: mainForm sınıfının bulunduğu pakettir.
- Apppackage: Dosya yollarını ve uygulama ayarlarını tutmak için yazılan sınıfların bulunduğu pakettir.
- Classpackage: Ders, öğrenci ve JSON işlemleri için yazılan sınıfların bulunduğu pakettir.
- Formpackage: studentForm ve courseForm sınıflarının bulunduğu pakettir.

## Formlar

- mainForm: Menü penceresidir.
- courseForm: Ders ekleme penceresidir.
- studentForm: Öğrenci ekleme penceresidir.

## Sınıflar

- apppackage -> filenameClass: Dosya isimlerini tutan sınıftır.
- apppackage -> settingsClass: Uygulama ayarlarını tutan sınıftır. 

- classpackage -> courseClass: Ders bilgisi alanlarını tutan, veri kontrolü yapan ve ders kaydı yapan sınıftır.
- classpackage -> jsonClass: JSON belgelerini kontrol eden, okuma ve yazma işlemi yapan sınıftır.
- classpackage -> studentClass: Öğrenci bilgisi alanlarını tutan, veri kontrolü yapan ve öğrenci kaydı yapan sınıftır.

- mainForm, courseForm ve studentForm sınıfları GUI sınıflarıdır.

## Alanlar

- filenameClass -> fileNameCourses: Ders bilgilerini tutan JSON dosyasının bilgisini tutan alandır.
- filenameClass -> fileNameStudents: Öğrenci bilgilerini tutan JSON dosyasının bilgisini tutan alandır.

- settingsClass -> studentFormEnabled: Öğrenci penceresinin görünürlük bilgisini tutan alandır.

- courseClass -> courseCode: Ders kodu bilgisini tutan alandır.
- courseClass -> courseName: Ders ad bilgisini tutan alandır.
- courseClass -> coursePeriod: Ders dönem bilgisini tutan alandır.
- courseClass -> courseCredit: Ders kredi bilgisini tutan alandır.
- courseClass -> courseQuota: Ders kota bilgisini tutan alandır.

- studentClass -> studentCode: Öğrenci numara bilgisini tutan alandır.
- studentClass -> studentName: Öğrenci ad bilgisini tutan alandır.
- studentClass -> studentSurname: Öğrenci soyad bilgisini tutan alandır.
- studentClass -> studentSection: Öğrenci bölüm bilgisini tutan alandır.
- studentClass -> studentPeriod: Öğrenci dönem bilgisini tutan alandır.
- studentClass -> studentCourse: Öğrenci ders bilgisini tutan alandır.

## Metodlar

- settingsClass -> openStudentForm: Öğrenci penceresinin görünürlüğünü ayarlamak için kullanılan metoddur. filenameClass sınıfında bulunan fileNameCourses değişkeni içerisinde tutulan dosya ismini veya yolunu arar. Dosya var ise studentFormEnabled değişken değerine true, yok ise değişken değerine false değeri atar.

- courseClass -> courseExist: Kayıt edilmek istenilen ders bilgisinin önceden kayıt edilip edilmediğini kontrol eder.
- courseClass -> addCourse: JSON belgesine ders verilerini kaydeder.
- courseClass -> control: Ders penceresinden gelen verilerin boş (null) olup olmadığını kontrol eder.

- jsonClass -> fileExists: JSON belgesinin olup olmadığını kontrol eder.
- jsonClass -> readFile: JSON belgesinin içerisindeki verileri okumak için kullanılır.
- jsonClass -> writeFile: JSON belgesine veri kayıt etmek için kullanılır.

- studentClass -> studentExist: Kayıt edilmek istenilen öğrenci bilgisinin önceden kayıt edilip edilmediğini kontrol eder.
- studentClass -> addStudent: JSON belgesine öğrenci verilerini kaydeder.
- studentClass -> control: Öğrenci penceresinden gelen verilerin boş (null) olup olmadığını kontrol eder.
- studentClass -> fillComboBox: Öğrenci penceresinde bulunan JComboBox nesnesine ders adı bilgilerini ekler.

* Not: Ders ve öğrenci kaydetme işlemleri kayıt buttonu (btnSave) ile gerçekleştirilir.
* Not: Öğrenci penceresinde bulunan JComboBox nesnesinin değerleri, öğrenci penceresi açıldığında veya öğrenci penceresinde bulunan Refresh Course buttonu (btnRefresh) ile comboStudentCourse nesnesine eklenir.