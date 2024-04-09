import java.util.List;

public class Bibliotheksverwaltung {
    public static void main(String[] args) {
        Bibliothek bibliothek = new Bibliothek();

        // Bücher hinzufügen
        Buch buch1 = new Buch("Java ist toll", "John Doe");
        Buch buch2 = new Buch("Python für Anfänger", "Jane Smith");
        bibliothek.buchHinzufuegen(buch1);
        bibliothek.buchHinzufuegen(buch2);

        // Benutzer registrieren
        Benutzer benutzer1 = new Benutzer("Max Mustermann", 123456);
        Benutzer benutzer2 = new Benutzer("Anna Schmidt", 789012);
        bibliothek.benutzerRegistrieren(benutzer1);
        bibliothek.benutzerRegistrieren(benutzer2);

        // Bücher ausleihen und zurückgeben
        bibliothek.buchAusleihen(benutzer1, buch1);
        bibliothek.buchAusleihen(benutzer2, buch2);
        bibliothek.buchRueckgabe(benutzer1, buch1);

        // Verfügbare Bücher anzeigen
        System.out.println("Verfügbare Bücher:");
        List<Buch> verfuegbareBuecher = bibliothek.getVerfuegbareBuecher();
        for (Buch buch : verfuegbareBuecher) {
            System.out.println(buch.getTitel() + " - " + buch.getAutor());
        }

        // Ausgeliehene Bücher eines Benutzers anzeigen
        System.out.println("\nAusgeliehene Bücher von " + benutzer1.getName() + ":");
        List<Buch> ausgelieheneBuecher = benutzer1.getAusgelieheneBuecher();
        for (Buch buch : ausgelieheneBuecher) {
            System.out.println(buch.getTitel() + " - " + buch.getAutor());
        }
    }
}