package domain;

import java.time.LocalDate;
import java.util.ArrayList;

public class RegisterController {
    private Database database;
    private boolean isChanged = false;

    public RegisterController() {
        this.database = new Database();
    }

    // Medlem _______________________________________________________________________
    public Medlem tilføjelseAfMedlem (Medlem medlem) {
        isChanged = true;
        database.tilføjMedlem(
                medlem.getFuldNavn(),
                medlem.getAdresse(),
                medlem.getAlder(),
                medlem.getFødselsdato(),
                medlem.getTelefonnummer(),
                medlem.getEmail(),
                medlem.getAktivitetsform(),
                medlem.getMedlemskabType(),
                medlem.getMedlemskabStatus());
        return medlem;
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

    // Hold ____________________________________________________________________________
    public void opretHold(String holdNavn) {
        database.opretHold(holdNavn);
    }

    public void tilføjMedlemTilJuniorEllerSenior(int alder) {
        database.tilføjMedlemTilJuniorEllerSenior(alder);
    }


    public void fjernMedlemFraHold(String fuldNavn) {
        database.fjernMedlemFraHold(fuldNavn);
    }




   /* public ArrayList<Domain.Hold> visHoldMedlemmer() {
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


    /* public ArrayList<Hold> getSeniorHold() {
        return database.getSeniorHold();
    }

    public ArrayList<Hold> getJuniorHold() {
        return database.getJuniorHold();
    }

     */





    // Kassere __________________________________________________________

public String kassereOversigt(){
    return database.kassereOversigt();
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
