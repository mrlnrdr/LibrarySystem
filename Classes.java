import java.util.*;
import java.time.LocalDate;

class Buch {
    private String titel;
    private String autor;
    private boolean verfuegbar;

    public Buch(String titel, String autor) {
        this.titel = titel;
        this.autor = autor;
        this.verfuegbar = true;
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
}

class Benutzer {
    private String name;
    private int ausweisnummer;
    private List<Buch> ausgelieheneBuecher;

    public Benutzer(String name, int ausweisnummer) {
        this.name = name;
        this.ausweisnummer = ausweisnummer;
        this.ausgelieheneBuecher = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void buchAusleihen(Buch buch) {
        ausgelieheneBuecher.add(buch);
    }

    public void buchRueckgabe(Buch buch) {
        ausgelieheneBuecher.remove(buch);
    }

    public List<Buch> getAusgelieheneBuecher() {
        return ausgelieheneBuecher;
    }
}












