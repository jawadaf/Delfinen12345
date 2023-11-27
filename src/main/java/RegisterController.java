import java.time.LocalDate;
import java.util.ArrayList;

public class RegisterController {
    private Database database = new Database();
    private boolean isChanged = false;


    public void tilføjelseAfMedlem (String fuldNavn,
                                    String adresse,
                                    int alder,
                                    LocalDate fødselsdato,
                                    int telefonnummer,
                                    String email,
                                    String aktivitetsform,
                                    boolean medlemskabStatus,
                                    int medlemskabType) {

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

    public void tilføjKonkurrenceSvømmer(String fuldNavn,
                                         String adresse,
                                         int alder,
                                         LocalDate fødselsdato,
                                         int telefonnummer,
                                         String email,
                                         String aktivitetsForm,
                                         boolean medlemskabStatus) {
        database.tilføjKonkurrenceSvømmer(fuldNavn, adresse, alder, fødselsdato, telefonnummer, email, aktivitetsForm, medlemskabStatus);
    }

    public void tilføjMotionist(String fuldNavn,
                                String adresse,
                                int alder,
                                LocalDate fødselsdato,
                                int telefonnummer,
                                String email,
                                boolean medlemskabStatus) {
        database.tilføjMotionist(fuldNavn, adresse, alder, fødselsdato, telefonnummer, email, medlemskabStatus);
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





    public void exit() {
        if (isChanged) {
            database.gemMedlemmer();
        }
    }
}
