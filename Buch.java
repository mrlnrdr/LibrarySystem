import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class Buch {
    private String titel;
    private String autor;
    private boolean verfuegbar;
    private List<Bewertung> bewertungen;

    public Buch(String titel, String autor) {
        this.titel = titel;
        this.autor = autor;
        this.verfuegbar = true;
        this.bewertungen = new ArrayList<>();
    }

    public String getTitel() {
        return titel;
    }

    public String getAutor() {
        return autor;
    }

    public boolean istVerfuegbar() {
        return verfuegbar;
    }

    public void setVerfuegbar(boolean verfuegbar) {
        this.verfuegbar = verfuegbar;
    }

    public void bewertungHinzufuegen(Bewertung bewertung) {
        this.bewertungen.add(bewertung);
    }

    public List<Bewertung> getBewertungen() {
        return bewertungen;
    }
}














