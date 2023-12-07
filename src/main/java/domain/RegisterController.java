package domain;

import ui.UserInterface;

import java.time.LocalDate;
import java.util.ArrayList;

public class RegisterController {
    private Database database;
    private boolean isChanged = false;

    public RegisterController() {
        this.database = new Database();
    }


    // Medlem _______________________________________________________________________

    public void tilføjelseAfMedlem(Medlem medlem) {
        database.tilføjMedlem(medlem.getFuldNavn(),
                medlem.getAdresse(),
                medlem.getAlder(),
                medlem.getFødselsdato(),
                medlem.getTelefonnummer(),
                medlem.getEmail(),
                medlem.getAktivitetsform(),
                medlem.getMedlemskabType(),
                medlem.getMedlemskabStatus());

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


}
