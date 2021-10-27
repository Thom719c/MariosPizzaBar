import java.io.*;
import java.util.*;
public class Filhaandtering {
    public void readFil() throws FileNotFoundException{
        Scanner readFileScanner = new Scanner(new File("Ressources/pizzaMenu"));
        int tempI = 1;
        while(readFileScanner.hasNext()) {
            System.out.printf("%3d. %s\n", tempI,readFileScanner.nextLine());
            tempI++;
        }
    }
    public void readB(String[] bestillingsliste)throws FileNotFoundException{
        Scanner input = new Scanner(new File("Ressources/Bestillingsliste"));
        PrintStream output = new PrintStream(new File("Ressources/Bestillingsliste"));

        String[] saveList = new String[10];

        boolean test = true;
        int count = 0;
        while(test) {
            if(input.hasNextLine()){
                saveList[count] = input.nextLine();
                count++;
            }
            if(!input.hasNextLine()){
                test = false;
            }
        }
        String outBestillingsliste = "";
        for(int i = 0; i <= saveList.length - 1; i++){
            outBestillingsliste += saveList[i];
        }
        output.println(outBestillingsliste);

        System.out.println(outBestillingsliste);


        /*
        int tempI = 0;
        while(readBScanner.hasNext()) {
            System.out.printf("%3d. %s\n", tempI,readBScanner.nextLine());
            tempI++;
        }*/
    }
}
