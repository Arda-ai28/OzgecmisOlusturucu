import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        KisiselBilgiler kisi = new KisiselBilgiler(
                "Kerem Demir",
                "Kıdemli Yazılım Mühendisi",
                "kerem.demir@email.com",
                "+90 (555) 123 45 67",
                "Kadıköy, İstanbul / Türkiye",
                "Nesne yönelimli programlama, kurumsal arka uç (backend) mimarileri ve dağıtık sistemler konusunda 5 yılı aşkın deneyime sahip Yazılım Mühendisi. Temiz kod prensiplerine bağlı, ölçeklenebilir mikroservis çözümleri üretmeye ve takım içi çevik (Agile) süreçleri geliştirmeye odaklanmıştır.",
                "profil.jpg"
        );

        List<IsDeneyimi> deneyimListesi = new ArrayList<>();

        IsDeneyimi deneyim1 = new IsDeneyimi(
                "TeknoVizyon Bilişim A.Ş.",
                "Kıdemli Java Geliştirici",
                "Ocak 2024 - Günümüz",
                "Yüksek trafikli finansal teknoloji uygulamalarının Java ve Spring Boot kullanılarak mikroservis mimarisine dönüştürülmesi. Veritabanı sorgu optimizasyonları ile sistem yanıt sürelerinin %35 oranında iyileştirilmesi."
        );

        IsDeneyimi deneyim2 = new IsDeneyimi(
                "NovaSoft Yazılım Çözümleri",
                "Yazılım Mühendisi",
                "Haziran 2021 - Aralık 2023",
                "E-ticaret platformları için RESTful API servislerinin tasarlanması ve geliştirilmesi. Otomatik birim testlerinin (JUnit) yazılması ve CI/CD süreçlerinin Docker kullanılarak entegre edilmesi."
        );

        IsDeneyimi deneyim3 = new IsDeneyimi(
                "SiberKalkan Teknoloji",
                "Yardımcı Yazılım Geliştirici",
                "Temmuz 2019 - Mayıs 2021",
                "Kurumsal iç ağ güvenliği ve log analizi modüllerinin geliştirilmesinde görev alınması. Mevcut monolitik uygulamalardaki yazılım hatalarının giderilmesi ve dokümantasyon süreçlerinin yürütülmesi."
        );

        deneyimListesi.add(deneyim1);
        deneyimListesi.add(deneyim2);
        deneyimListesi.add(deneyim3);

        EgitimVeYetenek egitimVeYetenek = new EgitimVeYetenek(
                "İstanbul Teknik Üniversitesi",
                "Bilgisayar Mühendisliği (Lisans)",
                "2015 - 2019",
                "Programlama Dilleri: Java, C, Python, SQL | Çatılar ve Araçlar: Spring Boot, Hibernate, Maven, Git, Docker, Linux | Yabancı Dil: İngilizce (İleri Seviye - C1)"
        );

        PdfOlusturucu pdfServisi = new PdfOlusturucu();
        pdfServisi.ozgecmisOlustur("Ozgecmis.pdf", kisi, deneyimListesi, egitimVeYetenek);
    }
}