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

    public void sletMedlem(String name) {
        Medlem sletterMedlem = null;
        for (Medlem medlem : medlemmer) {
            if (medlem.getFuldNavn().equalsIgnoreCase(name)) {
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
                              boolean aktivitetsform,
                              boolean medlemskabType,
                              boolean medlemStatus){
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

}
