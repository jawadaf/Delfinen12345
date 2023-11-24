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


    public void gemMedlem() {
        database.gemMedlem();
    }

    public void exit() {
    }


        /* UserInterface ui = new UserInterface();
        //ui print greeting
        //ui print en menu
        Medlem medlem = ui.registrerNytMedlem();
        medlemmer.add(medlem);
        saveNyMedlem();

    }

    public void saveNyMedlem() {

    }
*/


   /*

    public void medlemEdits (
            String fuldNavn,
            String adresse,
            int alder,
            LocalDate fødeselsdato,
            int telefonnumer,
            String email) {

        isChanged = true;

        RegisterController.medlemEdits(fuldNavn, adresse, alder, fødeselsdato, telefonnumer, email);*/
        //}



}
