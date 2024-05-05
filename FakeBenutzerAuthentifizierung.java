// FakeBenutzerAuthentifizierung.java
public class FakeBenutzerAuthentifizierung implements BenutzerAuthentifizierung {
    @Override
    public boolean authentifizieren(String benutzername, String passwort) {
        // Hier kannst du die Logik für die Fake-Authentifizierung implementieren
        // zum Beispiel immer true zurückgeben, um alle Benutzer zu authentifizieren
        return true;
    }
}
