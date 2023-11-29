package domain;

import java.util.Comparator;

public class TidsRegistrering implements Comparator<KonkurrenceSvømmer> {
    public int compare(KonkurrenceSvømmer k1, KonkurrenceSvømmer k2) {
        return (int)(k1.getTid() - k2.getTid());
    }

}
