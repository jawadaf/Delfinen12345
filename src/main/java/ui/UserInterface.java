package ui;

import domain.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.Random;

public class UserInterface {

    private Scanner sc;

    public RegisterController registerController;
    Random random = new Random();

    public UserInterface() {
        sc = new Scanner(System.in);
        registerController = new RegisterController();
        registerController.loadList();
    }

    public void startMenu() {
        System.out.println("""
                Tast 1 for formand.
                Tast 2 for træner.
                Tast 3 for kassere.
                Tast 4 for medlem.
                Tast 0 for exit.
                """);

    }

    public void startMenuKommando() {
        boolean isKør = true;
        while (isKør) {
            startMenu();
            int input = læsInt();
            switch (input) {
                case 1 -> formandMenu();
                case 2 -> trænerMenu();
                case 3 -> kassereMenu();
                case 4 -> medlemMenu();
                default -> isKør = false;
            }
        }
    }


    public void formandMenu() {
        System.out.println(""" 
                1. Opret et medlem.
                2. Gem registreret medlem.
                3. Redigere medlem
                4. Gem redigeret medlem.
                5. Slet medlem.
                6. Vis liste over medlemmer.
                7. Afslut programmet.
                """);

        int input = læsInt();
        switch (input) {
            case 1 -> tilføjNytMedlem();
            case 2 -> gemMedlem();
            case 3 -> redigerMedlem();
            case 4 -> gemRedigeretMedlem();
            case 5 -> sletMedlem();
            case 6 -> visMedlemsListe();
            case 10 -> registerController.exit();
            default -> System.out.println("Forkert input. Prøv igen.");
        }
    }

    public void trænerMenu() {
        System.out.println("""
                1. Tilføj medlem til desciplin.
                2. Gem medlem til hold.
                3. Fjern medlem fra hold.
                4. Vis medlemmer for valgte hold.                
                """);
        int input = læsInt();
        switch (input) {
            case 1 -> tilføjMedlemmerTilDiscipliner();
            case 2 -> gemMedlemTilHold();
            case 3 -> fjernMedlemFraHold();
            case 4 -> visMedlemmerForValgteHold();
            case 10 -> registerController.exit();
            default -> System.out.println("Forkert input. Prøv igen.");
        }
    }

    public void kassereMenu() {
        System.out.println("""
                1. Total kontingent for medlemmer baseret på deres alder og medlemskabsstatus.
                2. Oversigt over kontingentindbetalinger.
                3. Vis en liste over medlemmer i restance.
                """);
        int input = læsInt();
        switch (input) {
            case 1 -> totalKontingent();
            case 2 -> listeOverKontingenIndbetalinger();
            case 3 -> listeOverMedlemmerIRestance();
            case 10 -> registerController.exit();
            default -> System.out.println("Forkert input! Prøv igen.");
        }
    }

    public void medlemMenu() {
        System.out.println("""
                1. Rediger oplysninger for det valgte medlem.
                2. Gem redigeret medlem.
                3. Se liste over kontingenter.
                4. Se restance.
                """);
        int input = læsInt();
        switch (input) {
            case 1 -> redigerMedlemOplysninger();
            case 2 -> gemRedigeretOplysninger();
            case 3 -> seKontingenter();
            case 4 -> restanceOversigt();
        }
    }

    // Formand ____________________________________________________________________

    public void tilføjNytMedlem() {
        // opret dit medlem
        System.out.println("""
                Ved registrering af nyt medlem har jeg som formand bruge for følgende:
                1. Medlemmets fulde navn
                2. Medlemmets adresse (opdelt i by, vejnavn og vejnummer)
                3. Medlemmets alder
                4. Medlemmets fødselsdato
                5. Medlemmets telefonnummer
                6. Medlemmets e-mail
                7. Medlemmets Medlemskabstype
                8. Medlemmets Medlembskabstatus
                """);

        // Fulde navn
        String fuldNavn = indtastGyldigString("Indtast fulde navn på medlemmet: ");

        // Adressen (opdelt i by, vejnavn og vejnummer)
        String by = indtastGyldigString("Indtast by: ");
        String vejnavn = indtastGyldigString("Indtast vejnavn: ");
        int vejnummer = indtastGyldigInteger("Indtast vejnummer: ");

        // Saml adresse

        String adresse = by + " " + vejnavn + " " + vejnummer;

        // Alder
        int alder = indtastGyldigInteger("Indtast alder på medlemmet: ");
        int medlemskabType = 0;
        try {
            if (medlemskabType < 18) {
                registerController.tilføjMedlemTilJuniorEllerSenior(alder);
                medlemskabType = 1;
            } else {
                registerController.tilføjMedlemTilJuniorEllerSenior(alder);
                medlemskabType = 2;
            }
        } catch (InputMismatchException e) {
            System.out.println("Forkert input. Prøv igen.");
        }

        // Fødselsdato
        LocalDate fødselsdato = indtastGyldigDato("Indtast fødselsdato på medlemmet (åååå-mm-dd): ");

        // Telefonnummer
        int telefonnummer = indtastGyldigInteger("Indtast telefonnummer på medlemmet: ");

        // E-mail
        String email = indtastGyldigEmail("Indtast e-mail på medlemmet: ");


        // Medlemskabstatus
        boolean medlemskabStatus = true; // Start med at antage, at det er aktivt

        System.out.print("Er medlemmet aktivt? Indtast 'ja' eller 'nej': ");
        String svar = sc.nextLine().toLowerCase();

        if (svar.equals("nej")) {
            medlemskabStatus = false; // Hvis svaret er "nej", sæt til passivt
            System.out.println("Du er passivt medlem.");
        } else {
            System.out.println("Du er aktivt medlem.");
        }

        System.out.println("""
                1.Tilføj motionist
                2.Tilføj konkurrence svømmer
                0. kommer tilbage til at starte menuen.
                """);

        int input = læsInt();
        if (input == 1) {
            String aktivitetsform = null;
            aktivitetsform = "Motionist";
            registerController.tilføjMotionist(fuldNavn, adresse, alder, fødselsdato, telefonnummer, email, aktivitetsform, medlemskabType, medlemskabStatus);
            //registerController.tilføjMedlemTilJuniorEllerSenior(alder);
            System.out.println("Medlem tilføjet som motionist.");
        } else if (input == 2) {
            String aktivitetsform = null;
            aktivitetsform = "Konkurrencesvommer";
            registerController.tilføjKonkurrencesvommer(fuldNavn, adresse, alder, fødselsdato, telefonnummer, email, aktivitetsform, medlemskabType, medlemskabStatus);
            //registerController.tilføjMedlemTilJuniorEllerSenior(alder);
            System.out.println("Medlem tilføjet som konkurrence svømmer.");
        } else if (input == 0) {
            System.out.println("Medlemmet ikke tilføjet.");
        }

        System.out.println(fuldNavn + " er blevet registreret.");
    }

    private String indtastGyldigString(String prompt) {
        String input = "";
        boolean gyldigtInput = false;

        while (!gyldigtInput) {
            System.out.print(prompt);

            try {
                input = sc.nextLine();
                // Tjek om inputtet er en gyldig streng
                if (!input.matches("[a-zA-Z]+")) {
                    throw new NoSuchElementException();
                }
                gyldigtInput = true; // Hvis vi når hertil, er inputtet gyldigt
            } catch (NoSuchElementException e) {
                System.out.println("Forkert input. Prøv igen.");
            }
        }
        return input;
    }

    private int indtastGyldigInteger(String prompt) {
        int input = 0;
        boolean gyldigtInput = false;

        while (!gyldigtInput) {
            System.out.print(prompt);

            try {
                input = sc.nextInt();
                sc.nextLine(); // Forbrug resterende Enter
                gyldigtInput = true; // Hvis vi når hertil, er inputtet gyldigt
            } catch (InputMismatchException e) {
                System.out.println("Forkert input. Indtast venligst et heltal.");
                sc.nextLine(); // Ryd bufferen for at undgå uendelig løkke
            }
        }
        return input;
    }

    private LocalDate indtastGyldigDato(String prompt) {
        LocalDate dato = null;
        boolean gyldigtInput = false;

        while (!gyldigtInput) {
            System.out.print(prompt);

            try {
                String datoString = sc.nextLine();
                DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                dato = LocalDate.parse(datoString, dateFormat);
                gyldigtInput = true; // Hvis vi når hertil, er inputtet gyldigt
            } catch (DateTimeParseException | NoSuchElementException e) {
                System.out.println("Forkert datoformat. Indtast dato på formatet åååå-mm-dd.");
            }
        }
        return dato;
    }

    private String indtastGyldigEmail(String prompt) {
        String email = "";
        boolean gyldigtInput = false;

        while (!gyldigtInput) {
            System.out.print(prompt);

            try {
                email = sc.nextLine();
                // Tjek om inputtet er en gyldig e-mailadresse
                if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
                    throw new NoSuchElementException();
                }
                gyldigtInput = true; // Hvis vi når hertil, er inputtet gyldigt
            } catch (NoSuchElementException e) {
                System.out.println("Forkert input. Prøv igen.");
            }
        }
        return email;
    }


    public void gemMedlem() {
        System.out.println("Registreret medlem er blevet gemt.");
        registerController.gemMedlemer();
    }


    public void redigerMedlem() {
        System.out.println("Indtast det fulde navn på medlemmet, som du gerne vil redigere: ");
        String redigerMedlem = null;
        try {
            redigerMedlem = læsString();
        } catch (NoSuchElementException e) {
            System.out.println("Forkert input! Prøv igen.");
            return;
        }


        Medlem eksisterendeMedlem = registerController.findMedlem(redigerMedlem);

        if (eksisterendeMedlem == null) {
            System.out.println("Medlemmet blev ikke fundet. Prøv igen.");
            return;
        }

        System.out.println("Eksisterende oplysninger for medlemmet:");
        System.out.println(eksisterendeMedlem);

        // Opdater medlemsoplysninger
        System.out.println("Indtast nye oplysninger for medlemmet:");

        // Nyt fuld navn
        System.out.print("Rediger navnet på medlemmet (" + eksisterendeMedlem.getFuldNavn() + "): ");
        String nytFuldNavn = null;
        try {
            nytFuldNavn = læsString();
        } catch (NoSuchElementException e) {
            System.out.println("Forkert input! Navnet forbliver uændret.");
        }

        // Ny adresse
        System.out.print("Rediger adresse på medlemmet (" + eksisterendeMedlem.getAdresse() + "): ");
        String nyAdresse = null;
        try {
            nyAdresse = læsString();
        } catch (NoSuchElementException e) {
            System.out.println("Forkert input! Adressen forbliver uændret.");
        }

        // Ny alder
        System.out.print("Rediger alder på medlemmet (" + eksisterendeMedlem.getAlder() + "): ");
        int nyAlder = 0;
        try {
            nyAlder = læsInt();
        } catch (InputMismatchException e) {
            System.out.println("Forkert input! Alderen forbliver uændret.");
        }

        // Ny fødselsdato
        System.out.print("Rediger fødselsdato på medlemmet (åååå-mm-dd): ");
        LocalDate nyFødselsdato = null;
        try {
            String fødselsdagsdato = læsString();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            nyFødselsdato = LocalDate.parse(fødselsdagsdato, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Forkert datoformat. Brug formatet åååå-mm-dd. Prøv igen.");
            sc.nextLine();
        }

        // Nyt telefonnummer
        System.out.print("Rediger telefonnummeret på medlemmet (" + eksisterendeMedlem.getTelefonnummer() + "): ");
        int nytTelefonnummer = 0;
        try {
            nytTelefonnummer = læsInt();
        } catch (InputMismatchException e) {
            System.out.println("Forkert input! Telefonnummeret forbliver uændret.");
        }

        // Ny email
        System.out.print("Rediger email på medlemmet (" + eksisterendeMedlem.getEmail() + "): ");
        String nyEmail = null;
        try {
            nyEmail = læsString();
        } catch (NoSuchElementException e) {
            System.out.println("Forkert input! Email forbliver uændret.");
        }

        // Ny aktivitetsform
        System.out.print("Rediger aktivitetsform på medlemmet (" + eksisterendeMedlem.getAktivitetsform() + "): ");
        String nyAktivitetsform = null;
        try {
            nyAktivitetsform = læsString();
        } catch (NoSuchElementException e) {
            System.out.println("Forkert input! Aktivitetsformen forbliver uændret.");
        }

        // Ny medlemskabsstatus
        System.out.print("Rediger medlemsstatus på medlemmet (tast 'true' for aktiv, tast 'false' for passiv, nuværende: " + eksisterendeMedlem.getMedlemskabsstatus() + "): ");
        boolean nyMedlemsstatus = true;
        try {
            nyMedlemsstatus = sc.nextBoolean();
        } catch (InputMismatchException e) {
            System.out.println("Forkert input! Medlemsstatus forbliver uændret.");
            sc.nextLine();  // Ryd buffer
        }

        // Kald RegisterController for at foretage redigering
        registerController.redigerMedlem(
                registerController.redigerMedlem(
                        eksisterendeMedlem.getFuldNavn(),
                        eksisterendeMedlem.getAdresse(),
                        eksisterendeMedlem.getAlder(),
                        eksisterendeMedlem.getTelefonnummer(),
                        eksisterendeMedlem.getFødselsdato(),
                        eksisterendeMedlem.getEmail(),
                        eksisterendeMedlem.getAktivitetsform(),
                        eksisterendeMedlem.getMedlemskabsstatus()
                );

    }

    public void gemRedigeretMedlem() {
        System.out.println("De redigeret oplysninger er blevet gemt");


    }


   public void sletMedlem() {
       System.out.println("Skriv navnet på medlemmet der skal fjernes fra listen.");
       String sletMedlem = null;
       String fuldNavn = null;
       try {
           sletMedlem = læsString();
       } catch (NoSuchElementException e) {
           System.out.println("Forkert input! Prøv igen.");
       }
       registerController.sletterMedlem(fuldNavn);
       System.out.println("Medlemmet er blevet fjernet.");
   }

       /*System.out.println("Skriv navnet på medlemmet der skal slettes: ");
       String sletterMedlem = null;

       try {
           sletterMedlem = læsString();
           registerController.sletterMedlem();
           registerController.equals(sletterMedlem);
           System.out.println("Medlem er blevet slettet.");
       } catch (NoSuchElementException e) {
           System.out.println("Forkert input! Prøve igen.");
       }

        */



    public void visMedlemsListe() {
        ArrayList<Medlem> medlemListe = registerController.hentetMedlemmer();
        System.out.println("Liste over medlemmer: ");
        for (Medlem medlem : medlemListe) {
            System.out.println("Medlemmets navn: " + medlem.getFuldNavn());
            System.out.println();
            System.out.println("Medlemmets adresse: " + medlem.getAdresse());
            System.out.println();
            System.out.println("Medlemmets alder: " + medlem.getAlder());
            System.out.println();
            System.out.println("Medlemmets telefonnummer: " + medlem.getTelefonnummer());
            System.out.println();
            System.out.println("Medlemmets fødselsdato: " + medlem.getFødselsdato());
            System.out.println();
            System.out.println("Medlemmets e-mail: " + medlem.getEmail());
            System.out.println();
        }
    }


    // Træner___________________________________________________________________

   /* public void tilføjMedlemTilHold() {
        System.out.println("Indtast medlemmests fulde navn for at tilføje ind i et hold");
        //String fuldNavn;
        //String holdNavn;
        Medlem medlem = null;
        try {
           // fuldNavn = læsString();
            //holdNavn = læsString();
           // medlem.setAlder(alder);
           // registerController.tilføjMedlemTilJuniorEllerSenior(medlem);
        } catch (NoSuchElementException e) {
            System.out.println("Forkert input! Prøv igen.");
        }
    }

    */

    public void gemMedlemTilHold() {
        System.out.println("Indtast fulde navn for at få medlemmet gemt.");
        String fuldNavn = null;
        try {
            fuldNavn = læsString();
        } catch (NoSuchElementException e) {
            System.out.println("Forkert input! Prøv igen.");
        }
    }

    public void fjernMedlemFraHold() {
        System.out.println("Indtast fulde navn for at få medlemmet fjernet fra hold.");
        String fuldNavn = null;
        try {
            fuldNavn = læsString();
            registerController.fjernMedlemFraHold(fuldNavn);
        } catch (NoSuchElementException e) {
            System.out.println("Forkert input! Prøv igen.");
        }
    }

    public void visMedlemmerForValgteHold() {
        System.out.println("Vælg en holdtype:");
        System.out.println("1. Junior Hold");
        System.out.println("2. Senior Hold");
        System.out.println("3. Konkurrencesvømmere");
        System.out.println("4. Top 5 hver for disciplin");

        int holdTypeValg = læsInt();
        ArrayList<Medlem> valgteHold;

        if (holdTypeValg == 1) {
            valgteHold = registerController.getJuniorHold();
            System.out.println(valgteHold);
        } else if (holdTypeValg == 2) {
            valgteHold = registerController.getSeniorHold();
            System.out.println(valgteHold);
        } else if (holdTypeValg == 3) {
            valgteHold = registerController.getKonkurrenceSvømmere();
            System.out.println(valgteHold);
        } else if (holdTypeValg == 4) {
            valgteHold = registerController.getTop5();
            System.out.println(valgteHold);
        } else {
            System.out.println("Ugyldigt valg. Prøv igen");
        }

        //visHoldOgMedlemmer(valgteHold);
    }

    public void valgteHold() {
        System.out.println("""
                1. Vis juniorhold.
                2. Vis SeniorHold
                3. Konkurrencesvømmer
                4. Top 5 for hver disciplin
                """);
        int input = læsInt();
        switch (input) {
            case 1 -> visJuniorHold();
            case 2 -> visSeniorHold();
            case 3 -> koncurrenceSvømmer();
            case 4 -> top5ForHverDisciplin();
            case 10 -> registerController.exit();
            default -> System.out.println("Forkert input. Prøv igen.");
        }

    }

    public void visJuniorHold() {
        int input = læsInt();
        if (input == 1) {
            ArrayList<Hold> juniorHold = new ArrayList<>();
            System.out.println("Junior hold");

            for (Hold hold : juniorHold) {
                System.out.println(hold.getHoldNavn());
            }
        }
    }

    public void visSeniorHold() {
        int input = læsInt();
        if (input == 2) {
            ArrayList<Hold> seniorHold = new ArrayList<>();
            System.out.println("Senior Hold");

            for (Hold hold : seniorHold) {
                System.out.println(hold.getHoldNavn());
            }
        }
    }

    public void koncurrenceSvømmer() {
        int input = læsInt();
        if (input == 3) {

            ArrayList<Hold> konkurrenceSvømmer = new ArrayList<>();
            System.out.println("Koncurrence Svømmer");

            for (Hold hold : konkurrenceSvømmer) {
                System.out.println(hold.getHoldNavn());
            }
        }
    }

    public void top5ForHverDisciplin() {
        int input = læsInt();
        if (input == 4) {
            ArrayList<Hold> top5ForHverDisplin = new ArrayList<>();
            System.out.println("Top 5 for hver disciplin");

            for (Hold hold : top5ForHverDisplin) {
                System.out.println(hold.getHoldNavn());
            }
        }
    }


    /*public void visHoldOgMedlemmer(ArrayList<Hold> holdListe) {
        // du har nu valgt en liste, nu skal du printe den ud
        //for hvert medlem på listen skal du printe det ud med medlem navn osv.,
        for (int i = 0; i < holdListe.size(); i++) {
            System.out.println((i + 1) + ". " + holdListe.get(i).getHoldNavn());
        }
        System.out.println("Vælg et hold:");
        int holdValg = læsInt();

        if (holdValg > 0 && holdValg <= holdListe.size()) {
            Hold valgtHold = holdListe.get(holdValg - 1);
            ArrayList<Medlem> holdMedlemmer = valgtHold.getMedlemmer();

            if (holdMedlemmer.isEmpty()) {
                System.out.println("Der er ingen medlemmer på dette hold.");
            } else {
                System.out.println("Medlemmer på holdet '" + valgtHold.getHoldNavn() + "':");
                for (Medlem medlem : holdMedlemmer) {
                    System.out.println("Navn: " + medlem.getFuldNavn() + ", Alder: " + medlem.getAlder());
                }
            }
        } else {
            System.out.println("Ugyldigt holdvalg. Prøv igen.");
        }
    }

     */

    /*public void visMedlemmerForValgteHold() {
        Medlem medlem = new Medlem();
        ArrayList<Hold> juniorHold = registerController.getJuniorHold();
        System.out.println("Liste over medlemmer i junior hold: ");
        for (Hold hold : juniorHold) {
            System.out.println("Hold: " + hold.getHoldNavn());
            for (Medlem junior : hold.getMedlemmer()) {
                System.out.println("Medlemmets navn: " + junior.getFuldNavn() + ", alder: " + junior.getAlder());
            }
        }
        ArrayList<Hold> seniorHold = registerController.getSeniorHold();
        System.out.println("Liste over medlemmer i senior hold: ");
        for (Hold hold : seniorHold) {
            System.out.println("Hold: " + hold.getHoldNavn());
            for (Medlem senior : hold.getMedlemmer()) {
                System.out.println("Medlemmets navn: " + senior.getFuldNavn() + ", alder: " + senior.getAlder());
            }
        }
    }

     */

    private void tilføjMedlemmerTilDiscipliner() {
        ArrayList<Medlem> konkurrenceSvømmere = new ArrayList<>();
        System.out.println("Antal konkurrencesvømmere " + konkurrenceSvømmere.size());
        for (int i = 0; i < konkurrenceSvømmere.size(); i++) {
            System.out.println((i + 1 + "." + konkurrenceSvømmere.get(i).getFuldNavn()));
        }
        System.out.println("Vælg svømmer ved at taste et nummer: ");
        int userChoice = læsInt();
        if (userChoice >= 1 && userChoice <= konkurrenceSvømmere.size()) {
            Medlem svommerValg = konkurrenceSvømmere.get(userChoice - 1);

            System.out.println("Discipline: ");
            int userInput = læsInt();
            String discipline = "";

            System.out.println("""
                    1. Butterfly
                    2. Backcrawl
                    3. Crawl
                    4. Brystsvømning
                    """);

            while (discipline.isBlank()) {
                switch (userInput) {
                    case 1 -> discipline = "Butterfly";
                    case 2 -> discipline = "Backcrawl";
                    case 3 -> discipline = "Crawl";
                    case 4 -> discipline = "Brystsvomning";
                    default -> System.out.println("Forkert input! Prøv igen.");
                }
            }
            if (discipline.equalsIgnoreCase("butterfly")) {
                registerController.isButterFly();
                System.out.println("Medlem tilføjet til desciplin butterfly.");
                discipline = registerController.setDisciplinNavn(discipline);
            } else if (discipline.equalsIgnoreCase("backcrawl")) {
                registerController.isBackCrawl();
                System.out.println("Medlem tilføjet til desciplin backcrawl.");
            } else if (discipline.equalsIgnoreCase("crawl")) {
                registerController.isCrawl();
                System.out.println("Medlem tilføjet til desciplin crawl.");
            } else if (discipline.equalsIgnoreCase("brystsvomning")) {
                registerController.isBrystSvomning();
                System.out.println("Medlem tilføjet til desciplin brystsvomning.");
            } else {
                System.out.println("Medlemmet ikke tilføjet til nogen af discipliner.");
            }
            try {
                System.out.println("Svømmetid: ");
                double tid = sc.nextDouble();

                System.out.println("Indtast placering: ");
                String placering = læsString();

                System.out.println("Dato (åååå-mm-dd): \n");
                LocalDate dato = LocalDate.parse(sc.next());

                //svommerValg(new Resultat(discipline, tid, placering, dato));

                Resultat nyDesciplin = new Resultat(discipline, tid, placering, dato);
                Resultat[] nyeDiscipliner = {nyDesciplin};

                String resultatBesked = registerController.tilføjDisciplinerTilKonkurrencesvommer(svommerValg.getFuldNavn(), nyeDiscipliner);
                System.out.println(resultatBesked);

                registerController.saveDiscipliner(registerController.getKonkurrenceSvømmere());

            } catch (InputMismatchException i) {
                System.out.println("Forkert input! Det skal være en int.");
                sc.nextLine();
            } catch (DateTimeParseException d) {
                System.out.println("Forkert input! Prøv igen.");
                sc.nextLine();
            }
        }
    }


    /*public LocalDate tilføjDato() {
        LocalDate datoParsed = null;
        while (datoParsed == null) {
            String dato = læsString();
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-mm-YYYY");
            try {
                datoParsed = LocalDate.parse(dato, format);
            } catch (DateTimeParseException e) {
                System.out.println("Forkert input! Prøv igen.");
            }
        }
        return datoParsed;
    }

     */


    // Kassere __________________________________________________________


    public void totalKontingent() {
        ArrayList<Medlem> medlemmer = registerController.hentetMedlemmer();
        int totalKontingent = registerController.totalKontigent();
        /*for (Medlem medlem : medlemmer) {
            if (!medlem.getMedlemskabStatus()) {
                totalKontingent += 500;
            } else {
                if (medlem.getAlder() < 18) {
                    totalKontingent += 1000;
                }
                if (medlem.getAlder() >= 18) {
                    totalKontingent += 1600;
                }
                if (medlem.getAlder() >= 60) {
                    totalKontingent += 1200;
                }
            }
        }*/
        System.out.println("Total indtægt = " + totalKontingent + " kr.");
    }

    public void listeOverKontingenIndbetalinger() {
        ArrayList<Medlem> medlemmer = registerController.hentetMedlemmer();
        for (Medlem medlem : medlemmer) {
            int totalKontingent = 0;
            if (!medlem.getMedlemskabStatus()) {
                totalKontingent = 500;
                System.out.println("Som passiv medlem skal du betale: " + medlem.getFuldNavn() + " " + totalKontingent + " kr.");
            } else {
                if (medlem.getAlder() < 18) {
                    totalKontingent = 1000;
                    System.out.println("Som aktiv medlem under 18 år skal du betale: " + medlem.getFuldNavn() + " " + totalKontingent + " kr.");
                }
                if (medlem.getAlder() >= 18 && medlem.getAlder() < 60) {
                    totalKontingent = 1600;
                    System.out.println("Som aktiv medlem over 18 år. skal du betale: " + medlem.getFuldNavn() + " " + totalKontingent + " kr.");
                }
                if (medlem.getAlder() >= 60) {
                    totalKontingent = 1200;
                    System.out.println("Som pensionist medlem skal du betale: " + medlem.getFuldNavn() + " " + totalKontingent + " kr.");
                }
            }
        }
    }



        public void listeOverMedlemmerIRestance () {
            ArrayList<Medlem> medlemmer = registerController.hentetMedlemmer();
            int totalKontingent = 0;
            Random random = new Random();
            int tilfældigIndex = random.nextInt(medlemmer.size());
            Medlem tilfældigtMedlem = medlemmer.get(tilfældigIndex);
            if (!tilfældigtMedlem.getMedlemskabStatus()) {
                totalKontingent += 500;
                System.out.println("Tilfældigt medlem i restance " + tilfældigtMedlem.getFuldNavn() + " - Kontingenten er ikke betalt.");
            }

           /* for (Medlem medlem : medlemmer) {

                if (medlem.getMedlemskabStatus() == false) {
                    if (medlem.getFuldNavn().equals(totalKontingent)) {
                        totalKontingent += 500;
                        System.out.println("Medlemmet " + medlem.getFuldNavn() + "har betalt så meget: " + totalKontingent + "kr.");
                    } else {
                        totalKontingent -= 500;
                        System.out.println("Medlemmet " + medlem.getFuldNavn() + " har ikke betalt");
                    }
                }
                if (medlem.getMedlemskabStatus() == true) {
                    if (medlem.getAlder() < 18) {
                        if (medlem.getFuldNavn().equals(totalKontingent)) {
                            totalKontingent += 1000;
                            System.out.println("Medlemmet " + medlem.getFuldNavn() + "har betalt så meget: " + totalKontingent + "kr.");
                        } else {
                            totalKontingent -= 1000;
                            System.out.println("Medlemmet " + medlem.getFuldNavn() + " har ikke betalt");
                        }
                    }
                }
                if (medlem.getMedlemskabStatus() == true) {
                    if (medlem.getAlder() >= 18) {
                        if (medlem.getFuldNavn().equals(totalKontingent)) {
                            totalKontingent += 1600;
                            System.out.println("Medlemmet " + medlem.getFuldNavn() + "har betalt så meget: " + totalKontingent + "kr.");
                        } else {
                            totalKontingent -= 1600;
                            System.out.println("Medlemmet " + medlem.getFuldNavn() + " har ikke betalt");
                        }
                    }
                }
                if (medlem.getMedlemskabStatus() == true) {
                    if (medlem.getAlder() >= 59) {
                        if (medlem.getFuldNavn().equals(totalKontingent)) {
                            totalKontingent += 1200;
                            System.out.println("Medlemmet " + medlem.getFuldNavn() + "har betalt så meget: " + totalKontingent + "kr.");
                        } else {
                            totalKontingent -= 1200;
                            System.out.println("Medlemmet " + medlem.getFuldNavn() + " har ikke betalt");
                        }
                    }
                }

            }

                    if (medlem.getAlder() < 18) {
                        totalKontingent = 1000;
                        if(totalKontingent == 1000) {
                            System.out.println("Kontingenten er betalt");
                        } else {
                            System.out.println("Kontingenten er ikke betalt");
                        }
                    }
                    if (medlem.getAlder() >= 18) {
                        totalKontingent = 1600;
                        if(totalKontingent == 1200) {
                            System.out.println("Kontingenten er betalt");
                        } else {
                            System.out.println("Kontingenten er ikke betalt");
                        }
                    }
                    if (medlem.getAlder() >= 60) {
                        totalKontingent = 1200;
                        if(totalKontingent == 1200) {
                            System.out.println("Kontingenten er betalt");
                        } else {
                            System.out.println("Kontingenten er ikke betalt");
                        }
                    }

             */
                }


        // Medlem____________________________________________________________________


        public void redigerMedlemOplysninger () {
            System.out.println("Indtast det fulde navn på medlemmet, som du gerne vil redigere: ");
            String redigerMedlem = null;
            try {
                redigerMedlem = læsString();
            } catch (NoSuchElementException e) {
                System.out.println("Forkert input! Prøv igen.");
            }

            System.out.print("Rediger navnet på medlemmet: ");
            String nytFuldNavn = null;
            try {
                nytFuldNavn = læsString();
            } catch (NoSuchElementException e) {
                System.out.println("Forkert input! Prøv igen.");
            }

            System.out.print("Rediger adresse på medlemmet: ");
            String nyAdresse = null;
            try {
                nyAdresse = læsString();
            } catch (NoSuchElementException e) {
                System.out.println("Forkert input! Prøv igen.");
            }

            System.out.print("Rediger alder på medlemmet: ");
            int nyAlder = 0;
            try {
                nyAlder = læsInt();
            } catch (InputMismatchException e) {
                System.out.println("Forkert input! Prøv igen.");
            }

            System.out.print("Rediger fødselsdato på medlemmet: ");
            String nyFødselsdato = null;
            try {
                nyFødselsdato = læsString();
            } catch (NoSuchElementException e) {
                System.out.println("Forkert input! Prøv igen.");
            }

            System.out.print("Rediger telefonnummeret på medlemmet");
            int nytTelefonnummer = 0;
            try {
                nytTelefonnummer = læsInt();
            } catch (InputMismatchException e) {
                System.out.println("Forkert input! Prøv igen.");
            }
            System.out.print("Rediger email på medlemmet: ");
            String nyEmail = null;
            try {
                nyEmail = læsString();
            } catch (NoSuchElementException e) {
                System.out.println("Forkert input! Prøv igen.");
            }

            System.out.print("Rediger aktivitetsform på medlemmet:");
            boolean nyAktivitetsform = true;
            try {
                nyAktivitetsform = sc.nextBoolean();
            } catch (NoSuchElementException e) {
                System.out.println("Forkert input! Prøv igen.");
            }

            System.out.print("Rediger medlemstype på medlemmet: ");
            boolean nyMedlemsType = true;
            try {
                nyMedlemsType = sc.nextBoolean();
            } catch (NoSuchElementException e) {
                System.out.println("Forkert input! Prøv igen.");
            }

            System.out.print("Rediger medlemsstatus på medlemmet:");
            boolean nyMedlemsstatus = true;
            try {
                nyMedlemsstatus = sc.nextBoolean();
            } catch (NoSuchElementException e) {
                System.out.println("Forkert input! Prøv igen.");
            }
        }


        public void gemRedigeretOplysninger () {
            System.out.println("Oplysningerne er blevet redigeret.");
            registerController.gemMedlemer();
        }


        public void seKontingenter () {
            String[] kontingentOversigt = registerController.listeAfKontingenter();
            kontingentOversigt[0] = "Som aktiv medlem under 18 år skal du betale 1000 kr. årligt.";
            kontingentOversigt[1] = "Som aktiv medlem over 18 år skal du betale 1600 kr. årligt.";
            kontingentOversigt[2] = "Som aktiv pensionist over 59 år får du 25% rabat og skal betale 1200 kr. årligt.";
            kontingentOversigt[3] = "Som passivt medlem skal du betale 500 kr. årligt.";
            System.out.println("Liste over kontingenter: ");
            for (String kontingent : kontingentOversigt) {
                System.out.println(kontingent);
            }
        }


        public void restanceOversigt () {

        }


        public String læsString () {
            while (!sc.hasNextLine()) {
                System.out.println("Det er ikke en string");
                sc.next();
            }
            String s = sc.nextLine();
            //sc.nextLine();
            return s;
        }

        public int læsInt () {
            while (!sc.hasNextInt()) {
                System.out.println("Det er ikke en int");
                sc.next();
            }
            int i = sc.nextInt();
            sc.nextLine();
            return i;
        }

    }





