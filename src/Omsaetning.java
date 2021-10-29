import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Omsaetning {
    private Filhaandtering filhaandtering = new Filhaandtering();
    private int[] count = new int[15];
    private int[] prisCount = new int[15];

    public void filPizzaCounter(int line)throws FileNotFoundException {

        filhaandtering.opdaterOmsaetning(count);

        Scanner input = new Scanner(new File("Ressources/Bestillingsliste"));

        for(int i = 0; i < line - 1; i++){
            input.nextLine();
        }
        String text = input.nextLine();

        String antalBestil = text.substring(0, text.indexOf("."));      //Tag alt det fra linen i filen som er før punktum
        antalBestil = antalBestil.replaceAll(" ","");   //Udskifter alle de mellemrum der er med ingen mellemrum
        String[] arrOfStr = antalBestil.split(",");               //Deler den String op ved hvert komma og sætter det ind på en plads i array

        for (int i = 0; i < arrOfStr.length; i++){
            for (int j = 0; j <= 14; j++) {
                if (arrOfStr[i].equals(String.valueOf(j))){             //Tjekker om der er den værdi i array og hvis der er kan den gå ind og tælle count op
                    count[j-1]++;
                    break;
                }
            }
        }
        for (int i = 0; i <= 14; i++) {
            if (count[i] >= 1){
                System.out.printf("Pizzanummer: %d antal bestillinger %d\n", (i+1), count[i]);
            }
        }
        filhaandtering.writeToOmsaetning(count);
    }

    public void pizzaPris(String bestillingsliste, String tid)throws FileNotFoundException {
        String antalBestil = bestillingsliste.substring(0, bestillingsliste.indexOf("."));
        antalBestil = antalBestil.replaceAll(" ","");
        String[] arrOfStr = antalBestil.split(",");

        for (int i = 0; i < arrOfStr.length; i++){
            for (int j = 0; j <= 14; j++) {
                if (arrOfStr[i].equals(String.valueOf(j))){
                    prisCount[j-1]++;
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
        for (int i = 0; i <= 14; i++) {
            if (prisCount[i] >= 1){
                System.out.printf("Pizzanummer: %d antal bestillinger %d \n", (i+1), prisCount[i]);
                tempPris += prisCount[i] * filhaandtering.priser[i];
            }
        }
        for (int i = 0; i <= 14; i++){
            if (pris[i] == 0) {
                pris[i] = tempPris;
                System.out.printf("Pris for bestillingen: %d kr \nAfhentningstidspunkt: %4s\n\n", pris[i], tid);
                prisCount[i] = 0;
                break;
            }
        }
    }
}