import java.util.ArrayList;


public class HoldController {
    private ArrayList<Medlem> holdListe;
    private ArrayList<Hold> juniorHold;
    private ArrayList<Hold> seniorHold;


    public HoldController() {
        this.holdListe = new ArrayList<>();
    }




    public void opretHold (String holdNavn) {
        Hold nythold = new Hold(holdNavn);
        Medlem medlem = new Medlem();
        holdListe.add(medlem);
    }

    public void tilføjMedlemTilHold(String fuldNavn) {
        for (Medlem medlem : holdListe) {
            if (medlem.getFuldNavn().equalsIgnoreCase(fuldNavn)) {
                holdListe.add(medlem);
                System.out.println(medlem.getFuldNavn() + " er blevet fjernet fra " + fuldNavn + "holdet.");
            }
        }
        System.out.println("Holdet med navnet " + fuldNavn + " blev ikke fundet");
    }

    public void visHoldMedlemmer(String holdNavn) {
        for (Medlem medlem : holdListe){
            Hold hold = new Hold(holdNavn);
            if (hold.getHoldNavn().equalsIgnoreCase(holdNavn)){
                hold.visMedlemmer(ArrayList<medlem> visHoldMedlemmer(holdNavn));
            }
        }
        System.out.println("Holdet med navnet " + holdNavn + " blev ikke fundet");
    }

    public void fjernMedlemFraHold(Medlem medlem, String holdNavn) {

    }
}
