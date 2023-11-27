import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class UserInterface {

    public RegisterController registerController;

    public UserInterface() {
        registerController = new RegisterController();
    }


    public void showMenu() {
        System.out.println(""" 
                1. Opret et medlem.
                2. Gem registreret medlem.
                3. Vis liste over medlemmer.
                4. Slet medlem.
                5. Rediger medlems oplysninger
                6. Aflsut programmet.
                """);
    }

    public void printHeleUserInterface() {
        registerController.loadList();
        Scanner scanner = new Scanner(System.in);
        int isRunning = 0;

        while (isRunning != 7) {
            showMenu();
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
                    try {
                        alder = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Forkert input. Prøv igen.");
                    }

                    /*
                    System.out.print("Indtast fødselsdato på medlemmet: ");
                    LocalDate fødselsdato = null;
                        try {
                            String fødselsdagsdato = scanner.nextLine();
                            String[] fødselsdagsdatoComponents = fødselsdagsdato.split("-");
                            int year = Integer.parseInt(fødselsdagsdatoComponents[0]);
                            int month = Integer.parseInt(fødselsdagsdatoComponents[1]);
                            int day = Integer.parseInt(fødselsdagsdatoComponents[2]);
                            fødselsdato = LocalDate.of(year, month, day);
                        } catch (DateTimeParseException e) {
                            System.out.println("Forkert input. Prøv igen.");
                    }

                     */

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

                    System.out.print("Indtast Aktivitetsform på medlemmet; True = aktivt eller false = passivt: ");
                    boolean aktivitetsform = true;
                    scanner = new Scanner(System.in);
                    try {
                        aktivitetsform = scanner.nextBoolean();
                    } catch (NoSuchElementException e) {
                        System.out.println("Forkert input. Prøv igen.");
                    }
                    // HUSK LOWERCASE METODE TIL BOOLEANS /TRUE/true/TrUe/

                    System.out.println("Indtast medlemmets medlemskabstatus; true = aktivt eller false = passivt  ");
                    boolean aktivt = true;
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


                    System.out.println("Indtast medlemmets medlemskabtype");
                    boolean medlemskabType = true;
                    scanner = new Scanner(System.in);
                    try {
                        boolean medlemskabtype = scanner.nextBoolean();
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
                   case 4 -> registerController.exit();
                default -> System.out.println("Forkert input. Prøv igen.");

            }
        }
    }
}

