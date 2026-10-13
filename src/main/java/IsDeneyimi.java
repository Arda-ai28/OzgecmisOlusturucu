public class IsDeneyimi {
    private String sirketAdi;
    private String pozisyon;
    private String calismaTarihleri;
    private String isTanimi;

    public IsDeneyimi(String sirketAdi, String pozisyon, String calismaTarihleri, String isTanimi) {
        this.sirketAdi = sirketAdi;
        this.pozisyon = pozisyon;
        this.calismaTarihleri = calismaTarihleri;
        this.isTanimi = isTanimi;
    }

    public String getSirketAdi() {
        return sirketAdi;
    }

    public void setSirketAdi(String sirketAdi) {
        this.sirketAdi = sirketAdi;
    }

    public String getPozisyon() {
        return pozisyon;
    }

    public void setPozisyon(String pozisyon) {
        this.pozisyon = pozisyon;
    }

    public String getCalismaTarihleri() {
        return calismaTarihleri;
    }

    public void setCalismaTarihleri(String calismaTarihleri) {
        this.calismaTarihleri = calismaTarihleri;
    }

    public String getIsTanimi() {
        return isTanimi;
    }

    public void setIsTanimi(String isTanimi) {
        this.isTanimi = isTanimi;
    }
}
