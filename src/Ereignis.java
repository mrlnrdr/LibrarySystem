import java.time.LocalDateTime;

public class Ereignis {
    private String name;
    private LocalDateTime zeitpunkt;
    private String ort;
    private String beschreibung;

    public Ereignis(String name, LocalDateTime zeitpunkt, String ort, String beschreibung) {
        this.name = name;
        this.zeitpunkt = zeitpunkt;
        this.ort = ort;
        this.beschreibung = beschreibung;
    }

    // Getter methods
    public String getName() {
        return this.name;
    }

    public LocalDateTime getZeitpunkt() {
        return this.zeitpunkt;
    }

    public String getOrt() {
        return this.ort;
    }

    public String getBeschreibung() {
        return this.beschreibung;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setZeitpunkt(LocalDateTime zeitpunkt) {
        this.zeitpunkt = zeitpunkt;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }
}