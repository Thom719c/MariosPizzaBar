import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class Bestilling {
    String[] bestillingsliste = new String[10];
    private Filhaandtering filhaandtering = new Filhaandtering();
    private Salgsstatistik_Omsaetning salgsstatistikOmsaetning = new Salgsstatistik_Omsaetning();

    public void bestilling() throws FileNotFoundException {
        filhaandtering.opdaterArray(bestillingsliste);
        sorterAfhentingstidpunkt();
        Scanner input = new Scanner(System.in);
        int bestillingChoice = 0;
        while (bestillingChoice != 4){
            System.out.println("Bestilling menu" +
                    "\n1. Tilføj bestilling \n2. Fjern bestilling \n3. Vis bestillingsliste \n4. For exit" + "\nIndtast nummer: ");
            bestillingChoice = input.nextInt();
            input.nextLine();
            switch (bestillingChoice){
                case 1:
                    tilfojBestilling(input);
                    break;
                case 2:
                    fjernBestilling(input);
                    break;
                case 3:
                    printBestillinger();
                    break;
                default:
                    System.out.println();
            }
        }
    }
    public void tilfojBestilling(Scanner input) throws FileNotFoundException {
        printBestillinger();

        for (int i = 0; i < bestillingsliste.length; i++){
            if (bestillingsliste[i].equals("null")) {
                System.out.println("Indtast pizzanummer (f.eks: 1, 5, 3): ");
                String pizzaNr = input.nextLine();
                System.out.println("Indtast afhentningstidspunkt: ");
                String afhentningstidspunkt = input.next();
                bestillingsliste[i] = pizzaNr + ". " + afhentningstidspunkt;
                //  System.out.println("Bestilling tilføjet: " + bestillingsliste[i] + "\n");

                String result = bestillingsliste[i];
                String[] split = result.split( Pattern.quote( "." ) );
                String tid = split[split.length-1];

                salgsstatistikOmsaetning.pizzaPris(bestillingsliste[i], tid);
                break;
            }
        }
        sorterAfhentingstidpunkt();
        filhaandtering.writeToBestillingsliste(bestillingsliste);
    }

    public void fjernBestilling(Scanner input) throws FileNotFoundException {
        printBestillinger();
        System.out.println("\nHvilken bestilling vil du slette?:");
        int number = input.nextInt();
        salgsstatistikOmsaetning.filPizzaCounter(number);
        if(number >= 1 && number <= bestillingsliste.length){
            bestillingsliste[number-1] = "null";
        }
        printBestillinger();
        filhaandtering.writeToBestillingsliste(bestillingsliste);
    }
    public void printBestillinger() throws FileNotFoundException {
        sorterAfhentingstidpunkt();
        System.out.println("Bestillingslisten:");
        for (int i = 0; i < bestillingsliste.length; i++){
            System.out.printf("Nr %2d: %s\n", (i+1), bestillingsliste[i]);
        }
        System.out.println();
    }
    public void visBestillinger(){
        System.out.printf("Pizzanummer: %d, afhentningstidspunkt: &s");
    }

    public void sorterAfhentingstidpunkt() throws FileNotFoundException {
        String[] afhentningstidspunkt = new String[10];
        String tempBestilling;
        for (int i = 0; i < bestillingsliste.length; i++) {
            String result = bestillingsliste[i];
            String[] split = result.split( Pattern.quote( "." ) );
            String lastOne = split[split.length-1];
            afhentningstidspunkt[i] = lastOne;
        }
        for (int i = 0; i <bestillingsliste.length; i++) {
            for (int j = i+1; j <bestillingsliste.length; j++) {
                if( afhentningstidspunkt[i].compareTo(afhentningstidspunkt[j]) > 0) {
                    tempBestilling = bestillingsliste[i];
                    bestillingsliste[i] = bestillingsliste[j];
                    bestillingsliste[j] = tempBestilling;
                }
            }
            filhaandtering.writeToBestillingsliste(bestillingsliste);
        }
    }
}
