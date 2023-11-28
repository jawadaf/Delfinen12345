import java.time.LocalDate;

public class KonkurrenceSvømmere extends Medlem {
    private Resultat[] discipliner = new Resultat[4];

    public KonkurrenceSvømmere(String fuldNavn,
                               String adresse,
                               int alder,
                               LocalDate fødselsdato,
                               int telefonnummer,
                               String email,
                               String aktivitetsForm,
                               boolean medlemskabStatus) {

        super(fuldNavn, adresse, alder, fødselsdato, telefonnummer, email, aktivitetsForm, medlemskabStatus);
        setMedlemskabType(alder);
        setAktivitetsform("Konkurrencesvømmer");
    }

    public void tilføjAktivitet(Resultat nyDesciplin) {
        for (int i = 0; i < discipliner.length; i++) {
            if (discipliner[i] == null ) {
                discipliner[i] = nyDesciplin;
                break;
            }
        }
    }

    public boolean isButterFly() {
        for (Resultat resultat : discipliner) {
            if (resultat != null && resultat.getDisciplineNavn().equalsIgnoreCase("butterfly")) {
                return true;
            }
        } return false;
    }

    public boolean isCrawl() {
        for (Resultat resultat : discipliner) {
            if (resultat != null && resultat.getDisciplineNavn().equalsIgnoreCase("crawl")) {
                return true;
            }
        } return false;
    }

    public boolean isBackCrawl() {
        for (Resultat resultat : discipliner) {
            if (resultat != null && resultat.getDisciplineNavn().equalsIgnoreCase("backcrawl")) {
                return true;
            }
        } return false;
    }

    public boolean isBrystSvømning() {
        for (Resultat resultat : discipliner) {
            if (resultat != null && resultat.getDisciplineNavn().equalsIgnoreCase("brystsvømning")) {
                return true;
            }
        } return false;
    }

    public double getTid() {
        double bedsteTid = 0;
        for (Resultat resultat : discipliner) {
            if (resultat.getTid() != 0) {
                bedsteTid = resultat.getTid();
            }
        } return bedsteTid;
    }

    public Resultat[] getDiscipliner() {
        return discipliner;
    }
}
