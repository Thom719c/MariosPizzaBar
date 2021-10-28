import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Pattern;

public class Omsaetning {


    public static void filPizzaCounter(int line)throws FileNotFoundException {

        int count1 = 0;
        int[] count = new int[14];

        Scanner input = new Scanner(new File("Ressources/Bestillingsliste"));

        for (int i = 0; i < line - 1; i++) {
            input.nextLine();
        }
        String text = input.nextLine();
        System.out.println(text);


    }
}
