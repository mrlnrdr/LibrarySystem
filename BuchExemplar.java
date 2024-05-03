public class BuchExemplar {
    private Buch buch;
    private int exemplarNummer;

    public BuchExemplar(Buch buch, int exemplarNummer) {
        this.buch = buch;
        this.exemplarNummer = exemplarNummer;
    }

    // Getter methods
    public Buch getBuch() {
        return this.buch;
    }

    public int getExemplarNummer() {
        return this.exemplarNummer;
    }

    // Setter methods
    public void setBuch(Buch buch) {
        this.buch = buch;
    }

    public void setExemplarNummer(int exemplarNummer) {
        this.exemplarNummer = exemplarNummer;
    }
}