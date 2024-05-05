import java.util.HashMap;
import java.util.Map;

public class FakeBenutzerAuthentifizierung implements BenutzerAuthentifizierung {
    private Map<String, String> benutzerdaten;

    public FakeBenutzerAuthentifizierung() {
        benutzerdaten = new HashMap<>();
        benutzerdaten.put("benutzer1", "passwort1");
        benutzerdaten.put("benutzer2", "passwort2");
    }

    @Override
    public boolean authentifizieren(String benutzername, String passwort) {
        if (benutzerdaten.containsKey(benutzername) && benutzerdaten.get(benutzername).equals(passwort)) {
            return true;
        } else {
            return false;
        }
    }
}
