import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class Filhaandtering {
    int[] priser = new int[14];

    //Læser filen pizzaMenuen og printer den til konsolen
    public void readFil() throws FileNotFoundException {
        Scanner readFileScanner = new Scanner(new File("Ressources/pizzaMenu"));
        int tempI = 1;
        while (readFileScanner.hasNext()) {
            System.out.printf("%3d. %s\n", tempI, readFileScanner.nextLine());
            tempI++;
        }
    }

    //Læser filen Salgsstatistik og printer den til konsolen
    public void readSalgsstatistik() throws FileNotFoundException {
        Scanner readFileScanner = new Scanner(new File("Ressources/Statistik/Salgsstatistik.txt"));
        while (readFileScanner.hasNext()) {
            System.out.printf("%s\n", readFileScanner.nextLine());
        }
    }

    //tager array bestillingsliste og skriver til filen Bestillingsliste
    public void writeToBestillingsliste(String[] bestillingsliste) throws FileNotFoundException {
        PrintStream out = new PrintStream(new File("Ressources/Bestillingsliste"));
        String bestilling = "";

        for (int i = 0; i < bestillingsliste.length; ++i) {
            bestilling += bestillingsliste[i] + "\n";
        }
        out.println(bestilling);
    }

    //tager array salgsstatistikOmsaetning og skriver til filen Salgsstatistik
    public void writeToSalgsstatistik(int[] salgsstatistikOmsaetning) throws FileNotFoundException {
        PrintStream out = new PrintStream(new File("Ressources/Statistik/Salgsstatistik.txt"));
        String pizzaOmsaetning = "";

        for (int i = 0; i < 14; ++i) {
            pizzaOmsaetning += "Pizzanummer: " + (i + 1) + " antal pizzaer " + salgsstatistikOmsaetning[i] + "\n";
        }
        out.println(pizzaOmsaetning);
    }

    //Læser fra filen Salgsstatistik og inlæser data ind på arrayet countsalgsstatistik
    public void opdaterCountsalgsstatistik(int[] countsalgsstatistik) throws FileNotFoundException {
        int i = 0;
        Scanner readOmsaetning = new Scanner(new File("Ressources/Statistik/Salgsstatistik.txt"));
        while (readOmsaetning.hasNext()) {
            String tempS = readOmsaetning.next();   //Linje 55, 56, 57 og 58: lægger dataen ind på midlertidige variabler, for at nå den ønskede data
            int tempInt = readOmsaetning.nextInt();
            tempS = readOmsaetning.next();
            tempS = readOmsaetning.next();
            countsalgsstatistik[i] = readOmsaetning.nextInt(); //Gemmer den ønskede data i et array
            i++;
        }
    }

    //Læser fra filen Bestillingsliste og inlæser data ind på arrayet bestillingsliste
    public void opdaterArray(String[] bestillingsliste) throws FileNotFoundException {
        int i = 0;
        Scanner readBestillingsliste = new Scanner(new File("Ressources/Bestillingsliste"));
        while (readBestillingsliste.hasNext()) {
            bestillingsliste[i] = readBestillingsliste.nextLine();
            i++;
        }
    }

    //Læser filen pizzaMenu og sorterer frem til den ønskede data
    public void pizzaPris() throws FileNotFoundException {
        String[] menuA = new String[14];

        Scanner readFileScanner = new Scanner(new File("Ressources/pizzaMenu"));

        int tempI = 0;
        while (readFileScanner.hasNext()) {
            menuA[tempI] = readFileScanner.nextLine();
            tempI++;
        }
        for (int i = 0; i < menuA.length; i++) {
            String result = menuA[i];
            //substring af resultat hvor den tag fra det sidst punktum (der bliver plusset med 1 for at tag den sidste punktum væk) og til den ser " kr" hvor den ender med vores int i "pizzaMenu"
            String newLast = result.substring(result.lastIndexOf(".") + 1, result.indexOf(" kr"));
            priser[i] = Integer.parseInt(newLast);
        }
    }

    public void printTilPizzaOmsaetning(int omsaetningTotalPris) throws FileNotFoundException {
        PrintStream out = new PrintStream(new File("Ressources/Omsaetning/PizzaOmsaetning.txt"));
        out.println("Totalpris: " + omsaetningTotalPris);
    }
}
