public class Mitarbeiter {
    private String name;
    private String position;
    private String mitarbeiterID;

    public Mitarbeiter(String name, String position, String mitarbeiterID) {
        this.name = name;
        this.position = position;
        this.mitarbeiterID = mitarbeiterID;
    }

    // Getter methods
    public String getName() {
        return this.name;
    }

    public String getPosition() {
        return this.position;
    }

    public String getMitarbeiterID() {
        return this.mitarbeiterID;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setMitarbeiterID(String mitarbeiterID) {
        this.mitarbeiterID = mitarbeiterID;
    }
}