import java.util.*;

public class MainMariosPizzabar {
    public static void main(String[] args) {
        runMariosPizzaProgram();
    }

    public static void runMariosPizzaProgram() {

        Scanner input = new Scanner(System.in);
        while (true){
            System.out.println("Indtast nummer: ");
            int menuChoich = input.nextInt();
            switch (menuChoich){
                case 1:
                    System.out.println("Menu 1 Test");
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println();
            }
        }
    }

}
