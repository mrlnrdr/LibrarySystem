// EinfacheBenutzerAuthentifizierung.java
public class EinfacheBenutzerAuthentifizierung implements BenutzerAuthentifizierung {
    // Annahme: Harte Kodierung von Benutzerdaten für Demonstrationszwecke
    private static final String KORREKTER_BENUTZERNAME = "admin";
    private static final String KORREKTES_PASSWORT = "geheim";

    @Override
    public boolean authentifizieren(String benutzername, String passwort) {
        // Überprüfung, ob Benutzername und Passwort übereinstimmen
        return benutzername.equals(KORREKTER_BENUTZERNAME) && passwort.equals(KORREKTES_PASSWORT);
    }
}
