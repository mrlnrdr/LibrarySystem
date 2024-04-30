public class Bibliotheksangebot {
    private String name;
    private String beschreibung;

    public Bibliotheksangebot(String name, String beschreibung) {
        this.name = name;
        this.beschreibung = beschreibung;
    }

    // Getter methods
    public String getName() {
        return this.name;
    }

    public String getBeschreibung() {
        return this.beschreibung;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }
}