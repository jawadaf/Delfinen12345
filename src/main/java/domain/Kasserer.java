package domain;

import domain.Medlem;
import domain.RegisterController;

import java.util.ArrayList;

public class Kasserer {

    RegisterController registerController;

    public Kasserer(RegisterController registerController) {
        this.registerController = registerController;
    }

    public int totalKontingent() {
        ArrayList<Medlem> medlemmer = registerController.hentetMedlemmer();
        int totalKontingent = 0;
        for (Medlem medlem : medlemmer) {
            if (!medlem.getMedlemskabStatus()) {
                totalKontingent += 500;
            } else {
                if (medlem.getAlder() < 18) {
                    totalKontingent += 1000;
                }
                if (medlem.getAlder() >= 18) {
                    totalKontingent += 1600;
                }
                if (medlem.getAlder() >= 60) {
                    totalKontingent += 1200;
                }
            }
        }
        //System.out.println("Total indtægt = " + totalKontingent + " kr.");
        return totalKontingent;
    }

    public ArrayList<Medlem> hentMedlemmer() {
        ArrayList<Medlem> medlemmer = registerController.hentetMedlemmer();
        System.out.println("Antal medlemmer: " + medlemmer.size());
        return medlemmer;
    }


}
