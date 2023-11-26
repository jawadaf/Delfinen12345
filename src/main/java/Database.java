import java.time.LocalDate;
import java.util.ArrayList;

public class Database {

    FileHandler fileHandler = new FileHandler();
    private ArrayList<Medlem> medlemmer = new ArrayList<>();

    public void tilføjMedlem(String fuldNavn,
                             String adresse,
                             int alder,
                             LocalDate fødselsdato,
                             int telefonnummer,
                             String email) {

        Medlem nyMedlem = new Medlem(
                fuldNavn,
                adresse,
                alder,
                fødselsdato,
                telefonnummer,
                email);
        if (nyMedlem != null ) {
            medlemmer.add(nyMedlem);
        }
    }


    public ArrayList<Medlem> hentMedlem() {
        return medlemmer;
    }

    public void gemMedlemmer() {
        fileHandler.printMedlem(medlemmer);
    }

    public void loadList() {
        medlemmer = fileHandler.loadFromCsvFile();
    }


}

