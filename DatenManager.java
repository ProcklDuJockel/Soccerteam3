import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DatenManager {
    private static final String DATEIPFAD = "daten.txt";

    public static void speichereDaten(List<String> daten) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATEIPFAD))) {
            for (String datensatz : daten) {
                writer.write(datensatz);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> ladeDaten() {
        List<String> daten = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(DATEIPFAD))) {
            String line;
            while ((line = reader.readLine()) != null) {
                daten.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return daten;
    }
}
