import java.time.LocalDate;
import java.util.ArrayList;

public class RegisterController {

   /* Formand formand = new Formand();
    private boolean isChanged = false; */

    private ArrayList<Medlem> medlemmer = new ArrayList();
    FileHandler fileHandler = new FileHandler();

    public void start(){

        UserInterface ui = new UserInterface();
        //ui print greeting
        //ui print en menu
        Medlem medlem = ui.registrerNytMedlem();
        medlemmer.add(medlem);
        saveNyMedlem();

    }

    public void saveNyMedlem() {

        fileHandler.saveToCsvFile(medlemmer);
    }



   /* public void tilføjMedlem(String fuldNavn,
                             String adresse,
                             int alder,
                             LocalDate fødeselsdato,
                             int telefonnumer,
                             String email) {
    isChanged = true;
    RegisterController.tilføjMedlem;(
            String fuldNavn,
            String adresse,
            int alder,
            LocalDate fødeselsdato,
            int telefonnumer,
            String email)
    }
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
