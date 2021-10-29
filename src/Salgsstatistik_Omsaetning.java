import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

public class Salgsstatistik_Omsaetning {
    private Filhaandtering filhaandtering = new Filhaandtering();
    private int[] count = new int[14];
    private int[] prisCount = new int[14];
    private int omsaetningTotalPris = 0;

    public void salgsstatistikOmsaetning() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        int menuOmsaetningChoice = 0;
        while (menuOmsaetningChoice != 4){
            System.out.println("Omsætning menu" +
                    "\n1. Vis salgsstatistik \n2. Vis omsætning \n3. Ryd salgsstatistik og omsætning \n4. For exit" + "\nIndtast nummer: ");
            menuOmsaetningChoice = input.nextInt();
            System.out.println();
            switch (menuOmsaetningChoice){
                case 1:
                    filhaandtering.readSalgsstatistik();
                    break;
                case 2:
                    visOmsaetning();
                    break;
                case 3:
                    rydSalgsstatistikOmsaetning();
                    printTilPizzaOmsaetning();
                    break;
                default:
                    System.out.println();
            }
        }
    }

    public void filPizzaCounter(int line)throws FileNotFoundException {
        filhaandtering.opdaterCountsalgsstatistik(count);

        Scanner input = new Scanner(new File("Ressources/Bestillingsliste"));

        for(int i = 0; i < line - 1; i++){
            input.nextLine();
        }
        String text = input.nextLine();

        String antalBestil = text.substring(0, text.indexOf("."));      //Tag alt det fra linen i filen som er før punktum
        antalBestil = antalBestil.replaceAll(" ","");   //Udskifter alle de mellemrum der er med ingen mellemrum
        String[] arrOfStr = antalBestil.split(",");               //Deler den String op ved hvert komma og sætter det ind på en plads i array

        for (int i = 0; i < arrOfStr.length; i++){
            for (int j = 0; j < 14; j++) {
                if (arrOfStr[i].equals(String.valueOf(j+1))){             //Tjekker om der er den værdi i array og hvis der er kan den gå ind og tælle count op
                    count[j]++;
                    break;
                }
            }
        }
        filhaandtering.writeToSalgsstatistik(count);
        beregnOmsaetning();
    }

    public void pizzaPris(String bestillingsliste, String tid)throws FileNotFoundException {
        String antalBestil = bestillingsliste.substring(0, bestillingsliste.indexOf("."));
        antalBestil = antalBestil.replaceAll(" ","");
        String[] arrOfStr = antalBestil.split(",");

        for (int i = 0; i < arrOfStr.length; i++){
            for (int j = 0; j < 14; j++) {
                if (arrOfStr[i].equals(String.valueOf(j+1))){
                    prisCount[j]++;
                    break;
                }
            }
        }
        prisForBestilling(tid);
    }
    public void prisForBestilling(String tid) throws FileNotFoundException {
        filhaandtering.pizzaPris();
        int[] pris = new int[10];
        int tempPris = 0;
        for (int i = 0; i < 14; i++) {
            if (prisCount[i] >= 1){
                //System.out.printf("Pizzanummer: %d antal bestillinger %d \n", (i+1), prisCount[i]);
                tempPris += prisCount[i] * filhaandtering.priser[i];
            }
        }
        for (int i = 0; i < 14; i++){
            if (pris[i] == 0) {
                pris[i] = tempPris;
                System.out.printf("Pris for bestillingen: %d kr \nAfhentningstidspunkt: %4s\n\n", pris[i], tid);
                prisCount[i] = 0;
                break;
            }
        }
    }

    public void visOmsaetning() throws FileNotFoundException {
        beregnOmsaetning();
        System.out.printf("Omsætnings total: %d kr.\n\n", omsaetningTotalPris);
    }

    public void beregnOmsaetning() throws FileNotFoundException {
        filhaandtering.opdaterCountsalgsstatistik(count);
        filhaandtering.pizzaPris();
        for (int i = 0; i < 14; i++) {
            if (count[i] >= 1){
                omsaetningTotalPris += count[i] * filhaandtering.priser[i];
            }
        }
        printTilPizzaOmsaetning();
    }

    public void rydSalgsstatistikOmsaetning() throws FileNotFoundException {
        Arrays.fill(count, 0);
        filhaandtering.writeToSalgsstatistik(count);
        omsaetningTotalPris = 0;
    }

    public void printTilPizzaOmsaetning() throws FileNotFoundException {
        PrintStream out = new PrintStream(new File("Ressources/Omsaetning/PizzaOmsaetning.txt"));
        out.println("Totalpris: " + omsaetningTotalPris);
    }
}
