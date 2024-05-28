import java.util.ArrayList;
import java.util.List;

public class Mannschaft implements Comparable<Mannschaft>{
    private String name;
    private String liga;
    private List<Spieler> spielerListe;

    public Mannschaft(String name, String liga) {
        this.name = name;
        this.liga = liga;
        this.spielerListe = new ArrayList<>();
    }

    public void addSpieler(Spieler spieler) {
        this.spielerListe.add(spieler);
    }

    public void removeSpieler(Spieler spieler) {
        this.spielerListe.remove(spieler);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLiga() {
        return liga;
    }

    public void setLiga(String liga) {
        this.liga = liga;
    }

    public List<Spieler> getSpielerListe() {
        return spielerListe;
    }

    @Override
    public String toString() {
        return name + " (" + liga + ")";
    }
    
    public int compareTo(Mannschaft other) {
        return this.name.compareTo(other.name);
    }

}