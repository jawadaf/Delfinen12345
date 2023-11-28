import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    private File f = new File("medlemregister.csv");

    public void printMedlem(ArrayList<Medlem> medlemListe ) {
        try {
            PrintStream out = new PrintStream(f);
            for (Medlem medlem : medlemListe) {
                if (medlem instanceof KonkurrenceSvømmere) {
                    out.println(medlem.getFuldNavn() + ", " +
                            medlem.getAdresse() + ", " + ", " +
                            medlem.getAlder() + ", " +
                            medlem.getFødselsdato() + ", " +
                            medlem.getTelefonnummer() + ", " +
                            medlem.getEmail() + ", " +
                            medlem.getAktivitetsform() + ", " +
                            medlem.getMedlemskabType() + ", " +
                            medlem.getMedlemskabStatus());

                } else {
                    out.println(medlem.getFuldNavn() + ", " +
                            medlem.getAdresse() + ", " + ", " +
                            medlem.getAlder() + ", " +
                            medlem.getFødselsdato() + ", " +
                            medlem.getTelefonnummer() + ", " +
                            medlem.getEmail() + ", " +
                            medlem.getAktivitetsform() + ", " +
                            medlem.getMedlemskabType() + ", " +
                            medlem.getMedlemskabStatus());
                }
            }
            out.close();
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
                if (attributer.length < 10) {

                    String fuldNavn = attributer[0].trim();
                    String adresse = attributer[1].trim();
                    int alder = Integer.parseInt(attributer[2].trim());
                    LocalDate fødselsdato = LocalDate.parse(attributer[3].trim());
                    int telefonnummer = Integer.parseInt(attributer[4].trim());
                    String email = attributer[5].trim();
                    String aktivitetsform = attributer[6].trim();
                    int medlemskabType = Integer.parseInt(attributer[7].trim());
                    boolean medlemskabStatus = Boolean.parseBoolean(attributer[8].trim());


                    Medlem indlæsData = new Medlem(
                            fuldNavn,
                            adresse,
                            alder,
                            fødselsdato,
                            telefonnummer,
                            email,
                            aktivitetsform,
                            medlemskabType,
                            medlemskabStatus
                            );

                    information.add(indlæsData);
                } else {
                    Motionist motionist = new Motionist(attributer[0], attributer[1], Integer.parseInt(attributer[2]), LocalDate.parse(attributer[3]), Integer.parseInt(attributer[4]), attributer[5], attributer[6], Boolean.parseBoolean(attributer[7]));
                    information.add(motionist);
                }
            }
            sc.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return information;
    }
}
