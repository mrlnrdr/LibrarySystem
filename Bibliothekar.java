public class Bibliothekar {
    private String name;
    private String mitarbeiterID;

    public Bibliothekar(String name, String mitarbeiterID) {
        this.name = name;
        this.mitarbeiterID = mitarbeiterID;
    }

    // Getter methods
    public String getName() {
        return this.name;
    }

    public String getMitarbeiterID() {
        return this.mitarbeiterID;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setMitarbeiterID(String mitarbeiterID) {
        this.mitarbeiterID = mitarbeiterID;
    }
}