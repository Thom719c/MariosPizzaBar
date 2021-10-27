import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Bestilling {
    private String[] bestillingsliste = new String[10];
    private Filhaandtering filhaandtering = new Filhaandtering();

    public void bestilling() throws FileNotFoundException {
        filhaandtering.opdaterArray(bestillingsliste);
        Scanner input = new Scanner(System.in);
        int bestillingChoice = 0;
        while (bestillingChoice != 3){
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
                bestillingsliste[i] = pizzaNr + "\t" + afhentningstidspunkt;
                System.out.println(bestillingsliste[i]);
                break;
            }
        }
        filhaandtering.writeB(bestillingsliste);
    }

    public void fjernBestilling(Scanner input) throws FileNotFoundException {
        fjernBestillingPrint();
        System.out.println("\nHvilken bestilling vil du slette?:");
        int number = input.nextInt();
        if(number >= 1 && number <= bestillingsliste.length){
            bestillingsliste[number-1] = null;
        }
        fjernBestillingPrint();
        filhaandtering.writeB(bestillingsliste);
    }
    public void fjernBestillingPrint(){
        System.out.println("Bestillingslisten:");
        for (int i = 0; i < bestillingsliste.length; i++){
            System.out.println((i+1) + ". " + bestillingsliste[i]);
        }
    }

}
