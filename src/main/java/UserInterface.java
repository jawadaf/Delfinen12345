import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private ArrayList<Medlem> medlemsliste;
    private Scanner scanner;

    public UserInterface() {
        medlemsliste = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void registrerNytMedlem() {
        System.out.println("""
                            Ved registrering af ny medlem har jeg bruge for følgende:
                            1. Medlemmets fulde navn
                            2. Medlemmets adresse 
                            3. Medlemmets alder
                            4. Medlemmets fødselsdato
                            5. Medlemmets telefonnumer
                            6. Medlemmets e-mail
                            """);

        System.out.println("Indtast medlemmets fulde navn: ");
        String navn = scanner.nextLine();

        System.out.println("Indtast medlemmets adresse: ");
        String adresse = scanner.nextLine();

        System.out.println("Indtast medlemmets alder: ");
        int alder = scanner.nextInt();
        scanner.nextLine(); // For at fjerne newline fra scanner buffer

        System.out.println("Indtast medlemmets fødselsdato (åååå-mm-dd): ");
        String fødselsdatoString = scanner.nextLine();
        LocalDate fødselsdato = LocalDate.parse(fødselsdatoString);

        System.out.println("Indtast medlemmets telefonnummer: ");
        int telefonnummer = scanner.nextInt();
        scanner.nextLine(); // For at fjerne newline fra scanner buffer

        System.out.println("Indtast medlemmets e-mail: ");
        String email = scanner.nextLine();

        Medlem nytMedlem = new Medlem(navn, adresse, alder, fødselsdato, telefonnummer, email);
        medlemsliste.add(nytMedlem);
        System.out.println("Medlem registreret: " + nytMedlem.getFuldNavn());
    }

    public static void main(String[] args) {
        Formand formand = new Formand();

        System.out.println("Velkommen som formand for Svømmeklubben Delfinen!");
        System.out.println("Vil du registrere et nyt medlem? (ja/nej)");

        Scanner inputScanner = new Scanner(System.in);
        String svar = inputScanner.nextLine();

        while (svar.equalsIgnoreCase("ja")) {
            formand.registrerNytMedlem();
            System.out.println("Vil du registrere et nyt medlem? (ja/nej)");
            svar = inputScanner.nextLine();
        }

        System.out.println("Medlemsliste:");
        for (Medlem medlem : formand.medlemsliste) {
            System.out.println(medlem.getFuldNavn() + " - " + medlem.getAlder() + " år");
        }
    }
}
