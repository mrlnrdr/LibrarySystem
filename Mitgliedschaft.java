import java.time.LocalDate;

public class Mitgliedschaft {
    private Benutzer benutzer;
    private LocalDate beginnDatum;
    private LocalDate endDatum;

    public Mitgliedschaft(Benutzer benutzer, LocalDate beginnDatum, LocalDate endDatum) {
        this.benutzer = benutzer;
        this.beginnDatum = beginnDatum;
        this.endDatum = endDatum;
    }

    // Getter methods
    public Benutzer getBenutzer() {
        return this.benutzer;
    }

    public LocalDate getBeginnDatum() {
        return this.beginnDatum;
    }

    public LocalDate getEndDatum() {
        return this.endDatum;
    }

    // Setter methods
    public void setBenutzer(Benutzer benutzer) {
        this.benutzer = benutzer;
    }

    public void setBeginnDatum(LocalDate beginnDatum) {
        this.beginnDatum = beginnDatum;
    }

    public void setEndDatum(LocalDate endDatum) {
        this.endDatum = endDatum;
    }
}