package domain;

import java.time.LocalDate;

public class Resultat {
    private String disciplineNavn;
    private double tid;
    private String placering;
    private LocalDate dato;


    public String getDisciplineNavn() {
        return disciplineNavn;
    }

    public double getTid() {
        return tid;
    }

    public Resultat(String disciplineNavn, double tid, String placering, LocalDate dato) {
        this. disciplineNavn = disciplineNavn;
        this.tid = tid;
        this.placering = placering;
        this.dato = dato;
    }

    public Resultat() {
    }

    public String setDisciplinNavn(String disciplinNavn) {
        this.disciplineNavn = disciplinNavn;
        return disciplinNavn;
    }



}
