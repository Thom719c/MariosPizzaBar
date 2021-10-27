import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Bestilling {
    private String[] bestillingsliste = new String[3];
    private Filhaandtering filhaandtering = new Filhaandtering();
    private int count = 0;  //Variable der bruges til at tælle array op

    public void bestilling() throws FileNotFoundException {
        filhaandtering.opdaterArray(bestillingsliste);
        Scanner input = new Scanner(System.in);
        tilfojBestilling(input);

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
    public void fjernBestilling(){
        
    }

}
