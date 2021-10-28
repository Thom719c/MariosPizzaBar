import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class Bestilling {
    private String[] bestillingsliste = new String[10];
    private Filhaandtering filhaandtering = new Filhaandtering();

    public void bestilling() throws FileNotFoundException {
        filhaandtering.opdaterArray(bestillingsliste);
        Scanner input = new Scanner(System.in);
        int bestillingChoice = 0;
        while (bestillingChoice != 4){
            System.out.println("Bestilling menu \n" + "\n1. Tilføj bestilling \n2. Fjern bestilling \n4. For exit" + "\nIndtast nummer: ");
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
                    sorterAfhentingstidpunkt();
                    break;
                default:
                    System.out.println();
            }
        }

    }
    public void tilfojBestilling(Scanner input) throws FileNotFoundException {
        for (int i = 0; i < bestillingsliste.length; i++){
            if (bestillingsliste[i].equals("null")) {
                System.out.println("Indtast pizzanummer (f.eks: 1, 5, 3): ");
                String pizzaNr = input.nextLine();
                System.out.println("Indtast afhentningstidspunkt: ");
                String afhentningstidspunkt = input.next();
                bestillingsliste[i] = pizzaNr + ". " + afhentningstidspunkt;
                System.out.println(bestillingsliste[i]);
                break;
            }
        }
        sorterAfhentingstidpunkt();
        filhaandtering.writeB(bestillingsliste);
    }

    public void fjernBestilling(Scanner input) throws FileNotFoundException {
        fjernBestillingPrint();
        System.out.println("\nHvilken bestilling vil du slette?:");
        int number = input.nextInt();
        if(number >= 1 && number <= bestillingsliste.length){
            bestillingsliste[number-1] = "null";
        }
        sorterAfhentingstidpunkt();
        fjernBestillingPrint();
        filhaandtering.writeB(bestillingsliste);
    }
    public void fjernBestillingPrint(){
        System.out.println("Bestillingslisten:");
        for (int i = 0; i < bestillingsliste.length; i++){
            System.out.println("Nr " + (i+1) + ". " + bestillingsliste[i]);
        }
    }
    public void sorterAfhentingstidpunkt() throws FileNotFoundException {
        String[] resultA = new String[10];
        String tempA;
        String tempBestilling;
        for (int i = 0; i < bestillingsliste.length; i++) {
            String result = bestillingsliste[i];
            //resultA = result.split[(result.split("-")).length -1];
            String[] split = result.split( Pattern.quote( "." ) );
            String lastOne = split[split.length-1];
            resultA[i] = lastOne;
        }
        for (int i = 0; i <bestillingsliste.length; i++) {
            for (int j = i+1; j <bestillingsliste.length; j++) {
                if( resultA[i].compareTo(resultA[j]) > 0) {
                    tempA = resultA[i];
                    tempBestilling = bestillingsliste[i];
                    resultA[i] = resultA[j];
                    bestillingsliste[i] = bestillingsliste[j];
                    resultA[j] = tempA;
                    bestillingsliste[j] = tempBestilling;
                }
            }
            System.out.println(bestillingsliste[i]);
            filhaandtering.writeB(bestillingsliste);
        }
    }
}
