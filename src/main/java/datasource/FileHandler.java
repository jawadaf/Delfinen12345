package datasource;

import domain.KonkurrenceSvømmere;
import domain.Medlem;
import domain.Motionist;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    private File f = new File("medlemregister.csv");

    public void saveMedlem(ArrayList<Medlem> medlemListe ) {
        try (PrintStream out = new PrintStream(new FileOutputStream(f, true))) {
            for (Medlem medlem : medlemListe) {
                if (medlem instanceof KonkurrenceSvømmere) {
                    out.println(medlem.getFuldNavn() + ", " +
                            medlem.getAdresse() + ", " +
                            medlem.getAlder() + ", " +
                            medlem.getFødselsdato() + ", " +
                            medlem.getTelefonnummer() + ", " +
                            medlem.getEmail() + ", " +
                            medlem.getAktivitetsform() + ", " +
                            medlem.getMedlemskabType() + ", " +
                            medlem.getMedlemskabStatus());
                } else if (medlem instanceof Motionist) {
                    out.println(medlem.getFuldNavn() + ", " +
                            medlem.getAdresse() + ", " +
                            medlem.getAlder() + ", " +
                            medlem.getFødselsdato() + ", " +
                            medlem.getTelefonnummer() + ", " +
                            medlem.getEmail() + ", " +
                            medlem.getAktivitetsform() + ", " +
                            medlem.getMedlemskabType() + ", " +
                            medlem.getMedlemskabStatus());
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
                if (attributer.length >= 9) {
                    String fuldNavn = attributer[0].trim();
                    String adresse = attributer[1].trim();
                    int alder = Integer.parseInt(attributer[2].trim());
                    LocalDate fødselsdato = LocalDate.parse(attributer[3].trim());
                    int telefonnummer = Integer.parseInt(attributer[4].trim());
                    String email = attributer[5].trim();
                    String aktivitetsform = attributer[6].trim();
                    int medlemskabType = Integer.parseInt(attributer[7].trim());
                    boolean medlemskabStatus = Boolean.parseBoolean(attributer[8].trim());

                    if (attributer.length == 9) {
                        Motionist motionist = new Motionist(fuldNavn, adresse, alder, fødselsdato, telefonnummer, email, aktivitetsform, medlemskabType, medlemskabStatus);
                        information.add(motionist);
                    } else if (attributer.length == 10) {
                        int medlemskabsType = Integer.parseInt(attributer[7].trim());
                        KonkurrenceSvømmere konkurrenceSvømmere = new KonkurrenceSvømmere(fuldNavn, adresse, alder, fødselsdato, telefonnummer, email, aktivitetsform, medlemskabsType, medlemskabStatus);
                        information.add(konkurrenceSvømmere);
                    }
                } else {
                    System.out.println("Ugyldig linje " + line);
                }
            }
            sc.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return information;
    }
}
