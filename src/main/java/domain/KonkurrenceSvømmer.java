package domain;

import java.time.LocalDate;

public class KonkurrenceSvømmer extends Medlem {
    private Resultat[] discipliner = new Resultat[4];

    public KonkurrenceSvømmer(String fuldNavn,
                              String adresse,
                              int alder,
                              LocalDate fødselsdato,
                              int telefonnummer,
                              String email,
                              String aktivitetsForm,
                              int medlemskabsType,
                              boolean medlemskabStatus) {

        super(fuldNavn, adresse, alder, fødselsdato, telefonnummer, email, aktivitetsForm, medlemskabsType, medlemskabStatus);
        setMedlemskabType(alder);
        setAktivitetsform("Konkurrencesvommer");
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
