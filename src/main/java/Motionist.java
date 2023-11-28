import java.time.LocalDate;

public class Motionist extends Medlem {

    public Motionist(String fuldNavn,
                     String adresse,
                     int alder,
                     LocalDate fødselsdato,
                     int telefonnummer,
                     String email,
                     String aktivitetsform,
                     boolean medlemskabStatus) {
        super(fuldNavn, adresse, alder, fødselsdato, telefonnummer, email, aktivitetsform, medlemskabStatus);
        setMedlemskabType(alder);
        setAktivitetsform("Motionist");
    }
}
