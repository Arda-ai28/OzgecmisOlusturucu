public class EgitimVeYetenek {
    private String okulAdi;
    private String bolum;
    private String mezuniyetYili;
    private String yetenekler;

    public EgitimVeYetenek(String okulAdi, String bolum, String mezuniyetYili, String yetenekler) {
        this.okulAdi = okulAdi;
        this.bolum = bolum;
        this.mezuniyetYili = mezuniyetYili;
        this.yetenekler = yetenekler;
    }

    public String getOkulAdi() {
        return okulAdi;
    }

    public void setOkulAdi(String okulAdi) {
        this.okulAdi = okulAdi;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    public String getMezuniyetYili() {
        return mezuniyetYili;
    }

    public void setMezuniyetYili(String mezuniyetYili) {
        this.mezuniyetYili = mezuniyetYili;
    }

    public String getYetenekler() {
        return yetenekler;
    }

    public void setYetenekler(String yetenekler) {
        this.yetenekler = yetenekler;
    }
}