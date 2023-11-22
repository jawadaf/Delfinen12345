import java.time.LocalDate;

public class Medlem {

  

    private String navn;
    private int alder;
    private String adresse;
    private int telefonnummer;
    private String email;
    private LocalDate fødselsdato;
   /* private String aktivitetsform;
    private String medlemskabType;
    private String medlemskabStatus;*/

    public Medlem(String navn, String adresse, int telefonnummer, String email, int year, int month, int day, int alder) {
        this.navn = navn;
        this.adresse = adresse;
        this.telefonnummer = telefonnummer;
        this.email = email;
        this.fødselsdato = LocalDate.of(year, month, day);
        this.alder = alder;
    }

    public Medlem(String navn, String adresse, int telefonnummer, String email, LocalDate fødselsdato, int alder) {
    }

    public LocalDate getFødselsdato() {
        return fødselsdato;

    }
    public String getNavn() {
        return navn;
    }

    public int getAlder() {
        return alder;
    }

    public String getAdresse() {
        return adresse;
    }
    public int getTelefonnummer() {
        return telefonnummer;
    }
    public String getEmail() {
        return email;
    }



}


