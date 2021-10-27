import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Bestilling {
    private String[] bestillingsliste = new String[10];
    private Filhaandtering filhaandtering = new Filhaandtering();


    public void bestilling() throws FileNotFoundException {
        filhaandtering.opdaterArray(bestillingsliste);
        Scanner input = new Scanner(System.in);
        while (true){
            System.out.println("Bestilling menu \n" + "\n1. Tilføj bestilling \n2. Fjern bestilling\n3. For exit" + "\nIndtast nummer: ");
            int bestillingChoice = input.nextInt();
            input.nextLine();
            switch (bestillingChoice){
                case 1:
                    tilfojBestilling(input);
                    break;
                case 2:
                    fjernBestilling(input);
                    break;
                case 3:
                    System.exit(0);
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
                System.out.println(Arrays.toString(bestillingsliste));
                break;
            } else {
                System.out.println("Test");
            }
        }
        filhaandtering.writeB(bestillingsliste);
        System.out.println(Arrays.toString(bestillingsliste));
    }

    public void fjernBestilling(Scanner input) throws FileNotFoundException {
        System.out.println("Bestillingslisten:");
        filhaandtering.readB(bestillingsliste);
        int tempI = 1;
        System.out.println("\nHvilken bestilling vil du slette?:");
        int number = input.nextInt();
        if(number >= 1 && number <= bestillingsliste.length){
            bestillingsliste[number-1] = null;
        }
        System.out.println(Arrays.toString(bestillingsliste));
    }

}
