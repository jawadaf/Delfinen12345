import java.time.LocalDate;
import java.util.ArrayList;

public class Database {

    private FileHandler fileHandler = new FileHandler();
    private ArrayList<Medlem> medlemmer = new ArrayList<>();
    private Medlem medlem = new Medlem();
    private ArrayList<Medlem> konkurrenceSvømmer = new ArrayList<>();

    public void tilføjMedlem(String fuldNavn,
                             String adresse,
                             int alder,
                             LocalDate fødselsdato,
                             int telefonnummer,
                             String email,
                             String aktivitetsform,
                             int medlemskabType,
                             boolean medlemskabStatus) {

        Medlem nyMedlem = new Medlem(
                fuldNavn,
                adresse,
                alder,
                fødselsdato,
                telefonnummer,
                email,
                aktivitetsform,
                medlemskabType,
                medlemskabStatus);
        if (nyMedlem != null ) {
            medlemmer.add(nyMedlem);
        }

    }

    public void tilføjKonkurrenceSvømmer(String fuldNavn,
                                         String adresse,
                                         int alder,
                                         LocalDate fødselsdato,
                                         int telefonnummer,
                                         String email,
                                         String aktivitetsForm,
                                         boolean medlemskabStatus) {
        medlemmer.add(new KonkurrenceSvømmere(fuldNavn, adresse, alder, fødselsdato, telefonnummer, email, aktivitetsForm, medlemskabStatus));
    }

    public void tilføjMotionist(String fuldNavn,
                                         String adresse,
                                         int alder,
                                         LocalDate fødselsdato,
                                         int telefonnummer,
                                         String email,
                                         boolean medlemskabStatus) {
        medlemmer.add(new Motionist(fuldNavn, adresse, alder, fødselsdato, telefonnummer, email, medlemskabStatus));
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

    public void getMedlemskabType(int alder) {
        medlem.setMedlemskabType(alder);
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
                              String aktivitetsform,
                              int medlemskabType,
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
