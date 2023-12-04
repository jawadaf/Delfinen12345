package domain;

import java.util.ArrayList;

public class Hold {
    private String holdNavn;
    private ArrayList<Medlem> medlemmer = new ArrayList<>();
    //private ArrayList<Hold> seniorHold = new ArrayList<>();
    //private ArrayList<Hold> juniorHold = new ArrayList<>();
    private ArrayList<Hold> juniorHold = new ArrayList<>();
    private ArrayList<Hold> seniorHold = new ArrayList<>();
    private ArrayList<Hold> holdListe = new ArrayList<>();
    private ArrayList<Hold> top5 = new ArrayList<>();


    public Hold(String holdNavn) {
        this.holdNavn = holdNavn;

    }

    public Hold() {
    }


    public void tilføjMedlemTilHold(Medlem medlem) {
        medlemmer.add(medlem);
        if (medlem.getAlder() < 18) {
            juniorHold.add(this);
        } else {
            seniorHold.add(this);
        }

    }
    /*public void tilføjMedlemTilHold(Medlem medlem) {
        medlemmer.add(medlem);
        if (medlem.getAlder() < 18) {
            juniorHold.add(medlem);
        } else {
            seniorHold.add(medlem);
        }

    }*/

    public void fjernMedlemFraHold(Medlem medlem) {
        medlemmer.remove(medlem);
        if (medlem.getAlder() < 18) {
            juniorHold.remove(medlem);
        } else {
            seniorHold.remove(medlem);
        }
    }

    /* public void fjernMedlemFraHold(Medlem medlem) {
        medlemmer.remove(medlem);
    }

     */

    public void visMedlemmer() {
        System.out.println("Medlemmer på " + holdNavn + "holdet:");
        for (Medlem medlem : medlemmer) {
            System.out.println(medlem.getFuldNavn());
        }
    }

    public ArrayList<Medlem> getMedlemmer() {
        return medlemmer;
    }

    public String getHoldNavn() {
        return holdNavn;

    }

    public ArrayList<Hold> getJuniorHold() {
        return juniorHold;
    }

    public ArrayList<Hold> getSeniorHold() {
        return seniorHold;
    }
    /*public ArrayList<Medlem> getJuniorHold() {
        return juniorHold;
    }

    public ArrayList<Medlem> getSeniorHold() {
        return seniorHold;
    }*/




}