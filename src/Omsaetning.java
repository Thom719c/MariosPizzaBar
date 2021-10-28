import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Omsaetning {


    public static void filPizzaCounter(int line)throws FileNotFoundException {

        int count1 = 0;

        Scanner input = new Scanner(new File("Ressources/Bestillingsliste"));

        for(int i = 0; i < line; i++){
            input.nextLine();
        }
        String text = input.nextLine();
        System.out.println(text);

        for(int i = 0; i <= text.length(); i++){
            if(text.charAt(i) == '.'){
                break;
            }else if(text.charAt(i) == '1'){
                count1++;
            }
        }
        System.out.println("Her er den: " + count1);
    }
}
    /*public static int pizzaCounter(String nr){
        int count1 = 0;

        if(nr.equals("1")){
            count1++;
        }
        return count1;
    }*/


    /*int x = 0;
     if(text.charAt(x) == '.'){
        break;
    }

    x++;
}*/