import java.io.FileNotFoundException;
import java.util.*;

public class MainMariosPizzabar {

    public static void main(String[] args) throws FileNotFoundException{
        runMariosPizzaProgram();
    }

    public static void runMariosPizzaProgram() throws FileNotFoundException {
        /**
         * Hovedmenu for programmet
         * Opretter objekter af klasserne (disse vil kalde på constuctors)Dette gøres på linje 16, 17, 18 og 19
         * Disse bliver oprettet for at vi kan til gå dem i switchen
         */
        Filhaandtering filhaandtering = new Filhaandtering();
        Bestilling bestilling = new Bestilling();
        Salgsstatistik_Omsaetning salgsstatistikOmsaetning = new Salgsstatistik_Omsaetning();
        Scanner input = new Scanner(System.in);
        while (true){
            System.out.println("Menu - 1-4" +
                    "\n1. Menukort \n2. Vis bestillings menu \n3. Vis salgsstatistik- og omsætnings menu \n4. For exit" + "\nIndtast nummer: ");
            int menuChoice = input.nextInt();
            System.out.println();
            switch (menuChoice){
                case 1:
                    filhaandtering.readFil(); //Objektet filhaandtering kalder metoden readFil
                    System.out.println();
                    break;
                case 2:
                    bestilling.bestilling(); //Objektet bestilling kalder metoden bestilling
                    break;
                case 3:
                    salgsstatistikOmsaetning.salgsstatistikOmsaetning(); //Objektet salgsstatistikOmsaetning kalder metoden salgsstatistikOmsaetning
                    break;
                case 4:
                    System.exit(0); //Afslutter programmet
                default:
                    System.out.println("Input " + menuChoice + " findes ikke i menuen\n");
            }
        }
    }
}
