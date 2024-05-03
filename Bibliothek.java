import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
public class Bibliothek {
    private List<Ausleihe> ausleihen;
    private List<Buch> buecher;
    private List<Benutzer> benutzer;


    public Bibliothek() {
        ausleihen = new ArrayList<>();
        buecher = new ArrayList<>();
        benutzer = new ArrayList<>();
    }

    // Methoden für Ausleihen verwalten
    public void buchAusleihen(Benutzer benutzer, Buch buch) {
        // Überprüfen, ob das Buch verfügbar ist
        if (buecher.contains(buch)) {
            // Überprüfen, ob der Benutzer bereits das Buch ausgeliehen hat
            boolean hatBereitsAusgeliehen = ausleihen.stream()
                    .anyMatch(ausleihe -> ausleihe.getBenutzer().equals(benutzer) && ausleihe.getBuch().equals(buch));
            if (!hatBereitsAusgeliehen) {
                // Buch ausleihen und Ausleihe hinzufügen
                Ausleihe ausleihe = new Ausleihe(benutzer, buch, LocalDate.now()); // Aktuelles Datum setzen
                ausleihen.add(ausleihe);
                System.out.println(benutzer.getName() + " hat das Buch \"" + buch.getTitel() + "\" ausgeliehen.");
            } else {
                System.out.println(benutzer.getName() + " hat das Buch \"" + buch.getTitel() + "\" bereits ausgeliehen.");
            }
        } else {
            System.out.println("Das Buch \"" + buch.getTitel() + "\" ist nicht verfügbar.");
        }
    }

    public void buchRueckgabe(Benutzer benutzer, Buch buch) {
        // Überprüfen, ob das Buch ausgeliehen wurde
        Ausleihe ausleihe = ausleihen.stream()
                .filter(ausl -> ausl.getBenutzer().equals(benutzer) && ausl.getBuch().equals(buch))
                .findFirst()
                .orElse(null);

        if (ausleihe != null) {
            ausleihen.remove(ausleihe);
            System.out.println(benutzer.getName() + " hat das Buch \"" + buch.getTitel() + "\" zurückgegeben.");
        } else {
            System.out.println("Das Buch \"" + buch.getTitel() + "\" wurde von " + benutzer.getName() + " nicht ausgeliehen.");
        }
    }
    public List<Buch> getVerfuegbareBuecher() {
        List<Buch> verfuegbare = new ArrayList<>();
        for (Buch buch : buecher) {
            if (!istAusgeliehen(buch)) {
                verfuegbare.add(buch);
            }
        }
        return verfuegbare;
    }

    private boolean istAusgeliehen(Buch buch) {
        for (Ausleihe ausleihe : ausleihen) {
            if (ausleihe.getBuch().equals(buch)) {
                return true;
            }
        }
        return false;
    }

    // Methoden für Buchverwaltung
    public void buchHinzufuegen(Buch buch) {
        buecher.add(buch);
        System.out.println("Buch hinzugefügt: " + buch.getTitel());
    }

    public void buchEntfernen(Buch buch) {
        buecher.remove(buch);
    }

    // Methoden für Benutzerverwaltung
    public void benutzerRegistrieren(Benutzer benutzer) {
        System.out.println("Benutzer registriert: " + benutzer.getName());
    }

    // Weitere Methoden für Buch- und Benutzerverwaltung..
    //

}
