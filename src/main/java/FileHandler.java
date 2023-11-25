import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {


    public void saveToCsvFile(ArrayList<Medlem> medlemList) {
        try {
           PrintStream out = new PrintStream(new File("medlemregister.csv"));
            for (Medlem medlem : medlemList) {
                if (medlem != null) {
                    out.println(medlem);
                } else {
                    System.out.println("Der er ingen medlemmer registeret");
                }
            }
            out.close();
        }catch(FileNotFoundException e) {
            System.out.println("Filen eksistere ikke.");
            }
        }


public static ArrayList<Medlem> loadFromCsvFile() {
    File file = new File("medlemregister.csv");
    ArrayList<Medlem> medlemmer = new ArrayList<>();
    try (Scanner scanner = new Scanner(new File("medlemregister.csv"))) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
        }
    } catch (FileNotFoundException e) {

        e.printStackTrace();
    }
    return medlemmer;
}
}