public class KisiselBilgiler {
    private String adSoyad;
    private String unvan;
    private String email;
    private String telefon;
    private String adres;
    private String ozetBilgi;
    private String fotografYolu;

    public KisiselBilgiler(String adSoyad, String unvan, String email, String telefon, String adres, String ozetBilgi, String fotografYolu) {
        this.adSoyad = adSoyad;
        this.unvan = unvan;
        this.email = email;
        this.telefon = telefon;
        this.adres = adres;
        this.ozetBilgi = ozetBilgi;
        this.fotografYolu = fotografYolu;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getUnvan() {
        return unvan;
    }

    public void setUnvan(String unvan) {
        this.unvan = unvan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getOzetBilgi() {
        return ozetBilgi;
    }

    public void setOzetBilgi(String ozetBilgi) {
        this.ozetBilgi = ozetBilgi;
    }

    public String getFotografYolu() {
        return fotografYolu;
    }

    public void setFotografYolu(String fotografYolu) {
        this.fotografYolu = fotografYolu;
    }
}