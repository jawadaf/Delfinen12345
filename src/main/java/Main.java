public class Main {
    public static void main(String[] args) {
        RegisterController rc = new RegisterController();
        rc.start();

        {
            FileHandler fileHandler = new FileHandler();
            ArrayList<Medlem> medlemListe = new ArrayList<>();

            fileHandler.saveToCsvFile(medlemListe);
    }
}