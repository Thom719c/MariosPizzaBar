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
    public void readB(String[] bestillingNr)throws FileNotFoundException{
        Scanner readBScanner = new Scanner(new File("Ressources/Bestillingsliste"));
        //String[] bestillingNr = new String[10];
        int tempI = 0;
        while(readBScanner.hasNext()) {
            //System.out.printf("%3d. %s\n", tempI,readBScanner.nextLine());
            bestillingNr[tempI] = readBScanner.nextLine();
            System.out.println((tempI+1) + ". " + bestillingNr[tempI]);
            tempI++;
        }
    }
}
