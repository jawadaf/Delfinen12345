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

    public KonkurrenceSvømmer() {

    }

    public void tilføjDiscipliner(Resultat[] nyDesciplin) {
        int startIndex = 0;
        for (int i = 0; i < discipliner.length; i++) {
            if (discipliner[i] == null ) {
                startIndex = i;
                break;
            }
        }
        for (int i = 0; i < nyDesciplin.length && startIndex + i < discipliner.length; i++) {
            discipliner[startIndex + i] = nyDesciplin[i];  // sørger for at discipline er ikke større end den ny Array.
        }
    }


    public String isButterFly() {
        for (Resultat resultat : discipliner) {
            if (resultat != null) {
                String disciplinNavn = resultat.getDisciplineNavn();
                if (disciplinNavn != null && disciplinNavn.equalsIgnoreCase("butterfly")) {
                    return "butterfly";
                }
            }
        } return null;
    }


    public String isCrawl() {
        for (Resultat resultat : discipliner) {
            if (resultat != null) {
                String disciplinNavn = resultat.getDisciplineNavn();
                if (disciplinNavn != null && disciplinNavn.equalsIgnoreCase("crawl")) {
                    return "crawl";
                }
            }
        } return null;
    }

    public String isBackCrawl() {
        for (Resultat resultat : discipliner) {
            if (resultat != null) {
                String disciplinNavn = resultat.getDisciplineNavn();
                if (disciplinNavn != null && disciplinNavn.equalsIgnoreCase("backcrawl")) {
                    return "backcrawl";
                }
            }
        } return null;
    }

    public String isBrystSvomning() {
        for (Resultat resultat : discipliner) {
            if (resultat != null) {
                String disciplinNavn = resultat.getDisciplineNavn();
                if (disciplinNavn != null && disciplinNavn.equalsIgnoreCase("brystsvomning")) {
                    return "brystsvomning";
                }
            }
        } return null;
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
