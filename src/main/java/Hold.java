import java.util.ArrayList;

public class Hold {
    private String holdNavn;
    private ArrayList<Medlem> medlemmer;
    private ArrayList<Hold> seniorHold = new ArrayList<>();
    private ArrayList<Hold> juniorHold = new ArrayList<>();
    private Hold hold;

    Medlem medlem = new Medlem();

    public Hold(String holdNavn) {
        this.holdNavn = holdNavn;
        this.medlemmer = new ArrayList<>();

    }

    public void tilføjMedlemTilHold(Medlem medlem) {
        if (medlem.getAlder() < 18) {
            juniorHold.add(hold);
        } else if (medlem.getAlder() > 18) {
            seniorHold.add(hold);
        }
    }

    public void gemMedlemTilHold() {
        medlemmer.add(medlem);
    }

    public void fjernMedlemFraHold(Medlem medlem) {
        medlemmer.remove(medlem);
    }

    public void visMedlemmer() {
        System.out.println("Medlemmer på " + holdNavn + "holdet:");
        for (Medlem medlem : medlemmer) {
            System.out.println(medlem.getFuldNavn());
        }
    }

    public String getHoldNavn() {
        return holdNavn;

    }

    public String getHoldnavn() {
        return null;
    }
}