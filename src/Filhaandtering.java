import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class Filhaandtering {
    int[] priser = new int[14];

    public void readFil() throws FileNotFoundException{
        Scanner readFileScanner = new Scanner(new File("Ressources/pizzaMenu"));
        int tempI = 1;
        while(readFileScanner.hasNext()) {
            System.out.printf("%3d. %s\n", tempI,readFileScanner.nextLine());
            tempI++;
        }
    }

    public void readOmsaetning() throws FileNotFoundException{
        Scanner readFileScanner = new Scanner(new File("Ressources/Omsaetning/PizzaOmsaetning.txt"));
        int tempI = 1;
        while(readFileScanner.hasNext()) {
            System.out.printf("%s\n", readFileScanner.nextLine());
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

    public void writeToOmsaetning(int[] omsaetning) throws FileNotFoundException {
        PrintStream out = new PrintStream(new File("Ressources/Omsaetning/PizzaOmsaetning.txt"));
        String pizzaOmsaetning = "";

        for(int i = 0; i < 14; ++i) {
            pizzaOmsaetning += "Pizzanummer: " + (i+1) + " antal pizzaer " + omsaetning[i] + "\n";
        }
        out.println(pizzaOmsaetning);
    }

    public void opdaterOmsaetning(int[] countOmsaetning) throws FileNotFoundException {
        int i = 0;
        Scanner readOmsaetning = new Scanner(new File("Ressources/Omsaetning/PizzaOmsaetning.txt"));
        while (readOmsaetning.hasNext()){
            String tempS = readOmsaetning.next();
            int tempInt = readOmsaetning.nextInt();
            tempS = readOmsaetning.next();
            tempS = readOmsaetning.next();
            countOmsaetning[i] = readOmsaetning.nextInt();
            i++;
        }
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
        }
    }
}
