import java.util.*;

public class Bestilling {
    public void bestilling(){
        Scanner input = new Scanner(System.in);
        tilfojBestilling(input);

    }
    public void tilfojBestilling(Scanner input){
        System.out.println("Indtast pizzanummer: ");
        int pizzaNr;
        int answer = 0;
        do{
         pizzaNr = input.nextInt();
        }while(answer != 0);
    }

}
