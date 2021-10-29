import java.io.FileNotFoundException;
import java.util.*;

public class MainMariosPizzabar {

    public static void main(String[] args) throws FileNotFoundException{
        runMariosPizzaProgram();
    }

    public static void runMariosPizzaProgram() throws FileNotFoundException {
        Filhaandtering filhaandtering = new Filhaandtering();
        Bestilling bestilling = new Bestilling();
        Omsaetning omsaetning = new Omsaetning();
        Scanner input = new Scanner(System.in);
        while (true){
            System.out.println("Menu - 1-4" +
                    "\n1. Menukort \n2. Vis bestillings menu \n3. Vis salgsstatistik- og omsætnings menu \n4. For exit" + "\nIndtast nummer: ");
            int menuChoice = input.nextInt();
            System.out.println();
            switch (menuChoice){
                case 1:
                    filhaandtering.readFil();
                    System.out.println();
                    break;
                case 2:
                    bestilling.bestilling();
                    break;
                case 3:
                    omsaetning.omsaetning();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println();
            }
        }
    }

}
