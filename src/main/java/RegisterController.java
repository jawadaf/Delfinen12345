import java.time.LocalDate;
import java.util.ArrayList;

public class RegisterController {
    Database database = new Database();
    private boolean isChanged = false;


    public void tilføjelseAfMedlem (String fuldNavn,
                                    String adresse,
                                    int alder,
                                    LocalDate fødselsdato,
                                    int telefonnummer,
                                    String email) {

        isChanged = true;
        database.tilføjMedlem(
                fuldNavn,
                adresse,
                alder,
                fødselsdato,
                telefonnummer,
                email);

    }

    public ArrayList<Medlem> hentetMedlem() {
        return database.hentMedlem();
    }


    public void gemMedlemer() {
        database.gemMedlemmer();
    }

    public void loadList() {
        database.loadList();
    }

    public void sletterMedlem (String fuldNavn) {
        isChanged = true;
        database.sletMedlem(fuldNavn);
    }

    public void redigerMedlem(String fuldNavn,
                              String adresse,
                              int alder,
                              int telefonnummer,
                              LocalDate fødselsdato,
                              String email,
                              boolean aktivitetsform,
                              boolean medlemskabStatus,
                              boolean medlemskabType){

        isChanged = true;
        database.redigerMedlem(
                fuldNavn,
                adresse,
                alder,
                telefonnummer,
                fødselsdato,
                email,
                aktivitetsform,
                medlemskabStatus,
                medlemskabType);
    }





    public void exit() {
        if (isChanged) {
            database.gemMedlemmer();
        }
    }
}
