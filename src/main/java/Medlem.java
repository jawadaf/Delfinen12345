import java.time.LocalDate;

public class Medlem {
    private String fuldNavn;
    private String adresse;
    private int alder;
    private LocalDate fødselsdato;
    private int telefonnummer;
    private String email;
   /* private String aktivitetsform;
    private String medlemskabType;
    private String medlemskabStatus;*/

    public Medlem(String fuldNavn, String adresse, int alder, int year, int month, int day, int telefonnummer, String email) {
        this.fuldNavn = fuldNavn;
        this.adresse = adresse;
        this.alder = alder;
        this.fødselsdato = LocalDate.of(year, month, day);
        this.telefonnummer = telefonnummer;
        this.email = email;


    }

    public Medlem(String fuldNavn, String adresse, int alder, LocalDate fødselsdato, int telefonnummer, String email) {
        this.fuldNavn = fuldNavn;
        this.adresse = adresse;
        this.alder = alder;
        this.fødselsdato = fødselsdato;
        this.telefonnummer = telefonnummer;
        this.email = email;
    }

    // Getter metode

    public String getFuldNavn() {
        return fuldNavn;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getAlder() {
        return alder;
    }

    public LocalDate getFødselsdato() {
        return fødselsdato;
    }

    public int getTelefonnummer() {
        return telefonnummer;
    }

    public String getEmail() {
        return email;
    }

    // Setter metode

    public void setFuldNavn(String fuldNavn) {
        this.fuldNavn = fuldNavn;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setAlder(int alder) {
        this.alder = alder;
    }

    public void setFødselsdato(LocalDate fødselsdato) {
        this.fødselsdato = fødselsdato;
    }

    public void setTelefonnummer(int telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return fuldNavn + ", " +
                adresse + ", " +
                alder + ", " +
                fødselsdato + ", " +
                telefonnummer + ", " +
                email;
    }
}


