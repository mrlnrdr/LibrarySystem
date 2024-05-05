import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class BibliotheksverwaltungTest {

    @Test
    void testBuchHinzufuegen() {
        Bibliothek bibliothek = new Bibliothek();
        Buch buch = new Buch("Java ist toll", "John Doe");
        bibliothek.buchHinzufuegen(buch);
        assertTrue(bibliothek.getVerfuegbareBuecher().contains(buch));
    }

    @Test
    void testBuchAusleihen() {
        Bibliothek bibliothek = new Bibliothek();
        Benutzer benutzer = new Benutzer("Max Mustermann", 123456);
        Buch buch = new Buch("Java ist toll", "John Doe");
        bibliothek.buchHinzufuegen(buch);
        bibliothek.benutzerRegistrieren(benutzer);
        bibliothek.buchAusleihen(benutzer, buch);
        assertTrue(benutzer.getAusgelieheneBuecher().contains(buch));
        assertFalse(bibliothek.getVerfuegbareBuecher().contains(buch));
    }

    @Test
    void testBuchRueckgabe() {
        Bibliothek bibliothek = new Bibliothek();
        Benutzer benutzer = new Benutzer("Max Mustermann", 123456);
        Buch buch = new Buch("Java ist toll", "John Doe");
        bibliothek.buchHinzufuegen(buch);
        bibliothek.benutzerRegistrieren(benutzer);
        bibliothek.buchAusleihen(benutzer, buch);
        bibliothek.buchRueckgabe(benutzer, buch);
        assertTrue(bibliothek.getVerfuegbareBuecher().contains(buch));
        assertFalse(benutzer.getAusgelieheneBuecher().contains(buch));
    }

    @Test
    void testBewertungHinzufuegen() {
        Buch buch = new Buch("Java ist toll", "John Doe");
        Benutzer benutzer = new Benutzer("Max Mustermann", 123456);
        Bewertung bewertung = new Bewertung(buch, benutzer, 5, "Tolles Buch!");
        buch.bewertungHinzufuegen(bewertung);
        assertEquals(1, buch.getBewertungen().size());
        assertTrue(buch.getBewertungen().contains(bewertung));
    }

    @Test
    void testBewertungAnzeigen() {
        Buch buch = new Buch("Java ist toll", "John Doe");
        Benutzer benutzer = new Benutzer("Max Mustermann", 123456);
        Bewertung bewertung = new Bewertung(buch, benutzer, 5, "Tolles Buch!");
        buch.bewertungHinzufuegen(bewertung);
        List<Bewertung> bewertungen = buch.getBewertungen();
        assertEquals(1, bewertungen.size());
        assertTrue(bewertungen.contains(bewertung));
    }

    @Test
    void testBibliotheksstandortHinzufuegen() {
        Bibliothek bibliothek = new Bibliothek();
        Bibliotheksstandort standort = new Bibliotheksstandort("Hauptbibliothek", "Hauptstraße 1", "Mo-Fr: 9-18 Uhr");
        bibliothek.bibliotheksstandortHinzufuegen(standort);
        assertTrue(bibliothek.getBibliotheksstandorte().contains(standort));
    }

    @Test
    void testBibliotheksstandortEntfernen() {
        Bibliothek bibliothek = new Bibliothek();
        Bibliotheksstandort standort = new Bibliotheksstandort("Hauptbibliothek", "Hauptstraße 1", "Mo-Fr: 9-18 Uhr");
        bibliothek.bibliotheksstandortHinzufuegen(standort);
        bibliothek.bibliotheksstandortEntfernen(standort);
        assertFalse(bibliothek.getBibliotheksstandorte().contains(standort));
    }

    @Test
    void testBenutzerRegistrieren() {
        Bibliothek bibliothek = new Bibliothek();
        Benutzer benutzer = new Benutzer("Max Mustermann", 123456);
        bibliothek.benutzerRegistrieren(benutzer);
        assertTrue(bibliothek.getBenutzerListe().contains(benutzer));
    }

    @Test
    void testVerfuegbareBuecher() {
        Bibliothek bibliothek = new Bibliothek();
        Buch buch1 = new Buch("Java ist toll", "John Doe");
        Buch buch2 = new Buch("Python für Anfänger", "Jane Smith");
    }
}
