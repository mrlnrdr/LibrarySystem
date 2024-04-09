import java.util.*;

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


class Bibliothek {
    private List<Buch> buecher;
    private List<Benutzer> benutzer;

    public Bibliothek() {
        buecher = new ArrayList<>();
        benutzer = new ArrayList<>();
    }

    public void buchHinzufuegen(Buch buch) {
        buecher.add(buch);
    }

    public void buchEntfernen(Buch buch) {
        buecher.remove(buch);
    }

    public void benutzerRegistrieren(Benutzer benutzer) {
        this.benutzer.add(benutzer);
    }

    public void buchAusleihen(Benutzer benutzer, Buch buch) {
        if (buch.istVerfuegbar()) {
            benutzer.buchAusleihen(buch);
            buch.setVerfuegbar(false);
            System.out.println("Buch " + buch.getTitel() + " wurde erfolgreich an " + benutzer.getName() + " ausgeliehen.");
        } else {
            System.out.println("Das Buch ist nicht verfügbar.");
        }
    }

    public void buchRueckgabe(Benutzer benutzer, Buch buch) {
        benutzer.buchRueckgabe(buch);
        buch.setVerfuegbar(true);
        System.out.println("Buch " + buch.getTitel() + " wurde erfolgreich von " + benutzer.getName() + " zurückgegeben.");
    }

    public List<Buch> getVerfuegbareBuecher() {
        List<Buch> verfuegbare = new ArrayList<>();
        for (Buch buch : buecher) {
            if (buch.istVerfuegbar()) {
                verfuegbare.add(buch);
            }
        }
        return verfuegbare;
    }

    public List<Benutzer> getBenutzer() {
        return benutzer;
    }
}


