package ui;

import domain.Hold;
import domain.Medlem;
import domain.RegisterController;

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
        switch (input){
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
                """);
        int input = læsInt();
        switch (input) {
            case 1 -> tilføjMedlemTilHold();
            case 2 -> gemMedlemTilHold();
            case 3 -> fjernMedlemFraHold();
            case 4 -> visMedlemmerForValgteHold();
            case 10 -> registerController.exit();
            default -> System.out.println("Forkert input. Prøv igen.");
        }
    }

    // Formand ____________________________________________________________________

    public void tilføjNytMedlem(){
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
        String fuldNavn = null;
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

        System.out.print("Indtast fødselsdato på medlemmet: ");
        LocalDate localDate = null;    // denne burde ikke være her
        LocalDate fødselsdato = localDate;   // denne skal hedde LocalDate fødselsdato = null;

        try {
            String fødselsdagsdato = læsString();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            fødselsdato = LocalDate.parse(fødselsdagsdato, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Forkert datoformat. Brug formatet åååå-mm-dd. Prøv igen.");
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

       /* System.out.print("Indtast Aktivitetsform på medlemmet: ");
        String aktivitetsform = null;
        try {
            aktivitetsform = læsString();
        } catch (NoSuchElementException e) {
            System.out.println("Forkert input. Prøv igen.");
        }*/
        // HUSK LOWERCASE METODE TIL BOOLEANS /TRUE/true/TrUe/

        System.out.println("Indtast medlemmets medlemskabstatus; true = aktivt eller false = passivt  ");
        boolean aktivt;
        boolean medlemskabStatus = false;
        try {
            aktivt = sc.nextBoolean();
            System.out.println("Du er aktiv medlem.");
            medlemskabStatus = aktivt;
        } catch (NoSuchElementException e) {
            System.out.println("Forkert input. Prøv igen.");
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
            registerController.tilføjelseAfMedlem(fuldNavn, adresse, alder, fødselsdato, telefonnummer, email, aktivitetsform, medlemslabsType, medlemskabStatus);
           // registerController.gemMedlemer();
            System.out.println("Domain.Medlem tilføjet som motionist.");
        } else if (input == 2) {
            System.out.print("Indtast Aktivitetsform på medlemmet: ");
            aktivitetsform = læsString();
            registerController.tilføjelseAfMedlem(fuldNavn, adresse, alder, fødselsdato, telefonnummer, email, aktivitetsform, medlemslabsType, medlemskabStatus);
            System.out.println("Medlem tilføjet som konkurrence svømmer.");
        } else if (input == 0) {
            System.out.println("Medlemmet ikke tilføjet.");
        }
    }

    public void gemMedlem(){
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
            System.out.println("Domain.Medlem er blevet slettet.");
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
        String fuldNavn;
        String holdNavn;
        try {
            fuldNavn = læsString();
            holdNavn = læsString();
            registerController.tilføjMedlemTilHold(fuldNavn, holdNavn);
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
        try {
            fuldNavn = læsString();
        } catch (NoSuchElementException e) {
            System.out.println("Forkert input! Prøv igen.");
        }
    }

    public void visMedlemmerForValgteHold() {
        Medlem medlem = new Medlem();
        ArrayList<Hold> juniorHold = registerController.getJuniorHold();
        System.out.println("Liste over medlemmer i junior hold: ");
        for (Hold hold : juniorHold) {
            System.out.println("Domain.Hold: " + hold.getHoldNavn());
            for (Medlem junior : hold.getMedlemmer()) {
                System.out.println("Medlemmets navn: " + junior.getFuldNavn() + ", alder: " + junior.getAlder());
            }
        }
        ArrayList<Hold> seniorHold = registerController.getSeniorHold();
        System.out.println("Liste over medlemmer i senior hold: ");
        for (Hold hold : seniorHold) {
            System.out.println("Domain.Hold: " + hold.getHoldNavn());
            for (Medlem senior : hold.getMedlemmer()) {
                System.out.println("Medlemmets navn: " + senior.getFuldNavn() + ", alder: " + senior.getAlder());
            }
        }
    }









    public String læsString() {
        while (!sc.hasNextLine()) {
            System.out.println("Det er ikke er en string");
            sc.next();
        }
        String i = sc.nextLine();
        // sc.nextInt();
        return i;
    }

    public int læsInt(){
        while (!sc.hasNextInt()){
            System.out.println("Det er ikke en int");
            sc.next();
        }
        int i = sc.nextInt();
        sc.nextLine();
        return i;
    }

    // Malou

    /* public void printHeleUserInterface() {
        registerController.loadList();
        Scanner scanner = new Scanner(System.in);
        int isRunning = 0;

        while (isRunning != 7) {
            formandMenu();
            try {
                isRunning = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Forkert input. Prøv igen.");
                continue;
            }

            scanner.nextLine();

            String fuldNavn = null;
            switch (isRunning) {
                case 1 -> {
                    //opret dit medlem
                    System.out.println("""
                            Ved registrering af nyt medlem har jeg som formand bruge for følgende:
                            1. Medlemmets fulde navn
                            2. Medlemmets adresse
                            3. Medlemmets alder
                            4. Medlemmets fødselsdato
                            5. Medlemmets telefonnumer
                            6. Medlemmets e-mail
                            7. Medlemmets Aktivitetsform
                            8. Medlemmets Medlemskabstype
                            9. Medlemmets Medlembskabstatus
                            """);

                    // Fulde navn

                    System.out.print("Indtast fulde navn på medlemmet: ");
                    fuldNavn = null;
                    try {
                        fuldNavn = scanner.nextLine();
                    } catch (NoSuchElementException e) {
                        System.out.println("Forkert input. Prøv igen.");
                    }

                    // Adresse

                    System.out.print("Indtast adresse på medlemmet: ");
                    String adresse = null;
                    try {
                        adresse = scanner.nextLine();
                    } catch (NoSuchElementException e) {
                        System.out.println("Forkert input. Prøv igen.");
                    }

                    // Alder

                    System.out.print("Indtast alder på medlemmet: ");
                    int alder = 0;
                    int medlemskabType = 0;
                    try {
                        alder = scanner.nextInt();
                        medlemskabType = alder;
                    } catch (InputMismatchException e) {
                        System.out.println("Forkert input. Prøv igen.");
                    }

                    // Fødselsdato

                    System.out.print("Indtast fødselsdato på medlemmet: ");
                    LocalDate localDate = null;    // denne burde ikke være her
                    LocalDate fødselsdato = localDate;   // denne skal hedde LocalDate fødselsdato = null;
                    scanner = new Scanner(System.in);
                    try {
                        String fødselsdagsdato = scanner.nextLine();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        fødselsdato = LocalDate.parse(fødselsdagsdato, formatter);
                    } catch (DateTimeParseException e) {
                        System.out.println("Forkert datoformat. Brug formatet åååå-mm-dd. Prøv igen.");
                    }

                    // Telefonnummer

                    System.out.print("Indtast telefonnummeret på medlemmet: ");
                    int telefonnummer = 0;
                    try {
                        // int telefonnummer = 0;
                        telefonnummer = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Forkert input. Prøv igen.");
                    }

                    // Email

                    System.out.print("Indtast email på medlemmet: ");
                    String email = null;
                    scanner = new Scanner(System.in);
                    try {
                        // String email = null;
                        email = scanner.nextLine();
                    } catch (NoSuchElementException e) {
                        System.out.println("Forkert input. Prøv igen.");
                    }

                    System.out.print("Indtast Aktivitetsform på medlemmet: ");
                    String aktivitetsform = null;
                    scanner = new Scanner(System.in);
                    try {
                        aktivitetsform = scanner.nextLine();
                    } catch (NoSuchElementException e) {
                        System.out.println("Forkert input. Prøv igen.");
                    }
                    // HUSK LOWERCASE METODE TIL BOOLEANS /TRUE/true/TrUe/

                    System.out.println("Indtast medlemmets medlemskabstatus; true = aktivt eller false = passivt  ");
                    boolean aktivt;
                    boolean medlemskabStatus = false;
                    scanner = new Scanner(System.in);
                    try {
                        aktivt = scanner.nextBoolean();
                        System.out.println("Du er aktiv medlem.");
                        medlemskabStatus = aktivt;
                    } catch (NoSuchElementException e) {
                        System.out.println("Forkert input. Prøv igen.");
                    }
                    // HUSK LOWERCASE METODE TIL BOOLEANS /TRUE/true/TrUe/

/*
                    System.out.println("Indtast medlemmets medlemskabtype");
                    boolean medlemskabType = false;
                    scanner = new Scanner(System.in);
                    try {
                        medlemskabType = scanner.nextBoolean();
                    } catch (NoSuchElementException e) {
                        System.out.println("Forkert input. Prøv igen.");
                    }
                    // HUSK LOWERCASE METODE TIL BOOLEANS /TRUE/true/TrUe/








                //int telefonnummer = 0;
                //String email = null;
                registerController.tilføjelseAfMedlem(
                        fuldNavn,
                        adresse,
                        alder,
                        fødselsdato,
                        telefonnummer,
                        email,
                        aktivitetsform,
                        medlemskabStatus,
                        medlemskabType);
                System.out.println(fuldNavn + " er blevet registreret.");
            }




            case 2 -> {
                System.out.println("Registreret medlem er blevet gemt.");
                registerController.gemMedlemer();
            }

            case 3 -> {
                //vis en liste over medlemmer
                ArrayList<Domain.Medlem> medlemListe = registerController.hentetMedlem();
                System.out.println("Liste over medlemmer: ");
                for (Domain.Medlem medlem : medlemListe) {
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
            case 4 -> {
                System.out.println("Skriv navnet på medlemmet der skal slettes.");
                String sletterMedlem = null;
                try {
                    sletterMedlem = scanner.nextLine();
                } catch (NoSuchElementException e) {
                    System.out.println("Forkert input! Prøve igen.");
                }
                registerController.sletterMedlem(fuldNavn);

                System.out.println("Domain.Medlem er blevet slettet.");
            }
            case 5 -> {
                System.out.println("Indtast det fulde navn på medlemmet, som du gerne vil redigere: ");
                String redigerMedlem = null;
                try {
                    redigerMedlem = scanner.nextLine();
                } catch (NoSuchElementException e) {
                    System.out.println("Forkert input! Prøv igen.");
                }

                System.out.print("Rediger navnet på medlemmet: ");
                String nytFuldNavn = null;
                try {
                    nytFuldNavn = scanner.nextLine();
                } catch (NoSuchElementException e) {
                    System.out.println("Forkert input! Prøv igen.");
                }

                System.out.print("Rediger adresse på medlemmet: ");
                String nyAdresse = null;
                try {
                    nyAdresse = scanner.nextLine();
                } catch (NoSuchElementException e) {
                    System.out.println("Forkert input! Prøv igen.");
                }

                System.out.print("Rediger alder på medlemmet: ");
                int nyAlder = 0;
                try {
                    nyAlder = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Forkert input! Prøv igen.");
                }

                System.out.print("Rediger fødselsdato på medlemmet?: ");
                String nyFødselsdato = null;
                try {
                    nyFødselsdato = scanner.nextLine();
                } catch (NoSuchElementException e) {
                    System.out.println("Forkert input! Prøv igen.");
                }

                System.out.print("Rediger telefonnummeret på medlemmet: ");
                int nytTelefonnummer = 0;
                try {
                    nytTelefonnummer = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Forkert input! Prøv igen.");
                }
                System.out.print("Rediger email på medlemmet: ");
                String nyEmail = null;
                try {
                    nyEmail = scanner.nextLine();
                } catch (NoSuchElementException e) {
                    System.out.println("Forkert input! Prøv igen.");
                }

                System.out.print("Rediger aktivitetsform på medlemmet: ");
                boolean nyAktivitetsform = true;
                try {
                    nyAktivitetsform = scanner.nextBoolean();
                } catch (NoSuchElementException e) {
                    System.out.println("Forkert input! Prøv igen.");
                }

                System.out.print("Rediger medlemstype på medlemmet: ");
                boolean nyMedlemsType = true;
                try {
                    nyMedlemsType = scanner.nextBoolean();
                } catch (NoSuchElementException e) {
                    System.out.println("Forkert input! Prøv igen.");
                }

                System.out.print("Rediger medlemsstatus på medlemmet: ");
                boolean nyMedlemsstatus = true;
                try {
                    nyMedlemsstatus = scanner.nextBoolean();
                } catch (NoSuchElementException e) {
                    System.out.println("Forkert input! Prøv igen.");
                }


            }
            case 6 -> registerController.exit();
            default -> System.out.println("Forkert input. Prøv igen.");


            }
        }
    }
    */





}

