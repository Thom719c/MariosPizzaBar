import java.util.*;

public class MainMariosPizzabar {
    public static void main(String[] args) {
        runMariosPizzaProgram();
    }

    public static void runMariosPizzaProgram() {
        System.out.println("hej");
        System.out.println("Tonje");
        Scanner input = new Scanner(System.in);
        while (true){
            int menuChoich = input.nextInt();
            switch (menuChoich){
                case 1:
                case 5:
                    System.exit(0);
                default:
                    System.out.println();
            }
        }
    }

}
