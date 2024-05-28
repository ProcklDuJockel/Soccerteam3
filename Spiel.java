public class Spiel {
    private Mannschaft mannschaft1;
    private Mannschaft mannschaft2;
    private String ergebnis;

    public Spiel(Mannschaft mannschaft1, Mannschaft mannschaft2) {
        this.mannschaft1 = mannschaft1;
        this.mannschaft2 = mannschaft2;
        this.ergebnis = "0:0"; // Standardergebnis
    }

    public Mannschaft getMannschaft1() {
        return mannschaft1;
    }

    public void setMannschaft1(Mannschaft mannschaft1) {
        this.mannschaft1 = mannschaft1;
    }

    public Mannschaft getMannschaft2() {
        return mannschaft2;
    }

    public void setMannschaft2(Mannschaft mannschaft2) {
        this.mannschaft2 = mannschaft2;
    }

    public String getErgebnis() {
        return ergebnis;
    }

    public void setErgebnis(String ergebnis) {
        this.ergebnis = ergebnis;
    }

    @Override
    public String toString() {
        return mannschaft1.getName() + " vs. " + mannschaft2.getName() + ": " + ergebnis;
    }
}