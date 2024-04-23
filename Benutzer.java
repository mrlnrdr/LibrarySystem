import java.util.ArrayList;
import java.util.List;

public class Benutzer {
        private String name;
        private int ausweisnummer;
        private List<Buch> ausgelieheneBuecher;

        public Benutzer(String name, int ausweisnummer) {
            this.name = name;
            this.ausweisnummer = ausweisnummer;
            this.ausgelieheneBuecher = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public void buchAusleihen(Buch buch) {
            ausgelieheneBuecher.add(buch);
        }

        public void buchRueckgabe(Buch buch) {
            ausgelieheneBuecher.remove(buch);
        }

        public List<Buch> getAusgelieheneBuecher() {
            return ausgelieheneBuecher;
        }
    }
