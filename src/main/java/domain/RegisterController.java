package domain;

import java.time.LocalDate;
import java.util.ArrayList;

public class RegisterController {
    private Database database;
    private boolean isChanged = false;

    public RegisterController() {
        this.database = new Database();
    }

    // Medlem_______________________________________________________________________
    public void tilføjelseAfMedlem (String fuldNavn,
                                    String adresse,
                                    int alder,
                                    LocalDate fødselsdato,
                                    int telefonnummer,
                                    String email,
                                    String aktivitetsform,
                                    int medlemskabType,
                                    boolean medlemskabStatus) {

        isChanged = true;
        database.tilføjMedlem(
                fuldNavn,
                adresse,
                alder,
                fødselsdato,
                telefonnummer,
                email,
                aktivitetsform,
                medlemskabType,
                medlemskabStatus);
    }

    public ArrayList<Medlem> hentetMedlem() {
        return database.hentMedlem();
    }

    public void gemMedlemer() {
        database.gemMedlemmer();
    }

    public void sletterMedlem (String fuldNavn) {
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
                              boolean medlemskabStatus,
                              int medlemskabType){

        isChanged = true;
        database.redigerMedlem(
                fuldNavn,
                adresse,
                alder,
                telefonnummer,
                fødselsdato,
                email,
                aktivitetsform,
                medlemskabType,
                medlemskabStatus
        );
    }

    // Hold____________________________________________________________________________
    public void opretHold(String holdNavn) {
        database.opretHold(holdNavn);
    }


    public void fjernMedlemFraHold(String fuldNavn, String holdNavn) {
        database.fjernMedlemFraHold(fuldNavn, holdNavn);
    }

    public void tilføjMedlemTilHold(String fuldNavn, String holdNavn) {
        database.tilføjMedlemTilHold(fuldNavn, holdNavn);
    }

   /* public ArrayList<Domain.Hold> visHoldMedlemmer() {
       return database.visHoldMedlemmer();
    }

    */

    public ArrayList<Hold> getSeniorHold() {
        return database.getSeniorHold();
    }

    public ArrayList<Hold> getJuniorHold() {
        return database.getJuniorHold();
    }



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
