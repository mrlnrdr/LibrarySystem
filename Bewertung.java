
public class Bewertung {
    private Buch buch;
    private Benutzer benutzer;
    private int bewertung;
    private String kommentar;
    private int sterne;

    public Bewertung(Buch buch, Benutzer benutzer, int bewertung, String kommentar) {
        this.buch = buch;
        this.benutzer = benutzer;
        this.bewertung = bewertung;
        this.kommentar = kommentar;
        this.sterne = sterne;
    }
    public int getSterne() {
        return sterne;
    }
    public void setSterne(int sterne) {
        this.sterne = sterne;
    }

    // Getter methods
    public Buch getBuch() {
        return this.buch;
    }

    public Benutzer getBenutzer() {
        return this.benutzer;
    }

    public int getBewertung() {
        return this.bewertung;
    }

    public String getKommentar() {
        return this.kommentar;
    }

    // Setter methods
    public void setBuch(Buch buch) {
        this.buch = buch;
    }

    public void setBenutzer(Benutzer benutzer) {
        this.benutzer = benutzer;
    }

    public void setBewertung(int bewertung) {
        this.bewertung = bewertung;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }
}