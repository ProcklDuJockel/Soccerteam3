import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;

public class InputManager {
	
	 private static final String NAME_PATTERN = "^[a-zA-Z]+$";
	 private static final String POSITION_PATTERN = "^[a-zA-Z]+$";
	 private static final String NUMMER_PATTERN = "^[0-9]+$";
    
    Scanner scanner = new Scanner(System.in);
    List<String> daten = DatenManager.ladeDaten();

    public void start() {
        while (true) {
            System.out.println("1. Spieler hinzufügen");
            System.out.println("2. Spieler entfernen");
            System.out.println("3. Mannschaft erstellen");
            System.out.println("4. Spiel simulieren");
            System.out.println("5. Beenden");
            System.out.print("Wähle eine Option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Verbrauche das neue Zeilenzeichen

            switch (option) {
                case 1:
                	 System.out.print("Spielername: ");
                     String spielerName = scanner.nextLine();
                     if (!spielerName.matches(NAME_PATTERN)) {
                         System.out.println("Ungültiger Name. Bitte nur Buchstaben eingeben.");
                         break;
                     }

                     System.out.print("Position: ");
                     String position = scanner.nextLine();
                     if (!position.matches(POSITION_PATTERN)) {
                         System.out.println("Ungültige Position. Bitte nur Buchstaben eingeben.");
                         break;
                     }

                     System.out.print("Trikotnummer: ");
                     String trikotnummerStr = scanner.nextLine();
                     if (!trikotnummerStr.matches(NUMMER_PATTERN)) {
                         System.out.println("Ungültige Trikotnummer. Bitte nur Zahlen eingeben.");
                         break;
                     }
                     int trikotnummer = Integer.parseInt(trikotnummerStr);

                     String spielerData = spielerName + "," + position + "," + trikotnummer;
                     daten.add(spielerData);
                     System.out.println("Spieler hinzugefügt: " + spielerName + ", " + position + ", " + trikotnummer);
                     break;
                case 2:
                    System.out.print("Spielername zum Entfernen: ");
                    String spielerToRemove = scanner.nextLine();
                    if (!spielerToRemove.matches(NAME_PATTERN)) {
                        System.out.println("Ungültiger Name. Bitte nur Buchstaben eingeben.");
                        break;
                    }

                    // Durchlaufe die Spielerliste und entferne den Spieler mit dem angegebenen Namen
                    boolean entfernt = false;
                    for (String datensatz : daten) {
                        String[] spielerData2 = datensatz.split(",");
                        if (spielerData2[0].equals(spielerToRemove)) {
                            daten.remove(datensatz);
                            System.out.println("Spieler " + spielerToRemove + " wurde entfernt.");
                            entfernt = true;
                            break;
                        }
                    }
                    if (!entfernt) {
                        System.out.println("Spieler " + spielerToRemove + " wurde nicht gefunden.");
                    }
                    break;
                case 3:
                    System.out.print("Mannschaftsname: ");
                    String mannschaftsName = scanner.nextLine();
                    System.out.print("Liga: ");
                    String liga = scanner.nextLine();

                    String mannschaftData = mannschaftsName + "," + liga;
                    daten.add(mannschaftData);
                    break;
                case 4:
                    System.out.print("Name der ersten Mannschaft: ");
                    String nameMannschaft1 = scanner.nextLine();
                    System.out.print("Name der zweiten Mannschaft: ");
                    String nameMannschaft2 = scanner.nextLine();

                    Mannschaft mannschaft1 = null;
                    Mannschaft mannschaft2 = null;

                    // Finde die Mannschaftsobjekte in der Liste der Daten
                    for (String datensatz : daten) {
                        String[] mannData = datensatz.split(",");
                        if (mannData.length == 2) {
                            if (mannData[0].equals(nameMannschaft1)) {
                                mannschaft1 = new Mannschaft(mannData[0], mannData[1]);
                            } else if (mannData[0].equals(nameMannschaft2)) {
                                mannschaft2 = new Mannschaft(mannData[0], mannData[1]);
                            }
                        }
                    }

                    // Wenn beide Mannschaften gefunden wurden, erstelle ein Spiel und simuliere es
                    if (mannschaft1 != null && mannschaft2 != null) {
                        Spiel spiel = new Spiel(mannschaft1, mannschaft2);
                        // Hier könntest du die Simulation durchführen
                        // Beispiel für ein zufälliges Ergebnis
                        int toreMannschaft1 = (int) (Math.random() * 5);
                        int toreMannschaft2 = (int) (Math.random() * 5);
                        String ergebnis = toreMannschaft1 + ":" + toreMannschaft2;
                        spiel.setErgebnis(ergebnis);
                        System.out.println("Simulation des Spiels: " + spiel);
                    } else {
                        System.out.println("Eine oder beide Mannschaften nicht gefunden.");
                    }
                    break;
                case 5:
                	System.out.println("1. Namen aller Mannschaften sortiert ausgeben");
                    System.out.println("2. Spieler einer bestimmten Mannschaft sortiert ausgeben");
                    System.out.print("Wähle eine Option: ");
                    scanner.nextLine(); // Verbrauche das neue Zeilenzeichen

                    switch (option) {
                        case 1:
                            // Sortiere die Namen aller Mannschaften
                            List<Mannschaft> sortedMannschaften = new ArrayList<>(mannschaftListe);
                            sortedMannschaften.sort(Comparator.comparing(Mannschaft::getName));
                            System.out.println("Namen aller Mannschaften sortiert:");
                            for (Mannschaft mannschaft : sortedMannschaften) {
                                System.out.println(mannschaft.getName());
                            }
                            break;
                        case 2:
                            // Gib die Spielerliste einer bestimmten Mannschaft sortiert aus
                            System.out.print("Gib den Namen der Mannschaft ein: ");
                            String mannschaftsName2 = scanner.nextLine();
                            Mannschaft foundMannschaft = null;
                            for (Mannschaft mannschaft : mannschaftListe) {
                                if (mannschaft.getName().equals(mannschaftsName2)) {
                                    foundMannschaft = mannschaft;
                                    break;
                                }
                            }
                            if (foundMannschaft != null) {
                                List<Spieler> sortedSpieler = new ArrayList<>(foundMannschaft.getSpielerListe());
                                sortedSpieler.sort(Comparator.comparing(Spieler::getName));
                                System.out.println("Spielerliste von " + mannschaftsName2 + " sortiert:");
                                for (Spieler spieler : sortedSpieler) {
                                    System.out.println(spieler);
                                }
                            } else {
                                System.out.println("Mannschaft nicht gefunden.");
                            }
                            break;
                        
                case 6:
                    DatenManager.speichereDaten(daten);
                    System.out.println("Daten gespeichert. Programm beendet.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Ungültige Option. Bitte wählen Sie erneut.");
            }
        }
    }
    }
}

