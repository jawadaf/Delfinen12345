package domain;

import java.util.Comparator;

public class TidsRegistrering implements Comparator<Medlem> {
    private String disciplin;

    public TidsRegistrering(String disciplin) {
        this.disciplin = disciplin;
    }

    public int compare(Medlem m1, Medlem m2) {
        double tid1 = getTidForDiscipline(m1);
        double tid2 = getTidForDiscipline(m2);
        // Fange den bedste svømmer
        if (tid1 < tid2) {
            return -1;
        } else if (tid1 > tid2) {
            return 1;
        } else {
            return 0;
        }

    }

    private double getTidForDiscipline(Medlem medlem) {
        if (medlem instanceof KonkurrenceSvømmer) {
            KonkurrenceSvømmer konkurrenceSvømmer = (KonkurrenceSvømmer) medlem;
            for (Resultat resultat : konkurrenceSvømmer.getDiscipliner()) {
                if (resultat.getDisciplineNavn().equalsIgnoreCase(disciplin)) {
                    return resultat.getTid();
                }
            }
        }
        return Double.MAX_VALUE;
    }



}
