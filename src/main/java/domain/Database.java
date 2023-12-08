package domain;

import datasource.FileHandler;

import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class Database {
    private FileHandler fileHandler;
    private ArrayList<Medlem> medlemmer;
    private Medlem medlem;
    private ArrayList<Medlem> konkurrenceSvømmere;
    private ArrayList<Medlem> motionist;
    private ArrayList<Hold> holdListe;
    private ArrayList<Medlem> juniorHold;
    private ArrayList<Medlem> seniorHold;
    private ArrayList<Medlem> top5;
    private Hold hold;
    private Træner træner;
    private String[] listeAfKontingenter;
    private Resultat resultat;

    public Database() {
        this.holdListe = new ArrayList<>();
        this.fileHandler = new FileHandler();
        this.medlemmer = new ArrayList<>();
        this.medlem = new Medlem();
        this.konkurrenceSvømmere = new ArrayList<>();
        this.motionist = new ArrayList<>();
        this.juniorHold = new ArrayList<>();
        this.seniorHold = new ArrayList<>();
        this.top5 = new ArrayList<>();
        this.hold = new Hold();
        this.træner = new Træner("Mike");
        this.listeAfKontingenter = new String[4];
        this.resultat = new Resultat();

    }

// Formand___________________________________________________________

    public void redigerMedlem(String fuldNavn,
                              String adresse,
                              int alder,
                              int telefonnummer,
                              LocalDate fødselsdato,
                              String email,
                              String aktivitetsform,
                              boolean medlemStatus) {


        for (Medlem medlem : medlemmer) {
            if (medlem.getFuldNavn().equalsIgnoreCase(fuldNavn)) {
                medlem.setAdresse(adresse);
                medlem.setAlder(alder);
                medlem.setTelefonnummer(telefonnummer);
                medlem.setFødselsdato(fødselsdato);
                medlem.setEmail(email);
                medlem.setAktivitetsform(aktivitetsform);
                medlem.setMedlemskabStatus(medlemStatus);
            }
        }
    }


    public void fjernMedlemFraHold(String fuldNavn) {
        if (fuldNavn != null) {
            Medlem fundetMedlem = søgEfterMedlem(fuldNavn);
            if (fundetMedlem != null) {
                konkurrenceSvømmere.remove(fundetMedlem);
                motionist.remove(fundetMedlem);
                medlemmer.remove(fundetMedlem);
            } else {
                System.out.println("Medlemmet med navnet " + fuldNavn + " ikke fundet");
            }
        }
    }


    public void sletMedlem(String fuldNavn) {
        Medlem sletMedlem = null;
        for (Medlem medlem : medlemmer) {
            if (medlem.getFuldNavn().equalsIgnoreCase(fuldNavn)) {
                sletMedlem = medlem;
                break;
            }
        }
        if (sletMedlem != null) {
            medlemmer.remove(sletMedlem);
        }
    }



    /*public void sletMedlem(String fuldNavn,
                           String adresse,
                           int alder,
                           LocalDate fødselsdato,
                           int telefonnummer,
                           String email,
                           String aktivitetsform,
                           boolean medlemskabStatus) {
        Medlem sletterMedlem;
        for (Medlem medlem : medlemmer) {
            if (medlem.getFuldNavn().equalsIgnoreCase(fuldNavn)) {
                sletterMedlem = medlem;
                break;
            }
        }
        if (sletterMedlem == null) {
            medlemmer.remove(sletterMedlem);
        } else {
            System.out.println("Medlemmet med navnet " + fuldNavn + " ikke fundet");
        }
    }

     */





    // Hold ______________________________________________________________

    public void opretHold(String holdNavn) {
        Hold nythold = new Hold(holdNavn);
        holdListe.add(nythold);
    }


    public String tilføjMedlemTilJuniorEllerSenior(int alder) {
        Medlem medlem = new Medlem();
        medlemmer.add(medlem);
        if (alder < 18) {
            juniorHold.add(medlem);
        } else {
            seniorHold.add(medlem);
        }
        return "";

    }


   /* public void fjernMedlemFraHold(Medlem medlem) {
        medlemmer.remove(medlem);
        if (medlem instanceof KonkurrenceSvømmer) {
            konkurrenceSvømmere.remove(medlem);
            motionist.add(medlem);
        } else {
            motionist.remove(medlem);
            konkurrenceSvømmere.add(medlem);
        }
    }*/

    /* public void fjernMedlemFraHold(Medlem medlem) {
        medlemmer.remove(medlem);
    }

     */

    public ArrayList<Medlem> visKonkurrenceSvømmerPåHold() {
        System.out.println("Medlemmer på konkurrencesvømmere holdet: ");
        for (Medlem medlem : medlemmer) {
            if (medlem instanceof KonkurrenceSvømmer) {
                konkurrenceSvømmere.add(medlem);
            }
        }
        return konkurrenceSvømmere;
    }

    public ArrayList<Medlem> getMedlemmer() {
        return medlemmer;
    }


    public ArrayList<Medlem> getJuniorHold() {
        for (Medlem medlem : medlemmer) {
            if (medlem.getAlder() < 18) {
                juniorHold.add(medlem);
            }
        }
        return juniorHold;

    }

    public ArrayList<Medlem> getSeniorHold() {
        for (Medlem medlem : medlemmer) {
            if (medlem.getAlder() >= 18) {
                seniorHold.add(medlem);
            }
        }
        return medlemmer;
    }

    public ArrayList<Medlem> getTop5() {
        top5.addAll(medlemmer);
        return medlemmer;
    }

    public Medlem søgEfterMedlem(String fuldNavn) {
        for (Medlem medlem : medlemmer) {
            if (medlem.getFuldNavn().toLowerCase().contains(fuldNavn.toLowerCase())) {
                return medlem;
            }
        }
        return null;
    }

    /*public void fjernMedlemFraHold(String fuldNavn) {
        if (fuldNavn != null) {
            Medlem fundetMedlem = søgEfterMedlem(fuldNavn);
            fjernMedlemFraHold(fundetMedlem);
        } else {
            System.out.println("Medlemmet med navnet " + fuldNavn + " ikke fundet");
        }
    }*/


    public ArrayList<Medlem> getKonkurrenceSvømmer() {
        for (Medlem medlem : medlemmer) {
            if (medlem instanceof KonkurrenceSvømmer) {
                konkurrenceSvømmere.add(medlem);
            }
        }
        return konkurrenceSvømmere;
    }

    public String tilføjDisciplinerTilKonkurrencesvommer(String fuldNavn, Resultat[] discipliner) {
        Medlem medlem = søgEfterMedlem(fuldNavn);
        if (medlem instanceof KonkurrenceSvømmer) {
            KonkurrenceSvømmer konkurrenceSvømmer = (KonkurrenceSvømmer) medlem;
            ((KonkurrenceSvømmer) medlem).tilføjDiscipliner(discipliner);
            return "Tilføj disicipliner til konkurrencesvommer";
        } else {
            return "Der er ikke tilføjet discipliner til konkurrencesvommer";
        }
    }

    public String setDisciplinNavn(String disciplinNavn) {
        return resultat.setDisciplinNavn(disciplinNavn);
    }

    public String isButterFly() {
        KonkurrenceSvømmer konkurrenceSvømmer = new KonkurrenceSvømmer();
        return konkurrenceSvømmer.isButterFly();
    }

    public String isCrawl() {
        KonkurrenceSvømmer konkurrenceSvømmer = new KonkurrenceSvømmer();
        return konkurrenceSvømmer.isCrawl();
    }

    public String isBackCrawl() {
        KonkurrenceSvømmer konkurrenceSvømmer = new KonkurrenceSvømmer();
        return konkurrenceSvømmer.isBackCrawl();
    }
    public String isBrystSvomning() {
        KonkurrenceSvømmer konkurrenceSvømmer = new KonkurrenceSvømmer();
        return konkurrenceSvømmer.isBrystSvomning();
    }

    public ArrayList<Medlem> getTop5ForDiscipline(String disciplin) {
        ArrayList<Medlem> alleKonkurrenceSvommer = new ArrayList<>(konkurrenceSvømmere);
        Collections.sort(alleKonkurrenceSvommer, new TidsRegistrering(disciplin));

        return new ArrayList<>(alleKonkurrenceSvommer.subList(0, Math.min(5, alleKonkurrenceSvommer.size())));
    }

    // Få top 5 medlemmer for alle discipliner
    public ArrayList<Medlem> getTop5ForAlleDiscipliner() {
        ArrayList<Medlem> top5ForAlleDiscipliner = new ArrayList<>();

        // Loop genne, alle discipliner og tilføj top 5 for hver disciplin
        for (String disciplin : getAlleDiscipliner()) {
            top5ForAlleDiscipliner.addAll(getTop5ForDiscipline(disciplin));
        }
        return new ArrayList<>(top5ForAlleDiscipliner.subList(0, Math.min(5, top5ForAlleDiscipliner.size())));
    }

    public ArrayList<String> getAlleDiscipliner() {
        ArrayList<String> alleDiscipliner = new ArrayList<>();
        for (Medlem svommer : konkurrenceSvømmere) {
            if (svommer instanceof KonkurrenceSvømmer) {
                KonkurrenceSvømmer konkurrenceSvømmer = (KonkurrenceSvømmer) svommer;
                for (Resultat resultat : konkurrenceSvømmer.getDiscipliner()) {
                    if (resultat != null && !alleDiscipliner.contains(resultat.getDisciplineNavn())) {
                        alleDiscipliner.add(resultat.getDisciplineNavn());
                    }
                }
            }
        } return alleDiscipliner;
    }


    // Kassere __________________________________________________________







    // Medlem _________________________________________________________________________


    public void tilføjKonkurrencesvommer(String fuldNavn,
                             String adresse,
                             int alder,
                             LocalDate fødselsdato,
                             int telefonnummer,
                             String email,
                             String aktivitetsform,
                             int medlemskabType,
                             boolean medlemskabStatus) {
        Medlem konkurrencesvommerMedlem = new KonkurrenceSvømmer(fuldNavn, adresse, alder, fødselsdato, telefonnummer, email, aktivitetsform, medlemskabType, medlemskabStatus);
        medlemmer.add(konkurrencesvommerMedlem);
        konkurrenceSvømmere.add(konkurrencesvommerMedlem);
    }


    public void tilføjMotionist(String fuldNavn,
                             String adresse,
                             int alder,
                             LocalDate fødselsdato,
                             int telefonnummer,
                             String email,
                             String aktivitetsform,
                             int medlemskabType,
                             boolean medlemskabStatus) {
        Medlem motionistMedlem = new Motionist(fuldNavn, adresse, alder, fødselsdato, telefonnummer, email, aktivitetsform, medlemskabType, medlemskabStatus);
        medlemmer.add(motionistMedlem);
        motionist.add(motionistMedlem);
    }

    public ArrayList<Medlem> hentMedlemmer() {
        System.out.println("Medlemmer " + medlemmer.size());
        return medlemmer;
    }


    public void getMedlemskabType(int alder) {
        medlem.setMedlemskabType(alder);
    }


    /*public void sletMedlem(String fuldNavn) {

        Medlem sletterMedlem = null;
        for (Medlem medlem : medlemmer) {
            if (medlem.getFuldNavn().equalsIgnoreCase(fuldNavn)) {
                sletterMedlem = medlem;
                break;
            }
        }
        if (sletterMedlem != null) {
            medlemmer.remove(sletterMedlem);
        }

    }*/


   /* public void redigerMedlem(String fuldNavn,
                              String adresse,
                              int alder,
                              int telefonnummer,
                              LocalDate fødselsdato,
                              String email,
                              String aktivitetsform,
                              boolean medlemStatus) {
        for (Medlem medlem : medlemmer) {
            if (medlem.getFuldNavn().equalsIgnoreCase(fuldNavn)) {
                medlem.setAdresse(adresse);
                medlem.setAlder(alder);
                medlem.setTelefonnummer(telefonnummer);
                medlem.setFødselsdato(fødselsdato);
                medlem.setEmail(email);
                medlem.setAktivitetsform(aktivitetsform);
                medlem.setMedlemskabStatus(medlemStatus);
                return;
            }
        }

    }*/

    public String[] listeAfKontingenter() {
        return listeAfKontingenter;
    }






// FileHandler_____________________________________________
        public void loadList () {
            this.medlemmer = fileHandler.loadFromCsvFile();
        }

        public void gemMedlemmer () {
            fileHandler.saveMedlem(medlemmer);
        }

    public void saveDiscipliner(ArrayList<Medlem> konkurrenceSvømmere) {
        fileHandler.saveDiscipliner(konkurrenceSvømmere);
    }
}
