import java.io.FileNotFoundException;
import java.util.*;

public class MainMariosPizzabar {

    public static void main(String[] args) throws FileNotFoundException{
        runMariosPizzaProgram();
    }

    public static void runMariosPizzaProgram() throws FileNotFoundException {
        Filhaandtering filhaandtering = new Filhaandtering();
        Scanner input = new Scanner(System.in);
        while (true){
            System.out.println("Menu - 1-5 \n" + "1. Vis menu \n5. For exit" + "\nIndtast nummer: ");
            int menuChoice = input.nextInt();
            switch (menuChoice){
                case 1:
                    filhaandtering.readFil();
                    System.out.println();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println();
            }
        }
    }

}
