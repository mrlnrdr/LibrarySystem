import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class BibliotheksverwaltungTest {

    @Test
    public void testBuchHinzufuegen() {
        Bibliothek bibliothek = new Bibliothek();
        Buch buch = new Buch("Testbuch", "Testautor");

        bibliothek.buchHinzufuegen(buch);

        assertTrue("Buch wurde nicht hinzugefügt", bibliothek.getVerfuegbareBuecher().contains(buch));
    }

    @Test
    public void testBenutzerRegistrieren() {
        Bibliothek bibliothek = new Bibliothek();
        Benutzer benutzer = new Benutzer("Max Mustermann", 123456);

        bibliothek.benutzerRegistrieren(benutzer);

        // Hier könnte man zusätzliche Tests durchführen, um sicherzustellen, dass der Benutzer richtig registriert wurde
    }

    @Test
    public void testBuchAusleihenUndRueckgabe() {
        Bibliothek bibliothek = new Bibliothek();
        Buch buch = new Buch("Testbuch", "Testautor");
        Benutzer benutzer = new Benutzer("Max Mustermann", 123456);

        bibliothek.buchHinzufuegen(buch);
        bibliothek.benutzerRegistrieren(benutzer);

        bibliothek.buchAusleihen(benutzer, buch);
        assertTrue("Buch wurde nicht ausgeliehen", bibliothek.getAusgelieheneBuecher(benutzer).contains(buch));

        bibliothek.buchRueckgabe(benutzer, buch);
        assertFalse("Buch wurde nicht zurückgegeben", bibliothek.getAusgelieheneBuecher(benutzer).contains(buch));
    }
}
// Path: Bibliotheksverwaltung.java