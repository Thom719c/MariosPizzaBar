import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

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
            bestilling += bestillingsliste[i] + "\n";
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

    public void pizzaPris() throws FileNotFoundException {
        String[] menuA = new String[14];
        int[] priser = new int[14];

        Scanner readFileScanner = new Scanner(new File("Ressources/pizzaMenu"));

        int tempI = 0;
        while(readFileScanner.hasNext()) {
            menuA[tempI] = readFileScanner.nextLine();
            tempI++;
        }
        for (int i = 0; i < menuA.length; i++) {
            String result = menuA[i];
            String[] split = result.split( Pattern.quote( "." ) );
            String lastOne = split[split.length-1];
            String[] splitF = lastOne.split( Pattern.quote( " " ) );
            String firstOne = splitF[splitF.length-2];
            priser[i] = Integer.parseInt(firstOne);
            System.out.println(priser[i]);
        }
    }
}
