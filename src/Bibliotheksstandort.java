public class Bibliotheksstandort {
    private String name;
    private String adresse;
    private String oeffnungszeiten;

    public Bibliotheksstandort(String name, String adresse, String oeffnungszeiten) {
        this.name = name;
        this.adresse = adresse;
        this.oeffnungszeiten = oeffnungszeiten;
    }

    // Getter methods
    public String getName() {
        return this.name;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public String getOeffnungszeiten() {
        return this.oeffnungszeiten;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setOeffnungszeiten(String oeffnungszeiten) {
        this.oeffnungszeiten = oeffnungszeiten;
    }
}