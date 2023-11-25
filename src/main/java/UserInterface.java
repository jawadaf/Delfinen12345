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
                3. Aflsut programmet.
                """);
    }

    public void printHeleUserInterface() {
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
                    System.out.println("""
                    Ved registrering af nyt medlem har jeg bruge for følgende:
                    1. Medlemmets fulde navn
                    2. Medlemmets adresse
                    3. Medlemmets alder
                    4. Medlemmets fødselsdato
                    5. Medlemmets telefonnumer
                    6. Medlemmets e-mail
                    """);

                    System.out.print("Indtast fulde navn på medlemmet: ");
                    fuldNavn = null;
                    try {
                        fuldNavn = scanner.nextLine();
                    } catch (NoSuchElementException e) {
                        System.out.println("Forkert input. Prøv igen.");
                    }

                    System.out.print("Indtast adresse på medlemmet: ");
                    String adresse = null;
                    try {
                        adresse = scanner.nextLine();
                    } catch (NoSuchElementException e) {
                        System.out.println("Forkert input. Prøv igen.");
                    }

                    System.out.print("Indtast alder på medlemmet: ");
                    int alder = 0;
                    try {
                        alder = scanner.nextInt();
                    } catch (NoSuchElementException e) {
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



                    System.out.print("Indtast fødselsdato på medlemmet: ");
                    LocalDate fødselsdato = null;
                    scanner = new Scanner(System.in);
                    try {
                        String fødselsdagsdato = scanner.nextLine();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        fødselsdato = LocalDate.parse(fødselsdagsdato, formatter);

                    } catch (DateTimeParseException e) {
                        System.out.println("Forkert datoformat. Brug formatet åååå-mm-dd. Prøv igen.");
                    }





                    System.out.print("Indtast telefonnummeret på medlemmet: ");
                    int telefonnummer = 0;
                    try {
                        telefonnummer = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Forkert input. Prøv igen.");
                    }

                    System.out.print("Indtast email på medlemmet: ");
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
                    System.out.println(fuldNavn + " er blevet registreret.");
                }

                case 2 -> {
                        System.out.println("Registreret medlem er blevet gemt.");
                        registerController.gemMedlemer();
                }

                /* case 2 -> {
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

                 */
                case 3 -> registerController.exit();
                default -> System.out.println("Forkert input. Prøv igen.");

            }
        }
    }
}
