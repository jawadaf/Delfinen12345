import java.util.ArrayList;

public class Database {
    private ArrayList<Medlem> medlemmer = new ArrayList<>();

    public void addMedlem  (Medlem medlem) {
        medlemmer.add(medlem);}

    public ArrayList<Medlem> getMedlemmer() {
        return medlemmer;
    }

    public void setMedlemList(ArrayList<Medlem> loadedMedlemmer) {
        this.medlemmer = loadedMedlemmer;

    }
}

