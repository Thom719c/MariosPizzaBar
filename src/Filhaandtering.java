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

    public void writeB(String[] bestillingsliste) throws FileNotFoundException {
        PrintStream out = new PrintStream(new File("Ressources/Bestillingsliste"));
        String bestilling = "";

        for(int i = 0; i < bestillingsliste.length; ++i) {
            if (bestillingsliste[i] != null) {
                bestilling = bestilling + bestillingsliste[i] + "\n";
            }
        }
        out.println(bestilling);
    }

    public void opdaterArray(String[] bestillingsliste) throws FileNotFoundException {
        int i = 0;
        Scanner readBestillingsliste = new Scanner(new File("Ressources/Bestillingsliste"));
        while (readBestillingsliste.hasNext()){
            bestillingsliste[i] = readBestillingsliste.nextLine();
            i++;
        }
    }
}
