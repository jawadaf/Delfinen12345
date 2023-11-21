import java.time.LocalDate;

public class Medlem {

    Formand formand = new Formand();

    private String navn;
    private int alder;
    private String adresse;
    private int telefonnummer;
    private String email;
    private LocalDate fødselsdato;
    private String aktivitetsform;
    private String medlemskabType;
    private String medlemskabStatus;
    private int abonnement;
    private String ikkeBetalt;
    private boolean isBetalt;


    public Medlem
            (String navn, String adresse, int telefonnummer,
             String email, int year, int month, int day, int alder) {
        this.navn = navn;
        this.adresse = adresse;
        this.telefonnummer = telefonnummer;
        this.email = email;
        this.fødselsdato = LocalDate.of(year, month, day);
        this.alder = alder;
    }
    public LocalDate getFødselsdato() {
        return fødselsdato;
    }
}

