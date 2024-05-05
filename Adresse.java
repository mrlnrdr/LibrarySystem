public class Adresse {
    private String strasse;
    private String stadt;
    private String plz;

    public Adresse(String strasse, String stadt, String plz) {
        this.strasse = strasse;
        this.stadt = stadt;
        this.plz = plz;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getStadt() {
        return stadt;
    }

    public void setStadt(String stadt) {
        this.stadt = stadt;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }
}
