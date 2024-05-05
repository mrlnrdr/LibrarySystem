import java.util.List;

public interface BuchRepository {
    List<Buch> alleBuecher();
    Buch buchNachId(int id);
    void buchSpeichern(Buch buch);
    void buchLoeschen(Buch buch);
}
