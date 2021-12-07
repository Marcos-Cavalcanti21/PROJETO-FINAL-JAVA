package Services;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Get {
    public static int integer() {
        int valor = 0;
        Scanner get = new Scanner(System.in);

        while (true) {
            try {
                valor = get.nextInt();
            break;
            } catch (InputMismatchException e) {
                System.err.println("\n\nApenas números inteiros");
                System.out.println("Não use pontos ou vírgulas.");
                System.out.println("Tente novamente: ");
                get.nextLine();
            }

        }
        return valor;
    }

    public static double decimal(){
        double valor = 0;
        Scanner get = new Scanner(System.in);

        while (true){
            try{
                valor = get.nextDouble();
                break;
            }catch (InputMismatchException e){
                System.out.println("\n\nApenas números");
                System.out.println("Não use pontos, apenas 'virgulas' para casas decimais.");
                System.out.println("Ex: 99999,35");
                System.out.println("Tente Novamente: ");
                get.nextLine();
            }
        }

        return valor;
    }

    public static String string(){
        Scanner get = new Scanner(System.in);

        return get.nextLine();

    }
}
