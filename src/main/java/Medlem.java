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


    public Medlem(String fuldNavn,
                  String adresse,
                  int alder,
                  LocalDate fødselsdato,
                  int telefonnummer,
                  String email,
                  boolean aktivitetsform,
                  boolean medlemskabsType,
                  boolean medlemskabStatus) {

        this.fuldNavn = fuldNavn;
        this.adresse = adresse;
        this.alder = alder;
        this.fødselsdato = fødselsdato;
        this.telefonnummer = telefonnummer;
        this.email = email;
        this.aktivitetsform = aktivitetsform;
        this.medlemskabType = medlemskabsType;
        this.medlemskabStatus = medlemskabStatus;
    }

    public Medlem(String fuldNavn,
                  String adresse,
                  int alder,
                  String fødselsdato,
                  int telefonnummer,
                  String email,
                  boolean aktivitetsfor,
                  boolean medlemskabStatus,
                  boolean medlemskabType) {
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

    public boolean getAktivitetsform() {
        return aktivitetsform;
    }

    public boolean getMedlemskabStatus() {
        return medlemskabStatus;
    }

    public boolean getMedlemskabType() {
        return medlemskabType;
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

    public void setAktivitetsform(boolean aktivitetsform) {
        this.aktivitetsform = aktivitetsform;
    }

    public void setMedlemskabType (boolean medlemskabType) {
        this.medlemskabType = medlemskabType;
    }

    public void setMedlemskabStatus (boolean medlemskabStatus) {
        this.medlemskabStatus = medlemskabStatus;
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


