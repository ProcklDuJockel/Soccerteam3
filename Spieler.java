

public class Spieler implements Mensch, Comparable<Spieler> {
	
	private String Name;
	private String Position;
	private int Trikotnummer;
	
	public Spieler(String Name, String Position, int Trikotnummer) {
		this.Name=Name;
		this.Position=Position;
		this.Trikotnummer=Trikotnummer;
	}
	public String getName() {
		return Name;
	}
	
	public void setName (String Name) {
		this.Name = Name;
	}
	
	public String getPosition() {
		return Position;
	}
	
	public void setPosition(String Position) {
		this.Position = Position;
	}
	
	public int getTrikotnummer() {
		return Trikotnummer;
	}
	
	public void setTrikotnummer(int Trikotnummer) {
		this.Trikotnummer = Trikotnummer;
	}
	public String toString() {
        return Name + " (" + Position + ", #" + Trikotnummer + ")";
    }
	
	public int compareTo(Spieler other) {
        return this.Name.compareTo(other.Name);
    }
}