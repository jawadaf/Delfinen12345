import java.time.LocalDate;

public class Medlem {
    private String fuldNavn;
    private String adresse;
    private int alder;
    private LocalDate fødselsdato;
    private int telefonnummer;
    private String email;
    private String aktivitetsform;
    private int medlemskabType;
    private boolean medlemskabStatus;


    public Medlem(String fuldNavn,
                  String adresse,
                  int alder,
                  LocalDate fødselsdato,
                  int telefonnummer,
                  String email,
                  String aktivitetsform,
                  int medlemskabsType,
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
                  LocalDate fødselsdato,
                  int telefonnummer,
                  String email,
                  int medlemskabsType,
                  boolean medlemskabStatus) {

        this.fuldNavn = fuldNavn;
        this.adresse = adresse;
        this.alder = alder;
        this.fødselsdato = fødselsdato;
        this.telefonnummer = telefonnummer;
        this.email = email;
        this.medlemskabType = medlemskabsType;
        this.medlemskabStatus = medlemskabStatus;
    }



    public Medlem(){
    }

    public Medlem(String fuldNavn,
                  String adresse,
                  int alder,
                  LocalDate fødselsdato,
                  int telefonnummer,
                  String email,
                  String aktivitetsForm,
                  boolean medlemskabStatus) {
        this.fuldNavn = fuldNavn;
        this.adresse = adresse;
        this.alder = alder;
        this.fødselsdato = fødselsdato;
        this.telefonnummer = telefonnummer;
        this.email = email;
        this.aktivitetsform = aktivitetsForm;
        this.medlemskabStatus = medlemskabStatus;
    }

    public Medlem(String fuldNavn,
                  String adresse,
                  int alder,
                  LocalDate fødselsdato,
                  int telefonnummer,
                  String email,
                  boolean medlemskabStatus) {
        this.fuldNavn = fuldNavn;
        this.adresse = adresse;
        this.alder = alder;
        this.fødselsdato = fødselsdato;
        this.telefonnummer = telefonnummer;
        this.email = email;
        this.medlemskabStatus = medlemskabStatus;
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

    public String getAktivitetsform() {
        return aktivitetsform;
    }

    public boolean getMedlemskabStatus() {
        return medlemskabStatus;
    }

    public void setMedlemskabType(int alder) {
        if (alder<18) {
            System.out.println("Du er registreret som junior. ");
        } else {
            System.out.println("Du er registreret som senior. ");
        }
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

    public void setAktivitetsform(String aktivitetsform) {
        this.aktivitetsform = aktivitetsform;
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
                email + ", " +
                aktivitetsform + ", " +
                medlemskabStatus + ", " +
                medlemskabType;
    }
}


