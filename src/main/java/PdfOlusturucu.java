import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

import java.io.FileOutputStream;
import java.util.List;

public class PdfOlusturucu {

    private Font baslikFont;
    private Font altBaslikFont;
    private Font bolumBaslikFont;
    private Font kalinFont;
    private Font normalFont;
    private Font italikFont;

    public PdfOlusturucu() {
        fontlariHazirla();
    }

    private void fontlariHazirla() {
        try {
            BaseFont bf = BaseFont.createFont("C:/Windows/Fonts/arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            baslikFont = new Font(bf, 22, Font.BOLD, new BaseColor(44, 62, 80));
            altBaslikFont = new Font(bf, 13, Font.BOLD, new BaseColor(127, 140, 141));
            bolumBaslikFont = new Font(bf, 14, Font.BOLD, new BaseColor(41, 128, 185));
            kalinFont = new Font(bf, 11, Font.BOLD, BaseColor.BLACK);
            normalFont = new Font(bf, 10, Font.NORMAL, new BaseColor(50, 50, 50));
            italikFont = new Font(bf, 10, Font.ITALIC, new BaseColor(100, 100, 100));
        } catch (Exception e) {
            baslikFont = new Font(Font.FontFamily.HELVETICA, 22, Font.BOLD, BaseColor.DARK_GRAY);
            altBaslikFont = new Font(Font.FontFamily.HELVETICA, 13, Font.BOLD, BaseColor.GRAY);
            bolumBaslikFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.BLUE);
            kalinFont = new Font(Font.FontFamily.HELVETICA, 11, Font.BOLD, BaseColor.BLACK);
            normalFont = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.BLACK);
            italikFont = new Font(Font.FontFamily.HELVETICA, 10, Font.ITALIC, BaseColor.DARK_GRAY);
        }
    }

    public void ozgecmisOlustur(String dosyaAdi, KisiselBilgiler kisi, List<IsDeneyimi> deneyimler, EgitimVeYetenek egitim) {
        Document document = new Document(PageSize.A4, 40, 40, 40, 40);

        try {
            PdfWriter.getInstance(document, new FileOutputStream(dosyaAdi));
            document.open();

            ustBilgiEkle(document, kisi);
            bolumCizgisiEkle(document, "ÖZET BİLGİLER");

            Paragraph ozet = new Paragraph(kisi.getOzetBilgi(), normalFont);
            ozet.setAlignment(Element.ALIGN_JUSTIFIED);
            ozet.setSpacingAfter(15);
            document.add(ozet);

            bolumCizgisiEkle(document, "İŞ DENEYİMLERİ");
            for (IsDeneyimi deneyim : deneyimler) {
                Paragraph pozisyonVeSirket = new Paragraph(deneyim.getPozisyon() + " - " + deneyim.getSirketAdi(), kalinFont);
                document.add(pozisyonVeSirket);

                Paragraph tarih = new Paragraph(deneyim.getCalismaTarihleri(), italikFont);
                tarih.setSpacingAfter(4);
                document.add(tarih);

                Paragraph tanim = new Paragraph(deneyim.getIsTanimi(), normalFont);
                tanim.setAlignment(Element.ALIGN_JUSTIFIED);
                tanim.setSpacingAfter(12);
                document.add(tanim);
            }

            bolumCizgisiEkle(document, "EĞİTİM BİLGİLERİ");
            Paragraph okul = new Paragraph(egitim.getOkulAdi() + " - " + egitim.getBolum(), kalinFont);
            document.add(okul);

            Paragraph mezuniyet = new Paragraph("Mezuniyet / Dönem: " + egitim.getMezuniyetYili(), italikFont);
            mezuniyet.setSpacingAfter(15);
            document.add(mezuniyet);

            bolumCizgisiEkle(document, "TEKNİK YETENEKLER VE YETKİNLİKLER");
            Paragraph yetenekParagrafi = new Paragraph(egitim.getYetenekler(), normalFont);
            yetenekParagrafi.setSpacingAfter(10);
            document.add(yetenekParagrafi);

            System.out.println("PDF Özgeçmiş başarıyla oluşturuldu: " + dosyaAdi);

        } catch (Exception e) {
            System.err.println("PDF oluşturulurken hata meydana geldi: " + e.getMessage());
        } finally {
            if (document.isOpen()) {
                document.close();
            }
        }
    }

    private void ustBilgiEkle(Document document, KisiselBilgiler kisi) throws Exception {
        PdfPTable tablo = new PdfPTable(2);
        tablo.setWidthPercentage(100);
        tablo.setWidths(new float[]{3f, 1f});
        tablo.setSpacingAfter(15);

        PdfPCell bilgiHucresi = new PdfPCell();
        bilgiHucresi.setBorder(Rectangle.NO_BORDER);
        bilgiHucresi.addElement(new Paragraph(kisi.getAdSoyad(), baslikFont));
        bilgiHucresi.addElement(new Paragraph(kisi.getUnvan(), altBaslikFont));

        Paragraph bosluk = new Paragraph(" ");
        bosluk.setLeading(8);
        bilgiHucresi.addElement(bosluk);

        bilgiHucresi.addElement(new Paragraph("E-posta: " + kisi.getEmail(), normalFont));
        bilgiHucresi.addElement(new Paragraph("Telefon: " + kisi.getTelefon(), normalFont));
        bilgiHucresi.addElement(new Paragraph("Adres: " + kisi.getAdres(), normalFont));
        tablo.addCell(bilgiHucresi);

        PdfPCell fotoHucresi = new PdfPCell();
        fotoHucresi.setBorder(Rectangle.NO_BORDER);
        fotoHucresi.setHorizontalAlignment(Element.ALIGN_RIGHT);
        fotoHucresi.setVerticalAlignment(Element.ALIGN_MIDDLE);

        try {
            Image foto = Image.getInstance(kisi.getFotografYolu());
            foto.scaleToFit(100, 120);
            fotoHucresi.addElement(foto);
        } catch (Exception e) {
            fotoHucresi.addElement(new Phrase("Fotoğraf Yüklenemedi", italikFont));
        }

        tablo.addCell(fotoHucresi);
        document.add(tablo);
    }

    private void bolumCizgisiEkle(Document document, String baslikMetni) throws Exception {
        Paragraph bolumBasligi = new Paragraph(baslikMetni, bolumBaslikFont);
        bolumBasligi.setSpacingBefore(10);
        bolumBasligi.setSpacingAfter(4);
        document.add(bolumBasligi);

        LineSeparator cizgi = new LineSeparator(1f, 100f, new BaseColor(41, 128, 185), Element.ALIGN_CENTER, -2);
        document.add(cizgi);

        Paragraph bosluk = new Paragraph(" ");
        bosluk.setLeading(6);
        document.add(bosluk);
    }
}