import java.io.*;
import java.util.*;
public class Filhaandtering {
    public void readFil() throws FileNotFoundException{
        Scanner readFileScanner = new Scanner(new File("Ressources/pizzaMenu"));
        int tempI = 1;
        while(readFileScanner.hasNext()) {
            System.out.printf("%3d. %s\n", tempI,readFileScanner.nextLine());
            tempI++;
        }
    }
    public void readB(String[] bestillingsliste)throws FileNotFoundException{
        Scanner readBScanner = new Scanner(new File("Ressources/Bestillingsliste"));
        int tempI = 0;
        while(readBScanner.hasNext()) {
            System.out.printf("%3d. %s\n", tempI,readBScanner.nextLine());
            tempI++;
        }
    }
}
