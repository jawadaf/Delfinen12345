import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class FileHandler {
    private File f = new File("medlemregister.csv");

    public void printMedlem(ArrayList<Medlem> medlemListe) {
        try {
            PrintStream out = new PrintStream(f);
            for (Medlem medlem : medlemListe) {
                if (medlem != null) {
                    out.println(medlem);
                } else {
                    System.out.println("Der er ingen medlemmer registeret");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Filen eksistere ikke.");
        }
    }


    public ArrayList<Medlem> loadFromCsvFile() {
        ArrayList<Medlem> information = new ArrayList<>();

        try {
            Scanner sc = new Scanner(f, StandardCharsets.ISO_8859_1);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] attributer = line.split(",");
                if (attributer.length == 6) {

                    String fuldNavn = attributer[0].trim();
                    String adresse = attributer[1].trim();
                    int alder = Integer.parseInt(attributer[2].trim());
                    String fødselsdato = attributer[3].trim();
                    int telefonnummer = Integer.parseInt(attributer[4].trim());
                    String email = attributer[5].trim();

                    Medlem indlæsData = new Medlem(
                            fuldNavn,
                            adresse,
                            alder,
                            fødselsdato,
                            telefonnummer,
                            email);
                    information.add(indlæsData);
                } else {
                    System.out.println("Lengden er ikke lige med 6.");
                }
            }
            sc.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return information;
    }
}
