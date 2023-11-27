import java.time.LocalDate;

public class Motionist extends Medlem {

    public Motionist(String fuldNavn,
                     String adresse,
                     int alder,
                     LocalDate fødselsdato,
                     int telefonnummer,
                     String email,
                     boolean medlemskabStatus) {
        super(fuldNavn, adresse, alder, fødselsdato, telefonnummer, email, medlemskabStatus);
        setMedlemskabType(alder);
        setAktivitetsform("Motionist");
    }
}
