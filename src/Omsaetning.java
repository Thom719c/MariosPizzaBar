import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Omsaetning {

    public static void filPizzaCounter(int line)throws FileNotFoundException {

        int count1 = 0;
        int count2 = 0;
        int count3;
        int count4;
        int count5;
        int count6;
        int count7;
        int count8;
        int count9;
        int count10;
        int count11;
        int count12;
        int count13;
        int count14;

        Scanner input = new Scanner(new File("Ressources/Bestillingsliste"));

        for (int j = 0; j < line - 1; j++) {
            input.nextLine();
        }
        String text = input.nextLine(); // tester om vi har fat i den rigtige linje i filen
        System.out.println(text);

        String[] a = text.split(" ");
        String number = "1";
        int count = 0;
        for(int i = 0; i < 14; i++){
            if(number.equals(a[i])){
                count1++;
            }
        }
        System.out.println("HER: " + count1);
    }

    /*public static void filPizzaCounter(int line)throws FileNotFoundException {

        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;
        int count6 = 0;
        int count7 = 0;
        int count8 = 0;
        int count9 = 0;
        int count10 = 0;
        int count11 = 0;
        int count12 = 0;
        int count13 = 0;
        int count14 = 0;

        Scanner input = new Scanner(new File("Ressources/Bestillingsliste"));



}
