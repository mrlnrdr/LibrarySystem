import java.time.LocalDate;

public class Ausleihe {
    private Benutzer benutzer;
    private Buch buch;
    private LocalDate ausleihDatum;
    private LocalDate rueckgabeDatum;

    public Ausleihe(Benutzer benutzer, Buch buch, LocalDate ausleihDatum) {
        this.benutzer = benutzer;
        this.buch = buch;
        this.ausleihDatum = ausleihDatum;
        this.rueckgabeDatum = null;
    }

    public Benutzer getBenutzer() {
        return benutzer;
    }

    public Buch getBuch() {
        return buch;
    }

    public LocalDate getAusleihDatum() {
        return ausleihDatum;
    }

    public LocalDate getRueckgabeDatum() {
        return rueckgabeDatum;
    }

    public void setRueckgabeDatum(LocalDate rueckgabeDatum) {
        this.rueckgabeDatum = rueckgabeDatum;
    }
}