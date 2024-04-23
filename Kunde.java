public class Kunde {
    private String name;
    private String kontakt;

    public Kunde(String name, String kontakt) {
        this.name = name;
        this.kontakt = kontakt;
    }

    // Getter methods
    public String getName() {
        return this.name;
    }

    public String getKontakt() {
        return this.kontakt;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }
}