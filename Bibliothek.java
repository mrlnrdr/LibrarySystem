import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.time.LocalDate;
import java.util.Scanner;
public class Bibliothek {
    private List<Ausleihe> ausleihen;
    private List<Buch> buecher;
    private List<Benutzer> benutzer;
    private List<Bibliothekar> bibliothekare;
    

    private List<Bibliotheksstandort> bibliotheksstandorte;

    public Bibliothek() {
        ausleihen = new ArrayList<>();
        buecher = new ArrayList<>();
        benutzer = new ArrayList<>();
        this.bibliothekare = new ArrayList<>();
        this.bibliotheksstandorte = new ArrayList<>();
        this.benutzer = new ArrayList<>();
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

    public void bibliotheksstandortHinzufuegen(Bibliotheksstandort standort) {
        bibliotheksstandorte.add(standort);
    }
    public List<Bibliotheksstandort> getBibliotheksstandorte() {
        return bibliotheksstandorte;
    }

    public void bibliotheksstandortEntfernen(Bibliotheksstandort standort) {
        bibliotheksstandorte.remove(standort);
    }

    public void bibliothekarHinzufuegenMitInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bitte geben Sie den Namen des neuen Bibliothekars ein:");
        String name = scanner.nextLine();

        System.out.println("Bitte geben Sie die E-Mail-Adresse des neuen Bibliothekars ein:");
        String email = scanner.nextLine();

        // Erstelle ein neues Bibliothekar-Objekt mit den eingelesenen Daten
        Bibliothekar bibliothekar = new Bibliothekar(name, email);

        // Füge den neuen Bibliothekar zur Liste hinzu
        this.bibliothekare.add(bibliothekar);

        System.out.println("Neuer Bibliothekar erfolgreich hinzugefügt.");


    }

    public List<Benutzer> getBenutzerListe() {
        return benutzer;
    }

}
