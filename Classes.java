import java.util.*;

// Klassen definieren

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

    // Weitere Methoden können hier hinzugefügt werden, um Bücher auszuleihen, zurückzugeben usw.
}

class Bibliothek {
    private List<Buch> buecher;
    private List<Benutzer> benutzer;

    public Bibliothek() {
        buecher = new ArrayList<>();
        benutzer = new ArrayList<>();
    }

    // Weitere Methoden können hier hinzugefügt werden, um Bücher hinzuzufügen, Benutzer zu registrieren, Bücher auszuleihen usw.
}





