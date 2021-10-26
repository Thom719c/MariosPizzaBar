import java.util.*;

public class Bestilling {
    private String[] bestillingsliste = new String[3];
    public void bestilling(){
        Scanner input = new Scanner(System.in);
        tilfojBestilling(input);

    }
    public void tilfojBestilling(Scanner input){
        //System.out.println("Indtast pizzanummer: ");
        int tempI = 0;
        System.out.println("Indtast pizzanummer (f.eks: 1, 5, 3): ");
        while (true){
            String pizzaNr = input.nextLine();
            if (!pizzaNr.equals("")) {
                bestillingsliste[tempI] = pizzaNr;
                tempI++;
                break;
            }
        }
        System.out.println(Arrays.toString(bestillingsliste));
    }

}
