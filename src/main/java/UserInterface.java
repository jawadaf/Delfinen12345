import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class UserInterface {
    public RegisterController registerController;
    private Scanner scanner;


    public void showMenu() {
        System.out.println(""" 
                1. Opret et medlem.
                2. Gem registreret medlem.
                3. Aflsut programmet.
                """);
    }

    public Medlem printHeleUserInterface() {
        Scanner scanner = new Scanner(System.in);
        int isRunning = 0;

        while (isRunning != 3) {
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

                    System.out.print("Indtast fulde navn på medlemmet.");
                    fuldNavn = null;
                    try {
                        fuldNavn = scanner.nextLine();
                    } catch (NoSuchElementException e) {
                        System.out.println("Forkert input. Prøv igen.");
                    }

                    System.out.print("Indtast adresse på medlemmet.");
                    String adresse = null;
                    try {
                        adresse = scanner.nextLine();
                    } catch (NoSuchElementException e) {
                        System.out.println("Forkert input. Prøv igen.");
                    }

                    System.out.print("Indtast alder på medlemmet.");
                    int alder = 0;
                    try {
                        alder = scanner.nextInt();
                    } catch (NoSuchElementException e) {
                        System.out.println("Forkert input. Prøv igen.");
                    }



                    System.out.print("Indtast fødselsdato på medlemmet.");
                    LocalDate fødselsdato = null;
                    scanner = new Scanner(System.in);
                        try {
                            String fødselsdagsdato = scanner.nextLine();
                            String[] fødselsdagsdatoComponents = fødselsdagsdato.split("åååå-mm-dd");
                            int year = Integer.parseInt(fødselsdagsdatoComponents[0]);
                            int month = Integer.parseInt(fødselsdagsdatoComponents[1]);
                            int day = Integer.parseInt(fødselsdagsdatoComponents[2]);
                            fødselsdato = LocalDate.of(year, month, day);
                        } catch (NoSuchElementException e) {
                        System.out.println("Forkert input. Prøv igen.");
                    }






                    /*System.out.print("Indtast fødselsdato på medlemmet.");
                    LocalDate fødselsdato = null;
                    scanner = new Scanner(System.in);
                    try {
                        String fødselsdagsdato = scanner.nextLine();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        fødselsdato = LocalDate.parse(fødselsdagsdato, formatter);

                    } catch (DateTimeParseException e) {
                        System.out.println("Forkert datoformat. Brug formatet åååå-mm-dd. Prøv igen.");
                    }

                     */





                    System.out.print("Indtast telefon-nummeret på medlemmet.");
                    int telefonnummer = 0;
                    try {
                        telefonnummer = scanner.nextInt();
                    } catch (NoSuchElementException e) {
                        System.out.println("Forkert input. Prøv igen.");
                    }

                    System.out.print("Indtast e-mail på medlemmet.");
                    String email = null;
                    try {
                        email = scanner.nextLine();
                    } catch (NoSuchElementException e) {
                        System.out.println("Forkert input. Prøv igen.");
                    }
                    registerController.tilføjelseAfMedlem(
                            fuldNavn,
                            adresse,
                            alder,
                            fødselsdato,
                            telefonnummer,
                            email);
                }
                case 2 -> {
                    //vis en liste over medlemmer
                    ArrayList<Medlem> medlemListe = registerController.hentetMedlem();
                    System.out.println("Liste over medlemmer");
                    for (Medlem medlem : medlemListe) {
                        System.out.println("Medlemmets navn " + medlem.getFuldNavn());
                        System.out.println();
                        System.out.println("Medlemmets adresse " + medlem.getAdresse());
                        System.out.println();
                        System.out.println("Medlemmets alder " + medlem.getAlder());
                        System.out.println();
                        System.out.println("Medlemmets telefonnummer " + medlem.getTelefonnummer());
                        System.out.println();
                        System.out.println("Medlemmets fødselsdato " + medlem.getFødselsdato());
                        System.out.println();
                        System.out.println("Medlemmets e-mail " + medlem.getEmail());
                        System.out.println();
                    }

                }
                case 3 -> registerController.exit();
                default -> System.out.println("Invalid input. Please try again.");

            }


        }
        //ArrayList<Medlem> medlemliste;
        //UserInterface() {

        //medlemliste = new ArrayList<>();
        //scanner = new Scanner(System.in);
        return null;
    }

        public Medlem registrerNytMedlem() {
            System.out.println("""
                    Ved registrering af nyt medlem har jeg bruge for følgende:
                    1. Medlemmets fulde navn
                    2. Medlemmets adresse
                    3. Medlemmets alder
                    4. Medlemmets fødselsdato
                    5. Medlemmets telefonnumer
                    6. Medlemmets e-mail
                    """);

            System.out.println("Indtast medlemmets fulde navn: ");
            String fuldNavn = "";
            try {
                fuldNavn = scanner.nextLine();
            } catch (NoSuchElementException e) {
                System.out.println("Indtast venligst dit fulde navn");
            }

            System.out.println("Indtast medlemmets adresse: ");
            String adresse = "";
            try {
                adresse = scanner.nextLine();
            } catch (NoSuchElementException e) {
                System.out.println("Indtast venligst din adresse");
            }

            System.out.println("Indtast medlemmets alder: ");
            int alder = 0;
            try {
                alder = scanner.nextInt();
            } catch (NoSuchElementException e) {
                System.out.println("Indtast venligst din alder");
            }
            scanner.nextLine(); // For at fjerne newline fra scanner buffer

            System.out.println("Indtast medlemmets fødselsdato (åååå-mm-dd): ");
            LocalDate fødselsdato = null;
            try {
                String fødselsdatoinput = scanner.nextLine();
                fødselsdato = LocalDate.parse(fødselsdatoinput);
            } catch (NoSuchElementException e) {
                System.out.println("Indtast venligst din fødselsdato");
            }

            System.out.println("Indtast medlemmets telefonnummer: ");
            int telefonnummer = 0;
            try {
                telefonnummer = scanner.nextInt();
            } catch (NoSuchElementException e) {
                System.out.println("Indtast venligst dit telefonnummer");
            }
            scanner.nextLine(); // For at fjerne newline fra scanner buffer

            System.out.println("Indtast medlemmets e-mail: ");
            String email = "";
            try {
                email = scanner.nextLine();
            } catch (NoSuchElementException e) {
                System.out.println("Indtast venligst din e-mail");

                // add medlem
            }


            Medlem medlem = new Medlem(fuldNavn, adresse, alder, fødselsdato, telefonnummer, email);
            return medlem;


        }




}
