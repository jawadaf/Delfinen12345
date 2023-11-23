import java.time.LocalDate;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class UserInterface {
    private ArrayList<Medlem> medlemsliste;
    private Scanner scanner;

    public UserInterface() {
        medlemsliste = new ArrayList<>();
        scanner = new Scanner(System.in);
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
        }

        Medlem medlem = new Medlem(fuldNavn, adresse, alder, fødselsdato, telefonnummer, email);
        return medlem;
    }
}
