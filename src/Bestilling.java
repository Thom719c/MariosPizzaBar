import java.io.FileNotFoundException;
import java.util.*;

public class Bestilling {
    private String[] bestillingsliste = new String[10];

    public void bestilling() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        Filhaandtering filhaandtering = new Filhaandtering();
        tilfojBestilling(input);
        fjernBestilling(input, filhaandtering);

    }

    public void tilfojBestilling(Scanner input) {
        //System.out.println("Indtast pizzanummer: ");
        int tempI = 0;
        System.out.println("Indtast pizzanummer (f.eks: 1, 5, 3): ");
        while (true) {
            String pizzaNr = input.nextLine();
            if (!pizzaNr.equals("")) {
                bestillingsliste[tempI] = pizzaNr;
                tempI++;
                break;
            }
        }
        System.out.println(Arrays.toString(bestillingsliste));
    }

    public void fjernBestilling(Scanner input, Filhaandtering filhaandtering) throws FileNotFoundException {
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
