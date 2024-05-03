    import java.time.LocalDateTime;
    import java.time.LocalDate;
    import java.util.List;
    import java.util.Scanner;



    public class Bibliotheksverwaltung {
        public static void main(String[] args) {
            Bibliothek bibliothek = new Bibliothek();
            Scanner scanner = new Scanner(System.in);
            // Bücher hinzufügen
            Buch buch1 = new Buch("Java ist toll", "John Doe");
            Buch buch2 = new Buch("Python für Anfänger", "Jane Smith");
            bibliothek.buchHinzufuegen(buch1);
            bibliothek.buchHinzufuegen(buch2);
            // Bücher hinzufügen
            System.out.println("Buch hinzufügen:");
            System.out.print("Titel: ");
            String buchTitel = scanner.nextLine();
            System.out.print("Autor: ");
            String buchAutor = scanner.nextLine();
            Buch buch3 = new Buch(buchTitel, buchAutor);
            bibliothek.buchHinzufuegen(buch1);

            // Benutzer registrieren
            Benutzer benutzer1 = new Benutzer("Max Mustermann", 123456);
            Benutzer benutzer2 = new Benutzer("Anna Schmidt", 789012);
            bibliothek.benutzerRegistrieren(benutzer1);
            bibliothek.benutzerRegistrieren(benutzer2);
// Benutzer registrieren
            System.out.println("\nBenutzer registrieren:");
            System.out.print("Name: ");
            String benutzerName = scanner.nextLine();
            System.out.print("ID: ");
            int benutzerAusweisnummer = scanner.nextInt();
            scanner.nextLine(); // Um das newline-Zeichen nach nextInt() zu konsumieren
            Benutzer benutzer3 = new Benutzer(benutzerName, benutzerAusweisnummer);
            bibliothek.benutzerRegistrieren(benutzer1);

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


            // Kunden erstellen
            Kunde kunde1 = new Kunde("Max Mustermann", "max@example.com");
            Kunde kunde2 = new Kunde("Erika Mustermann", "erika@example.com");

            // Bewertungen erstellen
            Bewertung bewertung1 = new Bewertung(buch1, benutzer1, 5, "Tolles Buch!");
            Bewertung bewertung2 = new Bewertung(buch2, benutzer2, 4, "Sehr hilfreich!");

            // Bibliotheksstandorte erstellen
            Bibliotheksstandort standort1 = new Bibliotheksstandort("Hauptbibliothek", "Hauptstraße 1", "Mo-Fr: 9-18 Uhr");
            Bibliotheksstandort standort2 = new Bibliotheksstandort("Nebenstelle", "Nebenstraße 2", "Mo-Do: 10-16 Uhr");

            // Ereignisse erstellen
            Ereignis ereignis1 = new Ereignis("Lesung", LocalDateTime.now(), "Hauptbibliothek", "Lesung mit einem berühmten Autor");
            Ereignis ereignis2 = new Ereignis("Workshop", LocalDateTime.now().plusDays(7), "Nebenstelle", "Java-Workshop für Anfänger");
            // Bibliothekar erstellen
            Bibliothekar bibliothekar = new Bibliothekar("Hans Müller", "1234");

            // Mitgliedschaft erstellen
            Mitgliedschaft mitgliedschaft1 = new Mitgliedschaft(benutzer1, LocalDate.now(), LocalDate.now().plusYears(1));
            Mitgliedschaft mitgliedschaft2 = new Mitgliedschaft(benutzer2, LocalDate.now(), LocalDate.now().plusYears(2));

            // Gebühren festlegen
            Gebuehren gebuehren = new Gebuehren(2.0, 0.5);

            // Ausleihstatus überprüfen
            Ausleihstatus status = Ausleihstatus.AUSGELIEHEN;

            // Veranstaltungskategorie erstellen
            Veranstaltungskategorie veranstaltungskategorie = new Veranstaltungskategorie("Lesung");

            // Bibliotheksangebot erstellen
            Bibliotheksangebot bibliotheksangebot = new Bibliotheksangebot("PC-Nutzung", "Freie Nutzung der PCs in der Bibliothek");

            scanner.close();
        }
    }
