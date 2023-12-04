package ui;

import domain.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class UserInterface {

    private Scanner sc;

    public RegisterController registerController;

    public UserInterface() {
        sc = new Scanner(System.in);
        registerController = new RegisterController();
    }

    public void startMenu() {
        System.out.println("""
                Tast 1 for formand.
                Tast 2 for træner.
                Tast 3 for kassere.
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
                default -> isKør = false;
            }
        }
    }


    public void formandMenu() {
        System.out.println(""" 
                1. Opret et medlem.
                2. Gem registreret medlem.
                3. Vis liste over medlemmer.
                4. Slet medlem.
                5. Rediger medlems oplysninger
                6. Aflsut programmet.
                """);

        int input = læsInt();
        switch (input) {
            case 1 -> tilføjNytMedlem();
            case 2 -> gemMedlem();
            case 3 -> visMedlemsListe();
            case 4 -> sletMedlem();
            case 5 -> redigerMedlem();
            case 10 -> registerController.exit();
            default -> System.out.println("Forkert input. Prøv igen.");
        }
    }

    public void trænerMenu() {
        System.out.println("""
                1. Tilføj medlem til hold.
                2. Gem medlem til hold.
                3. Fjern medlem fra hold.
                4. Vis medlemmer for valgte hold.
                5. Vis discipliner.                
                """);
        int input = læsInt();
        switch (input) {
            case 1 -> tilføjMedlemTilHold();
            case 2 -> gemMedlemTilHold();
            case 3 -> fjernMedlemFraHold();
            case 4 -> visMedlemmerForValgteHold();
            case 5 -> tilføjDiscipliner();
            case 10 -> registerController.exit();
            default -> System.out.println("Forkert input. Prøv igen.");
        }
    }

    public void kassereMenu() {
        System.out.println("""
                1. Kontingent for et medlem baseret på dets alder og aktivitetsform.
                2. Oversigt over kontingentindbetalinger.
                3. Vis en liste over medlemmer i restance.
                """);
        int input = læsInt();
        switch (input) {
            case 1 -> kontingent();
            case 2 -> kontingenindbetalinger();
            case 3 -> listeOverMedlemmerIRestance();
            case 10 -> registerController.exit();
            default -> System.out.println("Forkert input! Prøv igen.");
        }
    }



    // Medlem____________________________________________________________________

        public void medlemMenu() {
            System.out.println("Indtast det fulde navn på medlemmet");
                    String medlemMenu = null;
            try {
                medlemMenu = læsString();
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

            System.out.print("Rediger fødselsdato på medlemmet?: ");
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

            System.out.print("Rediger aktivitetsform på medlemmet:" );
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



    // Formand ____________________________________________________________________

    public void tilføjNytMedlem() {
        //opret dit medlem
        System.out.println("""
                Ved registrering af nyt medlem har jeg som formand bruge for følgende:
                1. Medlemmets fulde navn
                2. Medlemmets adresse
                3. Medlemmets alder
                4. Medlemmets fødselsdato
                5. Medlemmets telefonnumer
                6. Medlemmets e-mail
                7. Medlemmets Medlemskabstype
                8. Medlemmets Medlembskabstatus
                """);
        // Fulde navn

        System.out.print("Indtast fulde navn på medlemmet: ");
        String fuldNavn = "";
            try {
                fuldNavn = læsString();
            } catch (NoSuchElementException e) {
                System.out.println("Forkert input. Prøv igen.");
            }


        // Adresse

        System.out.print("Indtast adresse på medlemmet: ");
        String adresse = null;
        try {
            adresse = læsString();
        } catch (NoSuchElementException e) {
            System.out.println("Forkert input. Prøv igen.");
        }

        // Alder

        System.out.print("Indtast alder på medlemmet: ");
        int alder = 0;
        int medlemskabType = 0;
        try {
            alder = læsInt();
            medlemskabType = alder;
        } catch (InputMismatchException e) {
            System.out.println("Forkert input. Prøv igen.");
        }

        // Fødselsdato

        System.out.print("Indtast fødselsdato på medlemmet (åååå-mm-dd): ");
        LocalDate localDate = null;
        LocalDate fødselsdato = localDate;
        try {
            String fødselsdagsdato = læsString();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            fødselsdato = LocalDate.parse(fødselsdagsdato, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Forkert datoformat. Brug formatet åååå-mm-dd. Prøv igen.");
            sc.nextLine();
        }

        // Telefonnummer

        System.out.print("Indtast telefonnummeret på medlemmet: ");
        int telefonnummer = 0;
        try {
            // int telefonnummer = 0;
            telefonnummer = læsInt();
        } catch (InputMismatchException e) {
            System.out.println("Forkert input. Prøv igen.");
        }

        // Email

        System.out.print("Indtast email på medlemmet: ");
        String email = null;
        try {
            // String email = null;
            email = læsString();
        } catch (NoSuchElementException e) {
            System.out.println("Forkert input. Prøv igen.");
        }

        String aktivitetsform = null;

        System.out.println("Indtast medlemmets medlemskabstatus; true = aktivt eller false = passivt  ");
        boolean aktivt;
        boolean passiv;
        boolean medlemskabStatus = false;

        try {
            aktivt = sc.nextBoolean();

            medlemskabStatus = aktivt;
        } catch (NoSuchElementException e) {
            System.out.println("Forkert input. Prøv igen.");
        }
        if (medlemskabStatus == false) {
            System.out.println("Du er passiv medlem.");
        } else {
            System.out.println("Du er aktiv medlem.");
        }

        tilføjNyMedlem(
                fuldNavn,
                adresse,
                alder,
                fødselsdato,
                telefonnummer,
                email,
                aktivitetsform,
                medlemskabType,
                medlemskabStatus);
        System.out.println(fuldNavn + " er blevet registreret.");
    }

    public void tilføjNyMedlem(String fuldNavn,
                               String adresse,
                               int alder,
                               LocalDate fødselsdato,
                               int telefonnummer,
                               String email,
                               String aktivitetsform,
                               int medlemslabsType,
                               boolean medlemskabStatus) {
        System.out.println("""
                1.Tilføj motionist
                2.Tilføj konkurrence svømmer
                0. kommer tilbage til at starte menuen.
                """);
        int input = læsInt();
        if (input == 1) {
            Medlem medlem = registerController.tilføjelseAfMedlem(new Motionist(fuldNavn, adresse, alder, fødselsdato, telefonnummer, email, aktivitetsform, medlemslabsType, medlemskabStatus));
            registerController.tilføjMedlemTilHold(medlem);
            System.out.println("Medlem tilføjet som motionist.");
        } else if (input == 2) {
            System.out.print("Indtast Aktivitetsform på medlemmet: ");
            aktivitetsform = læsString();
            Medlem medlem = registerController.tilføjelseAfMedlem(new KonkurrenceSvømmer(fuldNavn, adresse, alder, fødselsdato, telefonnummer, email, aktivitetsform, medlemslabsType, medlemskabStatus));
            registerController.tilføjMedlemTilHold(medlem);
            System.out.println("Medlem tilføjet som konkurrence svømmer.");
        } else if (input == 0) {
            System.out.println("Medlemmet ikke tilføjet.");
        }
    }

    public void gemMedlem() {
        System.out.println("Registreret medlem er blevet gemt.");
        registerController.gemMedlemer();
    }

    public void visMedlemsListe() {
        ArrayList<Medlem> medlemListe = registerController.hentetMedlem();
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

    public void sletMedlem() {
        System.out.println("Skriv navnet på medlemmet der skal slettes.");
        String sletterMedlem = null;
        String fuldNavn = null;
        try {
            sletterMedlem = læsString();
            registerController.sletterMedlem(fuldNavn);
            registerController.equals(sletterMedlem);
            System.out.println("Medlem er blevet slettet.");
        } catch (NoSuchElementException e) {
            System.out.println("Forkert input! Prøve igen.");
        }
    }


    public void redigerMedlem() {
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

        System.out.print("Rediger fødselsdato på medlemmet?: ");
        String nyFødselsdato = null;
        try {
            nyFødselsdato = læsString();
        } catch (NoSuchElementException e) {
            System.out.println("Forkert input! Prøv igen.");
        }

        System.out.print("Rediger telefonnummeret på medlemmet: ");
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

        System.out.print("Rediger aktivitetsform på medlemmet: ");
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

        System.out.print("Rediger medlemsstatus på medlemmet: ");
        boolean nyMedlemsstatus = true;
        try {
            nyMedlemsstatus = sc.nextBoolean();
        } catch (NoSuchElementException e) {
            System.out.println("Forkert input! Prøv igen.");
        }
    }

    // Træner___________________________________________________________________

    public void tilføjMedlemTilHold() {
        System.out.println("Indtast medlemmests fulde navn for at tilføje ind i et hold");
        //String fuldNavn;
        //String holdNavn;
        Medlem medlem = null;
        try {
           // fuldNavn = læsString();
            //holdNavn = læsString();
            registerController.tilføjMedlemTilHold(medlem);
        } catch (NoSuchElementException e) {
            System.out.println("Forkert input! Prøv igen.");
        }
    }

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
        String holdNavn = null;
        try {
            fuldNavn = læsString();
            holdNavn = læsString();
            registerController.fjernMedlemFraHold(fuldNavn, holdNavn);
        } catch (NoSuchElementException e) {
            System.out.println("Forkert input! Prøv igen.");
        }
    }

    public void visMedlemmerForValgteHold() {
        ArrayList<Medlem> juniorHold = registerController.getJuniorHold();
        System.out.println("Liste over medlemmer i junior hold: ");
        for (Medlem medlem1 : juniorHold) {
            System.out.println("Medlemmets navn: " + medlem1.getFuldNavn() + ", alder: " + medlem1.getAlder());

        }

        ArrayList<Medlem> seniorHold = registerController.getSeniorHold();
        System.out.println("Liste over medlemmer i senior hold: ");
        for (Medlem medlem1 : seniorHold) {
            System.out.println("Medlemmets navn: " + medlem1.getFuldNavn() + ", alder: " + medlem1.getAlder());
        }

    }

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

    private void tilføjDiscipliner() {
        ArrayList<KonkurrenceSvømmer> konkurrenceSvømmere = new ArrayList<>();
        for (Medlem medlem : registerController.getKonkurrenceSvømmere()) {
            if (medlem instanceof KonkurrenceSvømmer) {
                konkurrenceSvømmere.add((KonkurrenceSvømmer) medlem);
            }
        }
        for (KonkurrenceSvømmer konkurrenceSvømmer : konkurrenceSvømmere) {
            System.out.println("#" + (konkurrenceSvømmere.indexOf(konkurrenceSvømmer) + 1 + "\n"));
        }
        System.out.println("Svømmer med nummer: ");
        int userChoice = læsInt();
        KonkurrenceSvømmer svømmerValg = konkurrenceSvømmere.get(userChoice - 1);
        System.out.println("Discipliner: \n");
        String placering = læsString();
        System.out.println("Dato (åååå-mm-dd): \n");

        LocalDate dato = LocalDate.parse(sc.next());
        System.out.println("""
                1. Butterfly
                2. Backcrawl
                3. Crawl
                4. Brystsvømning
                """);
        System.out.println("Discipline: ");
        int userInput = læsInt();
        String discipline = "";
        while (discipline.isBlank()) {
            switch (userInput) {
                case 1 -> discipline = "Butterfly";
                case 2 -> discipline = "Backcrawl";
                case 3 -> discipline = "Crawl";
                case 4 -> discipline = "Brystsvømning";
                default -> System.out.println("Forkert input! Prøv igen.");
            }
        }
        System.out.println("Svømmetid: ");
        double tid = sc.nextDouble();
        svømmerValg.tilføjAktivitet(new Resultat(discipline, tid, placering, dato));
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

    public String kontingent() {
        registerController.kassereOversigt();
        {

        }
        return registerController.kassereOversigt();

    }

    public void kontingenindbetalinger() {

    }

    public void listeOverMedlemmerIRestance() {

    }




    public String læsString() {
        while (!sc.hasNextLine()) {
            System.out.println("Det er ikke en string");
            sc.next();
        }
        String s = sc.nextLine();
        //sc.nextLine();
        return s;
    }

    public int læsInt() {
        while (!sc.hasNextInt()) {
            System.out.println("Det er ikke en int");
            sc.next();
        }
        int i = sc.nextInt();
        sc.nextLine();
        return i;
    }

}