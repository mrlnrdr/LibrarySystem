import java.util.ArrayList;
import java.util.List;

public class MockEmailSender implements EmailSender {
    private List<String> gesendeteEmails = new ArrayList<>();

    @Override
    public void sendEmail(String empfaenger, String betreff, String nachricht) {
        // Einfach nur eine Nachricht an die Konsole ausgeben, um zu simulieren, dass eine E-Mail gesendet wird
        String email = "An: " + empfaenger + ", Betreff: " + betreff + ", Nachricht: " + nachricht;
        System.out.println("Email gesendet: " + email);

        // Die gesendete E-Mail zur Liste der gesendeten E-Mails hinzufügen
        gesendeteEmails.add(email);
    }

    // Methode zum Überprüfen, ob eine E-Mail gesendet wurde
    public boolean wurdeEmailGesendet(String empfaenger, String betreff, String nachricht) {
        String gesendeteEmail = "An: " + empfaenger + ", Betreff: " + betreff + ", Nachricht: " + nachricht;
        return gesendeteEmails.contains(gesendeteEmail);
    }
}
