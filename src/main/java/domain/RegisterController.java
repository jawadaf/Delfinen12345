package domain;

import ui.UserInterface;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class RegisterController {
    private Database database;
    private boolean isChanged = false;

    public RegisterController() {
        this.database = new Database();
    }


    // Medlem _______________________________________________________________________

    public void tilføjKonkurrencesvommer(String fuldNavn,
                                         String adresse,
                                         int alder,
                                         LocalDate fødselsdato,
                                         int telefonnummer,
                                         String email,
                                         String aktivitetsform,
                                         int medlemskabType,
                                         boolean medlemskabStatus) {
        database.tilføjKonkurrencesvommer(fuldNavn, adresse, alder, fødselsdato, telefonnummer, email, aktivitetsform, medlemskabType, medlemskabStatus);
    }


    public void tilføjMotionist(String fuldNavn,
                                String adresse,
                                int alder,
                                LocalDate fødselsdato,
                                int telefonnummer,
                                String email,
                                String aktivitetsform,
                                int medlemskabType,
                                boolean medlemskabStatus) {
        database.tilføjMotionist(fuldNavn, adresse, alder, fødselsdato, telefonnummer, email, aktivitetsform, medlemskabType, medlemskabStatus);
    }


    public ArrayList<Medlem> hentetMedlemmer() {
        return database.hentMedlemmer();
    }

    public void gemMedlemer() {
        database.gemMedlemmer();
    }

    public void sletterMedlem(String fuldNavn) {
        isChanged = true;
        database.sletMedlem(fuldNavn);
    }

    public void seMedlemskabType(int alder) {
        database.getMedlemskabType(alder);
    }


    public void redigerMedlem(String fuldNavn,
                              String adresse,
                              int alder,
                              int telefonnummer,
                              LocalDate fødselsdato,
                              String email,
                              String aktivitetsform,
                              boolean medlemskabStatus) {

        isChanged = true;
        database.redigerMedlem(
                fuldNavn,
                adresse,
                alder,
                telefonnummer,
                fødselsdato,
                email,
                aktivitetsform,
                medlemskabStatus);
    }


    // Hold ____________________________________________________________________________


    public ArrayList<Medlem> getTop5ForDiscipline(String disciplin) {
        return database.getTop5ForDiscipline(disciplin);
    }


    public ArrayList<Medlem> getTop5ForAlleDiscipliner() {
       return database.getTop5ForAlleDiscipliner();
    }

    public ArrayList<String> getAlleDiscipliner() {
       return database.getAlleDiscipliner();
    }


    public String tilføjDisciplinerTilKonkurrencesvommer(String fuldNavn, Resultat[] discipliner) {
        return database.tilføjDisciplinerTilKonkurrencesvommer(fuldNavn, discipliner);
    }

    public String setDisciplinNavn(String disciplinNavn) {
        return database.setDisciplinNavn(disciplinNavn);
    }

    public String isButterFly() {
        return database.isButterFly();
    }

    public String isCrawl() {
        return database.isCrawl();
    }

    public String isBackCrawl() {
        return database.isBackCrawl();
    }
    public String isBrystSvomning() {
        return database.isBrystSvomning();
    }





    public void opretHold(String holdNavn) {
        database.opretHold(holdNavn);
    }

    public String tilføjMedlemTilJuniorEllerSenior(int alder) {
        return database.tilføjMedlemTilJuniorEllerSenior(alder);
    }


    public void fjernMedlemFraHold(String fuldNavn) {
        database.fjernMedlemFraHold(fuldNavn);
    }




   /* public ArrayList<Hold> visHoldMedlemmer() {
       return database.visHoldMedlemmer();
    }

    */


    public ArrayList<Medlem> getSeniorHold() {
        return database.getSeniorHold();
    }

    public ArrayList<Medlem> getJuniorHold() {
        return database.getJuniorHold();
    }

    public ArrayList<Medlem> getKonkurrenceSvømmere() {
        return database.getKonkurrenceSvømmer();
    }

    public ArrayList<Medlem> getTop5() {
        return database.getTop5();
    }


    // Kassere __________________________________________________________


    public int kassereOversigt() {
        ArrayList<Medlem> medlemmer = hentetMedlemmer();
        int totalKontingent = 0;
        for (Medlem medlem : medlemmer) {
            if (medlem.getMedlemskabStatus() == false) {
                totalKontingent += 500;
            } else {
                if (medlem.getAlder() < 18) {
                    totalKontingent += 1000;
                }
                if (medlem.getAlder() >= 18) {
                    totalKontingent += 1600;
                }
                if (medlem.getAlder() >= 60) {
                    totalKontingent += 1200;
                }
            }
        }
        return 0;
    }





  /* public int kassereOversigt(int juniorPris,
                               int seniorPris,
                               int pensionistPris,
                               int passivPris) {
       return 0;
    }


   */

    public int totalKontigent() {
        return database.totalKontigent();
    }



    // Medlem __________________________________________________________

    public String[] listeAfKontingenter() {
        return database.listeAfKontingenter();
    }




    /*public String kassereOversigt() {
        return database.kassereOversigt();
    }

     */



    // FildHandler__________________________________________________________________
    public void loadList() {
        database.loadList();
    }







    public void exit() {
        if (isChanged) {
            database.gemMedlemmer();
        }
    }


    public void saveDiscipliner(ArrayList<Medlem> konkurrenceSvømmere) {
        database.saveDiscipliner(konkurrenceSvømmere);
    }

    // Formand_______________________________________________________________________

    public Medlem findMedlem(String fuldNavn) {
        // Iterér gennem medlemslisten og find medlemmet med det givne fulde navn
        for (Medlem medlem : hentetMedlemmer()) {
            if (medlem.getFuldNavn().equalsIgnoreCase(fuldNavn)) {
                return medlem;
            }
        }
        return null; // Returner null, hvis medlemmet ikke blev fundet
    }


}
