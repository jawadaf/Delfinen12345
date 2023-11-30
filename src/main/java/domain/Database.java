package domain;

import datasource.FileHandler;

import java.time.LocalDate;
import java.util.ArrayList;


public class Database {


    private FileHandler fileHandler;
    private ArrayList<Medlem> medlemmer;
    private Medlem medlem;
    private ArrayList<Medlem> konkurrenceSvømmer;
    private ArrayList<Hold> holdListe;
    private ArrayList<Medlem> juniorHold;
    private ArrayList<Medlem> seniorHold;
    private Hold hold;
    private Træner træner;

    public Database() {
        this.holdListe = new ArrayList<>();
        this.fileHandler = new FileHandler();
        this.medlemmer = new ArrayList<>();
        this.medlem = new Medlem();
        this.konkurrenceSvømmer =  new ArrayList<>();
        this.juniorHold = new ArrayList<>();
        this.seniorHold = new ArrayList<>();
        this.hold = new Hold();
        this.træner = new Træner("Mike");
    }

    // Medlem_________________________________________________
    public Medlem tilføjMedlem(String fuldNavn,
                             String adresse,
                             int alder,
                             LocalDate fødselsdato,
                             int telefonnummer,
                             String email,
                             String aktivitetsform,
                             int medlemskabType,
                             boolean medlemskabStatus) {

        Medlem nyMedlem;
        if (aktivitetsform.equalsIgnoreCase("Konkurrencesvømmer")) {
            nyMedlem = new KonkurrenceSvømmer(fuldNavn, adresse, alder, fødselsdato, telefonnummer, email, aktivitetsform, medlemskabType, medlemskabStatus);
        } else {
            nyMedlem = new Motionist(fuldNavn, adresse, alder, fødselsdato, telefonnummer, email, aktivitetsform, medlemskabType, medlemskabStatus);
        }
        medlemmer.add(nyMedlem);
        return medlem;
        }

    public ArrayList<Medlem> hentMedlem() {
        return medlemmer;
    }



    public void getMedlemskabType(int alder) {
        medlem.setMedlemskabType(alder);
    }


    public void sletMedlem(String name) {
        Medlem sletterMedlem = null;
        for (Medlem medlem : medlemmer) {
            if (medlem.getFuldNavn().equalsIgnoreCase(name)) {
                sletterMedlem = medlem;
                break;
            }
        }
        if (sletterMedlem != null) {
            medlemmer.remove(sletterMedlem);
        }
    }
    public void redigerMedlem(String fuldNavn,
                              String adresse,
                              int alder,
                              int telefonnummer,
                              LocalDate fødselsdato,
                              String email,
                              String aktivitetsform,
                              int medlemskabType,
                              boolean medlemStatus){
        for (Medlem medlem : medlemmer) {
            if (medlem.getFuldNavn().equalsIgnoreCase(fuldNavn)) {
                medlem.setAdresse(adresse);
                medlem.setAlder(alder);
                medlem.setTelefonnummer(telefonnummer);
                medlem.setFødselsdato(fødselsdato);
                medlem.setEmail(email);
                medlem.setAktivitetsform(aktivitetsform);
                medlem.setMedlemskabType(medlemskabType);
                medlem.setMedlemskabStatus(medlemStatus);
                return;
            }
        }
    }


   // Hold___________________________________________________

    public void opretHold (String holdNavn) {
        Hold nythold = new Hold(holdNavn);
        holdListe.add(nythold);
    }

    public void tilføjMedlemTilHold(Medlem medlem) {
        hold.tilføjMedlemTilHold(medlem);
    }

    public void tilføjMedlemTilHold(String fuldNavn, String holdNavn) {
        Hold fundetHold = findHold(fuldNavn);
        if (fundetHold != null) {
            Medlem fundetMedlem = findMedlem(fuldNavn);
            if (fundetHold != null) {
                fundetHold.tilføjMedlemTilHold(fundetMedlem);
            }
        } else {
            System.out.println("Holdet med navnet " + holdNavn + " blev ikke fundet");
        }
    }


    public Hold findHold(String holdNavn) {
        for (Hold hold : holdListe) {
            if (hold.getHoldNavn().equalsIgnoreCase(holdNavn)) {
                return hold;
            }
        } return null;
    }

    public Medlem findMedlem(String fuldNavn) {
        for (Hold hold : holdListe) {
            for (Medlem medlem : hold.getMedlemmer()) {
                if (medlem.getFuldNavn().equalsIgnoreCase(fuldNavn)) {
                    return medlem;
                }
            }
        } return null;

    }

    public void visHoldMedlemmer(String holdNavn) {
        Hold fundetHold = findHold(holdNavn);
        if (fundetHold != null) {
            fundetHold.visMedlemmer();
        } else {
            System.out.println("Holdet med navnet " + holdNavn + " blev ikke fundet");
        }
    }

    public void fjernMedlemFraHold(String fuldNavn, String holdNavn) {
        Hold fundetHold = findHold(holdNavn);
        if (fundetHold != null) {
            Medlem fundetMedlem = findMedlem(fuldNavn);
            if (fundetMedlem != null) {
                fundetHold.fjernMedlemFraHold(fundetMedlem);
            } else {
                System.out.println("Medlemmet med navnet " + fuldNavn + " ikke fundet");
            }
        } else {
            System.out.println("Holdet med navnet " + holdNavn + " ikke fundet.");
        }
    }

    public ArrayList<Medlem> getKonkurrenceSvømmer() {
        for (Medlem medlem : medlemmer) {
            if (medlem instanceof KonkurrenceSvømmer) {
                konkurrenceSvømmer.add(medlem);
            }
        } return konkurrenceSvømmer;
    }

    // FileHandler_____________________________________________
    public void loadList() {
        medlemmer = fileHandler.loadFromCsvFile();
    }

    public void gemMedlemmer() {
        fileHandler.saveMedlem(medlemmer);
    }

    public ArrayList<Medlem> getSeniorHold() {
        return hold.getSeniorHold();
    }

    public ArrayList<Medlem> getJuniorHold() {
        return hold.getJuniorHold();
    }
    /* public ArrayList<Hold> getSeniorHold() {
        return hold.getSeniorHold();
    }

    public ArrayList<Hold> getJuniorHold() {
        return hold.getJuniorHold();
    }

     */

}
