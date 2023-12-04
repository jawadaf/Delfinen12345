package domain;

import datasource.FileHandler;

import java.time.LocalDate;
import java.util.ArrayList;

public class Database {
    private FileHandler fileHandler;
    private ArrayList<Medlem> medlemmer;
    private Medlem medlem;
    private ArrayList<Medlem> konkurrenceSvømmer;
    private ArrayList<Medlem> motionist;
    private ArrayList<Hold> holdListe;
    private ArrayList<Medlem> juniorHold;
    private ArrayList<Medlem> seniorHold;
    private ArrayList<Medlem> top5;
    private Hold hold;
    private Træner træner;

    public Database() {
        this.holdListe = new ArrayList<>();
        this.fileHandler = new FileHandler();
        this.medlemmer = new ArrayList<>();
        this.medlem = new Medlem();
        this.konkurrenceSvømmer = new ArrayList<>();
        this.motionist = new ArrayList<>();
        this.juniorHold = new ArrayList<>();
        this.seniorHold = new ArrayList<>();
        this.top5 = new ArrayList<>();
        this.hold = new Hold();
        this.træner = new Træner("Mike");
    }

    // Medlem _________________________________________________________________________
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


    public void sletMedlem(String fuldNavn) {

        Medlem sletterMedlem = null;
        for (Medlem medlem : medlemmer) {
            if (medlem.getFuldNavn().equalsIgnoreCase(fuldNavn)) {
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
                              boolean medlemStatus) {
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


    // Hold ______________________________________________________________

    public void opretHold(String holdNavn) {
        Hold nythold = new Hold(holdNavn);
        holdListe.add(nythold);
    }


    public void tilføjMedlemTilJuniorEllerSenior(int alder) {
        Medlem medlem = new Medlem();
        medlemmer.add(medlem);
        if (alder < 18) {
            juniorHold.add(medlem);
        } else {
            seniorHold.add(medlem);
        }

    }


    public void fjernMedlemFraHold(Medlem medlem) {
        medlemmer.remove(medlem);
        if (medlem instanceof KonkurrenceSvømmer) {
            konkurrenceSvømmer.remove(medlem);
            motionist.add(medlem);
        } else {
            motionist.remove(medlem);
            konkurrenceSvømmer.add(medlem);
        }
    }

    /* public void fjernMedlemFraHold(Medlem medlem) {
        medlemmer.remove(medlem);
    }

     */

    public ArrayList<Medlem> visKonkurrenceSvømmerPåHold() {
        System.out.println("Medlemmer på konkurrencesvømmere holdet: ");
        for (Medlem medlem : medlemmer) {
            if (medlem instanceof KonkurrenceSvømmer) {
                konkurrenceSvømmer.add(medlem);
            }
        } return konkurrenceSvømmer;
    }

    public ArrayList<Medlem> getMedlemmer() {
        return medlemmer;
    }


    public ArrayList<Medlem> getJuniorHold() {
        return juniorHold;

    }

    public ArrayList<Medlem> getSeniorHold() {
        seniorHold.addAll((medlemmer));
        return medlemmer;
    }

    public Medlem søgEfterMedlem(String fuldNavn) {
        for (Medlem medlem : medlemmer) {
            if (medlem.getFuldNavn().toLowerCase().contains(fuldNavn.toLowerCase())) {
                return medlem;
            }
        } return null;
    }

    public void fjernMedlemFraHold(String fuldNavn) {
        if (fuldNavn != null) {
            Medlem fundetMedlem = søgEfterMedlem(fuldNavn);
                fjernMedlemFraHold(fundetMedlem);
            } else {
                System.out.println("Medlemmet med navnet " + fuldNavn + " ikke fundet");
            }
        }


    public ArrayList<Medlem> getKonkurrenceSvømmer() {
        for (Medlem medlem : medlemmer) {
            if (medlem instanceof KonkurrenceSvømmer) {
                konkurrenceSvømmer.add(medlem);
            }
        }
        return konkurrenceSvømmer;
    }


    // Kassere __________________________________________________________


    public String kassereOversigt() {
        if (medlem.getAlder() < 18) {
            if (medlem.getMedlemskabStatus() == true) {
                System.out.println("Som medlem under 18 skal du betale 1000 kr årligt.");
            }
        }
        if (medlem.getAlder() > 18) {
            if (medlem.getMedlemskabStatus() == true) {
                System.out.println("Som medlem over 18 skal du betale 1600 kr årligt");
            }
        }
        if (medlem.getAlder() > 60) {
            if (medlem.getMedlemskabStatus() == true) {
                System.out.println("Som medlem over 60 skal du betale 1200 kr årligt");
            }
        }
        if (medlem.getMedlemskabStatus()) {
            if (medlem.getMedlemskabStatus() == false) {
                System.out.println("Som passivt medlem skal du betale 500 kr årligt");
            }
        } return kassereOversigt().toString();
    }


    // FileHandler_____________________________________________
    public void loadList() {
        medlemmer = fileHandler.loadFromCsvFile();
    }

    public void gemMedlemmer() {
        fileHandler.saveMedlem(medlemmer);
    }



}