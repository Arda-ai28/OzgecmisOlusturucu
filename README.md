# Java ile PDF Özgeçmiş Oluşturucu (OOP Projesi)

Bu proje, **Nesne Yönelimli Programlama (Object-Oriented Programming - OOP)** prensipleri temel alınarak Java programlama dili ve **iTextPDF** kütüphanesi ile geliştirilmiş konsol tabanlı bir PDF özgeçmiş (CV) üreticisidir. Uygulama, aday bilgilerini nesne modelleri üzerinden işleyerek fotoğraf, kişisel bilgiler, üç kademeli iş deneyimi ve eğitim/yetkinlik bölümlerinden oluşan A4 formatında yapılandırılmış bir PDF belgesi üretir.

---

## Proje Mimarisi ve Tasarım Prensipleri

Uygulama geliştirilirken **Sorumlulukların Ayrılması (Separation of Concerns)** ve **Kapsülleme (Encapsulation)** ilkeleri uygulanmıştır. PDF oluşturma işlemleri doğrudan `Main` sınıfı içerisinde yapılmamış; veri modelleri ve belge üretim mantığı birbirinden bağımsız sınıflar halinde tasarlanmıştır.

```text
OzgecmisOlusturucu/
├── src/main/java/
│   ├── KisiselBilgiler.java   # Kişisel verileri ve fotoğraf yolunu tutan model sınıfı
│   ├── IsDeneyimi.java        # İş tecrübelerini temsil eden model sınıfı
│   ├── EgitimVeYetenek.java   # Akademik bilgileri ve teknik becerileri tutan model sınıfı
│   ├── PdfOlusturucu.java     # iText bileşenleri ile PDF belgesini inşa eden servis sınıfı
│   └── Main.java              # Nesnelerin örneklendiği ve uygulamanın başlatıldığı giriş noktası
├── profil.jpg                 # Özgeçmişte kullanılan temsili profil fotoğrafı
├── Ozgecmis.pdf               # Uygulama çalıştırıldığında üretilen çıktı dosyası
└── pom.xml                    # Maven proje yapılandırması ve iText bağımlılığı
```

---

## Kullanılan Sınıflar, Nesneler ve Kullanım Nedenleri

### 1. Veri Modeli Sınıfları (POJO / Model Nesneleri)
* **`KisiselBilgiler` Nesnesi:** Adayın ad-soyad, unvan, e-posta, telefon, adres, özet bilgi ve fotoğraf dosya yolu verilerini bir arada tutmak için kullanılmıştır. Tüm sınıf alanları `private` olarak tanımlanmış ve dış erişime `public` Getter/Setter metotları ile açılarak veri güvenliği (Encapsulation) sağlanmıştır.
* **`IsDeneyimi` Nesneleri ve `ArrayList<IsDeneyimi>`:** Özgeçmişte yer alan 3 farklı iş deneyimini (şirket adı, pozisyon, çalışma tarihleri ve iş tanımı) ayrı nesneler halinde modellemek için kullanılmıştır. Çoklu iş deneyimlerini tek bir yapı altında dinamik olarak `PdfOlusturucu` sınıfına aktarabilmek amacıyla Java Collections Framework içerisinden `List` ve `ArrayList` nesneleri tercih edilmiştir.
* **`EgitimVeYetenek` Nesnesi:** Adayın üniversite, bölüm, mezuniyet dönemi ve teknik yetkinliklerini bağımsız bir modül olarak yönetmek amacıyla oluşturulmuştur.

### 2. İş Mantığı ve Servis Sınıfı
* **`PdfOlusturucu` Nesnesi:** PDF üretim sürecini `Main` metodundan soyutlamak amacıyla tasarlanmıştır. Veri nesnelerini parametre olarak alır ve sayfa düzenini oluşturur. İç yardımcı metotları (`fontlariHazirla`, `ustBilgiEkle`, `bolumCizgisiEkle`) dış müdahalelere karşı `private` erişim düzenleyicisi ile korunmuş, yalnızca ana üretim metodu (`ozgecmisOlustur`) `public` olarak dışa açılmıştır.

### 3. iTextPDF Kütüphanesi Bileşenleri ve Nesneleri
* **`Document` ve `PdfWriter`:** Bellekte A4 boyutunda (`PageSize.A4`) sanal bir belge oluşturmak ve bu belgeyi `FileOutputStream` aracılığıyla fiziksel bir `.pdf` dosyası olarak diske yazmak için kullanılmıştır.
* **`BaseFont` ve `Font`:** PDF belgesinde Türkçe karakterlerin (`ğ, ü, ş, ı, ö, ç, İ`) bozulmadan `Identity-H` (UTF-8) kodlamasıyla görüntülenmesini sağlamak ve başlık/metin hiyerarşisini renklendirmek amacıyla kullanılmıştır.
* **`PdfPTable` ve `PdfPCell`:** Özgeçmişin üst bölümünde kişisel iletişim bilgileri ile profil fotoğrafını sayfanın sol ve sağ köşelerine kenarlıksız (`Rectangle.NO_BORDER`) bir ızgara yapısıyla hizalamak için tercih edilmiştir.
* **`Image`:** Temsili profil fotoğrafını (`profil.jpg`) diskten okuyup, görüntü oranını bozmadan (`scaleToFit`) sağ üst hücreye yerleştirmek için kullanılmıştır.
* **`Paragraph`, `Phrase` ve `LineSeparator`:** Metin bloklarını hizalamak, satır boşluklarını ayarlamak ve özgeçmiş bölümleri arasına görsel ayırıcı çizgiler eklemek amacıyla kullanılmıştır.

---

##  Kurulum ve Çalıştırma

### Gereksinimler
* **Java Development Kit (JDK):** 17 veya üzeri (Proje JDK 25 ile test edilmiştir)
* **Apache Maven:** Bağımlılık yönetimi için

### Çalıştırma Adımları
1. Depoyu yerel makinenize klonlayın:
   ```bash
   git clone https://github.com/Arda-ai28/OzgecmisOlusturucu.git
   
2. Projeyi **IntelliJ IDEA** veya tercih ettiğiniz bir IDE ile açın.
3. `pom.xml` dosyasındaki Maven bağımlılıklarının (`com.itextpdf:itextpdf:5.5.13.3`) indirildiğinden emin olun.
4. `src/main/java/Main.java` sınıfını çalıştırın.
5. Proje ana dizininde oluşturulan **`Ozgecmis.pdf`** dosyasını görüntüleyin.